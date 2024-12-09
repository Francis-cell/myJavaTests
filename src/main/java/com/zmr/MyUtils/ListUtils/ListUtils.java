package com.zmr.MyUtils.ListUtils;

import com.zmr.MyUtils.ComparatorUtils.ComparatorUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.zmr.MyUtils.BasicUtils.CompareUtils.checkTwoValueEquals;

/**
 * <p> List 工具类 </p>
 */
public class ListUtils {
    /**
     * <p> List 元素比较器（元素不进行排序的比较） </p>
     * <p> 使用案例： </p>
     * <pre>
     *     {@code
     *         ArrayList<String> list1 = new ArrayList<>();
     *         list1.add("a");
     *         list1.add("b");
     *         list1.add("c");
     *         ArrayList<String> list2 = new ArrayList<>();
     *         list2.add("a");
     *         list2.add("c");
     *         list2.add("b");
     *
     *         boolean ans = isEqualListWithoutSort(list1, list2);
     *         System.out.println(ans);
     *     }
     * </pre>
     * @param list1
     * @param list2
     * @return
     * @param <E>
     */
    public static <E extends Comparable<E>> boolean isEqualListWithoutSort(List<E> list1, List<E> list2) {
        if (list1 == null && list2 != null || list1 != null && list2 == null) {
            return false;
        }
        if (list1 == null && list2 == null) {
            return true;
        }

        if (list1.size() != list2.size()) {
            return false;
        }

        for (int i = 0; i < list1.size(); i++) {
            if (!checkTwoValueEquals(list1.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * <p> List 元素比较器（元素进行排序的比较） </p>
     * <p> 使用案例： </p>
     * <pre>
     *     {@code
     *         ArrayList<String> list1 = new ArrayList<>();
     *         list1.add("a");
     *         list1.add("b");
     *         list1.add("c");
     *         ArrayList<String> list2 = new ArrayList<>();
     *         list2.add("a");
     *         list2.add("c");
     *         list2.add("b");
     *
     *         boolean ans = isEqualListWithoutSort(list1, list2);
     *         System.out.println(ans);
     *     }
     * </pre>
     * @param list1
     * @param list2
     * @return
     * @param <E>
     */
    public static <E extends Comparable<E>> boolean isEqualListWithSort(List<E> list1, List<E> list2) {
        if (list1 == null && list2 != null || list1 != null && list2 == null) {
            return false;
        }
        if (list1 == null && list2 == null) {
            return true;
        }

        if (list1.size() != list2.size()) {
            return false;
        }

        // 增加元素的排序处理
        Collections.sort(list1, new ComparatorUtils.ArrayComparator<>());
        Collections.sort(list2, new ComparatorUtils.ArrayComparator<>());

        for (int i = 0; i < list1.size(); i++) {
            if (!checkTwoValueEquals(list1.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("a");
        list2.add("c");
        list2.add("b");

        boolean ans1 = isEqualListWithoutSort(list1, list2);
        boolean ans2 = isEqualListWithSort(list1, list2);
        System.out.println(ans1);
        System.out.println(ans2);
    }
}
