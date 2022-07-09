package com.han.common.policy;


/**
 * @author wuj
 */
public interface RejectionHandle<T> {

    /**
     *  拒绝策略接口
     * @param task the task
     * @param t the t
     */
    default void reject(Runnable task, T t){}

}
