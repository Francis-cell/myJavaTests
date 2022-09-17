//package sortArithmetic;
//
//import static myUtils.ArrayUtils.printArray;
//
///**
// * @author 朱梦仁 franciszmr@foxmail.com
// * @version 1.0
// * @date 2021/9/25 20:34
// */
//public class BubbleSorted {
//
//    /**
//     * 未优化冒泡排序
//     * @param arr
//     */
//    public static void bubble_sorted(int arr[]) {
//        int temp;
//        for (int i = 0; i < arr.length - 1; i++) { // 趟数
//            for (int j = arr.length - 1;  j > i; j--) {
//                if (arr[j] < arr[j - 1]) {
//                    temp = arr[j - 1];
//                    arr[j - 1] = arr[j];
//                    arr[j] = temp;
//                }
//            }
//        }
//        printArray(arr);
//    }
//
//    /* 数据的顺序排好之后，冒泡算法仍然会继续进行下一轮的比较，直到arr.length-1次，
//        后面的比较没有意义的。 */
//
//    /**
//     * 优化后的冒泡排序算法
//     * @param arr
//     */
//    public static void bubble_sorted2(int arr[]) {
//        int temp;
//        boolean flag; // 是否交换的标志
//        for (int i = 0; i < arr.length - 1; i++) { // 趟数，一共length - 1次
//            flag = false;
//            for (int j = arr.length - 1;  j > i; j--) {
//                if (arr[j] < arr[j - 1]) {
//                    temp = arr[j - 1];
//                    arr[j - 1] = arr[j];
//                    arr[j] = temp;
//                    flag = true;
//                }
//            }
//            if (!flag) break;
//        }
//        printArray(arr);
//    }
//}
