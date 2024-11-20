package com.zmr.LearningFiles.OwnTests.MyJavaTests.javaTests;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Promise<T> {
    private final Supplier<T> supplier;
    private Consumer<T> onSuccess;
    private Consumer<Throwable> onFailure;

    public Promise(Supplier<T> supplier) {
        this.supplier = supplier;
    }

    public Promise<T> then(Consumer<T> onSuccess) {
        this.onSuccess = onSuccess;
        return this;
    }

    public Promise<T> catchException(Consumer<Throwable> onFailure) {
        this.onFailure = onFailure;
        return this;
    }

    public void execute() {
        try {
            T result = supplier.get();
            if (onSuccess != null) {
                onSuccess.accept(result);
            }
        } catch (Throwable t) {
            if (onFailure != null) {
                onFailure.accept(t);
            }
        }
    }

    public static <T> Promise<T> of(Supplier<T> supplier) {
        return new Promise<>(supplier);
    }

    public static void main(String[] args) {
        Promise.of(() -> {
                    // Your logic here
                    if (Math.random() > 0.5) {
                        throw new RuntimeException("Error occurred");
                    }
                    return "Success";
                })
                .then(result -> System.out.println("Result: " + result))
                .catchException(error -> System.out.println("Caught exception: " + error.getMessage()))
                .execute();
    }
}

