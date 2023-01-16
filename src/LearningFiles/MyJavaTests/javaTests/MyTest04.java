package LearningFiles.MyJavaTests.javaTests;

/**
 * @ClassName MyTest04
 * @Description Java测试04
 * @Author zhumengren
 * @Date 2022/4/8 9:19
 * @Email zhumengren@sinosoft.com
 * @Version 1.0
 **/
public class MyTest04 {
    public void methodTest() {
        // line innner values
        new Inner();
    }

    public class Inner {}
    public static void main(String[] args) {
        MyTest04 myTest04 = new MyTest04();
        // line innner values
        //new Inner();
        //new myTest04.Inner();
        //new MyTest04.Inner();
    }

}
