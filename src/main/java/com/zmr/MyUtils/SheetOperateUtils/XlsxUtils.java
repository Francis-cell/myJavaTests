package com.zmr.MyUtils.SheetOperateUtils;

import java.util.Map;

public interface XlsxUtils {
    /**
     * <p> 读取一个 xlsx 文件中的内容并输出 </p>
     * @param path 要操作的 xlsx 文件的路径信息 (获取当前的 xlsx 文件的第一个 sheet 页中的相关信息)
     */
    Object[][] readXlsxFile(String path);

    /**
     * <p> 读取一个 xlsx 文件中的内容并输出 </p>
     * @param path 要操作的 xlsx 文件的路径信息
     * @param sheetIndex 要被操作的 xlsx 文件中的第几个 sheet 页信息，从 0 开始计数
     */
    Object[][] readXlsxFile(String path, int sheetIndex);

    /**
     * <p> 打印一个 xlsx 文件中的内容并输出 </p>
     * @param path 要操作的 xlsx 文件的路径信息 (获取当前的 xlsx 文件的第一个 sheet 页中的相关信息)
     */
    void printXlsxFile(String path);

    /**
     * <p> 打印一个 xlsx 文件中的内容并输出 </p>
     * @param path 要操作的 xlsx 文件的路径信息
     * @param sheetIndex 要被操作的 xlsx 文件中的第几个 sheet 页信息，从 0 开始计数
     */
    void printXlsxFile(String path, int sheetIndex);

    /**
     * <p> 获取 xlsx 文件的行数之和和列数计数 </p>
     * @param path 要操作的 xlsx 文件的路径信息 (获取当前的 xls 文件的第一个 sheet 页中的相关信息)
     * @return
     */
    Map getXlsxFileRowAndColumnCount(String path);

    /**
     * <p> 获取 xlsx 文件的行数之和和列数计数 </p>
     * @param path 要操作的 xlsx 文件的路径信息
     * @param sheetIndex 要被操作的 xlsx 文件中的第几个 sheet 页信息，从 0 开始计数
     * @return
     */
    Map getXlsxFileRowAndColumnCount(String path, int sheetIndex);

    /**
     * <p> 将指定的数据 data 写入到一个指定路径下的 xlsxFileName 中 </p>
     * @param path 文件所在的路径
     * @param xlsxFileName 文件名称
     * @param data 要写入到 xlsx 文件中的 data 信息
     */
    void writeDataToAXlsxFile(String path, String xlsxFileName, Object[][] data);
}
