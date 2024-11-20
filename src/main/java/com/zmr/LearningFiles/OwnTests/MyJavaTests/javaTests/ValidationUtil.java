package com.zmr.LearningFiles.OwnTests.MyJavaTests.javaTests;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ValidationUtil {

    // 抽象方法，用于执行检查和特殊行为
    public static ValidationResult validate(String value, List<Predicate<String>> checks, boolean requireAll,
                                            Consumer<String> specialAction, String errorMessage) {
        boolean checkFlag = requireAll;

        // 遍历所有检查项
        for (Predicate<String> check : checks) {
            if (requireAll) {
                // 需要全部成立
                if (!check.test(value)) {
                    checkFlag = false;
                    break;
                }
            } else {
                // 只需部分成立
                if (check.test(value)) {
                    checkFlag = true;
                    break;
                }
            }
        }

        List<String> errorMessages = new ArrayList<>();
        // 如果检查标志为 false，则添加报错信息
        if (!checkFlag) {
            errorMessages.add(errorMessage);
        } else {
            // 如果检查标志为 true，执行特殊行为
            specialAction.accept(value);
        }

        return new ValidationResult(checkFlag, errorMessages);
    }

    public static void main(String[] args) {
        String value = "123";

        // 定义检查逻辑
        List<Predicate<String>> checks = new ArrayList<>();
        checks.add(ValidationUtil::checkA);
        checks.add(ValidationUtil::checkB);

        // 定义特殊行为
        Consumer<String> specialAction = ValidationUtil::specialBehavior;

        // 执行检查和特殊行为 (部分成立)
        ValidationResult resultPartial = validate(value, checks, false, specialAction, "检查不通过");
        System.out.println("部分成立 - 检查标志: " + resultPartial.isCheckFlag());
        if (!resultPartial.isCheckFlag()) {
            resultPartial.getErrorMessages().forEach(System.out::println);
        }

        // 执行检查和特殊行为 (全部成立)
        ValidationResult resultAll = validate(value, checks, true, specialAction, "检查不通过");
        System.out.println("全部成立 - 检查标志: " + resultAll.isCheckFlag());
        if (!resultAll.isCheckFlag()) {
            resultAll.getErrorMessages().forEach(System.out::println);
        }
    }

    // 示例检查方法
    private static boolean checkA(String value) {
        return value.matches("\\d+"); // 检查是否为数字
    }

    // 示例检查方法
    private static boolean checkB(String value) {
        return value.length() > 2; // 检查长度是否大于2
    }

    // 示例特殊行为方法
    private static void specialBehavior(String value) {
        System.out.println("执行特殊行为，值为: " + value);
    }
}

// 用于存储检查结果的类
class ValidationResult {
    private final boolean checkFlag;
    private final List<String> errorMessages;

    public ValidationResult(boolean checkFlag, List<String> errorMessages) {
        this.checkFlag = checkFlag;
        this.errorMessages = errorMessages;
    }

    public boolean isCheckFlag() {
        return checkFlag;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }
}


