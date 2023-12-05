package de.chloedev.kianalibfabric.event;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class Event {

    public <T extends Event> T invoke() {
        List<EventData> l = EventManager.get(this.getClass());
        if (l != null) {
            l.forEach(d -> {
                try {
                    d.target.invoke(d.source, this);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        return (T) this;
    }
}
