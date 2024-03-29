package com.zmr.LearningFiles.EasyExcelAbout.Demos;

import com.alibaba.excel.EasyExcel;
import com.zmr.LearningFiles.EasyExcelAbout.entity.FoodInfo;

import java.io.File;
import java.util.List;

public class CommonEasyExcelDemo {
    public static List<FoodInfo> excelDataToListOfObjets_withEasyExcel(String fileLocation){
        return EasyExcel.read(new File(fileLocation)).head(FoodInfo.class).sheet().doReadSync();
    }

    public static void printList(List<FoodInfo> lists) {
        for (FoodInfo e : lists) {
            System.out.printf(e.toString() + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String path = "D:/myOwnFiles/myJavaTests/src/main/java/com/zmr/LearningFiles/EasyExcelAbout/excel/b.xlsx";
        List<FoodInfo> foodInfos = excelDataToListOfObjets_withEasyExcel(path);
        printList(foodInfos);
    }
}
