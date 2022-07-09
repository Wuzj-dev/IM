package com.han.common.event;

import com.han.common.dto.Response;

import java.util.concurrent.ExecutorService;

/**
 * @ClassNAME EventHandler
 * @Description
 * @Author wuj
 * @Date 2022/7/9 15:30
 */
public interface EventHandlerI<E extends AbstractBaseEvent, S extends Response> {

    default ExecutorService getExecutor() {
        return null;
    }

    /**
     * 时间处理
     * @param event event
     * @return the Response
     */
    S execute(E event);
}
