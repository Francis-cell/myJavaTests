//package main.java.com.zmr.LearningFiles.BasicJava.lambdaTests;
//
//import main.java.com.zmr.LearningFiles.BasicJava.entity.Classes;
//import main.java.com.zmr.LearningFiles.BasicJava.entity.Student;
//
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.List;
//import java.util.stream.Stream;
//
//import static java.util.stream.Collectors.averagingInt;
//import static java.util.stream.Collectors.maxBy;
//
///**
// * @ClassName LambdaTests03
// * @Description 高级集合类及收集器--转换成值
// * @Author zhumengren
// * @Date 2022/3/15 16:59
//
// * @Version 1.0
// **/
//public class LambdaTests03 {
//    public static void main(String[] args) {
//        List<Student> students = new ArrayList<>(3);
//        students.add(new Student("小白", 10, 90));
//        students.add(new Student("小黑", 9, 101));
//        students.add(new Student("阿根", 11, 110));
//
//        Classes classes01 = new Classes("一班", students);
//        // 复制students，并移除一个学生
//        List<Student> students1 = new ArrayList<>(students);
//        students1.remove(2);
//
//        Classes classes02 = new Classes("二班", students1);
//        // 将 classes01和classes02转换成Stream
//        Stream<Classes> classesStream = Stream.of(classes01, classes02);
//        Classes classes = maxStudentsClasses(classesStream);
//        // 运行结果：人数最多的班级是：一班
//        System.out.println("人数最多的班级是：" + classes.getNames());
//        // 运行结果：一班的平均年龄是：10.0
//        System.out.println("一班的平均年龄是：" + averageAgeOfStudents(students));
//    }
//
//    /**
//     * 获取人数最多的班级
//     */
//    private static Classes maxStudentsClasses(Stream<Classes> classes) {
//        return classes.collect(maxBy(Comparator
//                                .comparing(classess -> classess.getStudents()
//                                .size())))
//                .orElseGet(Classes::new);
//    }
//
//    /**
//     * 计算学生的平均年龄
//     */
//    private static double averageAgeOfStudents(List<Student> students) {
//        return students.stream().collect(averagingInt(Student::getAge));
//    }
//}
