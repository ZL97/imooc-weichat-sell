package com.example.weichatsell.service;

import com.example.weichatsell.dto.OrderDTO;

/**
 * @author zhanghao
 * @date 2018/04/24
 */
public interface BuyerService {
    /**
     * 查询一个订单
     *
     * @return OrderDTO
     */
    OrderDTO findOrderOne(String openid, String orderId);

    /**
     * 取消订单
     */

    OrderDTO cancelOrder(String openid, String orderId);

}
