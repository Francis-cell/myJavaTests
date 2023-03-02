package com.zmr.LearningFiles.MyAlgorithmTests.MyBTExamples.SagmentTree;

import com.sun.jnlp.FileOpenServiceImpl;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/3/2 22:23
 * @description 线段树
 * 如果当前节点为i ，则父节点位置为(i / 2); 左孩子节点为(2 * i); 右孩子节点为(2 * i + 1)
 */
public class SagmentTreeDefine {
    /** 线段树定义 */
    public static class SegmentTree {
        private int MAXN;
        /** arr[]: 原序列的信息从0开始，但是arr里从1开始 */
        private int[] arr;
        /** sum[]模拟线段树---维护区间和 */
        private int[] sum;
        /** lazy[] 累加和懒惰标记 */
        private int[] lazy;
        /** change[] 为更新的值 */
        private int[] change;
        /** update[] 为更新懒惰标记(使用boolean值用来确定0这个值
         * 是更新后的值，还是没有执行更新的状态) */
        private boolean[] update;
        
        /** 构造方法 */
        public SegmentTree(int[] origin) {
            MAXN = origin.length + 1;
            // arr[0] 不使用，从1开始使用
            arr = new int[MAXN];
            for (int i = 1; i < MAXN; i++) {
                arr[i] = origin[i - 1];
            }
            
            // 说明：下方空间 * 4原因
            // 一棵数，如果它有N个节点，刚好满足 2^x = N (这种情况下只需要申请 2N个空间就足够了)
            // 但是这时候，又来了1个节点，由于这个新增的节点是最大值，在线段树中，最大的数在右子树，
            // 也就是说这个多出来的值在整棵线段树的最最最右子树的位置上，前面这行多出来的空间都将不存储
            // 任何值，所以相当于多了2N的空间存储，需要4N的空间去存储值
            // 具体可以参看-算法思维导图-线段树-（1-4线段树~1-5线段树变化流程）
            
            
            // 用来支持脑补概念中，某个范围累加和信息
            sum = new int[MAXN << 2];
            // 用来支持脑补概念中，某个范围没有往下传递的累加任务
            lazy = new int[MAXN << 2];
            // 用来支持脑补概念中，某个范围有没有更新操作的任务
            change = new int[MAXN << 2];
            // 用来支持脑补概念中，某个范围更新任务，更新成了什么
            update = new boolean[MAXN << 2];
        }
        
        /** 
         * 计算线段树累加和方法 
         * rt代表当前操作的线段树的节点 
         */
        private void pushUp(int rt) {
            // 左孩子 + 右孩子
            // 左孩子 = 2 * rt
            // 右孩子 = 2 * rt + 1
            sum[rt] = sum[rt << 1] + sum[rt << 1 | 1];
        }
        
        /** 
         * 结合懒更新的分发策略
         * 如果操作范围(a, b) 和 当前节点rt(a1, b1)的大小关系为：
         * a > a1 或者 b < b1，则对于当前节点的懒更新失效，需要将当前节点之前所有的懒更新操作
         * 传递给左孩子和右孩子
         * 
         * 参数说明：
         * 1、rt表示操作的节点
         * 2、ln 表示左子树结点个数
         * 3、rn 表示右子树结点个数
         */
        private void pushDown(int rt, int ln, int rn) {
            /** 
             * 这里一定要注意，需要先处理update操作，之后处理add操作 
             * 原因：更新将会清除掉所有的懒更新的值，如果之后执行了add操作，
             * 但是却最后让update执行，那么所有add产生的懒更新&对值的更改都将变化
             */
            
            // 执行update操作
            if (update[rt]) {
                // 将更新传递给当前结点的左孩子和右孩子
                update[rt << 1] = true;
                update[rt << 1 | 1] = true;
                // 更新左右孩子的值
                change[rt << 1] = change[rt];
                change[rt << 1 | 1] = change[rt];
                
                // 左右孩子的懒更新数组清空[add懒更新]
                lazy[rt << 1] = 0;
                lazy[rt << 1 | 1] = 0;
                // 左右孩子的累加和 = 对应子树的节点数量 * 将要change成为的值
                sum[rt << 1] = change[rt] * ln;
                sum[rt << 1 | 1] = change[rt] * rn;
                // 然后将当前节点rt的更新数组的boolean值关闭
                update[rt] = false;
            }
            
            // 执行add操作
            // 说明当前节点有懒更新存储的值，需要传递给左右孩子节点
            if (lazy[rt] != 0) {
                // 如果左右孩子原本有懒更新存储的值，则累加处理[add懒更新]
                lazy[rt << 1] += lazy[rt];
                lazy[rt << 1 | 1] += lazy[rt];
                // 更新累加和(原本的值 + 子树节点数量 * 懒更新的值大小)[add懒更新]
                sum[rt << 1] += lazy[rt] * ln;
                sum[rt << 1 | 1] += lazy[rt] * rn;
                // 最后将当前节点rt的懒更新的值更新为0[add懒更新]
                lazy[rt] = 0;
            }
        }
        
