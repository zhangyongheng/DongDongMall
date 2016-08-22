package com.dongdongmall.core.dao.product;

import com.dongdongmall.core.bean.product.Product;
import com.dongdongmall.core.query.product.ProductQuery;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductDao {

	/**
	 * 添加
	 * @param product
	 */
	Integer addProduct(Product product);

	/**
	 * 根据主键查找
	 */
	Product getProductByKey(Integer id);

	/**
	 * 根据主键批量查找
	 */
	List<Product> getProductsByKeys(List<Integer> idList);

	/**
	 * 根据主键删除
	 */
	Integer deleteByKey(Integer id);

	/**
	 * 根据主键批量删除
	 */
	Integer deleteByKeys(List<Integer> idList);

	/**
	 * 根据主键更新
	 */
	Integer updateProductByKey(Product product);

	/**
	 * 分页查询
	 * @param productQuery
	 */
	List<Product> getProductListWithPage(ProductQuery productQuery);

	/**
	 * 集合查询
	 * @param productQuery
	 */
	List<Product> getProductList(ProductQuery productQuery);
	
	/**
	 * 总条数
	 * @param productQuery
	 */
	int getProductListCount(ProductQuery productQuery);

}
