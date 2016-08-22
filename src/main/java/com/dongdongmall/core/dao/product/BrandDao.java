package com.dongdongmall.core.dao.product;

import com.dongdongmall.core.bean.product.Brand;
import com.dongdongmall.core.query.product.BrandQuery;
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

	void removeList(int[] ids);

}
