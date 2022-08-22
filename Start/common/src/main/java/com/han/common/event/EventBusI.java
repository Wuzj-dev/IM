package com.han.common.event;

import com.han.common.dto.Response;

/**
 * @ClassNAME EventHubI
 * @Description
 * @Author wuj
 * @Date 2022/7/9 16:04
 */
public interface EventBusI {
    /**
     * 同步选择执行一个
     *
     * @param event the event
     * @return the return
     */
    Response fire(AbstractDefaultEvent event);

    /**
     * 同步执行所有的 handle
     *
     * @param event the event
     */
    void fireAll(AbstractDefaultEvent event);

    /**
     * 执行所有的handle
     *
     * @param event the event
     */
    void asyncFire(AbstractDefaultEvent event);

}
