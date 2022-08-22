package com.han.common.misc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassNAME DeflateChooserFactory
 * @Description
 * @Author wuj
 * @Date 2022/7/12 12:37
 */
public abstract class DeflateChooserFactory<P> implements ChooserFactory<P> {

    /**
     * 通用选择器， 默认轮训
     *
     * @param ps the param
     */
    public GenericChooser newChooser(P... ps) {
        return new GenericChooser(ps);
    }

    public static class GenericChooser<P> implements Chooser<P> {
        private final AtomicInteger idx = new AtomicInteger();
        private final P[] ps;

        public GenericChooser(P[] ps) {
            this.ps = ps;
        }

        @Override
        public P next() {
            return ps[Math.abs(idx.getAndIncrement() % ps.length)];
        }
    }
}
