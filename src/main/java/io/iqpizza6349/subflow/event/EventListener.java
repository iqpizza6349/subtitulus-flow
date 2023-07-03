package io.iqpizza6349.subflow.event;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation is to allow different objects to communicate with each
 * other through events.
 * <p>
 *     when use this annotation in class, that class must have no-args-constructor
 * </p>
 *
 * @since 0.1.0
 * @author iqpizza6349
 * @version 0.1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface EventListener {

    /**
     * Ignores the event listen when if true.
     * @return if true, ignores event.
     */
    boolean ignored() default false;
}
