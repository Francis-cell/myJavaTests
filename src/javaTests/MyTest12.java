package javaTests;

import java.text.ParseException;

/**
 * @ClassName MyTest12
 * @Description TODO
 * @Author zhumengren
 * @Date 2022/6/7 10:46
 * @Email zhumengren@sinosoft.com
 * @Version 1.0
 **/
public class MyTest12 {
    public static void main(String[] args) throws ParseException {
        //String str = "abc,";
        //////String[] split = str.split(",");
        //////System.out.println(split[0]);
        ////System.out.println(str.substring(0, str.length()-1));
        //
        //String newSocialSecurity = "政策性惠民保,门诊慢特病保险,长期护理保险,新业态业务";
        ////String[] splitStrs = newSocialSecurity.split(",");
        //String str = "政策性惠民保";
        //System.out.println(newSocialSecurity.indexOf(str));

        //System.out.println(123 + "");
        //System.out.println((123 + "").getClass().getName());

        //String str = "{\"data\":{\"URL\":\"FireFly.getContextPath()/sy/base/view/stdCardView.jsp?sId=FM_BGS_SBFRSQSQ_APPLY&pkCode=&parmCode=3wNVVLnD53bFaGNfEPKnGC&uid=kV4CJhTlAUyOIRDOTQ2R5A==&isDES=y\"},\"code\":\"SUCCESS\"}\n";
        //JSONObject strJson = (JSONObject) JSONObject.parse(str);
        //String data = strJson.getString("data");
        //System.out.println("data的值：" + data);
        //String url = data.substring(8, data.length() - 2);
        //System.out.println(url);

        //long millis = System.currentTimeMillis();
        //System.out.println("millis的值为: " + millis);

        //long timeMillis = 1651334400000L;
        ////long timeMillis = 1651334400;
        //// 新建时间格式
        //SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        //// 转换时间格式
        //String dateTemp = formater.format(timeMillis);
        //System.out.println(dateTemp);

        //Date date = 1651334400000;
        //System.out.println(date);

        String a = "a";
        String abc = "abc";
        System.out.println(a.indexOf(abc));
        System.out.println(abc.indexOf(a));
    }
}
