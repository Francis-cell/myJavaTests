package LearningFiles.MyJavaTests.javaTests.CloneTest;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2021/9/22 22:27
 */
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        shallowCloneTest();
        System.out.println("==========");
        deepCloneTest();

//        Teacher teacher = new Teacher("teacher", 20);
//        Teacher teacher1 = teacher;
//        System.out.println(teacher);
//        System.out.println(teacher1);

        Teacher teacher = new Teacher("teacher", 20);
        Teacher teacher1 = (Teacher) teacher.clone();
        System.out.println(teacher);
        System.out.println(teacher1);
    }

    /***
     * 深拷贝
     */
    public static void deepCloneTest() throws CloneNotSupportedException {
        Teacher teacher = new Teacher();
        teacher.setName("teacher");
        teacher.setAge(20);

        StudentDeep student = new StudentDeep();
        student.setAge(10);
        student.setName("小白");
        student.setTeacher(teacher);

        StudentDeep student1 = (StudentDeep) student.clone();
        System.out.println("student1的姓名是：" + student1.getName());
        System.out.println("student1的年龄是：" + student1.getAge());
        System.out.println("student1老师的年龄是：" + student1.getTeacher().getAge());
        System.out.println("student1老师的名字是：" + student1.getTeacher().getName()); // teacher

        System.out.println("修改teacher的信息");
        teacher.setName("teacher01");
        System.out.println("student的老师的名字是：" + student.getTeacher().getName()); // teacher01
        System.out.println("student1的老师的名字是：" + student1.getTeacher().getName()); // teacher
    }

    /***
     * 浅拷贝
     */
    public static void shallowCloneTest() {
        Teacher teacher = new Teacher();
        teacher.setName("teacher");
        teacher.setAge(20);

        StudentShallow student = new StudentShallow();
        student.setAge(10);
        student.setName("小白");
        student.setTeacher(teacher);

        StudentShallow student1 = (StudentShallow) student.clone();
        System.out.println("student1的名字是：" + student1.getName());
        System.out.println("student1的年龄是：" + student1.getAge());
        System.out.println("student1的老师的名字是：" + student1.getTeacher().getName()); // teacher
        System.out.println("student1的老师的年龄是：" + student1.getTeacher().getAge());

        System.out.println("修改teacher的信息");
        teacher.setName("teacher01");
        System.out.println("student的老师的名字是：" + student.getTeacher().getName()); // teacher01
        System.out.println("student1的老师的名字是：" + student1.getTeacher().getName()); // teacher01
    }
}
