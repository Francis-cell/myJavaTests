package stringArrayTests;

import utils.myLogger.MyLoggerUtils;

/**
 * @ClassName StringArrayTest01
 * @Description String字符串和数组之间的转换测试类
 * @Author zhumengren
 * @Date 2022/4/16 20:36
 * @Email zhumengren@sinosoft.com
 * @Version 1.0
 **/
public class StringArrayTest01 {
    /**
     * 字符串和数组之间的转换测试
     * @return void
     */
    public void stringArray() {
        String str01 = "abcdef";
        // 最常使用的分割方法，使用 String.split("分割符") 的方法进行分割
        String[] str01Arr = str01.split("");

        // 第二种转换方式，返回的结果是Char类型的数组
        MyLoggerUtils.logger.info("=============String.toCharArray()方法==============");
        char[] str01ArrChar = str01.toCharArray();
        for (char ch : str01ArrChar) {
            System.out.println(ch);
        }

    }
}
