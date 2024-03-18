//package main.java.com.zmr.LearningFiles.MyAlgorithmTests.SortExamples.sortArithmetic;
//
//import static myUtils.ArrayUtils.printArray;
//
///**
// * @author 朱梦仁 franciszmr@foxmail.com
// * @version 1.0
// * @date 2021/9/25 20:50
// */
//public class SelectSorted {
//
//    /**
//     * 选择排序
//     * @param arr
//     */
//    public static void select_sorted(int arr[]){
//        for (int i = 0; i < arr.length - 1; i++) {
//            int minIndex = i;
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[j] < arr[minIndex]) {
//                    minIndex = j;
//                }
//            }
//            if (minIndex != i){
//                int temp = arr[i];
//                arr[i] = arr[minIndex];
//                arr[minIndex] = temp;
//            }
//        }
//        printArray(arr);
//    }
//}
