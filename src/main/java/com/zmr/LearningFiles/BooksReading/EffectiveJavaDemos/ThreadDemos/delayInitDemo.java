package com.zmr.LearningFiles.BooksReading.EffectiveJavaDemos.ThreadDemos;

public class delayInitDemo {
    /** -------------------------- 双重检查 ------------------------------- */
    /** ........................... 静态域 ................................ */
    /**
     * 如果出于性能的考虑需要对静态域使用延迟初始化，
     * 就使用 lazy initialization holder class 模式
     */
    private static class FieldHolder {
        static final FieldType field = computeFieldValue();
    }

    private final FieldType getFieldStatic() {
        return FieldHolder.field;
    }

    /** ........................... 非静态域 ............................... */
    /**
     * 对于非静态的域使用延迟初始化
     */
    private volatile FieldType field;

    private FieldType getFieldNotStatic() {
        FieldType result = field;
        // First check (no locking)
        if (result == null) {
            synchronized (this) {
                // Second check (with locking)
                if (field == null) {
                    field = result = computeFieldValue();
                }
            }
        }
        return result;
    }


    /** -------------------------- 单重检查 ------------------------------- */
    // Single-check idiom - can cause repeated initialization!
    // private volatile FieldType field;

    private FieldType getFieldSingleNotStatic() {
        FieldType result = field;
        if (result == null) {
            field = result = computeFieldValue();
        }
        return result;
    }


    private static FieldType computeFieldValue() {
        // TODO 相关运算
        return new FieldType();
    }

    public static void main(String[] args) {
        /**
         * 补充说明
         * 当 双重检查模式 或者 单重检查模式 应用到数值型的基本类型域时，就会用 0 来检查这个域
         * （这是数值型基本变量的默认值）而不是使用 null
         */
    }
}
