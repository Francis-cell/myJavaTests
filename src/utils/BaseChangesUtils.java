package utils;

import java.util.HashMap;

/**
 * @ClassName BaseChanges
 * @Description 进制转换工具类
 * @Author zhumengren
 * @Date 2022/4/13 10:17
 * @Email zhumengren@sinosoft.com
 * @Version 1.0
 **/
public class BaseChangesUtils {
    /**
     * 二进制数据转换成十六进制数据
     * @return String
     */
    public String binaryToHex(String binaryNum) {

        String result = "";
        // 首先检验传入的数据是否为二进制数据
        String[] binaryNumArr = binaryNum.split("");
        int len = binaryNumArr.length;
        int tempLen = len;
        while (tempLen > 0) {
            if ((!binaryNumArr[tempLen - 1].equals("0") && !binaryNumArr[tempLen - 1].equals("1"))) {
                result = "False";
                return result;
            }
            tempLen--;
        }

        // 判断二进制数据的位数是否为4的整数倍
        if (len % 4 != 0) {
            // 需要在字符串前端增加的0的个数
            int tempNum = 4 - len % 4;
            // 新建一个数组，或者也可以将数组转换成ArrayList这种可变长的数据类型
            String[] tempBinaryNumArr = new String[len + tempNum];
            // 前面的tempNum位数组的数据为"0",后面的数据继续插入原本的binaryNumArr的数据即可
            // 这里最终的tempNumArr就是转换成对应位数的二进制数据
            for (int i = 0; i < tempBinaryNumArr.length; i++) {
                if (i < tempNum) {
                    tempBinaryNumArr[i] = "0";
                }else {
                    tempBinaryNumArr[i] = binaryNumArr[i - tempNum];
                }
            }

            // 将这个tempNumArr按照4位进行分割，并转换成十六进制数据
            result = iBinaryToHex(tempBinaryNumArr);
        } else {
            // 否则说明这个二进制数据的长度为4的整数倍，可以直接处理
            result = iBinaryToHex(binaryNumArr);
        }
        return result;
    }

    /**
     * 将长度为4的整数倍的二进制数据转换成十六进制的数据
     * @return String
     */
    public static String iBinaryToHex(String[] binaryNumArr) {
        // 获取二进制转十六进制的hashMap
        HashMap<String, String> binaryHexHashMap = getBinaryHexHashMap();
        String result = "";
        for (int j = 0; j < binaryNumArr.length; ) {
            int num = 0;
            StringBuilder strB = new StringBuilder();
            while (num != 4){
                strB.append(binaryNumArr[j]);
                num++;
                j++;
            }
            result += binaryHexHashMap.get(strB.toString());
        }
        return "0x" + result;
    }

    /**
     * 十六进制数据转换成二进制数据(当man为true的时候为人性化显示)
     * @return String
     */
    public String hexToBinary(String hexNum, Boolean man) {
        // 首先将十六进制有效数据转换成一个字符串数组
        String result = "";
        // 首先判断一个字符串数据是否是十六进制的数据
        // 将整个String中的字母全部转换成大写字母
        hexNum = hexNum.toUpperCase();
        if (hexNum.startsWith("0X")) {
            // 取出其中代表数据的字段部分，并转换成一个String类型的数组
            String[] temp = hexNum.split("X")[1].split("");
            // 根据十六进制的字符转换成对应的二进制数据
            result = iHexToBinary(temp, man);
        } else {
            // 说明这个传入的数据不是十六进制的数据
            result = "False";
        }
        return result;
    }

    /**
     * 将十六进制的String类型的数组转换成二进制的数据
     * @return String
     */
    public static String iHexToBinary(String[] hexArr, Boolean man) {
        HashMap<String, String> hexBinaryHashMap = getHexBinaryHashMap();
        String result = "";
        for (String str : hexArr) {
            if (man == true) {
                result = result + hexBinaryHashMap.get(str) + " ";
            } else {
                result = result + hexBinaryHashMap.get(str);
            }

        }
        return result;
    }


    /**
     * 十六进制数据转换成十进制数据
     * @return String
     */
    public String hexToDecimal(String hexNum) {
        String result = "";
        // 首先判断一个字符串数据是否是十六进制的数据
        // 将整个String中的字母全部转换成大写字母
        hexNum = hexNum.toUpperCase();
        if (hexNum.startsWith("0X")) {
            // 取出其中代表数据的字段部分，并转换成一个String类型的数组
            String[] temp = hexNum.split("X")[1].split("");
            // 从后向前依次取出数据，然后将这些数据转换成十进制的数据，形成最终的结果
            result = iHexToDecimal(temp) + "";
        } else {
            // 说明这个传入的数据不是十六进制的数据
            result = "False";
        }
        return result;
    }


    /**
     * 将String数组中的数据依次转换成十六进制的数据，最终返回结果
     * @return Long
     */
    public static int iHexToDecimal(String[] hexArr) {
        int result = 0;
        // 首先构建16进制的hashMap
        HashMap<String, Integer> hexHashMap = new HashMap<>();
        int hexFlag = 9;
        while (hexFlag > 0) {
            hexHashMap.put(hexFlag + "", hexFlag);
            hexFlag --;
        }
        hexHashMap.put("A", 10);
        hexHashMap.put("B", 11);
        hexHashMap.put("C", 12);
        hexHashMap.put("D", 13);
        hexHashMap.put("E", 14);
        hexHashMap.put("F", 15);

        int length = hexArr.length;
        for (int i = length - 1; i >= 0; i--) {
            result += xPowerNBinary(16, length - i - 1) * (hexHashMap.get(hexArr[i]));
        }
        return result;
    }


