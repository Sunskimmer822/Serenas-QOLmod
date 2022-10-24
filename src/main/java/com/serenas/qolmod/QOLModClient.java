package com.serenas.qolmod;

import org.lwjgl.glfw.GLFW;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;

public class QOLModClient implements ClientModInitializer {
    
    private static KeyBinding keyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.qolmod.pickTool",InputUtil.Type.MOUSE,GLFW.GLFW_MOUSE_BUTTON_5,"category.qolmod.QoL")); 
    
    
    @Override
    public void onInitializeClient() {

        
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
        while (keyBinding.wasPressed()) {
            
        }
        });
    }
}
