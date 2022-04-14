import dateGetTests.DateGetMethods;
import utils.BaseChangesUtils;

/**
 * @ClassName MainTest
 * @Description 主要的测试类
 * @Author zhumengren
 * @Date 2022/3/15 14:36
 * @Email zhumengren@sinosoft.com
 * @Version 1.0
 **/
public class MainTest {
    /**
     * 时间测试
     * @return void
     */
    public void timeTest() {
        /** 获取当前的日期和时间等信息 */
        // 测试方法1
        DateGetMethods dateGetMethods = new DateGetMethods();
        String nowDate = dateGetMethods.dateGetWithTimeMillis();
        // 2022-04-13 at 17:59:49 CST
        System.out.println(nowDate);

        String nowDate02 = dateGetMethods.dateGetWithDate();
        // 2022-04-13 at 17:59:49 CST
        System.out.println(nowDate02);

        String nowDate03 = dateGetMethods.dateGetWithCalendar();
        // 2022-04-13 at 18:03:27 CST
        System.out.println(nowDate03);

        String nowDate04 = dateGetMethods.dateGetWithLocalDate();
        // 2022-04-13
        System.out.println(nowDate04);

        String nowDate05 = dateGetMethods.dateGetWithLocalTime();
        // 18:10:30
        System.out.println(nowDate05);

        String nowDate06 = dateGetMethods.dateGetWithLocalDateTime();
        // 2022-04-13 18:14:20
        System.out.println(nowDate06);
    }

    /**
     * 进制转换测试
     * @return void
     */
    public void baseTest() {
        BaseChangesUtils baseChangesUtils = new BaseChangesUtils();
        //int i = baseChanges.xPowerNBinary(3, 5);
        //int j = baseChanges.xPowerNRecursion(3, 5);
        String hexNum = "0X123";
        //String hexNum = "0xAC45";
        String str = baseChangesUtils.hexToDecimal(hexNum);
        System.out.println(str);

        String decimalNum1 = "1000";
        String str1 = baseChangesUtils.decimalToHex(decimalNum1);
        System.out.println(str1);

        //String decimalNum2 = "4";
        //String str2 = baseChangesUtils.decimalToBinary(decimalNum2);
        //System.out.println(str2);

        String hexNums = "0X6C49";
        //String decimalTempStr = baseChanges.hexToDecimal(hexNums);
        //String lastValues = baseChanges.decimalToBinary(decimalTempStr);
        String lastValues = baseChangesUtils.hexToBinary(hexNums, true);
        System.out.println("最终的值为：" + lastValues);

        // 二进制数据转换成十六进制数据
        String binaryNum = "110110011011010111";
        String hexStr = baseChangesUtils.binaryToHex(binaryNum);
        System.out.println(hexStr);

        // 二进制--》十进制
        System.out.println("二进制--》十进制");
        System.out.println(baseChangesUtils.binaryToDecimal("11110010101010111"));
        System.out.println(baseChangesUtils.binaryToDecimal("0x235"));

        // 十进制--》二进制
        System.out.println("十进制--》二进制");
        System.out.println(baseChangesUtils.decimalToBinary("10"));
        System.out.println(baseChangesUtils.decimalToBinary("0x1234"));

        // 十进制--》十六进制
        int a=10;
        String a1 = String.valueOf(a);
        System.out.println("十进制--》十六进制");
        System.out.println(baseChangesUtils.decimalToHex("10"));
        System.out.println(baseChangesUtils.decimalToHex("0x12345"));

        // 十六进制--》十进制
        System.out.println("十六进制--》十进制");
        System.out.println(baseChangesUtils.hexToDecimal("0xABCD"));
        System.out.println(baseChangesUtils.hexToDecimal("ABCD"));
        System.out.println(baseChangesUtils.hexToDecimal("1234"));


        // 十六进制--》二进制
        System.out.println("十六进制--》二进制");
        System.out.println(baseChangesUtils.hexToBinary("0xABCD", false));
        System.out.println(baseChangesUtils.hexToDecimal("ABCD"));
        System.out.println(baseChangesUtils.hexToDecimal("1234"));

        // 二进制--》十六进制
        System.out.println("二进制--》十六进制");
        System.out.println(baseChangesUtils.binaryToHex("1010101111001101"));
        System.out.println(baseChangesUtils.binaryToHex("0x1245"));
        System.out.println(baseChangesUtils.binaryToHex("1245"));


        // 2的3次方
        System.out.println(baseChangesUtils.xPowerNRecursion(2,3));
        System.out.println(baseChangesUtils.xPowerNBinarys(2, 3));

        System.out.println(baseChangesUtils.hexToDecimal("0xabcd"));
        System.out.println(baseChangesUtils.binaryToDecimal("0xabcd"));
    }

    public static void main(String[] args) {
        MainTest mainTest = new MainTest();
        // 进制转换测试
        mainTest.baseTest();
        // 时间输出测试
        //mainTest.timeTest();
    }
}
