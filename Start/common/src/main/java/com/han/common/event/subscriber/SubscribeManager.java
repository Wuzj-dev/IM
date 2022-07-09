package com.han.common.event.subscriber;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/**
 * @ClassNAME SubscribeManager
 * @Description 订阅事件处理器
 * @Author wuj
 * @Date 2022/7/9 13:17
 */
public class SubscribeManager {

    /**
     * ListenerEvent.class  -> List<Subscriber>
     */
    private static Map<Class<?>, List<Subscriber>> SUBSCRIBE_MAP = new HashMap<>();

    private static SubscribeManager subscribeManager = new SubscribeManager();

    private static SubscribeManager getSubscribeManager() {
        return subscribeManager;
    }

    private static Map<Class<?>, List<Subscriber>> getSubscribeManagerMap() {
        return SUBSCRIBE_MAP;
    }

    /**
     * 注册订阅事件
     *
     * @param class<?>   the cla
     * @param subscriber the subscriber
     */
    public static synchronized void register(Class<?> cla, Subscriber subscriber) {
        Map<Class<?>, List<Subscriber>> subscribeManagerMap = getSubscribeManagerMap();
        List<Subscriber> subscribers = subscribeManagerMap.get(cla);
        if (subscribers == null) {
            subscribers = new LinkedList<>();
        }
        subscribers.add(subscriber);
        subscribeManagerMap.put(cla, subscribers);
    }

    public static void push(ListenerEvent event) {
        if (event == null) {
            return;
        }
        Class<? extends ListenerEvent> eventClass = event.getClass();
        List<Subscriber> subscribers = getSubscribeManagerMap().get(eventClass);
        if (subscribers == null) {
            return;
        }

        subscribers.forEach(subscriber -> {
            if (subscriber.ignoreExpireEvent()) {
                return;
            }
            Executor executor;
            if ((executor = subscriber.executor()) != null
                    || (executor = event.executor()) != null) {
                executor.execute(() -> subscriber.onEvent(event));
                return;
            }
            subscriber.onEvent(event);
        });
    }


}
