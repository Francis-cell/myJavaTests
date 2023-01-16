package LearningFiles.MyJavaTests.javaTests;

/**
 * @ClassName MyTest01
 * @Description Java测试1
 * @Author zhumengren
 * @Date 2022/4/7 10:03
 * @Email zhumengren@sinosoft.com
 * @Version 1.0
 **/
public class MyTest01 {
    public static void main(String[] args) {
        int a = 5;
        int b = a;
        String str = "str";
        String str1 = str;
        System.out.println(a==b);
        System.out.println(str==str1);
        System.out.println("str的内存地址为" + System.identityHashCode(str));
        System.out.println("str1的内存地址为" + System.identityHashCode(str1));

    }
}
