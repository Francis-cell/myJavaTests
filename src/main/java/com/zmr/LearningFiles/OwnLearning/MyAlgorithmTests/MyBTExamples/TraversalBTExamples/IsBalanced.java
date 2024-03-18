package com.zmr.LearningFiles.OwnLearning.MyAlgorithmTests.MyBTExamples.TraversalBTExamples;

import com.sun.imageio.plugins.common.I18NImpl;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/3/11 17:47
 * @description 判断一棵二叉树是否是平衡二叉树
 * 条件：
 * 1、左树--平衡二叉树
 * 2、右树--平衡二叉树
 * 3、绝对值 (左数高度 - 右树高度) < 2
 */
public class IsBalanced {
    /** 辅助类 */
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        
        public Node (int value) {
            this.value = value;
        }
    }

    /**
     * 封装一个辅助类
     * 1、当前树是否平衡
     * 2、当前树的高度
     */
    public static class Info {
        public boolean isBalanced;
        public int height;

        public Info (boolean i, int h) {
            this.isBalanced = i;
            this.height = h;
        }
    }
    
    public static boolean isBalanced(Node head) {
        return process(head).isBalanced;
    }
    
    public static Info process (Node x) {
        if (x == null) {
            return new Info(true, 0);
        }
        // 先假设能够获取到左树和右树
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        
        // 获取当前树的高度( Max(左树高度, 右树高度) + 1)【这里 +1 是因为当前也算作一层】
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        // 假设isBalanced初始值为true
        boolean isBalanced = true;
        // 如果左树不平衡，那么isBalanced也为false
        if (!leftInfo.isBalanced) {
            isBalanced = false;
        }
        // 右树同理
        if (!rightInfo.isBalanced) {
            isBalanced = false;
        }
        // 如果不满足 绝对值 (左数高度 - 右树高度) < 2，那么依旧不平衡
        if (Math.abs(leftInfo.height - rightInfo.height) > 1) {
            isBalanced = false;
        }
        
        return new Info(isBalanced, height);
    }
}
