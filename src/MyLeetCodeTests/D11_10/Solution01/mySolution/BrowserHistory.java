package MyLeetCodeTests.D11_10.Solution01.mySolution;

/**
 * @ClassName BrowserHistory
 * @Description TODO
 * @Author zhumengren
 * @Date 2022/11/10 12:43
 * @Email zhumengren@sinosoft.com
 * @Version 1.0
 **/
public class BrowserHistory {
    Node page;
    Node temp = page;

    public BrowserHistory(String homepage) {
        page = new Node(homepage);
    }

    public void visit(String url) {
        Node newPage = new Node(url);
        newPage.next = null;
        page.next = newPage;
        newPage.pre = page;
        page = page.next;
    }

    public String back(int steps) {
        while (steps!=0) {
            // 如果当前页面的前一个页面是第一个节点(除了根节点外),则返回当前节点(除了根节点之外的第一个节点)
            if (page.pre == temp) {
                break;
            } else {
                page = page.pre;
                steps--;
            }
        }
        return page.str;
    }

    public String forward(int steps) {
        while (steps!=0) {
            // 如果当前页面的下一个页面是末尾,则当前节点就是历史记录中的最后一个节点
            if (page.next == null) {
                break;
            } else {
                page = page.next;
                steps--;
            }
        }
        return page.str;
    }

    /**
     * 定义双向链表，因为这里双向链表的值是String类型的，所以Node的val为String类型的值
     * @return
     */
    static class Node {
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


    public static void main(String[] args) {
        // 输入：["BrowserHistory","visit","visit","visit","back","back","forward","visit","forward","back","back"]
        // 输出：[["leetcode.com"],["google.com"],["facebook.com"],["youtube.com"],[1],[1],[1],["linkedin.com"],[2],[2],[7]]

        // 创建根节点
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        System.out.println(browserHistory.page.str);
        browserHistory.visit("google.com");
        System.out.println(browserHistory.page.str);
        browserHistory.visit("facebook.com");
        System.out.println(browserHistory.page.str);
        browserHistory.visit("youtube.com");
        System.out.println(browserHistory.page.str);
        browserHistory.back(1);
        System.out.println(browserHistory.page.str);
        browserHistory.back(1);
        System.out.println(browserHistory.page.str);
        browserHistory.forward(1);
        System.out.println(browserHistory.page.str);
        browserHistory.visit("linkedin.com");
        System.out.println(browserHistory.page.str);
        browserHistory.forward(2);
        System.out.println(browserHistory.page.str);
        browserHistory.back(2);
        System.out.println(browserHistory.page.str);
        browserHistory.back(7);
        System.out.println(browserHistory.page.str);
    }
}
