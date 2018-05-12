package com.example.weichatsell.controller;

import com.example.weichatsell.dataobject.ProductCategory;
import com.example.weichatsell.dataobject.ProductInfo;
import com.example.weichatsell.service.CategoryService;
import com.example.weichatsell.service.ProductService;
import com.example.weichatsell.utils.ResultVOUtils;
import com.example.weichatsell.vo.ProductInfoVO;
import com.example.weichatsell.vo.ProductVO;
import com.example.weichatsell.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhanghao
 * @date 2018/04/20
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    private ProductService productService;
    private CategoryService categoryService;

    @Autowired
    public BuyerProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/list")
    @Cacheable(value = "product", key = "123")
    public ResultVO list() {
        //1.查询所有上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        //2.查询类目(一次性查询)
        List<Integer> categoryTypeList = productInfoList.stream().map(ProductInfo::getCategoryType).collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
        //3.数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        productCategoryList.forEach(category -> {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(category.getCategoryType());
            productVO.setCategoryName(category.getCategoryName());
            ArrayList<ProductInfoVO> productInfoVOList = new ArrayList<>();
            productInfoList.forEach(productInfo ->
                    {
                        if (productInfo.getCategoryType().equals(category.getCategoryType())) {
                            ProductInfoVO productInfoVO = new ProductInfoVO();
                            BeanUtils.copyProperties(productInfo, productInfoVO);
                            productInfoVOList.add(productInfoVO);
                        }
                    }
            );
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        });
        return ResultVOUtils.success(productVOList);
    }

}

