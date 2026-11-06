package com.joy187.re8joymod.items.armor;

import com.google.common.collect.ImmutableMap;
import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.init.EffectInit;
import com.joy187.re8joymod.init.ItemInit;
import com.joy187.re8joymod.items.armor.render.RenderHanksuit;
import com.joy187.re8joymod.items.armor.render.RenderLeonsuit;
import com.joy187.re8joymod.util.CustomArmorMaterial;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;


public class LeonsuitArmorItem extends ArmorItem implements GeoItem{
	private final AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);

	public LeonsuitArmorItem(ArmorMaterial materialIn, Type slot, Properties builder) {
		super(materialIn, slot, builder);
	}

	@SuppressWarnings("unused")
	private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> state) {
		// This is all the extradata this event carries. The livingentity is the entity
		// that's wearing the armor. The itemstack and equipmentslottype are self
		// explanatory.
		Entity livingEntity = state.getData(DataTickets.ENTITY);

		// Always loop the animation but later on in this method we'll decide whether or
		// not to actually play it
		//state.setAndContinue(RawAnimation.begin().thenPlay("animation.heisensuit.idle"));

		// If the living entity is an armorstand just play the animation nonstop
		if (livingEntity instanceof ArmorStand) {
			return PlayState.CONTINUE;
		}

		// The entity is a player, so we want to only play if the player is wearing the
		// full set of armor
		else if (livingEntity instanceof Player) {
			Player player = (Player) livingEntity;

			// Get all the equipment, aka the armor, currently held item, and offhand item
			List<Item> equipmentList = new ArrayList<>();
			player.getAllSlots().forEach((x) -> equipmentList.add(x.getItem()));

			// elements 2 to 6 are the armor so we take the sublist. Armorlist now only
			// contains the 4 armor slots
			List<Item> armorList = equipmentList.subList(2, 6);

			// Make sure the player is wearing all the armor. If they are, continue playing
			// the animation, otherwise stop
			//ItemInit.HEISEN_BOOTS.get(), ItemInit.HEISEN_LEGGINGS.get(),ItemInit.HEISEN_CHEST.get(), ItemInit.HEISEN_HEAD.get()
			boolean isWearingAll = armorList
					.containsAll(Arrays.asList(ItemInit.LEON_BOOTS.get(), ItemInit.LEON_LEGG.get()
							,ItemInit.LEON_SUIT.get(), ItemInit.LEON_HEAD.get()));
			return isWearingAll ? PlayState.CONTINUE : PlayState.STOP;
		}
		return PlayState.STOP;
	}

	@Override
	public void initializeClient(Consumer<IClientItemExtensions> consumer) {
		consumer.accept(new IClientItemExtensions() {
			private GeoArmorRenderer<?> renderer;

			@Override
			public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
				if (this.renderer == null)
					this.renderer = new RenderLeonsuit();

				// This prepares our GeoArmorRenderer for the current render frame.
				// These parameters may be null however, so we don't do anything further with them
				this.renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);

				return this.renderer;
			}
		});
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar data) {
		data.add(new AnimationController(this, "controller", 20, this::predicate));
	}

	@Override
		public AnimatableInstanceCache getAnimatableInstanceCache() { 		return this.factory; 	}
	

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if(!world.isClientSide()) {
            if(!player.getInventory().getArmor(3).isEmpty() && !player.getInventory().getArmor(2).isEmpty() &&
                    !player.getInventory().getArmor(1).isEmpty() && !player.getInventory().getArmor(0).isEmpty() ) {
                ArmorItem helmet = ((ArmorItem)player.getInventory().getArmor(3).getItem());
                ArmorItem breastplate = ((ArmorItem)player.getInventory().getArmor(2).getItem());
                ArmorItem leggings = ((ArmorItem)player.getInventory().getArmor(1).getItem());
                ArmorItem boots = ((ArmorItem)player.getInventory().getArmor(0).getItem());

                if(helmet==ItemInit.LEON_HEAD.get() && breastplate==ItemInit.LEON_SUIT.get() &&
                        leggings==ItemInit.LEON_LEGG.get() && boots==ItemInit.LEON_BOOTS.get()) {
                    boolean hasPlayerEffect = player.hasEffect(EffectInit.ZENHEART.get());
                    if(!hasPlayerEffect) {
                        player.addEffect(new MobEffectInstance(EffectInit.ZENHEART.get(),600, 0));
                    }
                }
            }

        }
    }

}