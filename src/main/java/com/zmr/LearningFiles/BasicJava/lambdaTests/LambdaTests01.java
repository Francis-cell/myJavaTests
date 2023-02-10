//package main.java.com.zmr.LearningFiles.BasicJava.lambdaTests;
//
//import main.java.com.zmr.LearningFiles.BasicJava.entity.Student;
//
//import java.math.BigDecimal;
//import java.util.function.*;
//
///**
// * @ClassName LambdaTests
// * @Description 函数式接口
// * @Author zhumengren
// * @Date 2022/3/15 14:41
// * @Email zhumengren@sinosoft.com
// * @Version 1.0
// **/
//public class LambdaTests01 {
//    public static void main(String[] args) {
//        // 1、Predicate测试(判断真假)
//        Predicate<Integer> predicate = x -> x > 100;
//        Student xiaobai = new Student("小白", 10, 90);
//        Student xiaohei = new Student("小黑", 9, 101);
//        // 运行结果：小白的身高是否高于100: false
//        System.out.println("小白的身高是否高于100: " + predicate.test(xiaobai.getHeight()));
//        // 运行结果：小黑的身高是否高于100: true
//        System.out.println("小黑的身高是否高于100: " + predicate.test(xiaohei.getHeight()));
//
//        // 2、Consumer测试(消费消息)
//        Consumer<String> consumer = System.out::println;
//        // 运行结果：好滴好滴！
//        consumer.accept("好滴好滴！");
//
//        // 3、Function测试(将apply内的内容映射为 一个对象的操作结果)
//        Function<Student, String> function = Student::getName;
//        String name = function.apply(xiaobai);
//        // 运行结果：小白
//        System.out.println(name);
//
//        // 4、Supplier(生产消息)
//        Supplier<Integer> supplier =
//                () -> Integer.valueOf(BigDecimal.TEN.toString());
//        Supplier<String> supplier1 =
//                () -> xiaobai.getName();
//        // 运行结果：10
//        System.out.println(supplier.get());
//        // 运行结果：小白
//        System.out.println(supplier1.get());
//
//        // 5、UnaryOperator(一元操作【仅仅传入一个元素的操作】)
//        UnaryOperator<Boolean> unaryOperator = uglily -> !uglily;
//        Boolean apply1 = unaryOperator.apply(true);
//        // 运行结果：false
//        System.out.println(apply1);
//        UnaryOperator<Integer> unaryOperator1 = value -> value + 1;
//        Integer apply2 = unaryOperator1.apply(10);
//        // 运行结果：11
//        System.out.println(apply2);
//
//        // 6、BinaryOperator(二元操作)
//        BinaryOperator<Integer> binaryOperator = (x, y) -> x * y;
//        Integer apply3 = binaryOperator.apply(10, 9);
//        // 运行结果：90
//        System.out.println(apply3);
//
//        // 7、引入自定义函数式接口
//        customiseFunction(() -> "自定义函数式接口");
//    }
//
//    /***
//     *
//     * @Description 自定义函数式接口
//     * @param worker
//     */
//    public static void customiseFunction(Worker worker){
//        String work = worker.work();
//        System.out.println(work);
//    }
//
//    public interface Worker {
//        String work();
//    }
//}
