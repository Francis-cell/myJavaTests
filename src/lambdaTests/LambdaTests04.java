package lambdaTests;

import entity.SpecialityEnum;
import entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName LambdaTests04
 * @Description 高级集合类及收集器--转换成块
 * @Author zhumengren
 * @Date 2022/3/15 17:37
 * @Email zhumengren@sinosoft.com
 * @Version 1.0
 **/
public class LambdaTests04 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(3);
        students.add(new Student("小白", 10, 90, new SpecialityEnum(true, true, false, true)));
        students.add(new Student("小黑", 9, 101, new SpecialityEnum(false, false, true, true)));
        students.add(new Student("阿根", 11, 110, new SpecialityEnum(true, true, true, true)));

        Map<Boolean, List<Student>> listMap = students.stream().collect(
                Collectors.partitioningBy(student -> student.getSpecialityEnum().getSing() == true));
        // {false=[Student(name=小黑, age=9, height=101, specialityEnum=SpecialityEnum(sing=false, dance=false, swimming=true, running=true))],
        // true=[Student(name=小白, age=10, height=90, specialityEnum=SpecialityEnum(sing=true, dance=true, swimming=false, running=true)), Student(name=阿根, age=11, height=110, specialityEnum=SpecialityEnum(sing=true, dance=true, swimming=true, running=true))]}
        System.out.println(listMap);
    }
}
