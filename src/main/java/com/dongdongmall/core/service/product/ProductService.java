package com.dongdongmall.core.service.product;

import com.dongdongmall.core.bean.product.Product;
import com.dongdongmall.core.query.product.ProductQuery;
import common.PageModel;

import java.util.List;


/**
 * 
 * @author lixu
 * @Date [2014-3-28 下午01:50:28]
 */
public interface ProductService {
	/**
	 * 基本插入
	 * 
	 * @return
	 */
	Integer addProduct(Product product);

	/**
	 * 根据主键查询
	 */
	Product getProductByKey(Integer id);

	/**
	 * 根据主键批量查询
	 */
	List<Product> getProductsByKeys(List<Integer> idList);

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	Integer deleteByKey(Integer id);

	/**
	 * 根据主键批量删除
	 * 
	 * @return
	 */
	Integer deleteByKeys(List<Integer> idList);

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	Integer updateProductByKey(Product product);

	/**
	 * 根据条件查询分页查询
	 * 
	 * @param productQuery
	 *            查询条件
	 * @return
	 */

	/**
	 * 根据条件查询
	 * 
	 * @param productQuery
	 *            查询条件
	 * @return
	 */
	List<Product> getProductList(ProductQuery productQuery);

	PageModel<Product> getProductListWithPage(ProductQuery productQuery);
	
}
