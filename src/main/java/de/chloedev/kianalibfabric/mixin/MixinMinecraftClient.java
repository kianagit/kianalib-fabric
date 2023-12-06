package de.chloedev.kianalibfabric.mixin;

import de.chloedev.kianalibfabric.event.impl.client.ClientTickEvent;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MixinMinecraftClient {

    @Inject(method = "tick", at = @At(value = "HEAD"))
    public void onTickStart(CallbackInfo ci) {
        // Invokes the Example Event-Listener
        ClientTickEvent event = new ClientTickEvent(ClientTickEvent.InjectionPoint.START).invoke();
    }

    @Inject(method = "tick", at = @At(value = "TAIL"))
    public void onTickEnd(CallbackInfo ci) {
        // Invokes the Example Event-Listener
        ClientTickEvent event = new ClientTickEvent(ClientTickEvent.InjectionPoint.END).invoke();
    }
}
