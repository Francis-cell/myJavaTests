package com.zmr.MyUtils.SheetOperateUtils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class XlsxUtils {
    private static final XlsxUtils INSTANCE = new XlsxUtils();

    private XlsxUtils() {}

    public static XlsxUtils getInstance() {
        return INSTANCE;
    }

    /**
     * 默认打开的 xlsx 文件的第1个 sheet 表格信息
     */
    private static final int SHEET_INDEX = 0;

    /**
     * <p> 读取一个 xlsx 文件中的内容并输出 </p>
     * @param path 要操作的 xlsx 文件的路径信息 (获取当前的 xlsx 文件的第一个 sheet 页中的相关信息)
     */
    public static Object[][] readXlsxFile(String path) {
        return readXlsxFile(path, SHEET_INDEX);
    }

    /**
     * <p> 读取一个 xlsx 文件中的内容并输出 </p>
     * @param path 要操作的 xlsx 文件的路径信息
     * @param sheetIndex 要被操作的 xlsx 文件中的第几个 sheet 页信息，从 0 开始计数
     */
    public static Object[][] readXlsxFile(String path, int sheetIndex) {
        // 使用 HSSFWorkbook 操作 .xls 文件
        try (Workbook workbookXlsx = new XSSFWorkbook(new FileInputStream(path))) {
            Sheet sheet = workbookXlsx.getSheetAt(sheetIndex);
            // 获取当前的 xlsx 文件中的行数和列数信息
            Map<String, Integer> tmpMap = getXlsxFileRowAndColumnCount(path, sheetIndex);
            return readXlsxCellData(sheet, tmpMap);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <p> 打印一个 xlsx 文件中的内容并输出 </p>
     * @param path 要操作的 xlsx 文件的路径信息 (获取当前的 xlsx 文件的第一个 sheet 页中的相关信息)
     */
    public static void printXlsxFile(String path) {
        readXlsxFile(path, SHEET_INDEX);
    }

    /**
     * <p> 打印一个 xlsx 文件中的内容并输出 </p>
     * @param path 要操作的 xlsx 文件的路径信息
     * @param sheetIndex 要被操作的 xlsx 文件中的第几个 sheet 页信息，从 0 开始计数
     */
    public static void printXlsxFile(String path, int sheetIndex) {
        // 使用 XSSFWorkbook 操作 .xlsx 文件
        try (Workbook workbookXlsx = new XSSFWorkbook(new FileInputStream(path))) {
            Sheet sheet = workbookXlsx.getSheetAt(sheetIndex);
            Map<String, Integer> tmpMap = getXlsxFileRowAndColumnCount(path, sheetIndex);
            printXlsxCellData(sheet, tmpMap);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <p> 获取 xlsx 文件的行数之和和列数计数 </p>
     * @param path 要操作的 xlsx 文件的路径信息 (获取当前的 xls 文件的第一个 sheet 页中的相关信息)
     * @return
     */
    public static Map getXlsxFileRowAndColumnCount(String path) {
        return getXlsxFileRowAndColumnCount(path, SHEET_INDEX);
    }

    /**
     * <p> 获取 xlsx 文件的行数之和和列数计数 </p>
     * @param path 要操作的 xlsx 文件的路径信息
     * @param sheetIndex 要被操作的 xlsx 文件中的第几个 sheet 页信息，从 0 开始计数
     * @return
     */
    public static Map getXlsxFileRowAndColumnCount(String path, int sheetIndex) {
        Map<String, Integer> ansMap = new HashMap<>();
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

            // System.out.println("XSSFWorkbook 行数之和: " + rowCountXlsx);
            // System.out.println("XSSFWorkbook 列数之和: " + columnCountXlsx);

            ansMap.put("row", rowCountXlsx);
            ansMap.put("col", columnCountXlsx);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ansMap;
    }

    /**
     * <p> 将指定的数据 data 写入到一个指定路径下的 xlsxFileName 中 </p>
     * @param path 文件所在的路径
     * @param xlsxFileName 文件名称
     * @param data 要写入到 xlsx 文件中的 data 信息
     */
    public static void writeDataToAXlsxFile(String path, String xlsxFileName, Object[][] data) {
        String excelFilePathXlsx = path + xlsxFileName;

        // 创建 .xls 文件并写入数据
        try (Workbook workbookXlsx = new XSSFWorkbook()) {
            Sheet sheet = workbookXlsx.createSheet("Sheet1");

            // 遍历二维数组并写入数据
            for (int i = 0; i < data.length; i++) {
                Row row = sheet.createRow(i);
                for (int j = 0; j < data[i].length; j++) {
                    Cell cell = row.createCell(j);
                    Object val = data[i][j];
                    if (val instanceof String) {
                        cell.setCellValue((String) val);
                    } else if (val instanceof Integer) {
                        cell.setCellValue((Integer) val);
                    } else if (val instanceof Double) {
                        cell.setCellValue((Double) val);
                    } else if (val instanceof Boolean) {
                        cell.setCellValue((Boolean) val);
                    } else if (val instanceof Date) {
                        cell.setCellValue((Date) val);
                    } else {
                        // 可以根据需要处理其他类型或者未知类型
                        cell.setCellValue(val.toString());
                    }
                }
            }

            // 创建目录（如果不存在）
            File directory = new File(path);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // 将数据写入文件
            try (FileOutputStream fileOutXlsx = new FileOutputStream(excelFilePathXlsx)) {
                workbookXlsx.write(fileOutXlsx);
            }
            System.out.println("写入完成！");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("写入失败：" + e.getMessage());
        }
    }

    /**
     * <p> 打印一个 xlsx 文件中的信息 </p>
     * @param sheet sheet 表格
     * @param tmpMap 当前的 sheet 表格中的行数和列数的映射计数关系
     */
    private static void printXlsxCellData(Sheet sheet, Map<String, Integer> tmpMap) {
        int rowCount = tmpMap.get("row");
        int colCount = tmpMap.get("col");
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                Row row = sheet.getRow(i);
                Cell cell = row.getCell(j);

                // 单元格可能为空
                if (cell != null) {
                    switch (cell.getCellType()) {
                        case STRING:
                            System.out.printf(cell.getStringCellValue() + ", ");
                            break;
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                System.out.printf(cell.getDateCellValue() + ", ");
                            } else {
                                System.out.printf(cell.getNumericCellValue() + ", ");
                            }
                            break;
                        case BOOLEAN:
                            System.out.printf(cell.getBooleanCellValue() + ", ");
                            break;
                        case FORMULA:
                            System.out.printf(cell.getCellFormula() + ", ");
                            break;
                        case BLANK:
                            System.out.printf("⌈空白字符⌋, ");
                            break;
                        case ERROR:
                            System.out.printf(cell.getErrorCellValue() + ", ");
                            break;
                        default:
                            System.out.printf("Unknown type, ");
                            break;
                    }
                }
            }
            System.out.println();
        }
    }

    /**
     * <p> 读取一个 xlsx 文件中的信息 </p>
     * @param sheet sheet 表格
     * @param tmpMap 当前的 sheet 表格中的行数和列数的映射计数关系
     */
    private static Object[][] readXlsxCellData(Sheet sheet, Map<String, Integer> tmpMap) {
        int rowCount = tmpMap.get("row");
        int colCount = tmpMap.get("col");
        Object[][] ans = new Object[rowCount][colCount];

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                Row row = sheet.getRow(i);
                Cell cell = row.getCell(j);
                // 单元格可能为空
                if (cell != null) {
                    switch (cell.getCellType()) {
                        case STRING:
                            ans[i][j] = cell.getStringCellValue();
                            break;
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                ans[i][j] = cell.getDateCellValue();
                            } else {
                                ans[i][j] = cell.getNumericCellValue();
                            }
                            break;
                        case BOOLEAN:
                            ans[i][j] = cell.getBooleanCellValue();
                            break;
                        case FORMULA:
                            ans[i][j] = cell.getCellFormula();
                            break;
                        case BLANK:
                            ans[i][j] = "";
                            break;
                        case ERROR:
                            ans[i][j] = Byte.toString(cell.getErrorCellValue());
                            break;
                        default:
                            ans[i][j] = "Unknown type";
                            break;
                    }
                }
            }
        }

        return ans;
    }
}
