package com.zmr.MyUtils.ArrayUtils;

import com.zmr.MyUtils.StringUtils.StringUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ArrayUtils {
    private static final ArrayUtils INSTANCE  = new ArrayUtils();

    private ArrayUtils() {}

    public static ArrayUtils getInstance() {
        return INSTANCE;
    }

    /**
     * <p> 转置-二维数组 </p>
     * @param clazz 数组中元素的类型
     * @param arr 要进行转置的数组
     * @return
     * @param <T>
     */
    public static <T> T[][] reverseArr(Class<T> clazz, T[][] arr) {
        if (arr == null || arr.length == 0 || arr[0].length == 0) {
            return null;
        }
        int rows = arr[0].length;
        int cols = arr.length;
        // 创建泛型数组
        // T[][] ans = (T[][]) new Object[rows][cols];
        // 对于二维数组，需要手动传入 clazz 才行，下面的这种手段无法获取到数组的类型
        // T[][] ans = (T[][]) Array.newInstance(arr.getClass().getComponentType(), rows, cols);
        T[][] ans = (T[][]) Array.newInstance(clazz, rows, cols);
        // 转置
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                ans[j][i] = arr[i][j];
            }
        }
        return ans;
    }

    /**
     * <p> 查看一个元素是否在某个一维数组中存在 </p>
     * @param arr 要参与检查的数组
     * @param ele 要被检查是否存在的元素
     * @return true - 存在； false - 不存在；
     */
    public static <T> boolean arrContainsElement(T[] arr, T ele) {
        if (ele == null) {
            return false;
        }
        for (T e : arr) {
            // 基本元素类型
            if (e instanceof Integer || e instanceof Double) {
                if (ele == e) {
                    return true;
                }
            }
            // 字符串类型
            else if (e instanceof String) {
                if (ele.equals(e)) {
                    return true;
                }
            }
            // TODO - 封装类型的判断
        }
        return false;
    }

    /**
     * <p> 获取到两个数组之间的差别，返回值中为一个二维数组，
     * 其中第一个元素为在 arr1 中存在但是不在 arr2 中不存在的元素;
     * 第二个元素在 arr1 中不存在但是在 arr2 中存在的元素</p>
     * @param oldArr 待比较的数组1
     * @param newArr 待比较的数组2
     * @return 差值列表
     * @param <T>
     */
    public static <T extends Comparable<T>> List<T[]> getDifferentElementsFromTwoArray(T[] oldArr , T[] newArr) {
        // 只在oldArr中存在，不在newArr中存在的元素(删除的元素)
        List<T> inOldNotInNewArr = new ArrayList<>();
        // 只在newArr中存在，不在oldArr中存在的元素(新增的元素)
        List<T> inNewNotInOldArr = new ArrayList<>();

        // 查找只在oldArr中存在的元素
        for (T item : oldArr) {
            if (!Arrays.asList(newArr).contains(item)) {
                inOldNotInNewArr.add(item);
            }
        }

        // 查找只在newArr中存在的元素
        for (T item : newArr) {
            if (!Arrays.asList(oldArr).contains(item)) {
                inNewNotInOldArr.add(item);
            }
        }

        // 将列表转换为数组
        T[] arr1 = inOldNotInNewArr.toArray(Arrays.copyOf(newArr, 0));
        T[] arr2 = inNewNotInOldArr.toArray(Arrays.copyOf(newArr, 0));

        List<T[]> ans = new ArrayList<>();

        ans.add(arr1);
        ans.add(arr2);
        return ans;
    }

    /**
     * <p> String 字符串转换成一个 Character 类型的数组 </p>
     * @param str
     * @return
     */
    public static Character[] strToCharacterArr(String str) {
        if (StringUtils.isEmpty(str)) {
            return new Character[0];
        } else {
            Character[] ans = new Character[str.length()];
            for (int i = 0; i < str.length(); i++) {
                Character c = str.charAt(i);
                ans[i] = c;
            }
            return ans;
        }
    }

    /**
     * 检查两个数组中的元素是否相等
     * @param v1
     * @param v2
     * @return
     * @param <T>
     */
    // public <T> Boolean checkTwoValueEquals(T[] v1, T[] v2) {
    //
    // }

    // public static class ComparatorArrayInner<T> implements Comparable<T> {
    //     @Override
    //     public int compare(T e1, T e2) {
    //         // Character 类型
    //         if (e1 instanceof Character) {
    //             return (Character) e1 - (Character) e2;
    //         }
    //         // String 类型
    //         if (e1 instanceof String) {
    //             // return (String) e1 - (String) e2;
    //             return 0;
    //         }
    //         return 0;
    //     }
    // }
}
