package com.dongdongmall.core.service.product;

import com.dongdongmall.core.bean.product.Brand;
import com.dongdongmall.core.query.product.BrandQuery;
import common.PageModel;

import java.util.List;

/**
 * 品牌Service接口
 */
public interface BrandService {
    List<Brand> getAll();

    PageModel<Brand> getWithPage(BrandQuery pageModel);

    void addBrand(Brand brand);

    void removeBrand(int id);

    void removeBrands(int[] ids);

}
