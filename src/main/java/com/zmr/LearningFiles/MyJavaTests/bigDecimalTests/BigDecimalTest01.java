package main.java.com.zmr.LearningFiles.MyJavaTests.bigDecimalTests;

import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * @ClassName BigDecimalTest01
 * @Description BigDecimal测试类
 * @Author zhumengren
 * @Date 2022/4/14 9:58
 * @Email zhumengren@sinosoft.com
 * @Version 1.0
 **/
public class BigDecimalTest01 {

    /**
     * BigDecimal基本测试
     * @return void
     */
    public void baseTests() {
        // 创建一个整数类型的对象
        BigDecimal bd1 = new BigDecimal(10);
        // 结果：10
        System.out.println(bd1);

        // double(此处运行结果不符合预期的可能原因：此处在new的时候，传入的0.1本身就不是只有一位小数位的浮点数)
        BigDecimal bd2 = new BigDecimal(0.1);
        // 结果：0.1000000000000000055511151231257827021181583404541015625
        System.out.println(bd2);
        // 如果必须要传入double类型的数据源，操作如下
        BigDecimal bd21 = new BigDecimal(Double.toString(0.1));
        // 结果：0.1
        System.out.println(bd21);

        // long
        BigDecimal bd3 = new BigDecimal(10L);
        // 结果：10
        System.out.println(bd3);

        // String(浮点数的时候，建议使用String代替，因为它是可预测的)
        BigDecimal bd4 = new BigDecimal("0.1");
        // 结果：0.1
        System.out.println(bd4);
    }

    /**
     * BigDecimal常用方法测试
     * @return void
     */
    public void usuallyTests() {
        // 将BigDecimal中的值相加
        BigDecimal bg010 = new BigDecimal(10);
        // 结果：30
        System.out.println(bg010.add(new BigDecimal(20)));

        // 将BigDecimal中的值相减
        // 结果：5
        System.out.println(bg010.subtract(new BigDecimal(5)));

        // 将BigDecimal中的值相乘
        // 结果：20
        System.out.println(bg010.multiply(new BigDecimal(2)));

        // 将BigDecimal中的值相除
        // 结果：5
        System.out.println(bg010.divide(new BigDecimal(2)));
        // 用以设置精确的小数点位数，防止出现错误(取最近的值)
        System.out.println("---------");
        // 结果：4
        System.out.println(bg010.divide(new BigDecimal(3), 0));
        System.out.println(bg010.divide(new BigDecimal(3), 2));

        // 结果：3
        System.out.println(bg010.divide(new BigDecimal(3), 1));
        System.out.println(bg010.divide(new BigDecimal(3), 3));


        // 将BigDecimal中的值转换成字符串
        // 结果：10
        System.out.println(bg010.toString());

        // 将BigDecimal中的值转换成双精度的值
        // 结果：10.0
        System.out.println(bg010.doubleValue());

        // 将BigDecimal中的值转换成单精度的值
        // 结果：10.0
        System.out.println(bg010.floatValue());

        // 将BigDecimal中的值转换成长整型(Long)类型的数据
        // 结果：10
        System.out.println(bg010.longValue());

        // 将BigDecimal中的值转换成整型(int)类型的数据
        // 结果：10
        System.out.println(bg010.intValue());
    }

    /**
     * BigDecimal大小比较测试
     * @return void
     */
    public void sizeComparison() {
        // compareTo方法
        BigDecimal bg011 = new BigDecimal(10);
        int i = bg011.compareTo(new BigDecimal(10));
        // 结果：0
        System.out.println(i);
        // xs != ys ? ((xs > ys) ? 1 : -1) : 0;
        // 如果返回值为1,表bg011比后面的值大
        // 如果返回值为0,表bg011和后面的值相等
        // 如果返回值为-1,表bg011比后面的值小
    }

    /**
     * BigDecimal的格式化测试
     * @return void
     */
    public void formatBigDecimal() {
        // 使用NumberFormat类的format()方法，进行格式化

        // 建立货币格式化引用
        NumberFormat currency = NumberFormat.getCurrencyInstance();

        // 建立百分比格式化引用
        NumberFormat percent = NumberFormat.getPercentInstance();
        // 百分比的小数点后最多3位
        percent.setMaximumFractionDigits(3);

        // 设置贷款金额
        BigDecimal loanAmount = new BigDecimal("12345678.673");
        // 设置利率
        BigDecimal interestRate = new BigDecimal("0.008");
        // 将贷款金额和利率相乘
        BigDecimal interest = loanAmount.multiply(interestRate);

        // 结果：贷款金额:	￥12,345,678.67
        System.out.println("贷款金额:\t" + currency.format(loanAmount));
        // 结果：利率:	0.8%
        System.out.println("利率:\t" + percent.format(interestRate));
        // 结果：利息:	￥98,765.43
        System.out.println("利息:\t" + currency.format(interest));
    }


    /**
     * BigDecimal和Double转换的测试
     * @return void
     */
    public void bigDecimalDoubleTest() {
        System.out.println("new BigDecimal(0.99): " + new BigDecimal(0.99));
        System.out.println("new BigDecimal('0.99'): " + new BigDecimal("0.99"));
        System.out.println("BigDecimal.valueOf(0.99): " + BigDecimal.valueOf(0.99));
        System.out.println("BigDecimal.valueOf(0.99f): " + BigDecimal.valueOf(0.99f));
        System.out.println("new BigDecimal(Double.toString(0.99)): " + new BigDecimal(Double.toString(0.99)));
    }


    public static void main(String[] args) {
        BigDecimalTest01 bdt1 = new BigDecimalTest01();
        // 基本测试
        //bdt1.baseTests();

        // 常用方法测试
        //bdt1.usuallyTests();

        // 大小比较测试
        //bdt1.sizeComparison();

        // 格式化测试
        //bdt1.formatBigDecimal();

        // BigDecimal和Double转换的测试
        bdt1.bigDecimalDoubleTest();
    }
}
