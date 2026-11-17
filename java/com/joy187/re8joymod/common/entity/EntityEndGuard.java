package com.joy187.re8joymod.common.entity;

import com.google.common.collect.ImmutableSet;
import com.joy187.re8joymod.Utils;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.util.SoundEvents;
import net.minecraft.village.PointOfInterestType;
import net.minecraft.world.World;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.lang.reflect.InvocationTargetException;


public class EntityEndGuard extends VillagerEntity {
    public EntityEndGuard(EntityType<? extends VillagerEntity> p_35381_, World p_35382_) {
        super(p_35381_, p_35382_);
    }


    public static AttributeModifierMap.MutableAttribute setAttributes() {
        return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.5D).add(Attributes.FOLLOW_RANGE, 48.0D);
    }

    public static final DeferredRegister<PointOfInterestType> POI_TYPES
            = DeferredRegister.create(ForgeRegistries.POI_TYPES, Utils.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS
            = DeferredRegister.create(ForgeRegistries.PROFESSIONS, Utils.MOD_ID);

    public static final RegistryObject<PointOfInterestType> VIRUS_POI = POI_TYPES.register("edman_poi2",
            () -> new PointOfInterestType("edman_poi2",
                    PointOfInterestType.getBlockStates(Blocks.END_STONE), 1, 1));

    public static final RegistryObject<VillagerProfession> EDMANGUARD1 =
            VILLAGER_PROFESSIONS.register("edman.guard",
                    () -> new VillagerProfession("edman.guard", VIRUS_POI.get(),
                            ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_WEAPONSMITH));


    public static void registerPOIs() {
        try {
            ObfuscationReflectionHelper.findMethod(PointOfInterestType.class,
                    "registerBlockStates", PointOfInterestType.class).invoke(null, VIRUS_POI.get());
        } catch(InvocationTargetException | IllegalAccessException exception) {
            exception.printStackTrace();
        }
    }

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }

//    @Nullable
//    protected SoundEvent getAmbientSound() {
//        if (this.isSleeping()) {
//            return null;
//        } else {
//            Random ran = new Random();
//            if(ran.nextInt(2)==0)
//            {
//                return this.isTrading() ? SoundInit.ENTITY_DUKE_TRADE.get() : SoundInit.ENTITY_DUKE_AMBIENT2.get();
//            }
//            return this.isTrading() ? SoundInit.ENTITY_DUKE_TRADE.get() : SoundInit.ENTITY_DUKE_AMBIENT1.get();
//        }
//    }
//
//    protected SoundEvent getHurtSound(DamageSource p_35498_) {
//        return SoundInit.ENTITY_DUKE_HURT.get();
//    }

}