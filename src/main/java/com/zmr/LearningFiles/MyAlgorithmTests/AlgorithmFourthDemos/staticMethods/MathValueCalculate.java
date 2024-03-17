package com.zmr.LearningFiles.MyAlgorithmTests.AlgorithmFourthDemos.staticMethods;

/**
 * @Author franciszmr
 * @Date 2024/3/5 8:59
 * @Version 1.0
 * @Description 数学运算相关方法
 **/
public class MathValueCalculate {
    /**
     * <p> 计算一个整数的绝对值 </p>
     * @param x
     * @return
     */
    public static int abs(int x) {
        if (x < 0) {
            return -x;
        } else {
            return x;
        }
    }

    /**
     * <p> 计算一个浮点数的绝对值 </p>
     * @param x
     * @return
     */
    public static double abs(double x) {
        if (x < 0.0) {
            return -x;
        } else {
            return x;
        }
    }

    /**
     * <p> 判断一个数是否是素数 </p>
     * @param N
     * @return
     */
    public static boolean isPrime(int N) {
        if (N < 2) {
            return false;
        }

        for (int i = 2; i*i < N; i++) {
            if (N % i == 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * <p> 计算平方根（牛顿迭代法） </p>
     * @param c
     * @return
     */
    public static double sqrt(double c) {
        if (c < 0) {
            return Double.NaN;
        }

        double err = 1e-15;
        double t = c;
        while (Math.abs(t - c / t) > err * t) {
            t = (c / t + t) / 2.0;
        }
        return t;
    }

    /**
     * <p> 计算三角形的斜边 </p>
     * @param a
     * @param b
     * @return
     */
    public static double hypotenuse(double a, double b) {
        return Math.sqrt(a * a + b * b);
    }

    /**
     * <p> 调和级数 </p>
     * @param N
     * @return
     */
    public static double H(int N) {
        double sum = 0.0;
        for (int i = 0; i < N; i++) {
            sum += 1.0 / i;
        }
        return sum;
    }

    public static void main(String[] args) {
    }
}
