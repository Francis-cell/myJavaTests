package MyLeetCodeTests.My2022Lists.D9_14;

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
public class MultiString_offical {
    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String ans = "0";
        int m = num1.length(), n = num2.length();
        for (int i = n - 1; i >= 0; i--) {
            StringBuffer curr = new StringBuffer();
            int add = 0;
            for (int j = n - 1; j > i; j--) {
                curr.append(0);
            }
            int y = num2.charAt(i) - '0';
            for (int j = m - 1; j >= 0; j--) {
                int x = num1.charAt(j) - '0';
                int product = x * y + add;
                curr.append(product % 10);
                add = product / 10;
            }
            if (add != 0) {
                curr.append(add % 10);
            }
            ans = addStrings(ans, curr.reverse().toString());
        }
        return ans;
    }

    public static String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        ans.reverse();
        return ans.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        System.out.println(multiply(num1+"", num2+""));
    }
}
