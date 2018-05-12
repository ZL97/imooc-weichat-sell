package com.example.weichatsell.service;

import com.example.weichatsell.dto.OrderDTO;

/**
 * 推送消息
 *
 * @author zhanghao
 * @date 2018/05/07
 */
public interface PushMessage {
    /**
     * 订单状态变更
     *
     * @param orderDTO orderDTO
     */
    void status(OrderDTO orderDTO);
}
