package MyLeetCodeTests.My2022Lists.ListNodeTests;

import java.util.LinkedList;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @decription Java栈的使用
 * @date 2022/12/25 15:02
 */
public class MyStackTests {
    public static void main(String[] args) {
        // 初始化栈
        // Java中，推荐将LinkedList当作栈来使用
        LinkedList<Integer> stack = new LinkedList<>();

        // 元素入栈
        stack.addLast(1);
        stack.addLast(2);
        stack.addLast(3);
        stack.addLast(4);
        stack.addLast(5);

        // 访问栈顶元素
        int peek = stack.peekLast();

        // 元素出栈
        int pop = stack.removeLast();

        // 获取栈的长度
        int size = stack.size();

        // 判断栈是否为空
        boolean isEmpty = stack.isEmpty();
    }
}
