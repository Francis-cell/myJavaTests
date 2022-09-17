package MyLeetCodeTests.D9_14;

import java.util.Scanner;

/**
 * @Description 字符串相乘
 * 给定两个字符串形式的非负整数num1和num2，返回num1和num2的乘积，他们的形式也表示为字符串形式
 * 注意：不能使用任何内置的BigInteger库或者直接将输入转换成整数
 * eg: num1 = "2"; num2  = "3"; 输出：6
 * eg: num1 = "123"; num2="456"; 输出："56088"
 * 提示：
 *  1、1 <= num1.length, num2.length <= 200
 *  2、num1和num2只能由数字组成
 *  3、num1和num2都不能包含任何前置0，除了数字0本身
 **/
public class MultiString {
    public static String multiply(String num1, String num2) {
        // 如果num1和num2中其中的一个值为0，那么最终的结果就为0
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        } else {
            // 1、将num2中的每一位数字和num1进行相乘
            int sum = 0;
            for (int i = num2.length() - 1; i >= 0; i--) {
                for (int j = num1.length() - 1; j >= 0; j--) {
                    int a = num2.charAt(i) - '0';
                    int b = num1.charAt(j) - '0';
                    int iTemp1 = a * b;
                    int pows = (int) Math.pow(10, num1.length() - j - 1);
                    int pows1 = (int) Math.pow(10, num2.length() - i - 1);
                    //sum += num2.charAt(i) * num1.charAt(j) * (int) Math.pow(10, num1.length() - j + 1);
                    sum += iTemp1 * pows * pows1;
                }
            }
            return sum+"";
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        System.out.println(multiply(num1+"", num2+""));
    }
}
