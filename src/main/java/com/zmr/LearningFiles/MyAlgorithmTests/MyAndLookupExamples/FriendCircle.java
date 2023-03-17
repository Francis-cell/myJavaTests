package com.zmr.LearningFiles.MyAlgorithmTests.MyAndLookupExamples;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/3/13 22:29
 * @description 朋友圈问题--并查集--数组实现
 * 本题为leetcode原题
 * 测试链接：https://leetcode.com/problems/friend-circles/
 * 可以直接通过
 */
public class FriendCircle {
    /** 查看形成的朋友圈数量 */
    public static int findCircleNum(int[][] M) {
        // 先获取二维数组的长度
        // {0} {1} {2} ... {N - 1}
        int N = M.length;
        
        // 初始化并查集
        UnionFind unionFind = new UnionFind(N);
        // 只获取二维数组右上角部分的数据就可以了，因为左上--右下对角线是每个人和自己的关系
        // 例如A是B的朋友，那么B也是A的朋友，所以只需要一半的数据就足够形成并查集了
        //      A  B  C  D  E  F
        // A  | 1  0  0  0  0  1 |
        // B  | 0  1  1  0  1  0 |
        // C  | 0  1  1  0  0  0 |
        // D  | 0  0  0  1  0  1 |
        // E  | 0  1  0  0  1  0 |
        // F  | 1  0  0  1  0  1 |
        // 
        // 上面的这个二维数组形成的集合就是{BCE}和{ADF}

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                // 说明i和j相互认识
                if (M[i][j] == 1) {
                    // 在并查集中进行合并
                    unionFind.union(i, j);
                }
            }
        }
        return unionFind.sets();
    }
    
    /** 辅助类--并查集--数组实现 */
    public static class UnionFind {
        /** parent[i] = k : 表示i的父亲是k */
        private int[] parent;
        /** 
         * size[i] = k : 如果i是"代表节点", size[i]才有意义，否则无意义 
         * i 所在的集合大小是多少?
         */
        private int[] size;
        /** 辅助结构--代替HashMap实现并查集结构中的栈 */
        private int[] help;
        /** 一共有多少个结合 */
        private int sets;
        
        /** 构造方法 */
        public UnionFind(int N) {
            parent = new int[N];
            size = new int[N];
            help = new int[N];
            // 形成的set数量，初始的时候是N
            sets = N;
            for (int i = 0; i < N; i++) {
                // 当前node节点的父亲节点是它自己本身
                parent[i] = i;
                // 当前node节点初始化的时候所在的集合只有自己，所以size = 1
                size[i] = 1;
            }
        }
        
        /** 
         * 从i开始一直往上找，直到不能再往上,
         * 返回"代表节点"，过程中要做(路径压缩) 
         */
        private int findAncestor(int i) {
            // help[]数组中记录的节点数量
            int hi = 0;
            // 一直找，直到当前节点就是它自己的parent
            while (i != parent[i]) {
                // (入栈)--使用数组代替
                help[hi++] = i;
                // 将当前的父亲节点的值赋值给i
                i = parent[i];
            }
            
            // 将在help[]中存储的所有的节点的父亲节点直接挂"代表节点"
            // 1、第一个hi--，返回的是hi的最大的下标，用于找到help[]中对应的Node节点
            // 2、第二个hi--，是将help[]数组中所有缓存的数据都拿出来，好重新挂父节点
            for (hi--; hi >= 0; hi--) {
                parent[help[hi]] = i;
            }
            
            return i;
        }
        
        /** 将两个节点a、b所在的集合合并成一个集合 */
        public void union(int a, int b) {
            // 分别找到a、b节点对应的"代表节点"
            int fa = findAncestor(a);
            int fb = findAncestor(b);
            
            // 如果fa == fb，说明a和b本身就在同一个集合，那么不需要合并了
            if (fa != fb) {
                // 小的集合挂到大的集合上
                if (size[fa] >= size[fb]) {
                    // 将fb的大小 加入到fa的大小中
                    size[fa] += size[fb];
                    // 将fb的parent转成fa
                    parent[fb] = fa;
                } else {
                   size[fb] += size[fa];
                   parent[fa] = fb;
                }
                // 形成的set数量 -1
                sets--;
            }
        }
        
        /** 返回形成的集合的数量 */
        public int sets() {
            return sets;
        }
    }
}
