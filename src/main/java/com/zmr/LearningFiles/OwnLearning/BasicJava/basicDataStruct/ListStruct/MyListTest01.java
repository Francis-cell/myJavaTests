//package main.java.com.zmr.LearningFiles.BasicJava.basicDataStruct.ListStruct;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//import java.util.stream.Stream;
//import static java.util.stream.Collectors.toList;
//
//import static java.util.Arrays.asList;
//
///**
// * @ClassName MyListTest01
// * @Description 列表测试01--初始化列表
// * @Author zhumengren
// * @Date 2022/9/8 19:26
//
// * @Version 1.0
// **/
//public class MyListTest01 {
//    /**基本的初始化list的方法*/
//    public static void createListBasic() {
//        ArrayList<String> stringsArr = new ArrayList<>();
//        stringsArr.add("a");
//        stringsArr.add("b");
//        stringsArr.add("c");
//        stringsArr.add("d");
//        System.out.println(stringsArr);
//    }
//
//    /**使用Arrays工具类初始化list*/
//    public static void createListWithArraysUtils() {
//        // 如果使用这种方式的话，初始化出来的list是不可变的
//        List<String> strings = asList("a", "b", "c", "d");
//        // TODO--注意
//        // strings.add("f"); // 异常：creatrListWithArraysUtils
//        System.out.println(strings);
//
//        // 如果想要使用这种方式创建出可变的list，则需要处理一下才可以(处理方式如下)
//        ArrayList<String> strings1 = new ArrayList<>(strings);
//        strings1.add("f");
//        System.out.println(strings1);
//    }
//
//    /**使用Collections工具类*/
//    public static void createListWithCollections() {
//        // 1、使用Collections工具类创建list
//        // TODO--不可变，重复某个元素多次
//        List<String> xiaoHei = Collections.nCopies(3, "xiaoHei");
//        System.out.println(xiaoHei);
//
//        // TODO-2、将创建的list列表转换成可变的列表
//        ArrayList<String> strings = new ArrayList<>(xiaoHei);
//        strings.add("zhu");
//        System.out.println(strings);
//
//        // 3、初始化只有单个元素的list，且不可改变
//        List<String> xiaoBai = Collections.singletonList("xiaoBai");
//        System.out.println(xiaoBai);
//
//        // 4、创建一个空的list，没有默认容量，节省空间(doge
//        List<Object> emptyLists = Collections.emptyList();
//        System.out.println(emptyLists);
//    }
//
//    /**使用匿名内部类创建list*/
//    public static void createListWithAnonymousInnerClass() {
//        ArrayList<String> arrayList = new ArrayList() {{
//            add("1");
//            add("2");
//            add("3");
//        }};
//        System.out.println(Arrays.toString(arrayList.toArray()));
//    }
//
//    /**JDK8 Stream*/
//    // import static java.util.stream.Collectors.toList;
//    public static void createListWithJDK8Stream() {
//        List<String> collect = Stream.of("xiaoHei", "XiaoBai", "zhu").collect(toList());
//        System.out.println(collect);
//    }
//
//
//
//    public static void main(String[] args) {
//        /**初始化list*/
//        // 1、调用基本的list初始化方法
//        //createListBasic();
//
//        // 2、调用Arrays里的初始化list方法
//        //createListWithArraysUtils();
//
//        // 3、使用Collections创建list
//        //createListWithCollections();
//
//        // 4、使用匿名内部类创建list
//        //createListWithAnonymousInnerClass();
//
//        // 5、使用JDK8中的Stream创建list
//        //createListWithJDK8Stream();
//    }
//}
