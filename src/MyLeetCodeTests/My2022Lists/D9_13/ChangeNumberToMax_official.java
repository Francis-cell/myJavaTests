package MyLeetCodeTests.My2022Lists.D9_13;

import java.util.Scanner;

/**
 * @ClassName ChangeNumberToMax_official
 * @Description TODO
 * @Author zhumengren
 * @Date 2022/9/14 17:45
 * @Email zhumengren@sinosoft.com
 * @Version 1.0
 **/
public class ChangeNumberToMax_official {
    public static int maximumSwap(int num) {
        char[] charArray = String.valueOf(num).toCharArray();
        int n = charArray.length;
        int maxNum = num;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                swap(charArray, i, j);
                maxNum = Math.max(maxNum, Integer.parseInt(new String(charArray)));
                swap(charArray, i, j);
            }
        }
        return maxNum;
    }

    public static void swap(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(maximumSwap(num));
    }
}
