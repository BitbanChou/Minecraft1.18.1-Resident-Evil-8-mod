package com.joy187.re8joymod.common.items.ItemSniper;

import net.minecraftforge.eventbus.api.Event;

public class LivingExtensionEvent extends Event {
    private final LivingExtension<?, ?> living;

    public LivingExtensionEvent(LivingExtension<?, ?> living) {
        this.living = living;
    }

    public static class Load extends LivingExtensionEvent {

        public Load(LivingExtension<?, ?> living) {
            super(living);
        }
    }
}
