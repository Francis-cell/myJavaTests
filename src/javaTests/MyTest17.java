package javaTests;

import java.text.ParseException;

/**
 * @ClassName MyTest12
 * @Description int数据转换成String类型，然后获取长度
 * @Author zhumengren
 * @Date 2022/6/7 10:46
 * @Email zhumengren@sinosoft.com
 * @Version 1.0
 **/
public class MyTest17 {
    public static void main(String[] args) throws ParseException {
        //int a = 1234567;
        //// String.valueOf(a)
        //// Integer.toString(a)
        ////System.out.println(Integer.toString(a).length());
        //System.out.println(a % 10);
        //ArrayList arrayList = new ArrayList();
        //arrayList.add("1");
        //arrayList.add("2");
        //arrayList.add("3");
        //arrayList.add("4");
        //arrayList.set(0, "a");
        //System.out.println(arrayList);

        //String str = "39654077";
        ////System.out.println(str.length());
        //
        //System.out.println(Long.parseLong(str));

        //BigDecimal bigDecimal = new BigDecimal(1.010);
        //float v = bigDecimal.setScale(3, BigDecimal.ROUND_HALF_UP).floatValue();
        //System.out.println(v);

        //Double b1 = 20.0;
        //Double b2 = 80.0;
        //if (b1 + b2 == 100.00) {
        //    System.out.println(1);
        //}

        Character character = new Character('0');
        System.out.println(character == 48);
    }
}
