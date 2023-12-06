package de.chloedev.kianalibfabric.mixin;

import de.chloedev.kianalibfabric.event.impl.client.ClientHudRenderEvent;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class MixinInGameHud {

    @Shadow
    @Final
    private MinecraftClient client;

    @Inject(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/hud/InGameHud;renderAutosaveIndicator(Lnet/minecraft/client/gui/DrawContext;)V", shift = At.Shift.AFTER))
    public void onRender(DrawContext context, float tickDelta, CallbackInfo ci) {
        ClientHudRenderEvent event = new ClientHudRenderEvent();
        event.invoke();
        event.getTextElements().forEach((id, element) -> {
            context.drawTextWithShadow(this.client.textRenderer, element.text(), element.pos().getX(), element.pos().getY(), element.text().getStyle().getColor() == null ? 0xffffff : element.text().getStyle().getColor().getRgb());
        });
    }
}
