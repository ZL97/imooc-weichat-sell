package com.example.weichatsell.repository;

import com.example.weichatsell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author zhanghao
 * @date 2018/04/19
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
    /**
     * 查找
     *
     * @param categoryTypeList categoryTypeList
     * @return List<ProductCategory>
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
