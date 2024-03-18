package com.zmr.LearningFiles.BooksReading.AlgorithmFourthTests.searchDemos;

import com.zmr.LearningFiles.BooksReading.AlgorithmFourthTests.MethodsFromBook.BasicAbout.StdIn;
import com.zmr.LearningFiles.BooksReading.AlgorithmFourthTests.MethodsFromBook.BasicAbout.StdOut;
import com.zmr.LearningFiles.BooksReading.AlgorithmFourthTests.MethodsFromBook.SearchAbout.ST;

public class Start01 {
    public static void main(String[] args) {
        ST<String, Integer> st = new ST<>();

        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }

        for (String s : st.keys()) {
            StdOut.println(s + " " + st.get(s));
        }
    }
}
