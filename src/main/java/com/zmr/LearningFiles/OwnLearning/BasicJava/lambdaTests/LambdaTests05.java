//package main.java.com.zmr.LearningFiles.BasicJava.lambdaTests;
//
//import main.java.com.zmr.LearningFiles.BasicJava.entity.SpecialityEnum;
//import main.java.com.zmr.LearningFiles.BasicJava.entity.Student;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
///**
// * @ClassName LambdaTest05
// * @Description 高级集合类及收集器--数据分组
// * @Author zhumengren
// * @Date 2022/3/15 17:55
//
// * @Version 1.0
// **/
//public class LambdaTests05 {
//    public static void main(String[] args) {
//        List<Student> students = new ArrayList<>(3);
//        students.add(new Student("小白", 10, 90, new SpecialityEnum(true, true, false, true)));
//        students.add(new Student("小黑", 9, 101, new SpecialityEnum(false, false, true, true)));
//        students.add(new Student("阿根", 11, 110, new SpecialityEnum(true, true, true, true)));
//
//
//        Map<Boolean, List<Student>> listMap = students.stream().collect(
//                Collectors.groupingBy(student -> student.getSpecialityEnum().getSwimming() == true));
//        // 运行结果：{false=[Student(name=小白, age=10, height=90, specialityEnum=SpecialityEnum(sing=true, dance=true, swimming=false, running=true))],
//        // true=[Student(name=小黑, age=9, height=101, specialityEnum=SpecialityEnum(sing=false, dance=false, swimming=true, running=true)), Student(name=阿根, age=11, height=110, specialityEnum=SpecialityEnum(sing=true, dance=true, swimming=true, running=true))]}
//        System.out.println(listMap);
//    }
//}
