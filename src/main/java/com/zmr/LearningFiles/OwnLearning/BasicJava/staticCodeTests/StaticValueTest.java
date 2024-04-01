package com.zmr.LearningFiles.OwnLearning.BasicJava.staticCodeTests;

/**
 * @ClassName StaticValueTest
 * @Description 静态值测试
 * @Author zhumengren
 * @Date 2022/4/19 17:21

 * @Version 1.0
 **/
public class StaticValueTest {
    /** 八种基本数据类型变量 */
    public static byte byteValue;

    public static int intValue;

    public static float floatValue;

    public static long longValue;

    public static short shortValue;

    public static char charValue;

    public static boolean booleanValue;

    /** String 的静态初始化值 */
    public static String stringVale;

    /** StringBuffer 的静态初始化值 */
    public static StringBuffer stringBufferValue;

    /** StringBuilder 的静态初始化值 */
    public static StringBuilder stringBuilderValue;

    /**
     * 输出 八种基本数据类型的 static 静态初始化值
     * @return void
     */
    public static void baseStaticValues() {
        System.out.println("静态byte值为：" + byteValue);
        System.out.println("静态int值为：" + intValue);
        System.out.println("静态float值为：" + floatValue);
        System.out.println("静态long值为：" + longValue);
        System.out.println("静态short值为：" + shortValue);
        System.out.println("静态char值为：" + charValue);
        System.out.println("静态boolean值为：" + booleanValue);
    }

    /**
     * 输出 其他类型的 static 静态初始化值
     * @return void
     */
    public static void otherStaticValues() {
        System.out.println("静态String值为：" + stringVale);
        System.out.println("静态StringBuffer值为：" + stringBufferValue);
        System.out.println("静态StringBuilder值为：" + stringBuilderValue);
    }
}
