package com.zmr.LearningFiles.OwnTests.MyJavaTests.javaTests;

import com.zmr.MyUtils.PrintUtils.PrintUtils;
import com.zmr.MyUtils.SheetOperateUtils.XlsUtils;
import com.zmr.MyUtils.SheetOperateUtils.XlsxUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MyTest25 {
    /**
     * <p> 操作 xls 文件 </p>
     * @param path xls 文件对应的地址路径信息
     */
    public static void operateXlsFiles(String path) {
        // 使用 HSSFWorkbook 操作 .xls 文件
        try (Workbook workbookXls = new HSSFWorkbook(new FileInputStream(path))) {
            Sheet sheet = workbookXls.getSheetAt(0);
            Row row = sheet.getRow(0);
            Cell cell = row.getCell(0);
            System.out.println(cell.getStringCellValue());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <p> 获取 XSSFWorkbook 的行数之和和列数之和 </p>
     * @param path 要操作的 xlsx 文件的路径信息
     * @param sheetIndex 要操作的 xlsx 文件的第几个 sheet 页 (从 0 开始)
     */
    public static void getXlsFileRowAndColumnCount(String path, int sheetIndex) {
        // 获取 HSSFWorkbook 的行数之和和列数之和
        try (Workbook workbookXls = new HSSFWorkbook(new FileInputStream(path))) {
            // 指定的 sheet 页
            Sheet sheetXls = workbookXls.getSheetAt(sheetIndex);
            // 行数
            int rowCountXls = sheetXls.getLastRowNum() + 1;
            // 列数
            int columnCountXls = 0;

            for (Row row : sheetXls) {
                int lastCellNum = row.getLastCellNum();
                if (lastCellNum > columnCountXls) {
                    columnCountXls = lastCellNum;
                }
            }

            System.out.println("HSSFWorkbook 行数之和: " + rowCountXls);
            System.out.println("HSSFWorkbook 列数之和: " + columnCountXls);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * <p> 操作 xlsx 文件 </p>
     * @param path xlsx 文件对应的地址路径信息
     */
    public static void operateXlsxFiles(String path) {
        // 使用 XSSFWorkbook 操作 .xlsx 文件
        try (Workbook workbookXlsx = new XSSFWorkbook(new FileInputStream(path))) {
            Sheet sheet = workbookXlsx.getSheetAt(0);
            Row row = sheet.getRow(0);
            Cell cell = row.getCell(0);
            System.out.println(cell.getStringCellValue());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <p> 获取 XSSFWorkbook 的行数之和和列数之和 </p>
     * @param path 要操作的 xlsx 文件的路径信息
     * @param sheetIndex 要操作的 xlsx 文件的第几个 sheet 页 (从 0 开始)
     */
    public static void getXlsxFileRowAndColumnCount(String path, int sheetIndex) {
        try (Workbook workbookXlsx = new XSSFWorkbook(new FileInputStream(path))) {
            // 指定的 sheet 页
            Sheet sheetXlsx = workbookXlsx.getSheetAt(sheetIndex);
            // 行数
            int rowCountXlsx = sheetXlsx.getLastRowNum() + 1;
            // 列数
            int columnCountXlsx = 0;

            for (Row row : sheetXlsx) {
                int lastCellNum = row.getLastCellNum();
                if (lastCellNum > columnCountXlsx) {
                    columnCountXlsx = lastCellNum;
                }
            }

            System.out.println("XSSFWorkbook 行数之和: " + rowCountXlsx);
            System.out.println("XSSFWorkbook 列数之和: " + columnCountXlsx);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String basePath = "D:\\myOwnFiles\\myJavaTests\\src\\main\\java\\com\\zmr\\LearningFiles\\staticSources";
        String xlsPath = basePath + "\\xls\\a.xls";
        String writeXlsPath = "\\xls\\a1.xls";
        String xlsxPath = basePath + "\\xlsx\\b.xlsx";
        String writeXlsxPath = "\\xlsx\\b1.xlsx";
        // operateXlsFiles(xlsPath);
        // operateXlsxFiles(xlsxPath);
        // getXlsFileRowAndColumnCount(xlsPath, 0);
        // getXlsxFileRowAndColumnCount(xlsxPath, 0);

        Object[][] valsXls = XlsUtils.readXlsFile(xlsPath);
        PrintUtils.printArr(valsXls);

        Object[][] valsXlsx = XlsxUtils.readXlsxFile(xlsxPath);
        PrintUtils.printArr(valsXlsx);

        Object[][] vals = {
                {"姓名", "年龄", "性别"}, // 第一行是标题
                {"张三", 25, "男"},
                {"李四", 30, "女"},
                {"王五", 28, "男"}
        };

        XlsUtils.writeDataToAXlsFile(basePath, writeXlsPath, vals);
        XlsUtils.writeDataToAXlsFile(basePath, writeXlsxPath, vals);
    }
}
