package com.example.weichatsell.controller;

import com.example.weichatsell.dto.OrderDTO;
import com.example.weichatsell.enums.ResultEnum;
import com.example.weichatsell.exception.SellException;
import com.example.weichatsell.service.OrderService;
import com.example.weichatsell.service.PayService;
import com.lly835.bestpay.model.PayResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author zhanghao
 * @date 2018/04/27
 */
@Controller
@Slf4j
public class PayController {

    private OrderService orderService;
    private PayService payService;

    @Autowired
    public PayController(OrderService orderService, PayService payService) {
        this.orderService = orderService;
        this.payService = payService;
    }


    @GetMapping("/create")
    public ModelAndView create(@RequestParam("orderId") String orderId,
                               @RequestParam("returnUrl") String returnUrl,
                               ModelMap modelMap) {
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null) {
            throw new SellException(ResultEnum.ORDER_NOT_EXISTS);
        }
        PayResponse payResponse = payService.create(orderDTO);
        modelMap.put("payResponse", payResponse);
        modelMap.put("returnUrl", returnUrl);
        return new ModelAndView("pay/create", modelMap);
    }


    @PostMapping("notify")
    public ModelAndView notify(@RequestBody String notifyData) {
        payService.notify(notifyData);
        //返回给微信处理结果
        return new ModelAndView("pay/success");
    }

}
