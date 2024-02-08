package com.zmr.LearningFiles.EffectiveJavaDemos.ThreadDemos;

/**
 * 这个案例结合 CountDownLatchDemo 看，当下的这个案例是一个反面例子，
 * 需要学习这个例子中代码存在的问题
 */
public class SlowCountDownLatchDemo {
    private int count;

    public SlowCountDownLatchDemo(int count) {
        if (count < 0) {
            throw new IllegalArgumentException(count + " < 0");
        }
        this.count = count;
    }

    public void await() {
        while (true) {
            synchronized (this) {
                if (count == 0) {
                    return;
                }
            }
        }
    }

    public synchronized void countDown() {
        if (count != 0) {
            count--;
        }
    }


    public static void main(String[] args) {

    }
}
