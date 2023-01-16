package LearningFiles.MyJavaTests.javaTests;

/**
 * @ClassName Base
 * @Description Base测试类
 * @Author zhumengren
 * @Date 2022/4/8 16:06
 * @Email zhumengren@sinosoft.com
 * @Version 1.0
 **/
public class Base {
    int w, x, y, z;

    public Base(int a, int b) {
        x = a;
        y = b;
    }

    public Base(int a, int b, int c, int d) {
        // 1
        // new Base(a,b);

        // 2
        //x = a, y = b;

        // 3
        //x = a;
        //y = b;

        // 4
        this(a, b);
    }
}
