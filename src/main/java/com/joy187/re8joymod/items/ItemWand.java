package com.joy187.re8joymod.items;

import com.google.common.base.Predicate;
import com.joy187.re8joymod.init.EffectInit;
import com.joy187.re8joymod.items.render.RenderWand;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.network.PacketDistributor;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;


import java.util.function.Consumer;

public class ItemWand extends ItemKsword implements GeoItem {
	public AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);

	private int hurt=0;
	public ItemWand(Tier toolMaterial, int attackDamage, float attackSpeed, Properties itemProperties) {
		super(toolMaterial, attackDamage, attackSpeed, itemProperties);
	}


	@Override
	public void initializeClient(Consumer<IClientItemExtensions> consumer) {
		super.initializeClient(consumer);
		consumer.accept(new IClientItemExtensions() {
			private final BlockEntityWithoutLevelRenderer renderer = new RenderWand();

			@Override
			public BlockEntityWithoutLevelRenderer getCustomRenderer() {
				return renderer;
			}
		});
	}


	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar data) {
		data.add(new AnimationController(this, "controller",
				0, this::predicate));
	}

	private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> state) {

		if (this.hurt>0)
		{
			state.setAndContinue(RawAnimation.begin().thenPlay("animation.wand.idle"));
			this.hurt--;
			return PlayState.CONTINUE;
		}

		state.setAndContinue(RawAnimation.begin().thenPlay("animation.wand.idle"));
		return PlayState.CONTINUE;
	}

	private static final Predicate<Entity> MIMIC_AREA = (entity) -> {
		return entity.isAlive() && !(entity instanceof Player);
	};

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player playerIn, InteractionHand hand) {
		ItemStack itemstack = playerIn.getItemInHand(hand);

		if(!playerIn.getCooldowns().isOnCooldown(itemstack.getItem()))
		{
			for (LivingEntity livingentity : playerIn.level().getEntitiesOfClass(LivingEntity.class, playerIn.getBoundingBox().inflate(10), MIMIC_AREA)) {
				if(livingentity instanceof Mob)
				{
					if(((Mob) livingentity).getTarget()==playerIn)
					{
						livingentity.addEffect(new MobEffectInstance(EffectInit.MIMIC.get(), 10 * 20, 0, true, true));
					}
				}

			}

			playerIn.getCooldowns().addCooldown(this,100);
			playerIn.getMainHandItem().hurtAndBreak(1, playerIn, (p_40665_) -> {
				p_40665_.broadcastBreakEvent(playerIn.getUsedItemHand());
			});
		}

		return InteractionResultHolder.success(itemstack);
	}

	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		this.hurt=8;
		return true;
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.factory;
	}


}