        /** 
         * 构建线段树
         * 在初始化阶段，先把sum数组填好
         * 在arr[l~r]范围上build这个线段树
         * rt:表示这个范围在sum中的下标
         */
        public void build(int l, int r, int rt) {
            // 说明已经到了线段树的叶子节点了，可以直接赋值(eg: 1-4线段树中的 3-3节点就是一个叶子节点)
            if (l == r) {
                sum[rt] = arr[l];
                return;
            }
            
            int mid = (l + r) >> 1;
            // 分开构建左右子树
            // 左子树的根节点就是当前节点rt的左孩子，rt * 2
            build(l, mid, rt << 1);
            // 右子树的根节点就是当前节点rt的右孩子，rt * 2 + 1
            build(mid + 1, r, rt << 1 | 1);
            // 计算当前节点rt的的累加和的值
            pushUp(rt);
        }
        
        /**
         * 线段树update操作
         * 参数说明：
         * 【命令】
         * 在[L - R]范围上执行update操作
         * C-要update的值是多少
         * 【数组范围】
         * 在arr[l~r]范围上操作这个树
         * rt-表示被操作的节点
         */
        public void update(int L, int R, int C, int l, int r, int rt) {
            // L----------R 【更新操作的区间】 
            // ----l--r---- 【当前被操作的线段树区间】
            // 这种情况说明在l~r上可以执行懒更新操作
            if (L <= l && r <= R) {
                // 当前结点的懒更新boolean数组更新为true[change懒更新]
                update[rt] = true;
                // 当前节点的懒更新数组的值更新为C[change懒更新]
                change[rt] = C;
                // 更新当前结点的累加和的值
                sum[rt] = C * (r - l + 1);
                // 将当前节点的懒更新数组清空为0[add懒更新]
                lazy[rt] = 0;
                return;
            }
            
            // 当前任务没办法躲掉了，无法懒更新，要往下下发
            int mid = (l + r) >> 1;
            // 执行下发
            pushDown(rt, mid - l + 1, r - mid);
            
            // 如果更新的范围小于mid，说明mid划分后，左侧子树还要更新
            if (L <= mid) {
                update(L, R, C, l, mid, rt << 1);
            }
            // 同理右边一样
            if (R > mid) {
                update(L, R, C, mid + 1, r, rt << 1 | 1);
            }
            // 最后更新当前节点的累加和
            pushUp(rt);
        }
        
        /**
         * 线段树add操作
         * 参数说明：
         * 【命令】
         * 在[L - R]范围上执行add操作
         * C-要add的值是多少
         * 【数组范围】
         * 在arr[l~r]范围上操作这个树
         * rt-表示被操作的节点
         */
        public void add(int L, int R, int C, int l, int r, int rt) {
            // 如果任务把当前的范围全包了
            if (L <= l && r <= R) {
                // 直接执行懒更新
                sum[rt] += C * (r - l + 1);
                // 当前节点rt上懒更新的值增加C
                lazy[rt] += C;
                return;
            }
            
            // 任务没有被全包下来
            int mid = (l + r) >> 1;
            // 执行分发操作
            pushDown(rt, mid - l + 1, r - mid);
            // 同更新操作
            if(L <= mid) {
                add(L, R, C, l, mid, rt << 1);
            }
            if (R > mid) {
                add(L, R, C, mid + 1, r, rt << 1 | 1);
            }
            // 最后计算当前结点的累加和
            pushUp(rt);
        }
        
