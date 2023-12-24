package com.zmr.LearningFiles.EffectiveJavaDemos.CustomAnnotation;

import java.lang.reflect.Method;

public class ExceptionDemoTests {
    public static void main(String[] args) throws Exception {
        int tests = 0;
        int passed = 0;
        String className = ExceptionDemoTest.class.getName();
        Class<?> testClass = Class.forName(className);
        // Class<?> testClass = Class.forName(args[0]);
        // 获取发布的相关方法
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(ExceptionDemo.class)
                    || m.isAnnotationPresent(ExceptionDemoContainer.class)) {
                tests++;
                try {
                    m.invoke(null);
                    System.out.printf("Test %s failed: no exception%n", m);
                } catch (Throwable wrappedExc) {
                    Throwable exc = wrappedExc.getCause();
                    int oldPassed = passed;
                    ExceptionDemo[] excDemos =
                            m.getAnnotationsByType(ExceptionDemo.class);

                    for (ExceptionDemo excDemo : excDemos) {
                        if (excDemo.value().isInstance(exc)) {
                            passed++;
                            break;
                        }
                    }

                    if (passed == oldPassed) {
                        System.out.printf("Test %s failed: %s %n", m, exc);
                    }
                }
            }
        }
        System.out.printf("Passed: %d, Failed: %d%n",
                passed, tests - passed);
    }
}
