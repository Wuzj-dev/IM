package com.han.common.event;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @ClassNAME DefuletPushService
 * @Description
 * @Author wuj
 * @Date 2022/7/9 15:29
 */
@Component
public class DefaultEventPublisher implements ApplicationContextAware {

    private static EventBusI eventBusI = null;

    @Autowired
    EventHub eventHub;

    /**
     * 事件发布
     *
     * @param event the event
     */
    public static void push(final AbstractDefaultEvent event) {
        eventBusI.fireAll(event);
    }

    /**
     * 事件发布
     *
     * @param event the event
     */
    public static void pushAsync(final AbstractDefaultEvent event) {
        eventBusI.asyncFire(event);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (applicationContext != null) {
            final EventBus bean = applicationContext.getBean(EventBus.class);
            eventBusI = bean;
        }
    }
}
