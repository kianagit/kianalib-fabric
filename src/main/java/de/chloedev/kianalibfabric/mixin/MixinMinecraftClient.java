package de.chloedev.kianalibfabric.mixin;

import de.chloedev.kianalibfabric.event.impl.client.ClientScreenChangeEvent;
import de.chloedev.kianalibfabric.event.impl.client.ClientTickEvent;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MixinMinecraftClient {

    @Shadow
    @Nullable
    public Screen currentScreen;
    @Unique
    private ClientScreenChangeEvent clientScreenChangeEvent;

    @Inject(method = "tick", at = @At(value = "HEAD"))
    public void onTickStart(CallbackInfo ci) {
        ClientTickEvent event = new ClientTickEvent(ClientTickEvent.InjectionPoint.START).invoke();
    }

    @Inject(method = "tick", at = @At(value = "TAIL"))
    public void onTickEnd(CallbackInfo ci) {
        ClientTickEvent event = new ClientTickEvent(ClientTickEvent.InjectionPoint.END).invoke();
    }

    @Inject(method = "setScreen", at = @At(value = "HEAD"), cancellable = true)
    public void onScreenChange(Screen screen, CallbackInfo ci) {
        this.clientScreenChangeEvent = new ClientScreenChangeEvent(this.currentScreen, screen);
        this.clientScreenChangeEvent.invoke();
        if (this.clientScreenChangeEvent.isCancelled()) {
            ci.cancel();
        }
    }

    @ModifyVariable(method = "setScreen", at = @At(value = "HEAD"), argsOnly = true)
    public Screen onScreenChange$1(Screen value) {
        if (this.clientScreenChangeEvent != null && !this.clientScreenChangeEvent.isCancelled()) {
            return this.clientScreenChangeEvent.getNewScreen();
        }
        return value;
    }
}
