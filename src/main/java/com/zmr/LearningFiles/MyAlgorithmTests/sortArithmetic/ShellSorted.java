//package main.java.com.zmr.LearningFiles.MyAlgorithmTests.sortArithmetic;
//
//import static myUtils.ArrayUtils.printArray;
//
///**
// * @author 朱梦仁 franciszmr@foxmail.com
// * @version 1.0
// * @date 2021/9/25 20:13
// */
//public class ShellSorted {
//
//    /**
//     * 希尔排序
//     * @param arr
//     */
//    public static void shell_sorted(int[] arr) {
//        int temp = 0;
//        int incre = arr.length;
//        while (true) {
//            incre = incre / 2;
//            for (int k = 0; k < incre; k++) { // 比较的粒度，跨度（初始为arr.length / 2，最终为1）
//                for (int i = k + incre; i < arr.length; i += incre) { // 用于保存当前跨度下进行到哪个元素（用于给j重新初始化，j向前比较例外）
//                    for (int j = i; j > k; j -= incre) { // 当满足下方if条件后，将会依次向前比较（按照跨度跳转比较）
//                        if (arr[j] < arr[j - incre]) {
//                            temp = arr[j - incre];
//                            arr[j - incre] = arr[j];
//                            arr[j] = temp;
//                        } else {
//                            break;
//                        }
//                    }
//                }
//            }
//            if (incre == 1) {
//                break;
//            }
//        }
//        printArray(arr);
//    }
//}
