package com.zmr.LearningFiles.OwnTests.MyJavaTests.javaTests;

import com.zmr.MyUtils.PrintUtils.impl.PrintUtilsImpl;
import com.zmr.MyUtils.SheetOperateUtils.impl.XlsUtilsImpl;
import com.zmr.MyUtils.SheetOperateUtils.impl.XlsxUtilsImpl;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MyTest26 {
    public static void main(String[] args) {
        // List<Map<String, String>> maps = new ArrayList<>();
        // HashMap<String, String> map1 = new HashMap<>();
        // map1.put("ID", "1");
        // map1.put("V", "V1");
        // HashMap<String, String> map2 = new HashMap<>();
        // map2.put("ID", "2");
        // map2.put("V", "V2");
        // HashMap<String, String> map3 = new HashMap<>();
        // map3.put("ID", "3");
        // map3.put("V", "V3");
        //
        // maps.add(map1);
        // maps.add(map2);
        // maps.add(map3);
        //
        // List<String> ids = maps.stream().map(item -> item.get("ID")).collect(Collectors.toList());
        // PrintUtilsImpl.getInstance().printList(ids);
        String newString = "111".replaceAll(".$", "2");
        System.out.println(newString);
    }
}
