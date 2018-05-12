package com.example.weichatsell.repository;

import com.example.weichatsell.dataobject.SellerInfo;
import com.example.weichatsell.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhanghao
 * @date 2018/05/06
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SellerInfoRepositoryTest {

    @Autowired
    private SellerInfoRepository repository;


    @Test
    public void save() {
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setSellerId(KeyUtil.genUniqueKey());
        sellerInfo.setUsername("admin");
        sellerInfo.setPassword("admin");
        sellerInfo.setOpenid("abc");
        SellerInfo save = repository.save(sellerInfo);
        Assert.assertNotNull(save);

    }

    @Test
    public void findByOpenid() {
        SellerInfo abc = repository.findByOpenid("abc");
        Assert.assertEquals(abc.getOpenid(), "abc");
    }
}