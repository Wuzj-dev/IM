package com.han.common.event;

import com.han.common.dto.Response;

/**
 * @ClassNAME EventHubI
 * @Description
 * @Author wuj
 * @Date 2022/7/9 16:04
 */
public interface EventBusI {

    Response fire(AbstractDefaultEvent event);

    void fireAll(AbstractDefaultEvent event);

    void asyncFire(AbstractDefaultEvent event);

}
