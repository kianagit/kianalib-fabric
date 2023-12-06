package de.chloedev.testmod.event;

import de.chloedev.kianalibfabric.event.EventHandler;
import de.chloedev.kianalibfabric.event.impl.client.ClientHudRenderEvent;
import de.chloedev.kianalibfabric.render.ScreenPos;
import net.minecraft.text.Text;

public class EventListener {

    @EventHandler
    public void onHudRender(ClientHudRenderEvent e) {
        e.addTextElement("someElement", new ClientHudRenderEvent.TextElement(ScreenPos.relative(0, 0), Text.literal("Some Element")));
    }
}