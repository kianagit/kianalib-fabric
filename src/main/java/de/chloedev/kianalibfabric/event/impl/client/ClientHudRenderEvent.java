package de.chloedev.kianalibfabric.event.impl.client;

import de.chloedev.kianalibfabric.event.CancelableEvent;
import de.chloedev.kianalibfabric.event.Event;
import de.chloedev.kianalibfabric.render.ScreenPos;
import net.minecraft.text.Text;

import java.util.HashMap;
import java.util.Map;

public class ClientHudRenderEvent extends Event {

    private final Map<String, TextElement> textElements;

    public ClientHudRenderEvent() {
        this.textElements = new HashMap<>();
    }

    public void addTextElement(String id, TextElement element) {
        this.textElements.put(id, element);
    }

    public void removeTextElement(String id) {
        this.textElements.remove(id);
    }

    public Map<String, TextElement> getTextElements() {
        return textElements;
    }

    public record TextElement(ScreenPos pos, Text text) {
    }
}