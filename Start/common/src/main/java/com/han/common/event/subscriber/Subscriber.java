package com.han.common.event.subscriber;

import com.han.common.event.EventI;

import java.util.concurrent.Executor;

/**
 * @ClassNAME Subscriber
 * @Description
 * @Author wuj
 * @Date 2022/7/9 13:16
 */
public interface Subscriber<T extends ListenerEvent> {

    /**
     * Event callback.
     *
     * @param event {@link ListenerEvent}
     */
    void onEvent(T event);

    /**
     * Type of this subscriber's subscription.
     *
     * @return Class which extends {@link ListenerEvent}
     */
    default Class<?> subscribeType() {
        return this.getClass();
    }

    /**
     * It is up to the listener to determine whether the callback is asynchronous or synchronous.
     *
     * @return {@link Executor}
     */
    default Executor executor() {
        return null;
    }

    /**
     * Whether to ignore expired events.
     *
     * @return default value is {@link Boolean#FALSE}
     */
    default boolean ignoreExpireEvent() {
        return false;
    }
}
