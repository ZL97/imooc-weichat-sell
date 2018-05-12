package com.example.weichatsell.service;

import com.example.weichatsell.dataobject.SellerInfo;

/**
 * @author zhanghao
 * @date 2018/05/06
 */
public interface SellerService {

    /**
     * 通过openid查询买家信息
     *
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);
}
