package com.han.common.event;

import java.util.Map;
import java.util.concurrent.Executor;

/**
 * @author hanlin
 */
public interface EventI {

    /**
     *  获取 执行器
     * @return
     */
    Executor getExecutor();

    /**
     * 获取事件Id
     * @return Int
     */
    Integer getEventId();

    /**
     * 获取事件元数据
     * @return the Map
     */
    Map getmData();
 


}
