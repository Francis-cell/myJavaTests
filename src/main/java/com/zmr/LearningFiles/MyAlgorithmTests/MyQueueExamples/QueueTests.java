package main.java.com.zmr.LearningFiles.MyAlgorithmTests.MyQueueExamples;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @desciption 使用数组实现队列 (借助一个size实现，技巧)
 * @date 2023/2/1 21:15
 */
public class QueueTests {
    public class MyQueue {
        private int[] arr;
        // end
        private int pushI;
        // begin
        private int popI;
        // 数组的大小
        private int size;
        // 队列的大小
        private int limit;


        public MyQueue(int limit) {
            arr = new int[limit];
            pushI = 0;
            popI = 0;
            size = 0;
            this.limit = limit;
        }


        /** push方法 */
        public void push(int val) {
            // 判断size和limit的大小关系
            if (size == limit) {
                throw new RuntimeException("队列满了！！！");
            }
            size++;
            arr[pushI] = val;
            // 更新pushI的值
            pushI = nextIndex(pushI);
        }


        /** pop方法 */
        public int pop() {
            if (size == 0) {
                throw new RuntimeException("队列空了！！！");
            }
            size--;
            int ans = arr[popI];
            // 更新popI的值
            popI = nextIndex(popI);
            return ans;
        }


        /** isEmpty方法 */
        public boolean isEmpty() {
            return size == 0;
        }



        /** 辅助方法，如果现在的下标是i，返回下一个位置 */
        private int nextIndex(int i) {
            return i < limit - 1 ? i + 1 : 0;
        }
    }
}
