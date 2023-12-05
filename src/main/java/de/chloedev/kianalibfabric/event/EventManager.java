package de.chloedev.kianalibfabric.event;


import java.lang.reflect.Method;
import java.util.*;

/**
 * @author Eric Golde
 * NOTE: I (kiana) only modified this slightly. It's main credits should go to eric!
 */
public class EventManager {

    private static final Map<Class<? extends Event>, ArrayList<EventData>> REGISTRY_MAP = new HashMap<>();

    private static void sortListValue(Class<? extends Event> clazz) {
        ArrayList<EventData> flexableArray = new ArrayList<>();
        for (byte b : EventPriority.VALUES()) {
            for (EventData methodData : EventManager.REGISTRY_MAP.get(clazz)) {
                if (methodData.priority == b) {
                    flexableArray.add(methodData);
                }
            }
        }
        EventManager.REGISTRY_MAP.put(clazz, flexableArray);
    }

    private static boolean isBad(Method method) {
        return method.getParameterTypes().length != 1 || !method.isAnnotationPresent(EventHandler.class);
    }

    public static ArrayList<EventData> get(Class<? extends Event> clazz) {
        return REGISTRY_MAP.get(clazz);
    }

    public static void register(Method method, Object o) {
        Class<?> clazz = method.getParameterTypes()[0];
        EventData methodData = new EventData(o, method, method.getAnnotation(EventHandler.class).priority());
        if (!methodData.target.isAccessible()) {
            methodData.target.setAccessible(true);
        }
        if (REGISTRY_MAP.containsKey(clazz)) {
            if (!REGISTRY_MAP.get(clazz).contains(methodData)) {
                REGISTRY_MAP.get(clazz).add(methodData);
                sortListValue((Class<? extends Event>) clazz);
            }
        } else {
            REGISTRY_MAP.put((Class<? extends Event>) clazz, new ArrayList<>(Collections.singletonList(methodData)));
        }
    }

    public static void register(Object... o) {
        for (Object o1 : o) {
            for (Method m : o1.getClass().getMethods()) {
                if (!isBad(m)) register(m, o1);
            }
        }
    }
}
