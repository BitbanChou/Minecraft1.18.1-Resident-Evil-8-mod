package com.joy187.re8joymod.common.items.ItemSniper;

import net.minecraft.entity.player.PlayerEntity;

public interface PlayerExtension<E extends PlayerEntity>
        extends LivingExtension<E, PlayerHandler>, PlayerHandler {

    static <E extends PlayerEntity> PlayerExtension<E> create(E entity) {
        return new PlayerExtensionImpl<>(entity);
    }

//    @Nonnull
//    @SuppressWarnings("unchecked")
//    static <E extends PlayerEntity> PlayerExtension<E> getOrThrow(E player) {
//        return Capabilities.getOrThrow(Capabilities.LIVING_EXTENSION, player, PlayerExtension.class);
//    }

    boolean isCombatModeEnabled();

    void setCombatModeEnabled(boolean combatModeEnabled);

    void openEquipmentMenu();

//    void openStorage(ModEquipmentSlotType slotType);
}

