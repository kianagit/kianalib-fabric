package de.chloedev.kianalibfabric.event;

public class CancelableEvent extends Event {

    private boolean cancelled;

    public boolean isCancelled() {
        return cancelled;
    }

    public void cancel() {
        this.cancelled = true;
    }
}
