package de.chloedev.testmod.mixin;

import de.chloedev.kianalibfabric.event.EventManager;
import de.chloedev.testmod.event.EventListener;
import de.chloedev.testmod.event.impl.ClientTickEvent;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.RunArgs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MixinMinecraftClient {

    @Inject(method = "<init>", at = @At(value = "FIELD", target = "Lnet/minecraft/client/MinecraftClient;instance:Lnet/minecraft/client/MinecraftClient;"))
    public void init(RunArgs args, CallbackInfo ci){
        EventManager.register(new EventListener());
    }

    @Inject(method = "tick", at = @At(value = "HEAD"))
    public void onTickStart(CallbackInfo ci) {
        ClientTickEvent event = new ClientTickEvent(ClientTickEvent.InjectionPoint.START).invoke();
    }

    @Inject(method = "tick", at = @At(value = "TAIL"))
    public void onTickEnd(CallbackInfo ci) {
        ClientTickEvent event = new ClientTickEvent(ClientTickEvent.InjectionPoint.END).invoke();
    }
}
