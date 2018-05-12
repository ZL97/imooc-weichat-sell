package com.example.weichatsell.converter;

import com.example.weichatsell.dataobject.OrderMaster;
import com.example.weichatsell.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhanghao
 * @date 2018/04/23
 */
public class OrderMaster2OrderDTOConverter {

    public static OrderDTO covert(OrderMaster orderMaster) {
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList) {
        return orderMasterList.stream().map(OrderMaster2OrderDTOConverter::covert).collect(Collectors.toList());
    }
}
