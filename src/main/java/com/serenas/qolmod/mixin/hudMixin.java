package com.serenas.qolmod.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.serenas.qolmod.QOLModClient;

import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

@Mixin(InGameHud.class)
public abstract class hudMixin {

    Identifier rangefinder = new Identifier("textures/misc/rangefinderoverlay.png");
    InGameHud hud = ((InGameHud) (Object) this);

    @Shadow
    public void renderOverlay(Identifier texture, float opacity) {}

    @Inject(at = @At("HEAD"), method = "render")
    public void render(MatrixStack matrices, float tickDelta, CallbackInfo ci) {
        if (QOLModClient.overlayToggle) {
            this.renderOverlay(rangefinder, 1.0f);
        }
    }
    
}
