package LearningFiles.MyJavaTests.bitOperationTests;

/**
 * @ClassName BitOperationTest
 * @Description 位运算测试类
 * @Author zhumengren
 * @Date 2022/3/25 15:11
 * @Email zhumengren@sinosoft.com
 * @Version 1.0
 **/
public class BitOperationTest {
    public static void main(String[] args) {
        // 1、左移位运算 <<, num << 1, 相当于(num * 2)
        int num = 1;
        // 这种写法本身就是一种巧合，num本身的值就是1，所以利用本身的值，就相当于做了*2操作
        // num <<= num;
        num = num << 1;
        // 运行结果： 2
        System.out.println(num);

        // 2、右移运算符 >>, num >> 1, 相当于(num / 2)
        int num1 = 2;
        // num1 >>= num1;
        num1 = num1 >> 1;
        // 运行结果： 1
        System.out.println(num1);

        int num2 = 4;
        num2 = num2 >> 2;
        // 运行结果：1
        System.out.println(num2);

        // 3、无符号位移，忽略负号位，空位都以0位移
        int num3 = 60; // 对应的8位2进制为: 0011 1100
        num3 = num3 >>> 2; // 移动之后的值为: 0000 1111 -> 15
        // 运行结果：15
        System.out.println(num3);
    }
}
