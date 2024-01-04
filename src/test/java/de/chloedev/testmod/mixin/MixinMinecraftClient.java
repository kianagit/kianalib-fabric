package de.chloedev.testmod.mixin;

import de.chloedev.kianalibfabric.event.EventManager;
import de.chloedev.kianalibfabric.event.impl.client.ClientTickEvent;
import de.chloedev.kianalibfabric.util.ActionUtil;
import de.chloedev.testmod.event.EventListener;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.RunArgs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MixinMinecraftClient {

    @Inject(method = "<init>", at = @At(value = "FIELD", target = "Lnet/minecraft/client/MinecraftClient;instance:Lnet/minecraft/client/MinecraftClient;"))
    public void init(RunArgs args, CallbackInfo ci) {
        // Registers the Example Event-Listener
        EventManager.register(new EventListener());
        ActionUtil.run(() -> System.out.println("RUNNING..."), 5, 0, 1000);
    }

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
