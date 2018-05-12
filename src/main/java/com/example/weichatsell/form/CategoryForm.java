package com.example.weichatsell.form;

import lombok.Data;

/**
 * @author zhanghao
 * @date 2018/05/05
 */
@Data
public class CategoryForm {
    private Integer categoryId;
    /**
     * 类目名字
     */
    private String categoryName;
    /**
     * 类目编号
     */
    private Integer categoryType;
}
