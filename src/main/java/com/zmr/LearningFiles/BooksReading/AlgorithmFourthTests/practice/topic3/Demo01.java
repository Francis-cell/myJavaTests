package com.zmr.LearningFiles.BooksReading.AlgorithmFourthTests.practice.topic3;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>题目描述：</p>
 * <p>编写一段程序，创建一张符号表并建立字母成绩和数值分数的对应关系，如下表所示。从标准输
 * 入读取一系列字母成绩，计算并打印 GPA（字母成绩对应的分数的平均值）。</p>
 * <p>A+ A A- B+ B B- C+ C C- D F</p>
 * <p>4.33 4.00 3.67 3.33 3.00 2.67 2.33 2.00 1.67 1.00 0.00</p>
 */
public class Demo01 {
    @Data
    @AllArgsConstructor
    class HelpClass {
        /** 当前成绩段的数量计数信息 */
        private int count;
        /** 当前分数段的总成绩信息 */
        private double sumGrade;
    }

    /**
     * 根据传入的成绩，返回对应的成绩级别信息
     * @param gradeMap 成绩级别和对应的成绩下限分数线
     * @param grade 成绩信息
     * @return 返回对应的成绩对应的成绩分段信息
     */
    private static String getGradeLevelWithMap(Map<String, Double> gradeMap, Double grade) {
        // 成绩等级和对应的分数线（>=）
        // 分数 map 映射关系 （在这里使用 LinkedHashMap，用于保证插入 map 中 key 的顺序是自己操作的顺序）
        gradeMap = new LinkedHashMap<>();
        gradeMap.put("A+", 4.33);
        gradeMap.put("A", 4.00);
        gradeMap.put("A-", 3.67);
        gradeMap.put("B+", 3.33);
        gradeMap.put("B", 3.00);
        gradeMap.put("B-", 2.67);
        gradeMap.put("C+", 2.33);
        gradeMap.put("C", 2.00);
        gradeMap.put("C-", 1.67);
        gradeMap.put("D", 1.00);
        gradeMap.put("F", 0.00);

        for(Map.Entry<String, Double> entry : gradeMap.entrySet()) {
            String key = entry.getKey();
            Double val = entry.getValue();
            if (grade >= val) {
                return key;
            }
        }
        return "";
    }

    /**
     * 根据传入的成绩，返回对应的成绩级别信息
     * @param gradeLevelArr 成绩水平
     * @param gradeLineArr 成绩线
     * @param grade 成绩
     * @return
     */
    private static String getGradeLevelWithArr(String[] gradeLevelArr, Double[] gradeLineArr, Double grade) {
        // 存储下标
        int index = -1;
        for (int i = 0; i < gradeLineArr.length; i++) {
            if (grade >= gradeLineArr[i]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            // throw new BusinessException("下标不对");
        }
        // 返回对应的分数段信息
        return gradeLevelArr[index];
    }

    /**
     * 根据传入的成绩，返回对应的成绩级别信息-下标
     * @param gradeLevelArr 成绩水平
     * @param gradeLineArr 成绩线
     * @param grade 成绩
     * @return
     */
    private static Integer getGradeIndexWithArr(String[] gradeLevelArr, Double[] gradeLineArr, Double grade) throws Exception {
        // 存储下标
        int index = -1;
        for (int i = 0; i < gradeLineArr.length; i++) {
            if (grade >= gradeLineArr[i]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            // throw new BusinessException("下标不对");
            throw new Exception("error");
        }
        // 返回对应的分数段信息
        return index;
    }

    /**
     * 数组打印
     * @param arr
     */
    private static void printArr(Double[] arr) {
        for (Double d : arr) {
            System.out.printf(d + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        // 创建两个数组，分别用来存储和分数节点
        // 成绩水平
        String[] gradeLevelArr = new String[] {"A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D", "F"};
        // 成绩线
        Double[] gradeLineArr = new Double[] {4.33, 4.00, 3.67, 3.33, 3.00, 2.67, 2.33, 2.00, 1.67, 1.00, 0.00};

        // Test Demo
        // Double grade = 3.66;
        // String ans = getGradeLevelWithArr(gradeLevelArr, gradeLineArr, grade);
        // System.out.println(ans);

        Double[] gradeSumArr = new Double[gradeLevelArr.length];
        Double[] gradeAverageArr = new Double[gradeLevelArr.length];

        // 先模拟一波数据
        Double[] testData = new Double[] {4.56, 4.6, 3.7, 3.4, 2.4, 2.5, 4.1, 2.0, 0.0, 1.9, 1.8, 2.33, 3.66};
        for (Double grade : testData) {
            Integer index = getGradeIndexWithArr(gradeLevelArr, gradeLineArr, grade);
            gradeSumArr[index] = (gradeSumArr[index] == null ? 0 : gradeSumArr[index]) + grade;
        }

        // while (!StdIn.isEmpty()) {
        //     Double grade = StdIn.readDouble();
        //     Integer index = getGradeIndexWithArr(gradeLevelArr, gradeLineArr, grade);
        //     gradeSumArr[index] += grade;
        // }

        for (int i = 0; i < gradeAverageArr.length; i++) {
            gradeAverageArr[i] = gradeSumArr[i] == null ? 0 : gradeSumArr[i] / gradeAverageArr.length;
        }

        printArr(gradeAverageArr);
    }
}
