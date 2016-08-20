package com.dongdongmall.core.service;

import com.dongdongmall.core.bean.Brand;
import com.dongdongmall.core.bean.BrandQuery;
import common.PageModel;

import java.util.List;

/**
 * 品牌Service接口
 */
public interface BrandService {
    PageModel<Brand> getAll();

    PageModel<Brand> getWithPage(BrandQuery pageModel);

    void addBrand(Brand brand);

    void removeBrand(int id);
}
