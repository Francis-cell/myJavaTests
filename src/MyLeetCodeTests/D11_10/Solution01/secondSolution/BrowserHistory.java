package MyLeetCodeTests.D11_10.Solution01.secondSolution;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName BrowserHistory
 * @Description 动态数组的解法
 * @Author zhumengren
 * @Date 2022/11/11 19:51
 * @Email zhumengren@sinosoft.com
 * @Version 1.0
 **/
public class BrowserHistory {
    List<String> strArr =  new ArrayList<>();

    /** 定义初始下标 */
    int index = 0;

    public BrowserHistory(String homePage) {
        strArr.add(homePage);
    }

    public void visit(String url) {
        if (!"".equals(strArr.get(index))) {
            // 如果当前节点后面有其他节点，但是这时访问了一个新的页面，那么后面所有的节点都将被抛弃
            for (int i = strArr.size()-1; i > index; i--) {
                // 移除元素
                strArr.remove(i);
            }
        }
        strArr.add(url);
        index++;
    }

    public String back(int steps) {
        index = Math.max(index-steps, 0);
        return strArr.get(index);
    }

    public String forward(int steps) {
        index = Math.min(index+steps, strArr.size()-1);
        return strArr.get(index);
    }

    public static void main(String[] args) {
        // 输入：["BrowserHistory","visit","visit","visit","back","back","forward","visit","forward","back","back"]
        // 输出：[["leetcode.com"],["google.com"],["facebook.com"],["youtube.com"],[1],[1],[1],["linkedin.com"],[2],[2],[7]]

        // 创建根节点
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");
        browserHistory.visit("facebook.com");
        browserHistory.visit("youtube.com");
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.forward(1));
        browserHistory.visit("linkedin.com");
        System.out.println(browserHistory.forward(2));
        System.out.println(browserHistory.back(2));
        System.out.println(browserHistory.back(7));
    }
}
