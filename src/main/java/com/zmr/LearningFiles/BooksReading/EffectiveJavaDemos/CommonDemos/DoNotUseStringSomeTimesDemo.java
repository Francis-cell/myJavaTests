package com.zmr.LearningFiles.BooksReading.EffectiveJavaDemos.CommonDemos;

public class DoNotUseStringSomeTimesDemo {

    /**
     * 这个类这样声明存在的问题：当多个线程同时使用这个方法
     * A 设置的 key 是 a
     * B 设置的 key 是 a
     * 那么 A 和 B 就会出现数据混乱的问题，其中一个客户端可以获取到另外一个客户端的数据
     */
    public class ThreadLocal01 {
        private String key;
        private Object value;

        private ThreadLocal01() {}

        public void set(String key, Object value) {
            this.key = key;
            this.value = value;
        }

        public Object get(String key) {
            return this.value;
        }
    }

    /**
     * 使用一个不可伪造的键（有时被称作能力）来代替字符串即可
     * This API can be fixed by replacing the string with an unforgeable key
     * (sometimes called a capability):
     */
    public class ThreadLocal02 {
        private Key key;
        private Object value;
        private ThreadLocal02() {}

        // Capability
        public class Key {
            Key()  {}
        }

        // Generate a unique, unforgeable key
        public Key getKey() {
            return new Key();
        }

        public void set(Key key, Object value) {
            this.key = key;
            this.value = value;
        }

        public Object get(Key key) {
            return this.value;
        }
    }

    /**
     * 方法三（存在问题：类型不安全）
     */
    public final class ThreadLocal03 {
        private Object value;

        public ThreadLocal03() {};
        public void set(Object value) {
            this.value = value;
        }
        public Object get() {
            return this.value;
        }
    }

    /**
     * 在方法三的基础上增加泛型设计，使得它类型安全
     */
    public final class ThreadLocal04<T> {
        private T value;

        public ThreadLocal04() {};
        public void set(T value) {
            this.value = value;
        }
        public T get() {
            return this.value;
        }
    }

    public static void main(String[] args) {

    }
}
