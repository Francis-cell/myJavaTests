package com.zmr.MyUtils.OtherUtils;

public interface BaseUtils {
    /**
     * <p> 二进制数据转换成十六进制数据 </p>
     * @param binaryNum 要转换的二进制数据
     * @return
     */
    String binaryToHex(String binaryNum);

    /**
     * <p> 十六进制数据转换成二进制数据(当man为true的时候为人性化显示) </p>
     * @param hexNum 要处理的十六进制数据
     * @param man 是否人性化展示，true - 人性化展示； false - 不进行人性化展示
     * @return
     */
    String hexToBinary(String hexNum, Boolean man);

    /**
     * <p> 十六进制数据转换成十进制数据 </p>
     * @param hexNum 要处理的十六进制数据
     * @return
     */
    String hexToDecimal(String hexNum);

    /**
     * <p> 十进制转换成十六进制数据(int类型的十进制数据) </p>
     * @param decimalNum 要进行转换的十进制数据
     * @return
     */
    String decimalToHex(String decimalNum);

    /**
     * <p> 十进制转换成二进制数据 - 保留默认小数位数 </p>
     * @param decimalNum 要进行处理的十进制数据
     * @return
     */
    String decimalToBinary(String decimalNum);

    /**
     * <p> 十进制转换成二进制数据(初始方法 - 指定保留的小数位数) </p>
     * @param decimalNum 要进行处理的十进制数据
     * @param digit 指定保留的小数位数
     * @return
     */
    String decimalToBinary(String decimalNum, int digit);

    /**
     * <p> 二进制数据转换成十进制数据 (默认转出来的无符号位)</p>
     * @param binaryNum 要进行处理的二进制数据
     * @return
     */
    String binaryToDecimal(String binaryNum);

    /**
     * <p> 二进制数据转换成十进制数据(初始方法 - 指定有无符号位) </p>
     * @param binaryNum 要进行处理的二进制数据
     * @param sign false - 无符号位； true - 有符号位；
     * @return
     */
    String binaryToDecimal(String binaryNum, boolean sign);

    /**
     * <p> 反转二进制数字(如果原本的二进制数字是0，反转后为1，反之从1反转为0) </p>
     * @param binaryNum 要进行处理的二进制数据
     * @return
     */
    String reverseBinaryNum(String binaryNum);

    /**
     * <p> 递归计算x的n次幂 </p>
     * @param x
     * @param n
     * @return
     */
    int xPowerNRecursion(int x, int n);

    /**
     * <p> 二进制方法计算x的n次幂(仅仅对内使用) </p>
     * @param x
     * @param n
     * @return
     */
    int xPowerNBinary(int x, int n);
}