        /**
         * 线段树query操作
         * 参数说明：
         * 【命令】
         * 在[L - R]范围上执行query操作
         * 【数组范围】
         * 在arr[l~r]范围上操作这个树
         * rt-表示被操作的节点
         */
        public long query(int L, int R, int l, int r, int rt) {
            // 当前任务被全包了
            if (L <= l && r <= R) {
                // 直接返回当前节点的累加和即可
                return sum[rt];
            }
            int mid = (l + r) >> 1;
            // 执行分发操作
            pushDown(rt, mid - l + 1, r - mid);
            long ans = 0;
            if (L <= mid) {
                ans += query(L, R, l ,mid, rt << 1);
            }
            if (R > mid) {
                ans += query(L, R, mid + 1, r, rt << 1 | 1);
            }
            return ans;
        }
    }
    
    /** 比较器-暴力add, update, query */
    public static class Right {
        public int[] arr;
        
        public Right(int[] origin) {
            arr = new int[origin.length + 1];
            for (int i = 0; i < origin.length; i++) {
                arr[i + 1] = origin[i];
            }
        } 
        
        public void update(int L, int R, int C) {
            for (int i = L; i <= R; i++) {
                arr[i] = C;
            }
        }
        
        public void add(int L, int R, int C) {
            for (int i = L; i <= R; i++) {
                arr[i] += C;
            }
        }
        
        public long query(int L, int R) {
            long ans = 0;
            for (int i = L; i <= R; i++) {
                ans += arr[i];
            }
            return ans;
        }
    }
    
    /** 随机数组 */
    public static int[] genarateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int)(Math.random()* maxSize) + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (maxValue)) - (int) (Math.random() * (maxValue));
        }
        return arr;
    }

    //public static int[] genarateRandomArray(int len, int max) {
    //    int size = (int) (Math.random() * len) + 1;
    //    int[] origin = new int[size];
    //    for (int i = 0; i < size; i++) {
    //        origin[i] = (int) (Math.random() * max) - (int) (Math.random() * max);
    //    }
    //    return origin;
    //}

    /** 测试方法声明 */
    public static boolean test() {
        int testTimes = 5000;
        int maxSize = 100;
        int maxValue = 1000;
        int addOrUpdateTimes = 1000;
        int queryTimes = 500;
        for (int i = 0; i < testTimes; i++) {
            // 随机出初始原始数组
            int[] origin = genarateRandomArray(maxSize, maxValue);
            // 开始准备构建线段树
            SegmentTree seg = new SegmentTree(origin);
            // 表示将要构建的线段树的根节点root所在的位置{从1开始}
            int S = 1;
            int N = origin.length;
            int root = 1;
            seg.build(S, N, root);
            // 比较器方法调用
            Right rig = new Right(origin);
            // 比较两种方式结果是否一致
            for (int j = 0; j < addOrUpdateTimes; j++) {
                // 随机产生操作数
                int num1 = (int) (Math.random() * N) + 1;
                int num2 = (int) (Math.random() * N) + 1;
                int L = Math.min(num1, num2);
                int R = Math.max(num1, num2);
                int C = (int) (Math.random() * maxValue) - (int) (Math.random() * maxValue);

                // 执行add操作
                if (Math.random() < 0.5) {
                    seg.add(L, R, C, S, N, root);
                    rig.add(L, R, C);
                } else {
                    seg.update(L, R, C, S, N, root);
                    rig.update(L, R, C);
                }
            }

            // 然后是执行query操作
            for (int j = 0; j < queryTimes; j++) {
                // 随机产生操作数
                int num1 = (int) (Math.random() * N) + 1;
                int num2 = (int) (Math.random() * N) + 1;
                int L = Math.min(num1, num2);
                int R = Math.max(num1, num2);

                long ans1 = seg.query(L, R, S, N, root);
                long ans2 = rig.query(L, R);
                if (ans1 != ans2) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /** main方法 */
    public static void main(String[] args) {
        System.out.println("对数器测试开始...");
        System.out.println("测试结果 : " + (test() ? "通过" : "未通过"));
        
        
        // (int)(Math.random()* maxSize) + 1
        // (int)(Math.random()* maxSize + 1)
    }
}
