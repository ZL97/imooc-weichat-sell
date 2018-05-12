package com.example.weichatsell.utils;

import com.example.weichatsell.enums.CodeEnum;

/**
 * @author zhanghao
 * @date 2018/05/02
 */
public class EnumUtil {
    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each : enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
