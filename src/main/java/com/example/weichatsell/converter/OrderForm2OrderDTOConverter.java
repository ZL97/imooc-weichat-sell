package com.example.weichatsell.converter;

import com.example.weichatsell.dataobject.OrderDetail;
import com.example.weichatsell.dto.OrderDTO;
import com.example.weichatsell.enums.ResultEnum;
import com.example.weichatsell.exception.SellException;
import com.example.weichatsell.form.OrderForm;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanghao
 * @date 2018/04/24
 */
@Slf4j
public class OrderForm2OrderDTOConverter {

    public static OrderDTO covert(OrderForm orderForm) {

        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>() {
            }.getType());
        } catch (JsonSyntaxException e) {
            log.error("[对象转换]错误,json={}", orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }


}
