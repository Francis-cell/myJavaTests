package LearningFiles.MyJavaTests.javaTests;

import java.text.ParseException;

/**
 * @ClassName MyTest10
 * @Description String测试
 * @Author zhumengren
 * @Date 2022/5/14 15:37
 * @Email zhumengren@sinosoft.com
 * @Version 1.0
 **/
public class MyTest10 {
    //private static final String DATE_FORMAT = "EEE MMM dd HH:mm:ss z yyyy";
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static void main(String[] args) throws ParseException {
        //String str = "123456789";
        //System.out.println(str.substring(0,1));

        //// String转JSON测试
        ////String jsonString = "{\"name\" : \"zmr\", \"age\" : 23}";
        //JSONObject jsonObject = (JSONObject) JSONObject.parse(jsonString);
        //System.out.println(jsonObject);

        //String s = Long.toString(System.currentTimeMillis());
        // 将时间戳转换成需要的格式
        //System.out.println(s);

        //long timeMillis = System.currentTimeMillis();
        ////String millisTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(timeMillis);
        //String millisTime = new SimpleDateFormat("yyy-MM-dd HH:mm:ss.SSS z").format(timeMillis);
        //System.out.println(millisTime);


        //Date parse = new SimpleDateFormat(DATE_FORMAT, Locale.US).parse("Wed Mar 01 10:47:12 CST 2017");
        //Date parse = new SimpleDateFormat(DATE_FORMAT).parse(millisTime);
        //System.out.println(parse);

        //String user;
        //String code;
        //HashMap<String, String> hm = {user="123", code = "456"};
        //ArrayList<String> strings = new ArrayList<>();
        //String a = "123";
        //String b = "456";
        //strings.add(a);
        //strings.add(b);
        //System.out.println(strings);

        //HashMap<String, String> hashMap = new HashMap<>();
        //hashMap.put("a", "123");
        //hashMap.put("b", "456");
        //System.out.println(hashMap);
        //System.out.println(hashMap.get("a"));

        //String hashStr = "{a=123, b=345}";
        //String hashStr = "{PROJECTNAME=123, PROJECTCODE=345}";
        //String[] split = hashStr.substring(1, hashStr.length() - 1).split(", ");
        //// 获取PROJECTNAME的值
        //System.out.println(split[0].split("=")[1]);
        //// 获取PROJECTCODE的值
        //System.out.println(split[1].split("=")[1]);

        //HashMap<String, String> hashMap = new HashMap<>();
        //hashMap.put("1", "123");
        //hashMap.put("2", "234");
        //hashMap.put("3", "345");
        //System.out.println(hashMap.get("1"));
        //
        //String hashValue = "{\"1\"=\"123\", \"2\"=\"234\", \"3\"=\"345\"}";


        String str = "1234567";
        //System.out.println(str.length());
        //System.out.println(str.substring(0, str.length()-1));
    }
}
