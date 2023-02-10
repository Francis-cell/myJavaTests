//package main.java.com.zmr.LearningFiles.BasicJava.lambdaTests;
//
//import main.java.com.zmr.LearningFiles.BasicJava.entity.Student;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
///**
// * @ClassName LambdaTest06
// * @Description 高级集合类及收集器--字符串拼接
// * @Author zhumengren
// * @Date 2022/3/15 17:56
// * @Email zhumengren@sinosoft.com
// * @Version 1.0
// **/
//public class LambdaTests06 {
//    public static void main(String[] args) {
//        List<Student> students = new ArrayList<>(3);
//        students.add(new Student("小白", 10, 90));
//        students.add(new Student("小黑", 9, 101));
//        students.add(new Student("阿根", 11, 110));
//
//        String names = students.stream().map(
//                Student::getName).collect(Collectors.joining(",", "[", "]"));
//        // 运行结果: [小白,小黑,阿根]
//        System.out.println(names);
//    }
//}
