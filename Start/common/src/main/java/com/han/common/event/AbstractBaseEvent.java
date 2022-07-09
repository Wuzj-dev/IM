package com.han.common.event;

import com.han.common.model.JackBaseEntity;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @ClassNAME BseaEvent
 * @Description
 * @Author wuj
 * @Date 2022/7/9 13:52
 */
public abstract class AbstractBaseEvent
        extends JackBaseEntity implements EventI {

    private static AtomicLong atomicLong = new AtomicLong(0);

    /**
     * 元数据
     */
    private Map<String, Object> metaData;

    /**
     * 执行器
     */
    private Executor executor;

    private Long eventId;

    public AbstractBaseEvent() {
        this(getAtomicLong());
    }

    public AbstractBaseEvent(Long eventId) {
        this(eventId, Collections.emptyMap());
    }

    public AbstractBaseEvent(Map<String, Object> metaData) {
        this(getAtomicLong(), metaData);
    }

    public AbstractBaseEvent(Long eventId, Map<String, Object> metaData) {
        this(eventId, metaData, null);
    }

    public AbstractBaseEvent(Long eventId, Executor executor) {
        this(eventId, null, executor);
    }

    public AbstractBaseEvent(Executor executor, Map<String, Object> metaData) {
        this(getAtomicLong(), metaData, executor);
    }

    public AbstractBaseEvent(Long eventId, Map<String, Object> metaData, Executor executor) {
        this.eventId = eventId;
        this.metaData = metaData;
        this.executor = executor;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public static Long getAtomicLong() {
        return atomicLong.incrementAndGet();
    }

    @Override
    public Executor executor() {
        return executor;
    }

    @Override
    public Long eventId() {
        return eventId;
    }

    @Override
    public Map<String, Object> metaData() {
        return metaData;
    }
}
