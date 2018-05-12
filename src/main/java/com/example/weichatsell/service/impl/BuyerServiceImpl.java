package com.example.weichatsell.service.impl;

import com.example.weichatsell.dto.OrderDTO;
import com.example.weichatsell.enums.ResultEnum;
import com.example.weichatsell.exception.SellException;
import com.example.weichatsell.service.BuyerService;
import com.example.weichatsell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhanghao
 * @date 2018/04/24
 */
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {
    private OrderService orderService;

    @Autowired
    public BuyerServiceImpl(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {
        return checkOrderOwner(openid, orderId);
    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {
        OrderDTO orderDTO = checkOrderOwner(openid, orderId);
        if (orderDTO == null) {
            log.error("[取消订单]查不到该订单，orderId={}", orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXISTS);
        }
        return orderService.cancel(orderDTO);
    }

    /**
     * 检查订单的所有者
     */
    private OrderDTO checkOrderOwner(String openid, String orderId) {
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null) {
            return null;
        }
        String buyerOpenid = orderDTO.getBuyerOpenid();
        //判断是否是自己的订单
        if (!buyerOpenid.equalsIgnoreCase(openid)) {
            log.error("[查询订单] 订单的openid不一致.");
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }
}
