package main.java.com.zmr.LearningFiles.MyJavaTests.javaTests.CloneTest;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2021/9/22 22:41
 */
public class StudentDeep implements Cloneable{
    private String name;
    private Integer age;
    private Teacher teacher;

    public StudentDeep() {
    }

    public StudentDeep(String name, Integer age, Teacher teacher) {
        this.name = name;
        this.age = age;
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // 浅拷贝
        // return super.clone();

        // 深拷贝
        StudentDeep student = (StudentDeep) super.clone();
        student.setTeacher((Teacher) student.getTeacher().clone());
        return student;
    }
}
