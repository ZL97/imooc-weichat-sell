package com.example.weichatsell.utils;

/**
 * @author zhanghao
 * @date 2018/04/28
 */
public class MathUtil {


    private static final Double MONEY_RANGE = 0.01;

    /**
     * 比较两个金额是否相等
     */
    public static Boolean equals(Double d1, Double d2) {
        return Math.abs(d1 - d2) < MONEY_RANGE;
    }
}
