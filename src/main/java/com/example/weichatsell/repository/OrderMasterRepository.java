package com.example.weichatsell.repository;

import com.example.weichatsell.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhanghao
 * @date 2018/04/21
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {

    /**
     * 通过买家的OpenId进行查询
     *
     * @param buyerOpenId buyerOpenId
     * @param pageable    pageable
     * @return Page<OrderMaster>
     */
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenId, Pageable pageable);
}
