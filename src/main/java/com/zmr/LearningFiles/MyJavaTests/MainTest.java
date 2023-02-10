//import main.java.com.zmr.LearningFiles.BasicJava.dateGetTests.DateGetMethods;
//import main.java.com.zmr.LearningFiles.BasicJava.genericsTests.GenericClass;
//import main.java.com.zmr.LearningFiles.BasicJava.genericsTests.GenericTest01;
//import main.java.com.zmr.LearningFiles.UtilsUsing.javaMailUtils.SendMailUtils;
//import main.java.com.zmr.LearningFiles.BasicJava.staticCodeTests.StaticValueTest;
//import main.java.com.zmr.LearningFiles.BasicJava.stringArrayTests.StringArrayTest01;
//import main.java.com.zmr.LearningFiles.UtilsUsing.utils.arithmeticUtils.ArithmeticUtils;
//import main.java.com.zmr.LearningFiles.UtilsUsing.utils.baseChanges.BaseChangesUtils;
//import main.java.com.zmr.LearningFiles.UtilsUsing.utils.myLogger.MyLoggerUtils;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.logging.Logger;
//
///**
// * @ClassName MainTest
// * @Description 主要的测试类
// * @Author zhumengren
// * @Date 2022/3/15 14:36
// * @Email zhumengren@sinosoft.com
// * @Version 1.0
// **/
//public class MainTest {
//    /**
//     * 时间测试
//     * @return void
//     */
//    public void timeTest() {
//        /** 获取当前的日期和时间等信息 */
//        // 测试方法1
//        DateGetMethods dateGetMethods = new DateGetMethods();
//        String nowDate = dateGetMethods.dateGetWithTimeMillis();
//        // 2022-04-13 at 17:59:49 CST
//        System.out.println(nowDate);
//
//        String nowDate02 = dateGetMethods.dateGetWithDate();
//        // 2022-04-13 at 17:59:49 CST
//        System.out.println(nowDate02);
//
//        String nowDate03 = dateGetMethods.dateGetWithCalendar();
//        // 2022-04-13 at 18:03:27 CST
//        System.out.println(nowDate03);
//
//        String nowDate04 = dateGetMethods.dateGetWithLocalDate();
//        // 2022-04-13
//        System.out.println(nowDate04);
//
//        String nowDate05 = dateGetMethods.dateGetWithLocalTime();
//        // 18:10:30
//        System.out.println(nowDate05);
//
//        String nowDate06 = dateGetMethods.dateGetWithLocalDateTime();
//        // 2022-04-13 18:14:20
//        System.out.println(nowDate06);
//    }
//
//    /**
//     * 进制转换测试
//     * @return void
//     */
//    public void baseTest() {
//        //int i = baseChanges.xPowerNBinary(3, 5);
//        //int j = baseChanges.xPowerNRecursion(3, 5);
//        String hexNum = "0X123";
//        //String hexNum = "0xAC45";
//        String str = BaseChangesUtils.hexToDecimal(hexNum);
//        System.out.println(str);
//
//        String decimalNum1 = "1000";
//        String str1 = BaseChangesUtils.decimalToHex(decimalNum1);
//        System.out.println(str1);
//
//        //String decimalNum2 = "4";
//        //String str2 = BaseChangesUtils.decimalToBinary(decimalNum2);
//        //System.out.println(str2);
//
//        String hexNums = "0X6C49";
//        //String decimalTempStr = baseChanges.hexToDecimal(hexNums);
//        //String lastValues = baseChanges.decimalToBinary(decimalTempStr);
//        String lastValues = BaseChangesUtils.hexToBinary(hexNums, true);
//        System.out.println("最终的值为：" + lastValues);
//
//        // 二进制数据转换成十六进制数据
//        String binaryNum = "110110011011010111";
//        String hexStr = BaseChangesUtils.binaryToHex(binaryNum);
//        System.out.println(hexStr);
//
//        // 二进制--》十进制
//        System.out.println("二进制--》十进制");
//        System.out.println(BaseChangesUtils.binaryToDecimal("11110010101010111"));
//        System.out.println(BaseChangesUtils.binaryToDecimal("0x235"));
//        // 二进制转换十进制数据(带符号位和不带符号位)
//        System.out.println(BaseChangesUtils.binaryToDecimal("11101011", true));
//        System.out.println(BaseChangesUtils.binaryToDecimal("01101011", true));
//        System.out.println(BaseChangesUtils.binaryToDecimal("11101011", false));
//
//        // 十进制--》二进制（浮点数操作）
//        System.out.println("十进制--》二进制");
//        System.out.println(BaseChangesUtils.decimalToBinary("1.4", 10));
//        System.out.println(BaseChangesUtils.decimalToBinary("1.125", 10));
//        System.out.println(BaseChangesUtils.decimalToBinary("100.125", 10));
//        System.out.println(BaseChangesUtils.decimalToBinary("0.125", 10));
//        System.out.println(BaseChangesUtils.decimalToBinary("0.4", 10));
//        System.out.println(BaseChangesUtils.decimalToBinary("1.xxx", 10));
//
//        // 十进制--》十六进制
//        int a=10;
//        String a1 = String.valueOf(a);
//        System.out.println("十进制--》十六进制");
//        System.out.println(BaseChangesUtils.decimalToHex("10"));
//        System.out.println(BaseChangesUtils.decimalToHex("0x12345"));
//
//        // 十六进制--》十进制
//        System.out.println("十六进制--》十进制");
//        System.out.println(BaseChangesUtils.hexToDecimal("0xABCD"));
//        System.out.println(BaseChangesUtils.hexToDecimal("ABCD"));
//        System.out.println(BaseChangesUtils.hexToDecimal("1234"));
//
//
//        // 十六进制--》二进制
//        System.out.println("十六进制--》二进制");
//        System.out.println(BaseChangesUtils.hexToBinary("0xABCD", false));
//        System.out.println(BaseChangesUtils.hexToDecimal("ABCD"));
//        System.out.println(BaseChangesUtils.hexToDecimal("1234"));
//
//        // 二进制--》十六进制
//        System.out.println("二进制--》十六进制");
//        System.out.println(BaseChangesUtils.binaryToHex("1010101111001101"));
//        System.out.println(BaseChangesUtils.binaryToHex("0x1245"));
//        System.out.println(BaseChangesUtils.binaryToHex("1245"));
//
//
//        // 2的3次方
//        System.out.println(BaseChangesUtils.xPowerNRecursion(2,3));
//        System.out.println(BaseChangesUtils.xPowerNBinary(2, 3));
//
//        System.out.println(BaseChangesUtils.hexToDecimal("0xabcd"));
//        System.out.println(BaseChangesUtils.binaryToDecimal("0xabcd"));
//    }
//
//    /**
//     * 高精度运算测试
//     * @return void
//     */
//    public void mathTest() {
//        //ArithmeticUtils ath = new ArithmeticUtils();
//        System.out.println("加法测试");
//        System.out.println(ArithmeticUtils.add(0.2, 0.23));
//        System.out.println(ArithmeticUtils.add("0.2", "0.23"));
//        System.out.println(ArithmeticUtils.add("0.2", "0.23", 1));
//
//        System.out.println("减法测试");
//        System.out.println(ArithmeticUtils.sub(0.2, 0.1));
//        System.out.println(ArithmeticUtils.sub("0.2", "0.1"));
//        System.out.println(ArithmeticUtils.sub("0.2", "0.11", 2));
//
//        System.out.println("乘法测试");
//        System.out.println(ArithmeticUtils.mul(0.2, 0.1));
//        System.out.println(ArithmeticUtils.mul("0.2", "0.1"));
//        // 结果：0.02
//        System.out.println(ArithmeticUtils.mul(0.2, 0.1, 3));
//        // 结果：0.020
//        System.out.println(ArithmeticUtils.mul("0.2", "0.1", 3));
//
//        System.out.println("除法测试");
//        //System.out.println(ArithmeticUtils.div(0.2, 0.1));
//        // 结果：2.0
//        System.out.println(ArithmeticUtils.div(0.2, 0.1, 2));
//        System.out.println(2.00);
//        // 结果：2.00
//        //System.out.println(ArithmeticUtils.div("0.2", "0.1", 2));
//
//        System.out.println("取余测试");
//        // 结果：0.20
//        System.out.println(ArithmeticUtils.remainder("1.2", "0.5", 2));
//        // 结果：0.20
//        System.out.println(ArithmeticUtils.remainder(new BigDecimal(1.2), new BigDecimal(0.5), 2));
//
//        System.out.println("比大小测试");
//        System.out.println(ArithmeticUtils.compare("0.2", "0.1"));
//        System.out.println(ArithmeticUtils.compare("0.2", "0.3"));
//        System.out.println(ArithmeticUtils.compare("0.2", "0.2"));
//    }
//
//    /**
//     * 邮件发送测试
//     * @return void
//     */
//    public void sendMailTest() {
//        //SendMailUtils.createEmail();
//        SendMailUtils.sendEmail();
//    }
//
//    /**
//     * 自定义日志测试
//     * @return void
//     */
//    public void myLoggerTest() {
//        // 需要保存到本地指定路径下的日志定义方式
//        //String path = "C:\\Users\\86185\\Desktop\\temp\\logTest\\log1.txt";
//        //Logger myLogger = MyLoggerUtils.myLogger(path);
//
//        // 无需保存到本地文件中的日志定义方式
//        Logger myLogger = MyLoggerUtils.myLogger();
//
//        myLogger.info("这是一个info日志信息：普通信息");
//        myLogger.warning("这是一个warning日志信息：警告信息");
//        myLogger.config("这是一个config日志信息：配置信息");
//        myLogger.severe("这是一个severe日志信息：严重信息");
//
//
//        // 直接使用自定义的logger进行测试
//        MyLoggerUtils.logger.info("这是一条info消息");
//        MyLoggerUtils.logger.warning("这是一条warning消息");
//        MyLoggerUtils.logger.severe("这是一条severe消息");
//        MyLoggerUtils.logger.config("这是一条config消息");
//    }
//
//    /**
//     * String和Array之间的转换测试
//     * @return void
//     */
//    public void stringArrayTest() {
//        StringArrayTest01 strArr = new StringArrayTest01();
//        // String转Array测试
//        strArr.stringToArray();
//        // Array转String测试
//        strArr.arrayToString();
//
//        // 携带编码方式的转换
//        String str = "你好鸭";
//        strArr.StringArrayWithCode(str);
//    }
//
//    /**
//     * 泛型方法测试
//     * @return void
//     */
//    public void genericTest() {
//        System.out.println("==============1、数组打印测试==============");
//        // 创建不同类型的数组
//        Integer[] intArray = {1, 2, 3, 4, 5, 6};
//        Double[] doubleArray = {1.1, 1.2, 1.3, 1.4, 1.5, 1.6};
//        Character[] charArray = {'A', 'B', 'C', 'D', 'E', 'F'};
//
//        // 调用泛型方法
//        System.out.println("整型数组为：");
//        GenericTest01.printArray(intArray);
//
//        System.out.println("Double型数组为：");
//        GenericTest01.printArray(doubleArray);
//
//        System.out.println("Char型数组为：");
//        GenericTest01.printArray(charArray);
//
//
//        System.out.println("==============2、最大值测试==============");
//        System.out.printf("%d, %d, %d 中最大的值是: %d\n\n", 3, 6, 1, GenericTest01.maximum(3, 6, 1));
//        System.out.printf("%.1f, %.1f, %.1f 中最大的值是: %.1f\n\n", 1.1, 9.0, 3.7, GenericTest01.maximum(1.1, 9.0, 3.7));
//        System.out.printf("%s, %s, %s 中最大的值时: %s\n\n", "apple", "orange", "app", GenericTest01.maximum("apple", "orange", "app"));
//
//
//        System.out.println("==============3、泛型类的定义和使用==============");
//        // 新建泛型类对象
//        GenericClass strGeneric = new GenericClass<String>();
//        GenericClass<Integer> integerGeneric = new GenericClass<>();
//
//        strGeneric.setT("123");
//        integerGeneric.setT(456);
//
//        System.out.printf("整型值为: %d\n\n", integerGeneric.getT());
//        System.out.printf("字符串的值为: %s\n\n", strGeneric.getT());
//
//
//        System.out.println("==============4、类型通配符测试==============");
//        List<String> strings = new ArrayList<>();
//        List<Integer> integers = new ArrayList<>();
//        List<Number> numbers = new ArrayList<>();
//
//        strings.add("123");
//        integers.add(456);
//        numbers.add(789);
//
//        GenericTest01.getData(strings);
//        GenericTest01.getData(integers);
//        GenericTest01.getData(numbers);
//    }
//
//    /**
//     * 静态初始化值测试
//     * @return void
//     */
//    public void staticTest() {
//        // 打印八种基本数据类型的静态初始化值
//        StaticValueTest.baseStaticValues();
//
//        // 其他的数据类型的静态初始值
//        StaticValueTest.otherStaticValues();
//    }
//
//    public static void main(String[] args){
//        MainTest mainTest = new MainTest();
//        // 进制转换测试
//        //mainTest.baseTest();
//
//        // 时间输出测试
//        //mainTest.timeTest();
//
//        // 高精度数学运算测试
//        //mainTest.mathTest();
//
//        // 邮件发送测试
//        //mainTest.sendMailTest();
//
//        // 自定义日志测试
//        //mainTest.myLoggerTest();
//
//        // String和Array之间的转换测试
//        //mainTest.stringArrayTest();
//
//        // 泛型测试
//        //mainTest.genericTest();
//
//        // 静态测试
//        mainTest.staticTest();
//    }
//}
