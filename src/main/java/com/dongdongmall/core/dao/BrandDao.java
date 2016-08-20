package com.dongdongmall.core.dao;

import com.dongdongmall.core.bean.Brand;
import com.dongdongmall.core.bean.BrandQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 品牌Dao接口
 */
@Repository
public interface BrandDao {

    List<Brand> getAll();

    int getCountAll(BrandQuery brandQuery);

    List<Brand> getWithPage(BrandQuery brandQuery);

    void add(Brand brand);

    void remove(int id);

}
