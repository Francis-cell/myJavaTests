package com.zmr.LearningFiles.OwnLearning.MyAlgorithmTests.MyBTExamples.SagmentTree;

/**
 * @ClassName SecondSagmentTreeDefine
 * @Description 线段树-第二次实现
 * 线段树数组从1开始，而不是从0开始
 * 如果当前节点为i，则父节点的位置为(i / 2)，左孩子节点位置为(2 * i)，右孩子节点位置为(2 * i + 1) 
 **/
public class SecondSagmentTreeDefine {
    /** 线段树定义 */
    public static class SegmentTree {
        /** 线段树容量 */
        private int MAXN;
        /** arr[]: 原序列的信息从0开始，但是线段树采用的是从1开始的方式 */
        private int[] arr;
        /** sum[]: 模拟线段树的区间和数组--维护区间和 */
        private int[] sum;
        /** lazy[]: add懒惰标记 */
        private int[] lazy;
        /** change[]: update操作执行时要更改的值 */
        private int[] change;
        /** update[]: 一个boolean数组，用来确定change[]中的0是change的值还是没有任何change的初始化值 */
        private boolean[] update;
        
        /** 构造方法 */
        public SegmentTree(int[] origin) {
            // 初始化数组长度MAXN(从1开始的，所以length + 1)
            MAXN = origin.length + 1;
            
            // 初始化arr
            // arr[0]不使用，从1开始使用
            arr = new int[MAXN];
            for (int i = 1; i < MAXN; i++) {
                arr[i] = origin[i - 1];
            }
            
            // 初始化sum、lazy、change、update数组，默认4N空间(足够使用)
            sum = new int[MAXN << 2];
            lazy = new int[MAXN << 2];
            change = new int[MAXN << 2];
            update = new boolean[MAXN << 2];
        }
        
        /** 
         * 线段树累加和计算方法
         * rt表示当前正在操作的节点
         */
        private void pushUp(int rt) {
            // 累加和 = 左孩子累加和 + 右孩子累加和
            // 左孩子 = 2 * rt
            // 右孩子 = 2 * rt + 1
            sum[rt] = sum[rt << 1] + sum[rt << 1 | 1];
        }
        
        
        /** 
         * 线段树向下分发策略(配合懒更新使用) 
         * L-----------------R 【当前要操作的数组index范围】
         * ---l---------r----- 【当前被操作的数组arr的范围】
         * 上面这种情况下，是可以使用懒更新的
         * 
         * 参数说明：
         * 1、rt表示当前操作的节点
         * 2、ln表示左子树节点的个数
         * 3、rn表示右子树节点的个数
         */
        private void pushDown(int rt, int ln, int rn) {
            // 一定要先执行update操作，后执行add操作
            // 1、执行update操作
            if (update[rt]) {
                // 将更新传递给左右孩子节点
                // 更新(用来确定change[]中的0是change的值还是没有任何change的初始化值)数组
                update[rt << 1] = true;
                update[rt << 1 | 1] = true;
                // 更新(change[]，保存更新的数组的值)
                change[rt << 1] = change[rt];
                change[rt << 1 | 1] = change[rt];
                
                // 左右孩子的add懒更新数组lazy[]清空
                lazy[rt << 1] = 0;
                lazy[rt << 1 | 1] = 0;
                // 左右孩子的累加和 = 对应子树的节点数量 * change[rt]
                sum[rt << 1] = ln * change[rt];
                sum[rt << 1 | 1] = rn * change[rt];
                // 将当前节点(用来确定change[]中的0是change的值还是没有任何change的初始化值)数组重置
                update[rt] = false;
            }
            
            // 2、执行的add操作
            if (lazy[rt] != 0) {
                // 将add懒更新的值传递给左右孩子
                lazy[rt << 1] += lazy[rt];
                lazy[rt << 1 | 1] += lazy[rt];
                // 同时更新左右孩子的累加和数组sum
                sum[rt << 1] += lazy[rt] * ln;
                sum[rt << 1 | 1] += lazy[rt] * rn;
                // 将当前节点的add懒更新的值重置
                lazy[rt] = 0;
            }
        }
        
        /** 
         * 构建线段树
         * 初始化时，先将sum填好，
         * 在arr[l~r]上构建这个线段树
         * rt: 表示当前操作节点在sum中的下标
         */
        public void build(int l, int r, int rt) {
            // 说明已经到叶子节点了，直接赋值即可
            if (l == r) {
                sum[rt] = arr[l];
                return;
            }
            
            // 分开构建两棵子树
            int mid = (l + r) >> 1;
            build(l, mid, rt << 1);
            build(mid+1, r, rt << 1 | 1);
            // 计算当前节点的累加和信息
            pushUp(rt);
        }
        
