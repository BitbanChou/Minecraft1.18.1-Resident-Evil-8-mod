package com.joy187.re8joymod.common.items.ItemSniper;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.util.INBTSerializable;

import java.util.Collection;

public interface LivingHandler extends INBTSerializable<CompoundNBT>, Synched {

    default void tick() {}

    /**
     * When this entity is damaged; with potions and armour taken into account.
     *
     * @param source - the source of damage
     * @param amount - the amount of damage taken
     * @return the new damage amount
     */
    default float handleDamaged(DamageSource source, float amount) {
        return amount;
    }

    /**
     * When this entity is hurt.
     *
     * @param source - the source of damage
     * @param amount - the amount of damage taken
     * @return if the event should be cancelled
     */
    default boolean handleHurt(DamageSource source, float amount) {
        return false;
    }

    /**
     * When this entity kills another entity.
     *
     * @param target - the {@link Entity} killed
     * @return if the event should be cancelled
     */
    default boolean handleKill(Entity target) {
        return false;
    }

    /**
     * When this entity's health reaches 0.
     *
     * @param cause - the cause of death
     * @return if the event should be cancelled
     */
    default boolean handleDeath(DamageSource cause) {
        return false;
    }

    /**
     * When this entity's death causes dropped items to appear.
     *
     * @param cause - the DamageSource that caused the drop to occur
     * @param loot - a collections of {@link ItemEntity}s that will be dropped
     * @return if the event should be cancelled
     */
    default boolean handleDeathLoot(DamageSource cause, Collection<ItemEntity> loot) {
        return false;
    }

    /**
     * When this entity has started to be "tracked" by the specified {@link ServerPlayerEntity} (the
     * player receives updates about this entity, e.g. motion).
     *
     * @param playerEntity - the player tracking us
     */
    default void handleStartTracking(ServerPlayerEntity playerEntity) {}

//    /**
//     * Whether the {@link LivingExtension} is allowed to move or not.
//     *
//     * @return true if movement is blocked
//     */
//    default boolean isMovementBlocked() {
//        return false;
//    }
//
//    default Visibility getVisibility() {
//        return Visibility.VISIBLE;
//    }

    @Override
    default CompoundNBT serializeNBT() {
        return new CompoundNBT();
    }

    @Override
    default void deserializeNBT(CompoundNBT nbt) {}
}

