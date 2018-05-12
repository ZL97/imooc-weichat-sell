package com.example.weichatsell.service.impl;

import com.example.weichatsell.dto.OrderDTO;
import com.example.weichatsell.service.PushMessage;
import org.springframework.stereotype.Service;

/**
 * @author zhanghao
 * @date 2018/05/07
 */
@Service
public class PushMessageImpl implements PushMessage {


    /**
     * 订单状态变更
     *
     * @param orderDTO orderDTO
     */
    @Override
    public void status(OrderDTO orderDTO) {

    }
}