        /** 
         * 线段树的update操作
         * 参数说明：
         * 【命令】
         * 在[L - R]范围上执行update操作
         * C-要update的值是多少
         * 【数组范围】
         * 在arr[l~r]范围上操作这个树
         * rt-表示被操作的节点
         */
        public void update(int L, int R, int C, int l, int r, int rt) {
            // L------------------R
            // ----l---------r-----
            // 如果满足上面的情况，则执行懒更新操作
            if (L <= l && r <= R) {
                // 将当前的节点的懒更新boolean数组更新为true[change懒更新]
                update[rt] = true;
                // 当前节点的懒更新数组为C[change懒更新]
                change[rt] = C;
                // 更新当前节点的累加和的值
                sum[rt] = C * (r - l + 1);
                // 将当亲啊节点的add懒更新清空
                lazy[rt] = 0;
                return;
            }
            
            // 当前任务没办法躲掉了，必须往下分发执行了
            int mid = (l + r) >> 1;
            // 执行下发
            pushDown(rt, mid - l + 1, r - mid);
            
            // 如果更新的范围小于mid，则说明经过一轮的mid划分之后，左侧子树仍然需要更新
            if (L <= mid) {
                update(L, R, C, l, mid, rt << 1);
            }
            // 如果更新之后的mid的值小于R，则说明经过一轮的mid划分，右侧子树仍然需要更新
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
                // 直接执行懒更新即可
                sum[rt] += C * (r - l + 1);
                // 当前节点rt上懒更新的值增加C
                lazy[rt] += C;
                return;
            }
            
            // 任务没有被全包下来，无法执行懒更新了
            int mid = (l + r) >> 1;
            // 执行分发操作
            pushDown(rt, mid - l + 1, r - mid);
            // 如果在左侧子树上有add操作
            if (L <= mid) {
                add(L, R, C, l, mid, rt << 1);
            }
            // 如果再右侧子树上有add操作
            if (R > mid) {
                add(L, R, C, mid + 1, r, rt << 1 | 1);
            }
            // 最后计算当前节点的累加和
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
            // 如果任务被全包下来了
            if (L <= l && r <= R) {
                // 直接返回当前节点的累加和即可
                return sum[rt];
            }
            
            // 否则就是没有被全包下来的情况
            int mid = (l + r) >> 1;
            // 执行分发操作
            pushDown(rt, mid - l + 1, r - mid);
            long ans = 0;
            // 如果左子树上存在查询操作
            if (L <= mid) {
                ans += query(L, R, l, mid, rt << 1);
            }
            // 如果右子树上存在查询操作
            if (mid < R) {
                ans += query(L, R, mid + 1, r, rt << 1 | 1);
            }
            return ans;
        }
    }
    
    /** 比较器定义--暴力方法 */
    public static class Right {
        public int[] arr;
        
        public Right(int[] origin) {
            // 这里要使用的数组下标从1开始
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
    
    /** 随机数组方法 */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int)(Math.random() * maxSize) + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * maxValue) - (int) (Math.random() * maxValue);
        }
        return arr;
    }
    
    /** 测试主方法 */
    public static boolean test() {
        int testTimes = 5000;
        int maxSize = 100;
        int maxValue = 1000;
        int addOrUpdateTimes = 1000;
        int queryTimes = 500;
        for (int i = 0; i < testTimes; i++) {
            // 随机出原始数组
            int[] origin = generateRandomArray(maxSize, maxValue);
            // 准备构建线段树
            SegmentTree seg = new SegmentTree(origin);
            int S = 1;
            int N = origin.length;
            int root = 1;
            seg.build(S, N, root);
            // 比较器方法调用
            Right rig = new Right(origin);
            // 比较两种方式结果是否一致
            for (int j = 0; j < addOrUpdateTimes; j++) {
                // 随机产生操作数
                int num1 = (int)(Math.random() * N) + 1;
                int num2 = (int)(Math.random() * N) + 1;
                int L = Math.min(num1, num2);
                int R = Math.max(num1, num2);
                int C = (int)(Math.random() * maxValue) - (int)(Math.random() * maxValue);
                
                // 执行add操作
                if (Math.random() < 0.5) {
                    // 执行add操作
                    seg.add(L, R, C, S, N, root);
                    rig.add(L, R, C);
                } else {
                    seg.update(L, R, C, S, N, root);
                    rig.update(L, R, C);
                }
            }
            
            // query比较
            for (int j = 0; j < queryTimes; j++) {
                // 随机产生操作树
                int num1 = (int)(Math.random() * N) + 1;
                int num2 = (int)(Math.random() * N) + 1;
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
        System.out.println("测试开始！");
        System.out.println("测试结果：" + (test() ? "通过!" : "不通过!"));
    }
}
 