package com.zmr.LearningFiles.OwnLearning.MyAlgorithmTests.MyAndLookupExamples.myselfAndLookupTests;

/**
 * @ClassName MySencodeUnionFindWithArray
 * @Description 使用数组的方式实现并查集(具体案例参考朋友圈问题)
 **/
public class MySencodUnionFindWithArray {
    /** 并查集具体实现类-数组实现形式 */
    public static class UnionFind {
        /** parent[]数组: parent[i] = k ==> 表示i的父亲是k */
        private int[] parent;
        /** size[]数组: size[i] = k ==> 如果i是“代表节点”，则表示i所在集合size为k */
        private int[] size;
        /** 辅助结构: 代替HashMap方式实现并查集结构中的栈 */
        private int[] help;
        /** 一共有多少个集合 */
        private int sets;
        
        /** 构造方法 */
        public UnionFind(int N) {
            // 初始化相应的数组
            parent = new int[N];
            size = new int[N];
            help = new int[N];
            // 形成的集合的数量
            sets = N;
            for (int i = 0; i < N; i++) {
                // 当前node节点对应的父亲节点就是它自己本身
                parent[i] = i;
                // 当前节点所在的集合的大小初始时为1
                size[i] = 1;
            }
        }
        
        /** 关键辅助方法(给定一个节点，找到这个节点所在的集合中的代表节点) */
        private int findAncestor(int i) {
            // 记录help[]数组中记录的节点的数量
            int hi = 0;
            // 一直找，知道当前节点的parent就是它自己本身
            while (i != parent[i]) {
                // (入栈)
                help[hi++] = i;
                i = parent[i];
            }
            
            // 元素出栈，并将里面存储的元素的parent更新成找到的代表节点
            for (hi--; hi >= 0; hi--) {
                parent[help[hi]] = i;
            }
            
            return i;
        }
        
        /** 1、isSameSet(), 查看两个node节点是否在同一个集合中 */
        public boolean isSameSet(int a, int b) {
            // 分别找到a和b所在集合的代表节点
            return findAncestor(a) == findAncestor(b);
        }
        
        /** 2、union(), 合并两个节点a和b所在的集合 */
        public void union(int a, int b) {
            // 分别找到a和b所在集合的代表节点
            int aHead = findAncestor(a);
            int bHead = findAncestor(b);
            
            if (aHead != bHead) {
                // 将小的集合挂到大的集合上面
                if (size[aHead] >= size[bHead]) {
                    // 将小的集合挂到大的集合上面
                    size[aHead] += size[bHead];
                    // 将小的集合的parent转成大的集合的代表节点
                    parent[bHead] = aHead;
                } else {
                    size[bHead] += size[aHead];
                    parent[aHead] = bHead;
                }
                // 节点们总共形成的集合数量-1
                sets--;
            }
        }
        
        /** 返回节点们形成的集合数量 */
        public int sets() {
            return sets;
        }
    }
}
