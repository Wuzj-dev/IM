package com.han.common.event;

import com.han.common.dto.Response;
import com.han.common.exception.BaseException;
import com.han.common.exception.BasicErrorCode;
import com.han.common.exception.DefEventException;
import com.han.common.exception.ErrorCodeI;
import com.han.common.utils.ThreadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @ClassNAME EventBus
 * @Description
 * @Author wuj
 * @Date 2022/7/9 16:05
 */
@Component
public class EventBus implements EventBusI {
    ExecutorService defaultExecutor;
    @Autowired
    EventHub eventHub;
    BlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<>(1000);

    public BlockingQueue getBlockingQueue() {
        return blockingQueue;
    }

    public EventBus() {
        this.defaultExecutor = new ThreadPoolExecutor(ThreadUtils.getSuitableThreadCount(),
                ThreadUtils.getSuitableThreadCount(),
                0L, TimeUnit.MILLISECONDS,
                getBlockingQueue());
    }

    @Override
    public Response fire(AbstractDefaultEvent event) {
        Response response = null;
        EventHandlerI eventHandlerI = null;

        try {
            Optional<EventHandlerI> optionalEventHandlerI = this.eventHub.findEventHandlerList(event.getClass()).stream().findFirst();
            if (optionalEventHandlerI.isPresent()) {
                response = optionalEventHandlerI.get().execute(event);
            }
        } catch (Exception var5) {
            response = this.handleException(eventHandlerI, response, var5);
        }

        return response;
    }

    @Override
    public void fireAll(AbstractDefaultEvent event) {
        this.eventHub.findEventHandlerList(event.getClass()).stream().map((p) -> {
            Response response = null;

            try {
                response = p.execute(event);
            } catch (Exception var5) {
                response = this.handleException(p, response, var5);
            }

            return response;
        }).collect(Collectors.toList());
    }

    @Override
    public void asyncFire(AbstractDefaultEvent event) {
        this.eventHub.findEventHandlerList(event.getClass()).parallelStream().map((p) -> {
            Response response = null;

            try {
                if (null != p.getExecutor()) {
                    p.getExecutor().submit(() -> p.execute(event));
                } else {
                    this.defaultExecutor.submit(() -> p.execute(event));
                }
            } catch (Exception var5) {
                response = this.handleException(p, response, var5);
            }

            return response;
        }).collect(Collectors.toList());
    }

    private Response handleException(EventHandlerI handler, Response response, Exception exception) {

        Class responseClz = (Class) this.eventHub.getResponseRepository(handler.getClass());

        try {
            response = (Response) responseClz.newInstance();
        } catch (Exception var6) {
            throw new DefEventException(var6.getMessage());
        }

        if (exception instanceof BaseException) {
            ErrorCodeI errCode = ((BaseException) exception).getErrCode();
            response.setErrCode(errCode.getErrCode());
        } else {
            response.setErrCode(BasicErrorCode.SYS_ERROR.getErrCode());
        }

        response.setErrMessage(exception.getMessage());
        return response;
    }
}
