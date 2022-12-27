package myMindMapTests.basicJava.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2022/11/29 12:17
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User implements Serializable {
    /** 设置序列化版本号 */
    private static final long serialVersionUID = 1L;

    private int age;
    private transient String name;
    private String sex;
}
