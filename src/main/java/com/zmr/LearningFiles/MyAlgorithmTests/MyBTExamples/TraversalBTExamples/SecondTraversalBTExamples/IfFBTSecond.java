package com.zmr.LearningFiles.MyAlgorithmTests.MyBTExamples.TraversalBTExamples.SecondTraversalBTExamples;

/**
 * @ClassName IfFBTSecond
 * @Description 判断一棵二叉树是否是满二叉树
 * 1、左孩子是满二叉树；
 * 2、右孩子是满二叉树；
 * 3、左孩子height = 右孩子height
 **/
public class IfFBTSecond {
    /** 辅助Node类 */
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        
        public Node() {};
        public Node(int value) {
            this.value = value;
        }
    }
    
    public static boolean isFullBT(Node head) {
        return process(head).isFull;
    }
    
    /** Info类 */
    public static class Info {
        public int height;
        public boolean isFull;
        
        public Info (int height, boolean isFull) {
            this.height = height;
            this.isFull = isFull;
        }
    }
    
    /** process方法 */
    public static Info process (Node x) {
        if (x == null) {
            return new Info(0, true);
        }
        
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);

        int height = leftInfo.height + rightInfo.height + 1;
        boolean isFull = false;
        if (leftInfo.height == rightInfo.height && leftInfo.isFull && rightInfo.isFull) {
            isFull = true;
        }
        
        return new Info(height, isFull);
    }
    
    /** 对数器 */
    //public static boolean ifFullTreeForcible(Node head) {
    //    // 层序遍历，如果某个节点开始(使用两个辅助栈)
    //    if (head == null) {
    //        return true;
    //    }
    //    Queue<Node> queue = new LinkedList<>();
    //    queue.add(head);
    //    int num1 = 1;
    //    int num2 = 0;
    //    // 新建两个栈，用来存储每一层的情况
    //    Stack<Node> stack1 = new Stack<>();
    //    Stack<Node> stack2 = new Stack<>();
    //    // 先将头节点添加进第一个stack
    //    stack1.add(head);
    //    // 标志位：当前哪个stack是正在弹出数据的栈
    //    int flag = 1;
    //    
    //    while (!queue.isEmpty()) {
    //        // 当前正在执行弹出的栈
    //        Stack<Node> nowStack = flag == 1 ? stack1 : stack2;
    //        Stack<Node> anotherStack = nowStack == stack1 ? stack2 : stack1;
    //        
    //        Node cur = queue.poll();
    //        nowStack.pop();
    //        
    //        
    //        if (cur.left != null) {
    //            queue.add(cur.left);
    //            anotherStack.push(cur.left);
    //        }
    //        if (cur.right != null) {
    //            queue.add(cur.right);
    //            anotherStack.push(cur.right);
    //        } else {
    //            return false;
    //        }
    //    }
    //}


    /** Info类 */
    public static class Info1 {
        public int height;
        public int nodeNum;

        public Info1(int h, int n) {
            height = h;
            nodeNum = n;
        }
    }

    /** 满二叉树递归方法process */
    public static Info1 process1(Node x) {
        if (x == null) {
            return new Info1(0, 0);
        }
        // 假设可以获取到左右子树的信息
        Info1 leftInfo = process1(x.left);
        Info1 rightInfo = process1(x.right);
        // 获取height信息
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        // 获取nodeNum信息
        int nodeNum = leftInfo.nodeNum + rightInfo.nodeNum + 1;
        return new Info1(height, nodeNum);
    }

    /** 满二叉树判断主方法 */
    public static boolean ifFullBT(Node head) {
        return process1(head).nodeNum == (int)(Math.pow(2, process1(head).height)) - 1;
    }

    /** 随机产生二叉树辅助方法 */
    public static Node generateBinaryTreeWithLevel(int level, int maxLevel, int maxValue) {
        // 如果当前level > maxLevel，则直接返回null
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }
        Node head = new Node((int) (Math.random() * maxValue) + 1);
        head.left = generateBinaryTreeWithLevel(level + 1, maxLevel, maxValue);
        head.right = generateBinaryTreeWithLevel(level + 1, maxLevel, maxValue);
        return head;
    }


    /** 随机产生二叉树 */
    public static Node generateRandomBT(int maxLevel, int maxValue) {
        return generateBinaryTreeWithLevel(1, maxLevel, maxValue);
    }

    public static void main(String[] args) {
        //Node head = new Node(1);
        //head.left = new Node(2);
        //head.right = new Node(3);
        //head.left.left = new Node(4);
        //head.left.right = new Node(5);
        //head.right.left = new Node(6);
        //head.right.right = new Node(7);
        ////head.left.left.left = new Node(8);
        ////head.left.left.right = new Node(9);
        ////head.left.right.left = new Node(10);
        ////head.left.right.right = new Node(11);
        //
        //System.out.println(isFullBT(head));

        int maxLevel = 5;
        int maxValue = 100;
        int testTimes = 100000;
        System.out.println("测试开始！");
        for (int i = 0; i < testTimes; i++) {
            // 随机产生二叉树，比较
            Node bt = generateRandomBT(maxLevel, maxValue);
            if (isFullBT(bt) != ifFullBT(bt)) {
                System.out.println("出错了！");
                break;
            }
        }
        System.out.println("测试结束！");
        
    }
}
