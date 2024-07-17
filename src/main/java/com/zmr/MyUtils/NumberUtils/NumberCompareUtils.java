package com.zmr.MyUtils.NumberUtils;

public interface NumberCompareUtils {
    /**
     * <p> 检查两个数据是否偏差值在某个范围内 </p>
     * @param num1 参与比较的数据01 默认基准数
     * @param num2 参与比较的数据02
     * @param percent 百分比(当想要偏差值在 5% 内判断时，输入 5 即可，不支持浮点数，范围为 1 <= percent <= 100)
     * @return
     */
    boolean checkSomePercentBetweenTwoNum(String num1, String num2, int percent);
}
