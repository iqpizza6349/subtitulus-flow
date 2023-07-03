package io.iqpizza6349.subflow.event.core;

import io.iqpizza6349.subflow.event.EventListener;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.io.*;
import java.lang.reflect.Method;
import java.util.*;

import static org.reflections.scanners.Scanners.*;

/**
 * This class is register event methods and handle.
 * <p>
 *     Event Register is use by Reflection API to regists all method in packages.
 *     <br>
 * </p>
 * P.S. This class is based on the reflection API. Please don't edit it
 * carelessly.
 *
 * @see EventListener
 *
 * @since 0.1.0
 * @author iqpizza6349
 * @version 0.1.0
 */
public final class EventHandler {

    private static final Map<Class<?>, List<Method>> eventListeners = new HashMap<>();

    public static void registerEventListener(Class<?> listener) {
        Method[] methods = listener.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(EventListener.class)) {
                Class<?> eventType = method.getParameterTypes()[0];
                List<Method> handlers = eventListeners.getOrDefault(eventType, new ArrayList<>());
                handlers.add(method);
                eventListeners.put(eventType, handlers);
            }
        }
    }

    public static void publishEvent(Object event) {
        List<Method> handlers = eventListeners.get(event.getClass());
        if (handlers != null) {
            for (Method handler : handlers) {
                try {
                    // TODO: this code will be quiet dangerous
                    //noinspection deprecation
                    handler.invoke(handler.getDeclaringClass().newInstance(), event);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void registerClasses() throws IOException {
        Set<Class<?>> allClassesInPackage = findAllClassesInPackage();
        for (Class<?> clazz : allClassesInPackage) {
            if (hasAnnotation(clazz)) {
                registerEventListener(clazz);
            }
        }
    }

    @SuppressWarnings("deprecation")
    public static Set<Class<?>> findAllClassesInPackage() throws IOException {
        Reflections reflections = new Reflections("io.iqpizza6349.subflow", new SubTypesScanner(false));
        return reflections.get(SubTypes.of(Object.class).asClass());
    }

    private static boolean hasAnnotation(Class<?> clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(EventListener.class)) {
                return true;
            }
        }
        return false;
    }
}
