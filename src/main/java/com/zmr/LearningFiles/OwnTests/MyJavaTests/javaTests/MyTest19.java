// package main.java.com.zmr.LearningFiles.MyJavaTests.javaTests;
//
// /**
//  * @ClassName MyTest12
//  * @Author zhumengren
//  * @Date 2022/6/7 10:46
// 
//  * @Version 1.0
//  **/
// public class MyTest19 {
//     public static void main(String[] args) {
//         //// 调用instance对象的方法
//         //List<Integer> list = new ArrayList<>();
//         //list.add(123);
//
//         //// 调用非instance对象的方法
//         //ArrayList<Integer> arrayList = new ArrayList<>();
//         //arrayList.add(123);
//
//         I i = C::n;
//         // 等价于
//         I i1 = () -> { C.n(); };
//     }
//
//     @FunctionalInterface
//     public interface I {
//         void m();
//     }
//
//     public static class C {
//         static void n() {
//             System.out.println("123~");
//         }
//     }
// }
