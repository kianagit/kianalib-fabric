package de.chloedev.kianalibfabric.util;

import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Supplier;

public class ActionUtil {

    public static void doNothing(Object... values) {
    }

    public static <T> T get(Supplier<T> supplier) {
        return supplier.get();
    }

    /**
     * Runs the specified task "amount" of times every "periodMs" milliseconds, stating after "delayMs" milliseconds
     */
    public static void run(Task task, int amount, int delayMs, int periodMs) {
        new Timer().schedule(new TimerTask() {
            int i = 0;

            @Override
            public void run() {
                if (i == amount) {
                    this.cancel();
                    return;
                }
                task.run();
                i++;
            }
        }, delayMs, periodMs);
    }

    public interface Task {
        void run();
    }
}