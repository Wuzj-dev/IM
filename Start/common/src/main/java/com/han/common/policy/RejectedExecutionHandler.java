package com.han.common.policy;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/**
 * @ClassNAME RejectedExecutionHandler
 * @Description
 * @Author wuj
 * @Date 2022/7/9 12:03
 */
public interface RejectedExecutionHandler<T extends Executor> extends RejectionHandle<T> {

    RejectedExecutionHandler REJECT = new RejectedExecutionHandler() {
        @Override
        public void reject(Runnable task, Executor executor) {
            throw new RejectedExecutionException();
        }
    };

    /**
     * 拒绝策略接口
     *
     * @param task     task
     * @param executor the executor
     */
    @Override
    default void reject(Runnable task, Executor executor) {
        REJECT.reject(task, executor);
    }

}
