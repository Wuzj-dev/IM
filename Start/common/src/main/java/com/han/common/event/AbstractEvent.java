package com.han.common.event;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author hanlin
 */
public abstract class AbstractEvent implements EventI{

    private static final AtomicInteger atomicInteger = new AtomicInteger(0);

    Executor executor;

    private final Map mData;

    public AbstractEvent() {
        this(atomicInteger.incrementAndGet());
    }

    public AbstractEvent(Integer eventId) {
        this(eventId, Collections.emptyMap());
    }

    public AbstractEvent(Map map) {
        this(atomicInteger.decrementAndGet(), map);
    }

    public AbstractEvent(Integer eventId, Map map) {
        if (eventId == null) {
            eventId = atomicInteger.incrementAndGet();
        }
        if (map == null) {
            map = Collections.emptyMap();
        }
        this.mData = map;
    }

    public void setExecutor(Executor executor) {
        this.executor = executor;
    }

    @Override
    public Integer getEventId() {
        return this.getEventId();
    }

    @Override
    public Map getmData() {
        return mData;
    }

    @Override
    public Executor getExecutor() {
        return this.executor;
    }
}
