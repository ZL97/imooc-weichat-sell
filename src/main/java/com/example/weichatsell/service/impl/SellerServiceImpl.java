package com.example.weichatsell.service.impl;

import com.example.weichatsell.dataobject.SellerInfo;
import com.example.weichatsell.repository.SellerInfoRepository;
import com.example.weichatsell.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhanghao
 * @date 2018/05/06
 */
@Service
public class SellerServiceImpl implements SellerService {


    private SellerInfoRepository repository;

    @Autowired
    public SellerServiceImpl(SellerInfoRepository repository) {
        this.repository = repository;
    }

    /**
     * 通过openid查询买家信息
     *
     * @param openid openid
     * @return SellerInfo
     */
    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return repository.findByOpenid(openid);
    }
}
