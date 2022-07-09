package com.han.common.event;

import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @ClassNAME EventHub
 * @Description
 * @Author wuj
 * @Date 2022/7/9 15:38
 */
@Component
public class EventHub {

    /**
     * EventHandlerI.class --> response.class
     */
    private Map<Class, Class> responseRepository = new HashMap();

    /**
     * AbstractDefaultEvent.class --> List<EventHandlerI>
     */
    private Map<Class<? extends AbstractDefaultEvent>, List<EventHandlerI>> eventRepository = new HashMap<>();

    public Map<Class<? extends AbstractDefaultEvent>, List<EventHandlerI>> getEventRepository() {
        return eventRepository;
    }

    public void register(Class<? extends AbstractDefaultEvent> c, EventHandlerI eventHandlerI) {
        List<EventHandlerI> eventHandlerIList = findEventHandlerList(c);
        if (eventHandlerIList == null) {
            eventHandlerIList = new LinkedList<>();
        }
        eventHandlerIList.add(eventHandlerI);
        getEventRepository().put(c, eventHandlerIList);
    }

    public List<EventHandlerI> findEventHandlerList(Class<? extends AbstractDefaultEvent> abstractDefaultEvent) {
        List<EventHandlerI> eventHandlerIList = getEventRepository().get(abstractDefaultEvent);
        return eventHandlerIList == null ?Collections.emptyList() : eventHandlerIList;
    }

    public Class<?> getResponseRepository(Class<?> c){
        return responseRepository.get(c);
    }


}
