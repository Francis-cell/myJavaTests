package com.zmr.LearningFiles.BooksReading.EffectiveJavaDemos.SerializableDemo;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;

public class Period implements Serializable {
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

    /**
     * 序列化代理 demo
     */
    private class SerializationProxy implements Serializable {
        private final Date start;

        private final Date end;

        SerializationProxy(Period p) {
            this.start = p.start();
            this.end = p.end();
        }

        private static final long serialVersionUID = 234216236122312L;

        /**
         * 序列化代理类提那家一个 readResolve 方法，它的返回逻辑上相当于外围类的实例
         * readResolve method for Period.SerializationProxy
         */
        private Object readResolve() {
            // use public constructor
            return new Period(start, end);
        }
    }

    /**
     * writeReplace method for the serialization proxy pattern
     * 有了这个方法，序列化系统永远不会产生外围类的序列化示例，但是攻击者有可能伪造，企图违反该类的约束条件。
     * 为了防御此类攻击，只要在外围类中添加如下 readObject 方法即可。
     * @return
     */
    private Object writeReplace() {
        return new SerializationProxy(this);
    }

    /**
     * readObject method for the serialization proxy pattern
     * @param stream
     * @throws InvalidObjectException
     */
    private void readObject(ObjectInputStream stream) throws InvalidObjectException {
        throw new InvalidObjectException("Proxy required!");
    }

}
