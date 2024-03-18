package com.zmr.LearningFiles.BooksReading.EffectiveJavaDemos.ThreadDemos;

import java.util.HashSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ObservableSetTest {

    public static void test01() {
        ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());
        // lambda 无法访问它们自己
        set.addObserver((s, e) -> System.out.println(e));

        for (int i = 0; i < 100; i++) {
            set.add(i);
        }
    }

    public static void test02() {
        ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());

        // 内部类和 lambda 的区别在于，内部类可以访问到它们自己
        set.addObserver(new SetObserver<Integer>() {
            @Override
            public void added(ObservableSet<Integer> set, Integer e) {
                System.out.println(e);
                if (e == 23) {
                    set.removeObserver(this);
                }
            }
        });

        for (int i = 0; i < 100; i++) {
            set.add(i);
        }
    }

    public static void test03() {
        ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());

        set.addObserver(new SetObserver<Integer>() {
            @Override
            public void added(ObservableSet<Integer> set, Integer e) {
                System.out.println(e);
                if (e == 23) {
                    ExecutorService exec = Executors.newSingleThreadExecutor();
                    try {
                        exec.submit(() -> set.removeObserver(this)).get();
                    } catch (ExecutionException | InterruptedException ex) {
                        throw new AssertionError(ex);
                    } finally {
                        exec.shutdown();
                    }
                }
            }
        });

        for (int i = 0; i < 100; i++) {
            set.add(i);
        }
    }

    public static void main(String[] args) {
        // test01();
        test02();
    }
}
