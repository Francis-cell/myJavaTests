package com.zmr.LearningFiles.MyAlgorithmTests.MyKMPExamples;

/**
 * @ClassName KMP
 * @Description KMP算法实现(获取一个字符串s2在字符串s1中首次匹配到的位置)
 **/
public class KMP {
    /** KMP主方法 */
    public static int getIndexOf(String s1, String s2) {
        if (s1 == null || s2 == null || s2.length() < 1 || s1.length() < s2.length()) {
            return -1;
        }
        
        // 先将s1和s2转换成字符数组
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        
        // x表示当前s1正在匹配的位置(可以认为是画圈的位置)
        // y表示当前s2正在匹配的位置(可以认为是画圈的位置)
        int x = 0;
        int y = 0;
        
        // 计算next[]数组
        int[] next = getNextArray(str2);
        
        // 如果当前在str1和str2中匹配到的位置没有超过范围
        while (x < str1.length && y < str2.length) {
            // 如果str1当前正在进行匹配的位置 == str2当前正在匹配的位置
            // x和y的位置都可以向后移动1位
            if (str1[x] == str2[y]) {
                x++;
                y++;
            }
            // 当前str2回到了最开始位置，但是仍然没有和str1匹配上，那么str1正在匹配的位置x向后移动1位
            else if (next[y] == -1) {
                x++;
            }
            // 说明str2没有回到最开始的位置，直接回到当前y记录的next[y]的位置，继续进行匹配即可
            else {
                y = next[y];
            }
        }

        // 如果y == str2.length，说明str2越界了，这时候，说明str1中能完全匹配str2
        // 如果能完全匹配到，则返回str1中完全匹配str2的初始位置(使用当前str1中正在匹配的位置 - y即可)
        return  y == str2.length ? x - y : -1;
    }
    
    /** 
     * next数组计算 
     * 说明：求的是前缀和后缀完全一致的最大值
     * 举例：abcabdabca
     *      0123456789
     *      在0-3位置的前缀为abca; 在6-9位置的后缀为abca
     *      且没有更长的相同的前缀和后缀了，所以如果上面字符串如果后面还有字符，
     *      那么10位置的字符对应的next的值为4，同理计算其他位置的next的值
     */
    public static int[] getNextArray(char[] str2) {
        if (str2.length == 1) {
            return new int[] { -1 };
        }
        int[] next = new int[str2.length];
        // 给next数组中0位置赋值为-1; 1位置赋值为0 (固定写法)
        next[0] = -1;
        next[1] = 0;
        
        // 目前在哪个位置上求next数组的值
        // 说明：因为0和1已经赋了初始值了
        int i = 2;
        // 当前是哪个位置上的值，在和i-1位置上的字符进行比较
        // 说明：因为i位置的next值不由自己决定，而是由i位置之前的所有字符决定的，
        // 那么初始的时候，位置是在2位置，它的 i-1 位置是下标为1的元素，与下标为1
        // 的元素进行比较的前缀为0位置的元素，因此这里的cn赋值为0
        int cn = 0;
        
        while (i < next.length) {
            // 如果匹配成功了
            // str2[i-1]表示当前正在计算的位置的元素的前一个元素
            // str2[cn]表示当前正在和i-1位置元素的值进行比较的元素
            if (str2[i-1] == str2[cn]) {
                // 这里使用++cn，是为了让后面匹配的时候无需再对cn进行+1操作
                next[i++] = ++cn;
            }
            // 如果没有匹配到，但是cn位置的next > 0，说明还有再比较的空间
            // 则比较当前元素和cn位置存储的next的值进行第一个if中的比较操作
            else if (cn > 0) {
                cn = next[cn];
            }
            // 否则就是cn位置的next已经没有了，那么说明当前位置的最大前后缀匹配的长度为0
            else {
                next[i++] = 0;
            }
        }
        return next;
    }

    /** --------------------------对数器------------------------------ */
    
    /** 随机字符串 */
    public static String generateRandomString(int possibilities, int size) {
        char[] ans = new char[(int) (Math.random() * size) + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (char) ((int) (Math.random() * possibilities) + 'a');
        }
        return String.valueOf(ans);
    }
    
    
    public static void main(String[] args) {
        int possibilities = 5;
        // str1使用
        int strSize = 20;
        // str2使用
        int matchSize = 5;
        int testTimes = 5000000;
        System.out.println("测试开始");
        for (int i = 0; i < testTimes; i++) {
            // 随机字符串str1和str2
            String str1 = generateRandomString(possibilities, strSize);
            String str2 = generateRandomString(possibilities, matchSize);
            
            // 比较逻辑
            if (getIndexOf(str1, str2) != str1.indexOf(str2)) {
                System.out.println("出错了！");
                break;
            }
        }
        System.out.println("测试结束！");
    }
}
