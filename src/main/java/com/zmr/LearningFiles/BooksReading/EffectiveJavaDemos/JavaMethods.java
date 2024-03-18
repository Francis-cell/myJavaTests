package com.zmr.LearningFiles.BooksReading.EffectiveJavaDemos;

public class JavaMethods {
    public double add(float a, float b) {
        return a + b;
    }

//    public float add(float a, float b) {
//        return a + b;
//    }

    public static void main(String[] args) {
        // 本案例中两个 add 方法的方法签名是一致的，所以相当于是一个方法
        // 方法签名 = 方法名 + 参数 （不包含方法的返回值类型）
        // 这就是为什么 Java 中方法可以重载，但是重载的时候参数个数以及对应的参数类型不能一致的原因（和方法的返回值无关）
    }
}
