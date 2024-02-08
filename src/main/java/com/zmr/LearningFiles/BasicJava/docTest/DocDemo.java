package com.zmr.LearningFiles.BasicJava.docTest;

public interface DocDemo {

    /**
     * <pre>{@code
     *  if (a > 0) {
     *      return 1;
     *  } else if (b > 0) {
     *      return 2;
     *  } else {
     *      return 3;
     *  }
     * }</pre>
     */
    default void docTest01() {
        System.out.println("Interface default method implementation.");
    }
}
