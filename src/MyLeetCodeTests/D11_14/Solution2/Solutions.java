package MyLeetCodeTests.D11_14.Solution2;

/**
 * @ClassName Solutions
 * @Description 不同的二叉搜索树
 * @Author zhumengren
 * @Date 2022/11/14 11:26
 * @Email zhumengren@sinosoft.com
 * @Version 1.0
 **/
public class Solutions {
    /**
     * 输入树的节点个数，返回可能的二叉搜索树的个数(只需要中序遍历的结果满足结果即可)
     * 思路：当1为根节点的时候，左侧有0个节点，右侧有n-1个节点，此时树的数量为G[0]*G[n-1]
     *      当2为根节点的时候，左侧有1个节点，右侧有n-2个节点，此时树的数量为G[1]*G[n-2]
     *      当3为根节点的时候，左侧有2个节点，右侧有n-3个节点，此时树的数量为G[2]*G[n-3]
     *      ...
     *      当n为根节点的时候，左侧有n-1个节点，右侧有0个节点，此时树的数量为G[n-1]*G[0]
     * */
    public int numTrees(int n) {
        // 创建一个具有n个元素的数组
        int[] G = new int[n+1];
        G[0] = G[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                // 此处可以看作根节点为1(j=1)，左侧0个节点(j-1)，右侧n-1个节点(i-j)
                G[i] += G[j-1]*G[i-j];
            }
        }

        return G[n];
    }

    public static void main(String[] args) {
        Solutions solutions = new Solutions();
        System.out.println(solutions.numTrees(15));
    }
}
