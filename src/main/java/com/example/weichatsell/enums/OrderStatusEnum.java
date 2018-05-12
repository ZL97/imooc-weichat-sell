package com.example.weichatsell.enums;

import lombok.Getter;

/**
 * @author zhanghao
 * @date 2018/04/21
 */
@Getter
public enum OrderStatusEnum implements CodeEnum {

    /**
     * 新订单
     */
    NEW(0, "新订单"),
    /**
     * 完结
     */
    FINISH(1, "完结"),

    /**
     * 取消
     */
    CANCEL(2, "已取消");

    private Integer code;
    private String msg;

    OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
