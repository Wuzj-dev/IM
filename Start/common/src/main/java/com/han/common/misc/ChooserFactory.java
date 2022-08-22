package com.han.common.misc;

/**
 * @ClassNAME ChooserFactory
 * @Description
 * @Author wuj
 * @Date 2022/7/12 12:34
 */
public interface ChooserFactory<P> {

    /**
     * 选择器
     * @param param the param
     * @return the return
     */
    Chooser newChooser(P[] param);

    interface Chooser<P> {

        /**
         * 选择下一个
         * @return the P
         */
        P next();
    }
}
