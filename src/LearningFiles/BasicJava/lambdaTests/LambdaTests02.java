//package LearningFiles.BasicJava.lambdaTests;
//
//import LearningFiles.BasicJava.entity.Student;
//
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import static java.util.Arrays.asList;
//
///**
// * @ClassName LambdaTests02
// * @Description 常用的流
// * @Author zhumengren
// * @Date 2022/3/15 15:26
// * @Email zhumengren@sinosoft.com
// * @Version 1.0
// **/
//public class LambdaTests02 {
//    public static void main(String[] args) {
//        // 1、collect(Collectors.toList())
//        List<Student> studentList = Stream.of(new Student("小白", 10, 90),
//                new Student("小黑", 9, 101)).collect(Collectors.toList());
//        System.out.println(studentList);
//
//        // 2、filter
//        List<Student> students = new ArrayList<>(3);
//        students.add(new Student("小白", 10, 90));
//        students.add(new Student("小黑", 9, 101));
//        students.add(new Student("阿根", 11, 110));
//
//        List<Student> list = students.stream()
//                .filter(stu -> stu.getHeight() > 100)
//                .collect(Collectors.toList());
//        // 运行结果：[Student(name=小黑, age=9, height=101), Student(name=阿根, age=11, height=110)]
//        System.out.println(list);
//
//        // 3、map
//        List<String> names = students.stream()
//                .map(student -> student.getName())
//                .collect(Collectors.toList());
//        // 运行结果：[小白, 小黑, 阿根]
//        System.out.println(names);
//
//
//        // 4、flatMap
//        List<Student> studentList1 = Stream.of(students,
//                asList(new Student("山新", 9, 100),
//                        new Student("伍六七", 20, 180)))
//                .flatMap(students1 -> students1.stream())
//                .collect(Collectors.toList());
//        // 运行结果：[Student(name=小白, age=10, height=90), Student(name=小黑, age=9, height=101), Student(name=阿根, age=11, height=110),
//        // Student(name=山新, age=9, height=100), Student(name=伍六七, age=20, height=180)]
//        System.out.println(studentList1);
//
//
//        // 5、max和min
//        Optional<Student> max = students.stream()
//                .max(Comparator.comparing(student -> student.getAge()));
//        Optional<Student> min = students.stream()
//                .min(Comparator.comparing(student -> student.getAge()));
//        // 判断是否有值
//        if (max.isPresent()) {
//            // 运行结果：Student(name=阿根, age=11, height=110)
//            System.out.println(max.get());
//        }
//        if (min.isPresent()) {
//            // 运行结果：Student(name=小黑, age=9, height=101)
//            System.out.println(min.get());
//        }
//
//
//        // 6、count
//        long count = students.stream().filter(student -> student.getAge() < 11).count();
//        // 运行结果：年龄小于11岁的人数有：2个。
//        System.out.println("年龄小于11岁的人数有：" + count + "个。");
//
//
//        // 7、reduce
//        Integer reduce = Stream.of(1, 2, 3, 4).reduce(0, (acc, x) -> acc + x);
//        // 运行结果：10
//        System.out.println(reduce);
//        Integer reduce1 = Stream.of(1, 2, 3, 4).reduce(1, (acc, x) -> acc * x);
//        // 运行结果：24
//        System.out.println(reduce1);
//        Integer sum = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
//        // 运行结果：10
//        System.out.println(sum);
//        Integer max1 = Stream.of(1, 2, 3, 4).reduce(0, Integer::max);
//        // 运行结果：4
//        System.out.println(max1);
//        Integer min1 = Stream.of(1, 2, 3, 4).reduce(0, Integer::min);
//        // 运行结果：0
//        System.out.println(min1);
//    }
//}
