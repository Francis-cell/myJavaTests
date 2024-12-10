package com.zmr.MyUtils.TestTools.CompareUtils;

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
     * <p> 使用案例： </p>
     * <pre>
     *     {@code
     *          // 字符串比较
     *          checkTwoValueEquals("1", "1");
     *
     *          // Integer 比较
     *          Integer integer1 = new Integer(129);
     *          Integer integer2 = new Integer(129);
     *          checkTwoValueEquals(integer1, integer2);
     *
     *          // Date 比较
     *          // 原始日期对象
     *          Date originalDate = new Date();
     *          // 拷贝日期对象
     *          Date copiedDate = new Date(originalDate.getTime());
     *          checkTwoValueEquals(originalDate, copiedDate);
     *     }
     * </pre>
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
            return v1.equals(v2);
        }
        // 4、Date 检查
        if (v1 instanceof Date) {
            return ((Date) v1).compareTo((Date) v2) == 0;
        }

        return ans;
    }

    /**
     * <p> 检查两个 int 值的相等性 </p>
     * <p> 使用案例： </p>
     * <pre>
     *     {@code
     *          checkTwoValueEquals(1, 1);
     *     }
     * </pre>
     * @param v1
     * @param v2
     * @return
     */
    public static boolean checkTwoValueEquals(int v1, int v2) {
        return v1 == v2;
    }

    /**
     * <p> 检查两个浮点类型的数据是否相等 </p>
     * <pre>
     *     {@code
     *          checkTwoValueEquals(1.1, 1.1);
     *     }
     * </pre>
     * @param v1
     * @param v2
     * @return
     */
    public static boolean checkTwoValueEquals(double v1, double v2) {
        return v1 == v2;
    }

    /**
     * <p> 检查两个浮点类型的数据是否相等 </p>
     * <pre>
     *     {@code
     *          checkTwoValueEquals('1', '1');
     *     }
     * </pre>
     * @param v1
     * @param v2
     * @return
     */
    public static boolean checkTwoValueEquals(char v1, char v2) {
        return v1 == v2;
    }
}
