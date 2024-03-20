package com.zmr.LearningFiles.BooksReading.AlgorithmFourthTests.searchDemos;

import com.zmr.LearningFiles.BooksReading.AlgorithmFourthTests.MethodsFromBook.BasicAbout.StdIn;
import com.zmr.LearningFiles.BooksReading.AlgorithmFourthTests.MethodsFromBook.BasicAbout.StdOut;
import com.zmr.LearningFiles.BooksReading.AlgorithmFourthTests.MethodsFromBook.SearchAbout.ST;

public class Start01 {
    public static void main(String[] args) {
        // ST<String, Integer> st = new ST<>();
        //
        // for (int i = 0; !StdIn.isEmpty(); i++) {
        //     String key = StdIn.readString();
        //     st.put(key, i);
        // }
        //
        // for (String s : st.keys()) {
        //     StdOut.println(s + " " + st.get(s));
        // }
        //
        // while (!StdIn.isEmpty()) {
        //     String key = StdIn.readLine();
        //     StdOut.println(key + " ");
        // }

        BinarySearchST<Integer, Integer> st = new BinarySearchST<>(20);
        // 1、3、5、7、9、11、12、13、16
        for (int i = 0; i <= 16; i += 2) {
            st.put(i, i);
        }

        System.out.printf("当前搜索序列中的值：");
        for (int i = 0; i <= 16; i += 2) {
            Integer val = st.get(i);
            System.out.printf(val + ", ");
        }
        System.out.println("最终结果：");
        System.out.println(st.rank(4));
    }
}
