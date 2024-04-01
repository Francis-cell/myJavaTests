//package main.java.com.zmr.LearningFiles.UtilsUsing.guavaTests;
//
//import com.google.common.collect.Iterables;
//import com.google.common.collect.Lists;
//import com.google.common.collect.Maps;
//import com.google.common.collect.Sets;
//import com.google.common.primitives.Ints;
//import main.java.com.zmr.LearningFiles.BasicJava.entity.Student;
//
//import java.util.*;
//
///**
// * @ClassName GuavaTests01
// * @Description Guava静态工厂方法
// * @Author zhumengren
// * @Date 2022/3/16 9:36
//
// * @Version 1.0
// **/
//public class GuavaTests01 {
//    public static void main(String[] args) {
//        // 自动推断后面声明的集合的元素类型
//        List<Student> list = Lists.newArrayList();
//        // LinkedHashMap: 有序的hashMap
//        Map<String, Student> map = Maps.newLinkedHashMap();
//
//        Student xiaobai = new Student("小白", 10, 90);
//        Student xiaohei = new Student("小黑", 9, 101);
//        Student agen = new Student("阿根", 11, 110);
//        Set<Student> copySet = Sets.newHashSet(xiaobai);
//        // 运行结果： [Student(name=小白, age=10, height=90, specialityEnum=null)]
//        System.out.println(copySet);
//
//        List<Student> students = Lists.newArrayList(xiaobai, xiaohei, agen);
//        // 运行结果：[Student(name=小白, age=10, height=90, specialityEnum=null),
//        // Student(name=小黑, age=9, height=101, specialityEnum=null),
//        // Student(name=阿根, age=11, height=110, specialityEnum=null)]
//        System.out.println(students);
//
//        // 提高初始化可读性
//        List<Student> students1 = Lists.newArrayListWithCapacity(100);
//        List<Object> students2 = Lists.newArrayListWithExpectedSize(100);
//        Set<Student> students3 = Sets.newHashSetWithExpectedSize(100);
//
//
//        /** Iterable */
//        // 串联多个iterables的懒视图
//        Iterable<Integer> concatenated = Iterables.concat(
//                Ints.asList(1, 2, 3),
//                Ints.asList(4, 5, 6));
//        // 运行结果： [1, 2, 3, 4, 5, 6]
//        System.out.println(concatenated);
//
//
//        // 返回对象在iterable中出现的次数
//        int frequency = Iterables.frequency(concatenated, 1);
//        // 运行结果： 1
//        System.out.println(frequency);
//
//
//        // 将iterable按照指定大小进行分割，得到的子集都不能进行修改操作
//        Iterable<List<Integer>> partition = Iterables.partition(concatenated, 2);
//        // 运行结果： [[1, 2], [3, 4], [5, 6]]
//        System.out.println(partition);
//
//
//        // 返回iterable的第一个元素，若iterable为空，则返回默认值
//        Integer first = Iterables.getFirst(concatenated, 200);
//        // 运行结果： 1
//        System.out.println(first);
//
//
//        // 返回iterable的最后一个元素
//        Integer last = Iterables.getLast(concatenated);
//        // 运行结果： 6
//        System.out.println(last);
//
//
//        // 比较两个iterable中元素是否相同
//        Iterable<Integer> concatenated2 = Iterables.concat(
//                Ints.asList(1, 2, 3),
//                Ints.asList(4, 5, 6));
//        boolean b1 = Iterables.elementsEqual(concatenated, concatenated2);
//        // 运行结果： true
//        System.out.println(b1);
//
//
//    }
//}
