package com.zmr.LearningFiles.EffectiveJavaDemos.MethodsDemo;

import java.util.Date;

public class Period {
    private final Date start;
    private final Date end;

    /**
     * @param start the beginning of the period
     * @param end the end of the period; must not precede start
     * @throws IllegalArgumentException if start is after end
     * @throws NullPointerException if start of end is null
     */
    public Period(Date start, Date end) {
        // // 原本的写法，没有保护性拷贝的加持
        // if (start.compareTo(end) > 0) {
        //     throw new IllegalArgumentException(
        //             start + "after " + end
        //     );
        // }
        // this.start = start;
        // this.end = end;

        // 使用保护性拷贝加持的写法（保护性拷贝需要在参数比较之前进行）
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());

        if (this.start.compareTo(this.end) > 0) {
            throw new IllegalArgumentException(
                    start + "after " + end
            );
        }
    }

    public Date start() {
        // 原本的写法，不能规避掉参数被修改的问题
        // return start;

        // 保护性拷贝调整后写法
        return new Date(start.getTime());
    }

    public Date end() {
        // 原本的写法，不能规避掉参数被修改的问题
        // return end;

        // 保护性拷贝调整后写法
        return new Date(end.getTime());
    }

    // ...
}
