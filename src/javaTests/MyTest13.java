package javaTests;

import java.text.ParseException;
import java.util.ArrayList;

/**
 * @ClassName MyTest12
 * @Description 列表转string测试
 * @Author zhumengren
 * @Date 2022/6/7 10:46
 * @Email zhumengren@sinosoft.com
 * @Version 1.0
 **/
public class MyTest13 {
    public static void main(String[] args) throws ParseException {
        ArrayList<String> lists = new ArrayList<>();
        lists.add("a");
        //lists.add("b");
        //lists.add("c");
        //lists.add("d");
        StringBuilder tempString = new StringBuilder();
        for (String item : lists) {
            tempString.append(item);
            tempString.append(", ");
        }
        System.out.println(tempString);
        System.out.println(String.valueOf(tempString).indexOf("b"));
    }
}