    /**
     * 十进制转换成十六进制数据
     * @return String
     */
    public String decimalToHex(String decimalNum) {
        String result = "";
        // 首先检验这个十进制的数字是否是一个数字
        try {
            int flag = Integer.parseInt(decimalNum);
        } catch (NumberFormatException e) {
            result = "False";
            return result;
        }

        // 创建一个16进制使用的hashMap
        HashMap<Integer, String> hexHashMap = new HashMap<>();
        int hexFlag = 9;
        while (hexFlag > 0) {
            hexHashMap.put(hexFlag, hexFlag + "");
            hexFlag --;
        }
        hexHashMap.put(10, "A");
        hexHashMap.put(11, "B");
        hexHashMap.put(12, "C");
        hexHashMap.put(13, "D");
        hexHashMap.put(14, "E");
        hexHashMap.put(15, "F");

        int decimalNumInt = Integer.parseInt(decimalNum);
        while (decimalNumInt / 16 > 0) {
            // 获取到当前的十进制数据对应的十六进制的数据，并保存到tempStr中
            String tempStr = hexHashMap.get(decimalNumInt % 16);
            result += tempStr;
            decimalNumInt /= 16;
        }
        result += hexHashMap.get(decimalNumInt);
        // 将字符串进行颠倒
        result = new StringBuffer(result).reverse().toString();
        return result;
    }


    /**
     * 十进制转换成二进制数据
     * @return String
     */
    public String decimalToBinary(String decimalNum) {
        String result = "";
        // 首先检验这个十进制的数字是否是一个数字
        try {
            int flag = Integer.parseInt(decimalNum);
        } catch (NumberFormatException e) {
            result = "False";
            return result;
        }
        // 将这个String类型的decimalNum转换成数字
        int decimalNumInt = Integer.parseInt(decimalNum);
        while (decimalNumInt / 2 > 0) {
            result += (decimalNumInt % 2) + "";
            decimalNumInt /= 2;
        }
        result += decimalNumInt;
        result = new StringBuffer(result).reverse().toString();
        return result;
    }

    /**
     * 二进制数据转换成十进制数据
     * @return String
     */
    public String binaryToDecimal(String binaryNum) {
        String result = "";
        // 首先检验是否是二进制数据
        String[] binaryNumArr = binaryNum.split("");
        int len = binaryNumArr.length;
        int tempLen = len;
        while (tempLen > 0) {
            if ((!binaryNumArr[tempLen - 1].equals("0") && !binaryNumArr[tempLen - 1].equals("1"))) {
                result = "False";
                return result;
            }
            tempLen--;
        }

        int tempResult = 0;
        // 从二进制的最高位开始，逆着将值*2的n次方
        for (int i = binaryNumArr.length - 1; i >= 0; i--) {
            if (!binaryNumArr[i].equals("0")){
                tempResult += xPowerNBinary(2, Math.abs(i - binaryNumArr.length + 1));
            }
        }
        result = tempResult + "";
        return result;
    }


    /**
     * 递归计算x的n次幂
     * @return Long
     */
    public int xPowerNRecursion(int x, int n) {
        int result = 0;
        if (n == 0) {
            result = 1;
        } else {
            result = xPowerNRecursion(x, n / 2);
            result = result * result;
            // 如果x的值是偶数的话，使用(x^n/2)^2
            // 如果x的值为奇数的话，使用x(x^n/2)^2
            if (n % 2 != 0) {
                result = x * result;
            }
        }
        return result;
    }

    /**
     * 二进制方法计算x的n次幂(仅仅对内使用)
     * @return int
     */
    public static int xPowerNBinary(int x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        int y = 1;
        String str = Integer.toBinaryString(n);
        for (int a = 0; a < str.length(); a++) {
            // char类型转换成int
            int s = Integer.parseInt(String.valueOf(str.charAt(a)));
            y = y * y;
            if (s == 1) {
                y = y * x;
            }
        }
        return y;
    }

    /**
     * 二进制方法计算x的n次幂(对外暴露)
     * @return int
     */
    public int xPowerNBinarys(int x, int n) {
        return xPowerNBinary(x, n);
    }


    /**
     * 构建十六进制转换二进制的HashMap
     * @return HashMap<String, String>
     */
    public static HashMap<String, String> getHexBinaryHashMap() {
        HashMap<String, String> result = new HashMap<>();
        result.put("0", "0000");
        result.put("1", "0001");
        result.put("2", "0010");
        result.put("3", "0011");
        result.put("4", "0100");
        result.put("5", "0101");
        result.put("6", "0110");
        result.put("7", "0111");
        result.put("8", "1000");
        result.put("9", "1001");
        result.put("A", "1010");
        result.put("B", "1011");
        result.put("C", "1100");
        result.put("D", "1101");
        result.put("E", "1110");
        result.put("F", "1111");
        return result;
    }

    /**
     * 构建二进制转十六进制的HashMap
     * @return HashMap<String, String>
     */
    public static HashMap<String, String> getBinaryHexHashMap() {
        HashMap<String, String> result = new HashMap<>();
        result.put("0000", "0");
        result.put("0001", "1");
        result.put("0010", "2");
        result.put("0011", "3");
        result.put("0100", "4");
        result.put("0101", "5");
        result.put("0110", "6");
        result.put("0111", "7");
        result.put("1000", "8");
        result.put("1001", "9");
        result.put("1010", "A");
        result.put("1011", "B");
        result.put("1100", "C");
        result.put("1101", "D");
        result.put("1110", "E");
        result.put("1111", "F");
        return result;
    }
}
