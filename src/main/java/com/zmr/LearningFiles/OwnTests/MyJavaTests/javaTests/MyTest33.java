package com.zmr.LearningFiles.OwnTests.MyJavaTests.javaTests;

import java.util.*;

public class MyTest33 {
    public static void main(String[] args) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>(Arrays.asList(-1, 0, 1)));
        ans.add(new ArrayList<>(Arrays.asList(-1, 2, -1)));
        ans.add(new ArrayList<>(Arrays.asList(0, 1, -1)));

        List<List<Integer>> deduplicated = deduplicateLists(ans);
        for (List<Integer> list : deduplicated) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> deduplicateLists(List<List<Integer>> lists) {
        Set<List<Integer>> set = new LinkedHashSet<>();
        for (List<Integer> list : lists) {
            // Sort the list for consistent comparison
            List<Integer> sortedList = new ArrayList<>(list);
            sortedList.sort(Integer::compareTo);
            // Add the sorted list to the set, which will automatically deduplicate
            set.add(sortedList);
        }
        // Convert the set back to a list
        return new ArrayList<>(set);
    }
}
