package com.zmr.LearningFiles.EffectiveJavaDemos.CustomAnnotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunExceptionTests {
    public static void main(String[] args) throws Exception {
        int tests = 0;
        int passed = 0;
        String className = AnnotationTest.class.getName();
        Class<?> testClass = Class.forName(className);
        // Class<?> testClass = Class.forName(args[0]);
        // 获取发布的相关方法
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(ExceptionTest.class)) {
                tests++;
                try {
                    m.invoke(null);
                    System.out.printf("Test %s failed: no exception%n", m);
                } catch (InvocationTargetException wrappedExc) {
                    Throwable exc = wrappedExc.getCause();
                    // 获取到将要捕获的异常类型
                    Class<? extends Throwable> excType =
                            m.getAnnotation(ExceptionTest.class).value();
                    // 如果异常的类型属于注解中指定的异常类型，则给 passed 增加，否则打印错误
                    if (excType.isInstance(exc)) {
                        passed++;
                    } else {
                        System.out.printf(
                                "Test %s failed: expected %s, got %s%n",
                                m, excType.getName(), exc
                        );
                    }
                } catch (Exception exc) {
                    System.out.println("Invalid @Test: " + m);
                }
            }
        }
        System.out.printf("Passed: %d, Failed: %d%n",
                passed, tests - passed);
    }
}
