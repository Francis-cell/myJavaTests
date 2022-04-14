package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName Classes
 * @Description 班级类
 * @Author zhumengren
 * @Date 2022/3/15 17:02
 * @Email zhumengren@sinosoft.com
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Classes {
    /** 班级代号 */
    private String names;
    /** 学生 */
    List<Student> students;
}
