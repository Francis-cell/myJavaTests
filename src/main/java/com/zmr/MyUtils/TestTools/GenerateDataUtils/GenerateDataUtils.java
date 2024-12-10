package com.zmr.MyUtils.TestTools.GenerateDataUtils;

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
     * <p> 使用案例： </p>
     * <pre>
     *     {@code
     *          // 生成纯小写字符
     *          generateRandomString(100, "lower");
     *          // 生成纯大写字符
     *          generateRandomString(100, "upper");
     *     }
     * </pre>
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
     * <p> 使用案例： </p>
     * <pre>
     *     {@code
     *          // 生成大小写混合字符
     *          generateRandomString(100, true, null);
     *          // 生成纯小写字符
     *          generateRandomString(100, false, "lower");
     *          // 生成纯大写字符
     *          generateRandomString(100, false, "upper");
     *     }
     * </pre>
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
     * <p> 使用案例： </p>
     * <pre>
     *     {@code
     *          // 生成一个随机长度的整形数组（包含正负数）
     *          generateRandomIntArray(100, 100);
     *     }
     * </pre>
     * @param maxSize 数组的最大大小
     * @param maxValue 数组的最大的元素值
     * @return
     */
    public static int[] generateRandomIntArray(int maxSize, int maxValue) {
        // 当 mixed 值为 true 的时候，isBiggerThanZero 的值可为 true 或者 false 均可
        // return generateRandomIntArray(maxSize, maxValue, true, true);
        return generateRandomIntArray(maxSize, maxValue, true, false);
    }

    /**
     * <p> 构建一个随机的整形数组，要求数据在数据的范围内 </p>
     * <p> 使用案例： </p>
     * <pre>
     *     {@code
     *          // 生成一个随机长度的整形数组（负数）
     *          generateRandomIntArray(100, 100, false);
     *          // 生成一个随机长度的整形数组（正数）
     *          generateRandomIntArray(100, 100, true);
     *     }
     * </pre>
     * @param maxSize 数组的最大大小
     * @param maxValue 数组的最大的元素值
     * @param isBiggerThanZero 生成的元素是否大于 0（小于或者大于都可等于 0）
     * @return
     */
    public static int[] generateRandomIntArray(int maxSize, int maxValue, boolean isBiggerThanZero) {
        return generateRandomIntArray(maxSize, maxValue, false, isBiggerThanZero);
    }


    /**
     * <p> 构建一个随机的整形数组，要求数据在数据的范围内 </p>
     * <p> 使用案例： </p>
     * <pre>
     *     {@code
     *          // 生成一个随机长度的整形数组（包含正负数）
     *          generateRandomIntArray(100, 100, true, xxx);
     *          // 生成一个随机长度的整形数组（包含正数）
     *          generateRandomIntArray(100, 100, false, true);
     *          // 生成一个随机长度的整形数组（包含负数）
     *          generateRandomIntArray(100, 100, false, false);
     *     }
     * </pre>
     * @param maxSize 数组的最大大小
     * @param maxValue 数组的最大的元素值
     * @param mixed 是否开启混合正负数
     * @param isBiggerThanZero 生成的元素是否大于 0（小于或者大于都可等于 0）
     * @return
     */
    public static int[] generateRandomIntArray(int maxSize, int maxValue, boolean mixed, boolean isBiggerThanZero) {
        // 随机数组的长度
        int[] arr = new int[(int)(Math.random() * maxSize + 1)];
        for (int i = 0; i < arr.length; i++) {
            // 开启混合正负数
            if (mixed) {
                arr[i] = (int)(Math.random() * maxValue) - (int) (Math.random() * (maxValue));
            }
            else {
                // 生成纯正数数据
                if (isBiggerThanZero) {
                    arr[i] = (int)(Math.random() * maxValue);
                }
                // 生成纯负数
                else {
                    arr[i] = -(int)(Math.random() * maxValue);
                }
            }
        }
        return arr;
    }
}
