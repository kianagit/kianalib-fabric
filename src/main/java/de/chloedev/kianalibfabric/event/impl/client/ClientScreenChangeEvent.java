package de.chloedev.kianalibfabric.event.impl.client;

import de.chloedev.kianalibfabric.event.CancelableEvent;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.Selectable;
import net.minecraft.client.gui.screen.Screen;

public class ClientScreenChangeEvent extends CancelableEvent {

    private Screen oldScreen;
    private Screen newScreen;

    public ClientScreenChangeEvent(Screen oldScreen, Screen newScreen) {
        this.oldScreen = oldScreen;
        this.newScreen = newScreen;
    }

    public <T extends Element & Drawable & Selectable> void addChild(T child) {
        this.newScreen.addDrawableChild(child);
    }

    public Screen getOldScreen() {
        return oldScreen;
    }

    public Screen getNewScreen() {
        return newScreen;
    }

    public void setNewScreen(Screen newScreen) {
        this.newScreen = newScreen;
    }
}
