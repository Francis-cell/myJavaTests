package LearningFiles.MyAlgorithmTests.XORExamples;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @description 异或运算有两个数出现奇数次，其余数出现偶数次，找出这两个奇数
 * @date 2023/1/31 19:23
 */
public class PrintOddTimesNum2 {
    // arr中，有两种数出现奇数次
    public static void printOddTimesNum2(int[] arr) {
        // 1、声明异或值eor并逐个进行异或运算，得到 eor = a^b
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }

        // eor = a^b
        // eor != 0
        // eor 必然有一个位置上是1
        // 010010000
        // 000010000

        // 提取出最右侧的1
        int rightOne = eor&(-eor);
        // eor‘
        int onlyOne = 0;
        for (int i = 0; i < arr.length; i++) {
            // arr[1] =   111100011110000
            // rightOne = 000000000010000

            // 找到所有arr中在最右侧1位置上为1的数据，从而找到a的值
            if ((arr[i] & rightOne) != 0) {
                onlyOne ^= arr[i];
            }
        }

        // b的值为eor ^ eor' 即 eor ^ onlyOne
        System.out.println("这两个值为：" + onlyOne + ", " + (eor^onlyOne));
    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,1,2,3,4,5,1,2,3,4,5,2,2,1};
        printOddTimesNum2(arr);
    }
}
