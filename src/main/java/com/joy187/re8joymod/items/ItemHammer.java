package com.joy187.re8joymod.items;

import java.util.Optional;
import java.util.function.Consumer;

import com.joy187.re8joymod.entity.EntityBeibaby;
import com.joy187.re8joymod.entity.EntityBela;
import com.joy187.re8joymod.entity.EntityCassandra;
import com.joy187.re8joymod.entity.EntityDaniela;
import com.joy187.re8joymod.entity.EntityRe8Dimi;

import com.joy187.re8joymod.items.render.RenderHammer;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
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
import software.bernie.geckolib.network.GeckoLibNetwork;
import software.bernie.geckolib.network.SerializableDataTicket;
import software.bernie.geckolib.util.GeckoLibUtil;


public class ItemHammer extends AxeItem implements GeoItem {
	public AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);

	public static final int ANIM_OPEN = 0,ANIM_CLOSE = 0;
	public static int attr = 0;

    public ItemHammer(Tier toolMaterial, float attackDamage, float attackSpeed, Properties itemProperties) {
        super(toolMaterial, attackDamage, attackSpeed, itemProperties);
		GeckoLibNetwork.registerSyncedAnimatable(this);
    }
	
	@Override
	public void initializeClient(Consumer<IClientItemExtensions> consumer) {
		super.initializeClient(consumer);
		consumer.accept(new IClientItemExtensions() {
			private final BlockEntityWithoutLevelRenderer renderer = new RenderHammer();

//			@Override
//			public BlockEntityWithoutLevelRenderer renderByItem() {
//				return renderer;
//			}
		});
	}
	
//	public void inventoryTick(ItemStack itemStack, Level world, Entity player, int p_40723_, boolean p_40724_) {
//		      if (!world.isClientSide) {
//		    	  	if(this.attr==0) {
//		    			final int id = GeckoLibUtil.guaranteeIDForStack(itemStack, (ServerLevel)world);
//		    			final PacketDistributor.PacketTarget tg = PacketDistributor.TRACKING_ENTITY_AND_SELF
//		    					.with(() -> player);
//		    			GeckoLibNetwork.syncAnimation(tg, this, id, ANIM_CLOSE);
//		    			System.out.println("Idle Idle!");
//		    	  	}
//		      }
//	}
	   
	public boolean hurtEnemy(ItemStack itemStack, LivingEntity target, LivingEntity attacker) {
		if (!attacker.level().isClientSide) {
			this.attr=1;
//			final int id = GeckoLibUtil.guaranteeIDForStack(itemStack, (ServerLevel)attacker.level);
//			final PacketDistributor.PacketTarget tg = PacketDistributor.TRACKING_ENTITY_AND_SELF
//					.with(() -> attacker);
//			GeckoLibNetwork.syncAnimation(tg, this, id, ANIM_OPEN);
			//System.out.println("Hit Hit!");
		}
	    return true;
	}


	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar data) {
		data.add(new AnimationController(this, "controller",
				0, this::predicate));
	}

	private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> state) {

		if (this.attr==1)
		{
			state.setAndContinue(RawAnimation.begin().thenPlay("animation.hammer.hit"));
			return PlayState.CONTINUE;
		}
		this.attr=0;
		return PlayState.CONTINUE;
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.factory;
	}
//
//	@Override
//	public void onAnimationSync(int id, int state) {
//		if (state == ANIM_OPEN) {
//			final AnimationController<?> controller = GeckoLibUtil.getControllerForID(this.factory, id, "controller");
//			if (controller.getAnimationState() == AnimationState.Stopped) {
//				controller.markNeedsReload();
//				controller.setAnimation(new AnimationBuilder().addAnimation("animation.hammer.hit", false));
//			}
//		}
//		else {
//			final AnimationController<?> controller = GeckoLibUtil.getControllerForID(this.factory, id, "controller");
//			if (controller.getAnimationState() == AnimationState.Stopped) {
//				controller.markNeedsReload();
//				controller.setAnimation(new AnimationBuilder().addAnimation("animation.hammer.idle", false));
//			}
//		}
//	}
	
	
}
