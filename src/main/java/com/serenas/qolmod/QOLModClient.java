package com.serenas.qolmod;

import org.lwjgl.glfw.GLFW;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;

public class QOLModClient implements ClientModInitializer {
    
    //private static KeyBinding pickToolBind = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.qolmod.pickTool",InputUtil.Type.MOUSE,GLFW.GLFW_MOUSE_BUTTON_5,"category.qolmod.QoL")); 
    private static KeyBinding align0deg = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.qolmod.alignToZeroDegrees",InputUtil.Type.KEYSYM,GLFW.GLFW_KEY_G,"category.qolmod.QoL")); 
    private static KeyBinding align90deg = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.qolmod.alignToNinetyDegrees",InputUtil.Type.KEYSYM,GLFW.GLFW_KEY_H,"category.qolmod.QoL")); 
    private static KeyBinding align180deg = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.qolmod.alignToHundredEightyDegrees",InputUtil.Type.KEYSYM,GLFW.GLFW_KEY_V,"category.qolmod.QoL")); 
    private static KeyBinding align270deg = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.qolmod.alignToTwoSeventyDegrees",InputUtil.Type.KEYSYM,GLFW.GLFW_KEY_B,"category.qolmod.QoL")); 
    private static KeyBinding pitch0 = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.qolmod.alignTo0Pitch",InputUtil.Type.KEYSYM,GLFW.GLFW_KEY_J,"category.qolmod.QoL"));
    private static KeyBinding pitchneg45 = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.qolmod.alignTo-45Pitch",InputUtil.Type.KEYSYM,GLFW.GLFW_KEY_N,"category.qolmod.QoL"));
    private static KeyBinding pitch45 = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.qolmod.alignTo45Pitch",InputUtil.Type.KEYSYM,GLFW.GLFW_KEY_M,"category.qolmod.QoL"));
    private static KeyBinding knockKnock = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.qolmod.knockKnockWhosThere", InputUtil.Type.MOUSE, GLFW.GLFW_MOUSE_BUTTON_4, "category.qolmod.QoL"));


    @Override
    public void onInitializeClient() {

        
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
        //while (pickToolBind.wasPressed()) {
            
        //}
        while (align0deg.wasPressed()) {
            client.player.setYaw(0f);
            QOLMod.LOGGER.info("Aligned to 0 degrees");
        }
        while (align90deg.wasPressed()) {
            client.player.setYaw(90f);
            QOLMod.LOGGER.info("Aligned to 90 degrees");
        }
        while (align180deg.wasPressed()) {
            client.player.setYaw(180f);
            QOLMod.LOGGER.info("Aligned to 180 degrees");
        }
        while (align270deg.wasPressed()) {
            client.player.setYaw(270f);
            QOLMod.LOGGER.info("Aligned to 270 degrees");
        }
        while (pitch0.wasPressed()) {
            client.player.setPitch(0f);
            QOLMod.LOGGER.info("Pitched to 0 degrees");
        }
        while (pitchneg45.wasPressed()) {
            client.player.setPitch(-45f);
            QOLMod.LOGGER.info("Pitched to -45 degrees");
        }
        while (pitch45.wasPressed()) {
            client.player.setPitch(45f);
            QOLMod.LOGGER.info("Pitched to 45 degrees");
        }
        while (knockKnock.wasPressed()) {
            client.world.getPlayers().forEach(entity -> {
                Long x = Math.round(entity.getPos().x);
                Long y = Math.round(entity.getPos().y);
                Long z = Math.round(entity.getPos().z);
                
                client.player.sendMessage(Text.literal(entity.getEntityName()+" | X = "+x+" | Y = "+y+" | Z = "+z+" | Main Hand = "+entity.getStackInHand(Hand.MAIN_HAND)+" | Offhand = "+entity.getStackInHand(Hand.OFF_HAND)), false);
            });
        }
        });
    }
}
