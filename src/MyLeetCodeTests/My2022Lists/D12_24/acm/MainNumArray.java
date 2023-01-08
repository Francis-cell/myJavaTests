package MyLeetCodeTests.My2022Lists.D12_24.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @description 输入数字或者数组
 * @date 2022/12/24 11:03
 */
public class MainNumArray {
    public static void main(String[] args) throws IOException {
        // 获取键盘的一行输入，以enter为结尾标志
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // 以空格作为分隔符进行数据的读取
        String[] strs = reader.readLine().split(" ");

        // 转换成int类型的数组
        int[] ints = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            ints[i] = Integer.parseInt(strs[i]);
        }

        for (int tempInt : ints) {
            System.out.print(tempInt);
            System.out.print(" ");
        }
    }
}
