package main.java.com.zmr.TempTests;

public class JavaClassFiles {
    static volatile int count = 0;

    public static void increment() {
        count+=7;
    }

    public static void main(String[] args) {
        increment();
    }
}
