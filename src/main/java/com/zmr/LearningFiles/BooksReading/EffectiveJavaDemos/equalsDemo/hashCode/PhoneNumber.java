package com.zmr.LearningFiles.BooksReading.EffectiveJavaDemos.equalsDemo.hashCode;

public class PhoneNumber implements Cloneable{
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
}
