package com.serenas.qolmod;



public class QOLModClient implements ClientModInitializer {
    
    private static KeyBinding keyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.qolmod.pickTool",InputUtil.Type.MOUSE,GLFW.GLFW_MOUSE_BUTTON_5,"category.qolmod.QoL")); 
    
    
    @Override
    public void onInitializeClient() {

        
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
        while (keyBinding.wasPressed()) {
            client.player.sendMessage(Text.literal("Key 1 was pressed!"), false);
            }
        });
    }
}
