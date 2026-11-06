package com.joy187.re8joymod.entity;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.village.ReputationEventType;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.raid.Raid;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationState;;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;

import com.google.common.collect.ImmutableSet;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;

import javax.annotation.Nullable;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.init.BlockInit;
import com.joy187.re8joymod.init.SoundInit;

public class EntityDuke extends Villager implements GeoEntity{
	
    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);

	public EntityDuke(EntityType<? extends Villager> p_35381_, Level p_35382_) {
		super(p_35381_, p_35382_);
	}
	
	public static AttributeSupplier.Builder prepareAttributes() {
	   return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 200.0D)
			   .add(Attributes.MOVEMENT_SPEED, 0.5D).add(Attributes.FOLLOW_RANGE, 48.0D);
	}



    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
        if (event.isMoving()) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.duke.walk"));
            return PlayState.CONTINUE;
        }

        
        event.setAndContinue(RawAnimation.begin().thenPlay("animation.duke.idle"));
        return PlayState.CONTINUE;
    }
    
	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar data) {
        data.add(new AnimationController(this, "controller",
                0, this::predicate));		
	}

	@Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.factory;
    }
	
	@Nullable
	protected SoundEvent getAmbientSound() {
	      if (this.isSleeping()) {
	         return null;
	      } else {
	    	 Random ran = new Random();
	    	 if(ran.nextInt(2)==0)
	    	 {
		         return this.isTrading() ? SoundInit.ENTITY_DUKE_TRADE.get() : SoundInit.ENTITY_DUKE_AMBIENT2.get();	    		 
	    	 }
	         return this.isTrading() ? SoundInit.ENTITY_DUKE_TRADE.get() : SoundInit.ENTITY_DUKE_AMBIENT1.get();
	      }
	}

	protected SoundEvent getHurtSound(DamageSource p_35498_) {
	      return SoundInit.ENTITY_DUKE_HURT.get();
	}
	

	   
}

//public class EntityDuke {
//    public static final DeferredRegister<PoiType> POI_TYPES
//            = DeferredRegister.create(ForgeRegistries.POI_TYPES, Main.MOD_ID);
//    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS
//            = DeferredRegister.create(ForgeRegistries.PROFESSIONS, Main.MOD_ID);
//
//
//
//	public static final RegistryObject<PoiType> VIRUS_POI = POI_TYPES.register("virus_generator_poi",
//    () -> new PoiType("virus_generator_poi",
//            PoiType.getBlockStates(BlockInit.EXAMPLE_BLOCK.get()), 1, 1));
//
//	public static final RegistryObject<VillagerProfession> DUKE =
//    VILLAGER_PROFESSIONS.register("duker",
//            () -> new VillagerProfession("duker", VIRUS_POI.get(),
//                    ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_WEAPONSMITH));
//
//
//	public static void registerPOIs() {
//		try {
//		    ObfuscationReflectionHelper.findMethod(PoiType.class,
//		            "registerBlockStates", PoiType.class).invoke(null, VIRUS_POI.get());
//		} catch(InvocationTargetException | IllegalAccessException exception) {
//		    exception.printStackTrace();
//		}
//	}
//	
//    public static void register(IEventBus eventBus) {
//        POI_TYPES.register(eventBus);
//        VILLAGER_PROFESSIONS.register(eventBus);
//    }
//}
