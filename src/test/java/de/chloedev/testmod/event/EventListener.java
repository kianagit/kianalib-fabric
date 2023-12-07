package de.chloedev.testmod.event;

import de.chloedev.kianalibfabric.event.EventHandler;
import de.chloedev.kianalibfabric.event.impl.client.ClientHudRenderEvent;
import de.chloedev.kianalibfabric.event.impl.client.ClientHudRenderEvent.TextElement;
import de.chloedev.kianalibfabric.event.impl.client.ClientScreenChangeEvent;
import de.chloedev.kianalibfabric.render.ScreenPos;
import net.minecraft.client.gui.screen.option.VideoOptionsScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class EventListener {

    @EventHandler
    public void onHudRender(ClientHudRenderEvent e) {
        e.addTextElement("someElement", new TextElement(ScreenPos.relative(50, 50), Text.literal("Some Element")));
    }

    @EventHandler
    public void onScreenChange(ClientScreenChangeEvent e) {
        System.out.println(e.getOldScreen() + " -> " + e.getNewScreen());
        if (e.getNewScreen() instanceof VideoOptionsScreen) {
            e.addChild(ButtonWidget.builder(Text.literal("Test"), button -> {
                System.out.println("CLICKED");
            }).dimensions(4, 4, 75, 20).build());
        }
    }
}