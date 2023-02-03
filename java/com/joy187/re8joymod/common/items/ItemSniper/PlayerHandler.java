package com.joy187.re8joymod.common.items.ItemSniper;

public interface PlayerHandler extends LivingHandler {

    default boolean isCombatModeEnabled() {
        return false;
    }

    default void playerTick() {}

    /**
     * Copy data from old player before death/respawn.<br>
     * <i><b>Only called on server.</b></i>
     *
     * @param that - the old player
     * @param wasDeath if they died or not
     */
    default void copyFrom(PlayerExtension<?> that, boolean wasDeath) {}
}
