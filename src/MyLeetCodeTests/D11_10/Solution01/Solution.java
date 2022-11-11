package MyLeetCodeTests.D11_10.Solution01;

/**
 * @ClassName Solution
 * @Description 设计浏览器历史记录
 * @Author zhumengren
 * @Date 2022/11/10 12:43
 * @Email zhumengren@sinosoft.com
 * @Version 1.0
 **/
public class Solution {

    /**
     * 定义双向链表，因为这里双向链表的值是String类型的，所以Node的val为String类型的值
     * @return
     */
    class Node {
        String str;
        Node pre;
        Node next;

        public Node(String str) {
            this.str = str;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "str='" + str + '\'' +
                    ", pre=" + pre +
                    ", next=" + next +
                    '}';
        }
    }
}
