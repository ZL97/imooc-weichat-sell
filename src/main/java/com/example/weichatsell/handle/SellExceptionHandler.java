package com.example.weichatsell.handle;

import com.example.weichatsell.config.ProjectUrlConfig;
import com.example.weichatsell.exception.SellAuthorizeException;
import com.example.weichatsell.exception.SellException;
import com.example.weichatsell.utils.ResultVOUtils;
import com.example.weichatsell.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author zhanghao
 * @date 2018/05/06
 */
@ControllerAdvice
public class SellExceptionHandler {

    private ProjectUrlConfig projectUrlConfig;

    @Autowired
    public SellExceptionHandler(ProjectUrlConfig projectUrlConfig) {
        this.projectUrlConfig = projectUrlConfig;
    }

    /**
     * 拦截登录异常
     */
    @ExceptionHandler(value = SellAuthorizeException.class)
    public ModelAndView handleSellAuthorizeException() {
        String stringBuilder = "redirect:" + projectUrlConfig.getSell() +
                "/seller/order/list";
        return new ModelAndView(stringBuilder);
    }


    /**
     * 拦截sellException异常
     *
     * @param e e
     * @return ResultVO
     */

    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS)
    public ResultVO handlerSellException(SellException e) {
        return ResultVOUtils.error(e.getCode(), e.getMessage());
    }
}
