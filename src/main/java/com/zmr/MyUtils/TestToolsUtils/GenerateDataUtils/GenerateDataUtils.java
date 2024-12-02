package com.zmr.MyUtils.TestToolsUtils.GenerateDataUtils;

import java.util.Random;

/**
 * <p> 数据初始化方法 </p>
 */
public class GenerateDataUtils {
    private static final String LOWER_CASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER_CASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String ALL_CASE_LETTERS = LOWER_CASE_LETTERS + UPPER_CASE_LETTERS;

    /** ---------------------------------- 随机数值类型  ----------------------------------*/
    /**
     * <p> 随机一个整形数值 </p>
     * @param maxValue 随机数值中的最大值
     * @return
     */
    public static int generateRandomInt(int maxValue) {
        return (int)(Math.random() * maxValue);
    }

    /** ---------------------------------- 随机字符串类型  ----------------------------------*/

    /**
     * <p> 混合字符串生成 </p>
     * @param maxLength
     * @param mixed
     * @return
     */
    public static String generateRandomString(int maxLength, boolean mixed) {
        return generateRandomString(maxLength, true);
    }

    /**
     * <p> 大写或者小写随机字符串生成 </p>
     * @param maxLength
     * @param upOrLow 大写小写
     * @return
     */
    public static String generateRandomString(int maxLength, String upOrLow) {
        return generateRandomString(maxLength, false, upOrLow);
    }

    /**
     * <p> 随机一个字符串 </p>
     * <p> 默认只随机小写字符 ignoreUpLetter --> true；upOrLow --> false</p>
     * @param maxLength 随机的字符串长度
     * @param mixed 是否开启混合(开启则最后一个参数无效，否则随机按照最后一个参数进行随机大小写字符)
     * @param upOrLow 大写小写
     * @return
     */
    public static String generateRandomString(int maxLength, boolean mixed, String upOrLow) {
        StringBuilder randomString = new StringBuilder();
        Random random = new Random();
        int length = random.nextInt(maxLength) + 1; // 随机长度，至少为1

        for (int i = 0; i < length; i++) {
            if (mixed) {
                // 混合大小写
                randomString.append(ALL_CASE_LETTERS.charAt(random.nextInt(ALL_CASE_LETTERS.length())));
            } else {
                // 根据upOrLow参数决定大小写
                if ("upper".equalsIgnoreCase(upOrLow)) {
                    randomString.append(UPPER_CASE_LETTERS.charAt(random.nextInt(UPPER_CASE_LETTERS.length())));
                } else {
                    // 默认或"lower"时生成小写字符
                    randomString.append(LOWER_CASE_LETTERS.charAt(random.nextInt(LOWER_CASE_LETTERS.length())));
                }
            }
        }

        return randomString.toString();
    }


    /** ---------------------------------- 随机数组类型  ----------------------------------*/
    /**
     * <p> 构建一个随机的整形数组，要求数据在数据的范围内 </p>
     * @param maxSize 数组的最大大小
     * @param maxValue 数组的最大的元素值
     * @return
     */
    public static int[] generateRandomIntArray(int maxSize, int maxValue) {
        // 随机数组的长度
        int[] arr = new int[(int)(Math.random() * maxSize + 1)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * maxValue) - (int) (Math.random() * (maxValue));
        }
        return arr;
    }
}
