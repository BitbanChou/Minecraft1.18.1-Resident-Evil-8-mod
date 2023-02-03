//package com.joy187.re8joymod.common.keys;
//
//import com.joy187.re8joymod.Utils;
//import net.minecraft.client.settings.KeyBinding;
//import net.minecraft.client.util.InputMappings;
//import net.minecraftforge.client.settings.IKeyConflictContext;
//
//public class ModKeyBinding extends KeyBinding {
//    public ModKeyBinding(String description, IKeyConflictContext keyConflictContext, InputMappings.Type inputType, int keyCode, String category) {
//        super(String.format("key.%s.%s", Utils.MOD_ID, description), keyConflictContext, inputType.getOrCreate(keyCode), category);
//        KeyboardManager.KEY_BINDINGS.add(this);
//    }
//}
