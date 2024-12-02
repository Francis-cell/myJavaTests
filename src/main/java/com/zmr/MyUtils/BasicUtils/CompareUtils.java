package com.zmr.MyUtils.BasicUtils;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CompareUtils {
    private static final CompareUtils INSTANCE  = new CompareUtils();

    private CompareUtils() {}

    public static CompareUtils getInstance() {
        return INSTANCE;
    }

    /**
     * <p> 检查两个数据是否是相同的  </p>
     * @param v1
     * @param v2
     * @return
     * @param <E>
     */
    public static <E> Boolean checkTwoValueEquals(E v1, E v2) {
        Boolean ans = false;
        // 1、类型校验
        // null 值校验
        if (v1 == null && v2 == null) {
            return true;
        }
        if (v1 == null || v2 == null) {
            return false;
        }
        // v1 和 v2 的数据类型是否相同的校验
        if (v1.getClass().getName() != null && v2.getClass().getName() != null
                && !v1.getClass().getName().equals(v2.getClass().getName())) {
            return false;
        }

        // 2、字符串检查
        if (v1 instanceof String && v1.equals(v2)) {
            return true;
        }
        // 3、Integer、Double 检查
        if (v1 instanceof Integer || v1 instanceof Double) {
            return v1 == v2;
        }
        // 4、Date 检查
        if (v1 instanceof Date) {
            return ((Date) v1).compareTo((Date) v2) == 0;
        }

        return ans;
    }
}
