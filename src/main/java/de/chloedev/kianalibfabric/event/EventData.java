package de.chloedev.kianalibfabric.event;

import java.lang.reflect.Method;

public class EventData {

    public Object source;
    public Method target;
    public byte priority;

    public EventData(Object source, Method target, byte priority) {
        this.source = source;
        this.target = target;
        this.priority = priority;
    }
}