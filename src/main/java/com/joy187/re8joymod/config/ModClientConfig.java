package com.joy187.re8joymod.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ModClientConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;
    public static final ForgeConfigSpec.ConfigValue<Integer> bookGUIScale;

    static {
        BUILDER.push("Configs for Tutorial Mod");

        // HERE DEFINE YOUR CONFIGS

        BUILDER.pop();
        SPEC = BUILDER.build();
        
        bookGUIScale = BUILDER
                .comment("Use -1 for same as GUI scale, 0 for auto, 1+ for small/medium/large.")
                .translation("text.guidebook.config.book_gui_scale")
                .defineInRange("book_gui_scale", -1, -1, Integer.MAX_VALUE);
    }
}
