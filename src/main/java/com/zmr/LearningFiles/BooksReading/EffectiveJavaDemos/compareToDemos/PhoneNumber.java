package com.zmr.LearningFiles.BooksReading.EffectiveJavaDemos.compareToDemos;

import java.util.Comparator;

import static java.util.Comparator.comparingInt;

// public class PhoneNumber implements Cloneable, Comparable {
public class PhoneNumber implements Cloneable {
    private final short areaCode, prefix, lineNum;

    // hashCode 缓存值
    private int hashCode;

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "area code");
        this.prefix = rangeCheck(prefix, 999, "prefix");
        this.lineNum = rangeCheck(lineNum, 9999, "line num");
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max) {
            throw new IllegalArgumentException(arg + ": " + val);
        }
        return (short) val;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof PhoneNumber)) {
            return false;
        }
        PhoneNumber pn = (PhoneNumber) o;
        return pn.lineNum == lineNum && pn.prefix == prefix
                && pn.areaCode == areaCode;
    }

    @Override
    public int hashCode() {
        // 使用 Guava 中的方法 【尽量使用在性能要求不是很高的地方，因为接受可变参数，需要先创建数组】
        // return Objects.hash(lineNum, prefix, areaCode);

        // 增加缓存策略
        int result = hashCode;
        if (result == 0) {
            // 性能更好
            result = Short.hashCode(areaCode);
            result = 31 * result + Short.hashCode(prefix);
            result = 31 * result + Short.hashCode(lineNum);
            hashCode = result;
        }
        return result;
    }

    @Override
    public PhoneNumber clone() {
        try {
            return (PhoneNumber) super.clone();
        } catch (CloneNotSupportedException e) {
            // Can't happen
            throw new AssertionError();
        }
    }

    // @Override
    // public int compareTo(Object o) {
    //     if (!(o instanceof PhoneNumber)) {
    //         return -1;
    //     }
    //     PhoneNumber pn = (PhoneNumber) o;
    //     int result = Short.compare(areaCode, pn.areaCode);
    //     if (result == 0) {
    //         result = Short.compare(prefix, pn.prefix);
    //         if (result == 0) {
    //             result = Short.compare(lineNum, pn.lineNum);
    //         }
    //     }
    //     return result;
    // }

    private static final Comparator<PhoneNumber> COMPARATOR =
            comparingInt((PhoneNumber pn) -> pn.areaCode)
                    .thenComparingInt(pn -> pn.prefix)
                    .thenComparingInt(pn -> pn.lineNum);

    public int compareTo(PhoneNumber pn) {
        return COMPARATOR.compare(this, pn);
    }

//    private static Comparator<Object> hashCodeOrder = new Comparator<Object>() {
//        @Override
//        public int compare(Object o1, Object o2) {
//            // TODO 千万不要使用这种方式，它很容易造成整数溢出，同时违反 IEEE 754 浮点算数标准
////            return o1.hashCode() - o2.hashCode();
//
//            // 使用静态方法 compare
//            return Integer.compare(o1.hashCode(), o2.hashCode());
//        }
//    };


    private static Comparator<Object> hashCodeOrder =
            Comparator.comparingInt(o -> o.hashCode());
}
