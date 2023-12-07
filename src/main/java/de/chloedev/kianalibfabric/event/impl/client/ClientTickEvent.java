package de.chloedev.kianalibfabric.event.impl.client;

import de.chloedev.kianalibfabric.event.Event;

public class ClientTickEvent extends Event {

    private final InjectionPoint injectionPoint;

    public ClientTickEvent(InjectionPoint injectionPoint) {
        this.injectionPoint = injectionPoint;
    }

    public InjectionPoint getInjectionPoint() {
        return injectionPoint;
    }

    public enum InjectionPoint {
        START, END;
    }
}