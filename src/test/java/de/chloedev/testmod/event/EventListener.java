package de.chloedev.testmod.event;

import de.chloedev.kianalibfabric.event.EventHandler;
import de.chloedev.kianalibfabric.event.impl.client.ClientHudRenderEvent;
import de.chloedev.kianalibfabric.event.impl.client.ClientHudRenderEvent.TextElement;
import de.chloedev.kianalibfabric.event.impl.client.ClientScreenChangeEvent;
import de.chloedev.kianalibfabric.render.ScreenPos;
import de.chloedev.testmod.TestScreen;
import net.minecraft.client.gui.screen.option.LanguageOptionsScreen;
import net.minecraft.text.Text;

public class EventListener {

    @EventHandler
    public void onHudRender(ClientHudRenderEvent e) {
        e.addTextElement("someElement", new TextElement(ScreenPos.relative(50, 50), Text.literal("Some Element")));
    }

    @EventHandler
    public void onScreenChange(ClientScreenChangeEvent e) {
        System.out.println("Changing Screen: '" + e.getOldScreen() + "' -> '" + e.getNewScreen() + "'");
        if(e.getNewScreen() instanceof LanguageOptionsScreen s){
            e.setNewScreen(new TestScreen());
        }
    }
}