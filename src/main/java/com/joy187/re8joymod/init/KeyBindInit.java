package com.joy187.re8joymod.init;



import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;


public class KeyBindInit
{
    public static final String KEYCAT = "key.re8.category";
    public static final String shootKey = "key.re8.shootKey";

    public static final KeyMapping KEY_FIRE = new KeyMapping(shootKey, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_V, KEYCAT);


}