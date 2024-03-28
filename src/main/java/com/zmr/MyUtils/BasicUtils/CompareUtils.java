package com.zmr.MyUtils.BasicUtils;

public interface CompareUtils {
    /**
     * <p> 检查两个数据是否是相同的  </p>
     * @param v1
     * @param v2
     * @return
     * @param <E>
     */
    <E> Boolean checkTwoValueEquals(E v1, E v2);
}
