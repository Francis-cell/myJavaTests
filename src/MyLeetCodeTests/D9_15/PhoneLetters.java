package MyLeetCodeTests.D9_15;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Description 电话号码的字母组合
 * 说明：
 *      给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *      给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 2-abc, 3-def, 4-ghi, 5-jkl, 6-mno, 7-pqrs, 8-tuv, 9-wxyz
 *
 * eg:输入：digits = "23"
 *    输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *
 *    输入：digits = ""
 *    输出：[]
 *
 *    输入：digits = "2"
 *    输出：["a","b","c"]
 *
 * 提示：
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 **/
public class PhoneLetters {
    /**
     * 将字符串中的数字对应的所有的字母组合获取出来
     */
    public static void getAllGroups(HashMap<String, String[]> dicts) {
        // 1、获取传入的字典的长度

    }


    public static void main(String[] args) {
        // 1、输入数字
        Scanner sc = new Scanner(System.in);
        String num = sc.next();

        // 2、构建字典
        HashMap<String, String> dicts = new HashMap<>();
        dicts.put("2", "abc");
        dicts.put("3", "def");
        dicts.put("4", "ghi");
        dicts.put("5", "jkl");
        dicts.put("6", "mno");
        dicts.put("7", "pqrs");
        dicts.put("8", "tuv");
        dicts.put("9", "wxyz");
        //System.out.println(dicts);

        // 3、根据输入的字符串获取对应的字母映射数组(使用字典存储中间产生的数据)
        HashMap<String, String[]> numsDictTemp = new HashMap<>();
        String[] splitNums = num.split("");
        for (int i = 0; i < splitNums.length; i++) {
            numsDictTemp.put(splitNums[i], dicts.get(splitNums[i]).split(""));
        }
        System.out.println("处理之后的字典的值为：" + numsDictTemp);
    }
}
