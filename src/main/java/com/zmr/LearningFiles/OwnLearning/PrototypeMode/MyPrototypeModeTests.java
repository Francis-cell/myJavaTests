//package main.java.com.zmr.LearningFiles.MyDesignPatterns.PrototypeMode;
//
///**
// * @ClassName MyPrototypeModeTests
// * @Description 原型模式测试
// * @Author zhumengren
// * @Date 2022/10/20 10:24
//
// * @Version 1.0
// **/
//public class MyPrototypeModeTests {
//    private static Integer x = 3;
//
//    private static EntityClassExample user = new EntityClassExample("小黑", x);
//
//    public static void updateAge(int val) {
//        val = 3 * val;
//    }
//
//    public static void updateUser(EntityClassExample user) {
//        user.setName("小白");
//        user.setAge(10);
//    }
//
//    public static void main(String[] args) {
//        System.out.println("调用前x的值为：" + x);
//        updateAge(x);
//        System.out.println("调用后x的值为：" + x);
//
//        System.out.println("调用前user的值为：" + user.toString());
//        updateUser(user);
//        System.out.println("调用后user的值为：" + user.toString());
//    }
//}
