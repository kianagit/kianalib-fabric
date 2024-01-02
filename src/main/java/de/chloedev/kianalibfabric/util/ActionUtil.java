package de.chloedev.kianalibfabric.util;

import java.util.function.Supplier;

public class ActionUtil {

    public static void doNothing(Object... values) {
    }

    public static <T> T get(Supplier<T> supplier) {
        return supplier.get();
    }

    public interface Task {
        void run();
    }
}