package com.zmr.LearningFiles.BooksReading.AlgorithmFourthTests.basicDemos;

/**
 * <p> 欧几里得求解两数的最大公约数 </p>
 */
public class Gcd {
    public static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }
        int r = p % q;
        return gcd(q, r);
    }
}
