package com.zmr.LearningFiles.OwnLearning.MyAlgorithmTests.ViolentRecursion;

import java.util.Stack;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/3/18 21:27
 * @description 不额外申请空间，将栈中的元素进行翻转 【递归实现】
 */
public class ReverseStackUsingRecursive {
    /** 栈中元素翻转主方法 */
    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        // 获取栈底元素
        int i = f(stack);
        // 递归
        reverse(stack);
        // 将原本在栈底的元素一个一个放进去，最后拿到的是原本栈底的元素
        // 故而就实现了栈中元素的翻转
        stack.push(i);
    }
    
    
    /** 
     * 辅助方法
     * 说明：将栈顶元素移除掉；将上面的元素盖下来；返回移除掉的栈底元素；
     * eg:
     * | 1 |   递归结构 -->(result = 1, last = f(2))
     * | 2 |              (result = 2, last = f(3)) 
     * | 3 |              (result = 3)
     * -----
     * 
     * | 1 |  返回值：3
     * | 2 |
     * -----
     */
    public static int f(Stack<Integer> stack) {
        // result是出栈的元素(这些元素会被存储在系统栈中[递归])
        int result = stack.pop();
        // 上面的案例中，3的时候会空
        if (stack.isEmpty()) {
            // 返回3
            return result;
        } else {
            int last = f(stack);
            // 2和1的时候走完上面的f()会调用，故而栈中元素最后为 1、2
            stack.push(result);
            // 将last往上返回(实际上就是栈底的元素，这里是3)
            return last;
        }
    }


    public static void main(String[] args) {
        Stack<Integer> test = new Stack<Integer>();
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.push(5);
        reverse(test);
        while (!test.isEmpty()) {
            System.out.println(test.pop());
        }
    }
}
