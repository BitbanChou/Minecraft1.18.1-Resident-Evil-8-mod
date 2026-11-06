package com.joy187.re8joymod.items.armor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import com.google.common.collect.ImmutableMap;
import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.init.EffectInit;
import com.joy187.re8joymod.init.ItemInit;
import com.joy187.re8joymod.items.armor.render.RenderFranksuit;
import com.joy187.re8joymod.items.armor.render.RenderHeisensuit;
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


public class HeisensuitArmorItem extends ArmorItem implements GeoItem{
	private final AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);
    private int hen=0,fin=0,tickTimer=0;
	public HeisensuitArmorItem(ArmorMaterial materialIn, Type slot, Properties builder) {
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


		// If the living entity is an armorstand just play the animation nonstop
		if (livingEntity instanceof ArmorStand) {
			return PlayState.CONTINUE;
		}

		// The entity is a player, so we want to only play if the player is wearing the
		// full set of armor
		else if (livingEntity instanceof Player) {
			Player player = (Player) livingEntity;
            if(this.hen==1)
            {
                state.setAndContinue(RawAnimation.begin().thenPlayXTimes("animation.heisensuit.hen",1).thenPlay("animation.heisensuit.idle"));
                //System.out.println(this.tickTimer+" "+this.hen +" "+ state.getController().getCurrentAnimation());
                return PlayState.CONTINUE;
            }
            else {
                if (!state.isMoving()) {
                    state.setAndContinue(RawAnimation.begin().thenPlay("animation.heisensuit.idle"));
                }
                //System.out.println(this.tickTimer+" "+this.hen +" "+ state.getController().getCurrentAnimation());
                return PlayState.STOP;
            }
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
                    this.renderer = new RenderHeisensuit();

                // This prepares our GeoArmorRenderer for the current render frame.
                // These parameters may be null however, so we don't do anything further with them
                this.renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);

                return this.renderer;
            }
        });
    }
//    private <E extends IAnimatable> PlayState predicateIdle(AnimationEvent<E> event) {
//        if (!state.isMoving() && this.hen==1 && this.fin==1 && state.getController().getCurrentAnimation() == null) {
//            state.setAndContinue(RawAnimation.begin().thenPlay("animation.heisensuit.idle", ILoopType.EDefaultLoopTypes.LOOP));
//        }
//        else{
//            this.fin=0;
//        }
//        System.out.println(this.hen +" "+ this.fin +" "+ state.getController().getCurrentAnimation());
//        return PlayState.CONTINUE;
//    }

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar data) {
        //data.add(new AnimationController(this, "controller2", 20, this::predicateIdle));
        data.add(new AnimationController(this, "controller", 20, this::predicate));
	}

	@Override
		public AnimatableInstanceCache getAnimatableInstanceCache() { 		return this.factory; 	}
	
    private static final Map<ArmorMaterial, MobEffectInstance> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, MobEffectInstance>())
                    .put(CustomArmorMaterial.ARMOR_MATERIAL_HEISENSUIT,
                            new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 1)).build();
    
    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        this.tickTimer++;
        if(!world.isClientSide()) {

//            if(this.tickTimer<=40)
//            {
                if(!player.getInventory().getArmor(3).isEmpty() && !player.getInventory().getArmor(2).isEmpty()
                        && !player.getInventory().getArmor(1).isEmpty() && !player.getInventory().getArmor(0).isEmpty()){
                    ArmorItem helmet = ((ArmorItem)player.getInventory().getArmor(3).getItem());
                    ArmorItem breastplate = ((ArmorItem)player.getInventory().getArmor(2).getItem());
                    ArmorItem leggings = ((ArmorItem)player.getInventory().getArmor(1).getItem());
                    ArmorItem boots = ((ArmorItem)player.getInventory().getArmor(0).getItem());

                    if(helmet==ItemInit.HEISEN_HEAD.get() && breastplate==ItemInit.HEISEN_SUIT.get() &&
                            leggings==ItemInit.HEISEN_LEGG.get() && boots==ItemInit.HEISEN_BOOTS.get() ){
                        this.hen=1;
                    }
                    else{
                        this.hen=0;
                        this.tickTimer=0;
                    }
                }
                else{
                    this.hen=0;
                    this.tickTimer=0;
                }
//            }

//            if(player.getMainHandItem().getItem()==ItemInit.GBLADE.get() && player.getOffhandItem().getItem()==ItemInit.GBLADE.get()){
//                if(!player.hasEffect(MobEffects.MOVEMENT_SPEED))
//                {
//                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 2,true,false));
//                }
//
//            }

            if(!player.getInventory().getArmor(3).isEmpty()) {
                MobEffectInstance mapStatusEffect1 = new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 2);
                ArmorItem helmet = ((ArmorItem)player.getInventory().getArmor(3).getItem());
                if(helmet.getMaterial() == CustomArmorMaterial.ARMOR_MATERIAL_HEISENSUIT) {
                    boolean hasPlayerEffect = player.hasEffect(mapStatusEffect1.getEffect());
                    if(!hasPlayerEffect) {
                        player.addEffect(new MobEffectInstance(mapStatusEffect1.getEffect(),mapStatusEffect1.getDuration(), mapStatusEffect1.getAmplifier()));
                    }
                }
            }
            if(!player.getInventory().getArmor(2).isEmpty()) {
                MobEffectInstance mapStatusEffect2 = new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 100, 1);

                ArmorItem breastplate = ((ArmorItem)player.getInventory().getArmor(2).getItem());
                if(breastplate.getMaterial() == CustomArmorMaterial.ARMOR_MATERIAL_HEISENSUIT) {
                    boolean hasPlayerEffect = player.hasEffect(mapStatusEffect2.getEffect());
                    if(!hasPlayerEffect) {
                        player.addEffect(new MobEffectInstance(mapStatusEffect2.getEffect(),mapStatusEffect2.getDuration(), mapStatusEffect2.getAmplifier()));
                    }
                }
            }   
            if(!player.getInventory().getArmor(1).isEmpty()) {
                MobEffectInstance mapStatusEffect3 = new MobEffectInstance(MobEffects.SLOW_FALLING, 100, 1);

                ArmorItem leggings = ((ArmorItem)player.getInventory().getArmor(1).getItem());
                if(leggings.getMaterial() == CustomArmorMaterial.ARMOR_MATERIAL_HEISENSUIT) {
                    boolean hasPlayerEffect = player.hasEffect(mapStatusEffect3.getEffect());
                    if(!hasPlayerEffect) {
                        player.addEffect(new MobEffectInstance(mapStatusEffect3.getEffect(),mapStatusEffect3.getDuration(), mapStatusEffect3.getAmplifier()));
                    }
                }
            }
            if(!player.getInventory().getArmor(0).isEmpty()) {
                MobEffectInstance mapStatusEffect4 = new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100, 0);
                ArmorItem boots = ((ArmorItem)player.getInventory().getArmor(0).getItem());
                if(boots.getMaterial() == CustomArmorMaterial.ARMOR_MATERIAL_HEISENSUIT) {
                    boolean hasPlayerEffect = player.hasEffect(mapStatusEffect4.getEffect());
                    if(!hasPlayerEffect) {
                        player.addEffect(new MobEffectInstance(mapStatusEffect4.getEffect(),mapStatusEffect4.getDuration(), mapStatusEffect4.getAmplifier()));
                    }
                }
            }
        }
    }

}