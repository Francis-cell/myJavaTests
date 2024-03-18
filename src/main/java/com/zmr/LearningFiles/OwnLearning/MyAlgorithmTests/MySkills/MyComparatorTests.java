package com.zmr.LearningFiles.OwnLearning.MyAlgorithmTests.MySkills;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/2/16 20:53
 * @description 比较器
 */
public class MyComparatorTests {
    /** Student自定义类 */
    public static class Student {
        private int id;
        private int age;
        private String name;
        
        public Student (int id, int age, String name) {
            this.id = id;
            this.age = age;
            this.name = name;
        }
    }
    
    /** 
     * 比较器 
     * 遵循一个规范：
     * 1、返回负数的时候，认为第一个参数应该排在前面
     * 2、返回正数的时候，认为第二个参数应该排在前面
     * 3、返回0的时候，认为无所谓谁放在前面
     * 
     * 
     * 年龄比较器(从小到大排序)
     */
    public static class AgeComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.age - o2.age;
        }
    }
    
    
    /** 如果ID相同，则比较年龄，年龄小的放前面 */
    public static class IdWithAgeComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.id != o2.id ? o1.id - o2.id : (o1.age - o2.age);
        }
    }
    


    public static void main(String[] args) {
        Student student1 = new Student(1, 6, "小黑");
        Student student2 = new Student(2, 7, "小白");
        Student student3 = new Student(1, 10, "阿根");
        
        Student[] students = new Student[] {student1, student2, student3};
        System.out.println("年龄比较器！AgeComparator测试: ");
        Arrays.sort(students, new AgeComparator());
        for (int i = 0; i < students.length; i++) {
            Student tmpStudent = students[i];
            System.out.println(tmpStudent.id + ", " + tmpStudent.name + ", " + tmpStudent.age);
        }


        System.out.println("年龄ID比较器，ID相同时，年龄小的排前面!");
        Student[] students1 = new Student[] {student1, student2, student3};
        Arrays.sort(students1, new IdWithAgeComparator());
        for (int i = 0; i < students1.length; i++) {
            Student tmpStudent = students1[i];
            System.out.println(tmpStudent.id + ", " + tmpStudent.name + ", " + tmpStudent.age);
        }


        System.out.println("使用TreeMap有序集合处理!");
        // treeMap中相同的key值只会存储一个
        TreeMap<Student, String> treeMap = new TreeMap<>((a, b) -> (a.id - b.id));
        treeMap.put(student1, "小黑");
        treeMap.put(student2, "小白");
        treeMap.put(student3, "阿根");
        for (Student s : treeMap.keySet()) {
            System.out.println(s.id + ", " + s.name + ", " + s.age);
        }


        System.out.println("ArrayList中使用比较器！");
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.sort(new IdWithAgeComparator());
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i).id + ", " + studentList.get(i).name + ", " + studentList.get(i).age);
        }
    }
}
