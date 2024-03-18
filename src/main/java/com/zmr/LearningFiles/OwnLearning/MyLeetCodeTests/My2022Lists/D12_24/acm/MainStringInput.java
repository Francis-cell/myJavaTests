package com.zmr.LearningFiles.OwnLearning.MyLeetCodeTests.My2022Lists.D12_24.acm;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @description 手动输入字符串
 * @date 2022/12/24 10:56
 */
public class MainStringInput {
    // 输出字符串
    public static void main(String[] args) throws IOException {
        // 获取键盘一行的输入，以enter键为结束标志
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        // TODO-单行数据的输入
        //String s = reader.readLine();
        //// s为最终的字符串
        //System.out.println("s的值为:" + s);

        // TODO-多行数据的输入
        String str;
        while (!(str = reader.readLine()).equals("")) {
            System.out.println("str的值为：" + str);
        }
    }
}
