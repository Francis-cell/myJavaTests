## List--Array

### 0、参考链接

#### 1、list

1、[Java 中初始化 List 集合的 6 种方式!](https://blog.csdn.net/youanyyou/article/details/84846486)



#### 2、Array

1、[java数组的三种初始化方式](https://blog.csdn.net/Elias94/article/details/79808581)

2、[Java的Arrays.sort()方法到底用的什么排序算法](https://www.cnblogs.com/baichunyu/p/11935995.html)



#### 3、共同

1、[JAVA 快速打印数组和List集合中的所有元素的方法](https://blog.csdn.net/qq_41089622/article/details/103880402)





### 1、List

#### 1、初始化list

##### 1、基本初始化方法

```java
/**基本的初始化list的方法*/
public static void createListBasic() {
    ArrayList<String> stringsArr = new ArrayList<>();
    stringsArr.add("a");
    stringsArr.add("b");
    stringsArr.add("c");
    stringsArr.add("d");
    System.out.println(stringsArr);
}


// 1、调用基本的list初始化方法
createListBasic();

/**运行结果*/
[a, b, c, d]
```



##### 2、Arrays.asList

```java
import static java.util.Arrays.asList;

/**使用Arrays工具类初始化list*/
public static void createListWithArraysUtils() {
    // 如果使用这种方式的话，初始化出来的list是不可变的
    List<String> strings = asList("a", "b", "c", "d");
    // TODO--注意
    // strings.add("f"); // 异常：creatrListWithArraysUtils
    System.out.println(strings);

    // 如果想要使用这种方式创建出可变的list，则需要处理一下才可以(处理方式如下)
    ArrayList<String> strings1 = new ArrayList<>(strings);
    strings1.add("f");
    System.out.println(strings1);
}

// 2、调用Arrays里的初始化list方法
createListWithArraysUtils();

/**运行结果*/
[a, b, c, d]
[a, b, c, d, f]
```





##### 3、使用Collections工具类

```java
/**使用Collections工具类*/
public static void createListWithCollections() {
    // 1、使用Collections工具类创建list
    // TODO--不可变，重复某个元素多次
    List<String> xiaoHei = Collections.nCopies(3, "xiaoHei");
    System.out.println(xiaoHei);

    // TODO-2、将创建的list列表转换成可变的列表
    ArrayList<String> strings = new ArrayList<>(xiaoHei);
    strings.add("zhu");
    System.out.println(strings);

    // 3、初始化只有单个元素的list，且不可改变
    List<String> xiaoBai = Collections.singletonList("xiaoBai");
    System.out.println(xiaoBai);

    // 4、创建一个空的list，没有默认容量，节省空间(doge
    List<Object> emptyLists = Collections.emptyList();
    System.out.println(emptyLists);
}

// 3、使用Collections创建list
createListWithCollections();

/**运行结果*/
[xiaoHei, xiaoHei, xiaoHei]
[xiaoHei, xiaoHei, xiaoHei, zhu]
[xiaoBai]
[]
```





##### 4、使用匿名内部类创建list

```java
/**使用匿名内部类创建list*/
public static void createListWithAnonymousInnerClass() {
    ArrayList<String> arrayList = new ArrayList() {{
        add("1");
        add("2");
        add("3");
    }};
    System.out.println(Arrays.toString(arrayList.toArray()));
}

// 4、使用匿名内部类创建list
createListWithAnonymousInnerClass();

/**运行结果*/
[1, 2, 3]
```





##### 5、使用JDK8中的Stream创建list

```java
/**JDK8 Stream*/
// import static java.util.stream.Collectors.toList;
public static void createListWithJDK8Stream() {
    List<String> collect = Stream.of("xiaoHei", "XiaoBai", "zhu").collect(toList());
    System.out.println(collect);
}

// 5、使用JDK8中的Stream创建list
createListWithJDK8Stream();

/**运行结果*/
[xiaoHei, XiaoBai, zhu]
```





### 2、Array

#### 1、初始化

##### 1、初始化代码

```java
/**静态初始化方法*/
int[] arr1 = {1, 2, 3, 4, 5};

/**动态初始化方法*/
int[] ints = new int[4];
```



##### 2、初始化说明

```bash
# 不同类型的数组初始化之后的初始值不一样
1、 基本数据类型的"整数类型"（byte、short、int、long）默认值是"0"
2、 基本数据类型的"浮点类型"（float、double）默认值是"0.0"
3、 基本数据类型的"字符类型"（char）默认值是'\u0000'
4、 基本数据类型的"布尔类型"（boolean）默认值是"false"
5、 "引用类型"（类、数组、接口、String）默认值是"null"
```









### Append

#### 1、快速打印==数组==或者==list==中的元素

```java
/**快速打印Array中的元素*/
String [] array = new String[] {"a", "b", "c"};
System.out.println(Arrays.toString(array));

/**快速打印List中的元素*/
List<String> list = new ArrayList<String>();
list.add("a");
list.add("b");
list.add("c");
System.out.println(Arrays.toString(list.toArray()));
```





