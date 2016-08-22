package com.dongdongmall.core.service.product;

import java.util.List;

import javax.annotation.Resource;

import com.dongdongmall.core.bean.product.Product;
import com.dongdongmall.core.dao.product.ProductDao;
import com.dongdongmall.core.query.product.ProductQuery;
import common.PageModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 商品事务层
 * @author lixu
 * @Date [2014-3-27 下午03:31:57]
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Resource
	private ProductDao productDao;
	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addProduct(Product product) {
		return productDao.addProduct(product);
	}

	/**
	 * 根据主键查找
	 */
	@Transactional(readOnly = true)
	public Product getProductByKey(Integer id) {
		return productDao.getProductByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<Product> getProductsByKeys(List<Integer> idList) {
		return productDao.getProductsByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return productDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return productDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateProductByKey(Product product) {
		return productDao.updateProductByKey(product);
	}
	

	@Transactional(readOnly = true)
	public List<Product> getProductList(ProductQuery productQuery) {
		return productDao.getProductList(productQuery);
	}

	public PageModel<Product> getProductListWithPage(ProductQuery productQuery) {
		List<Product> productList = productDao.getProductListWithPage(productQuery);
		int count = productDao.getProductListCount(productQuery);
		PageModel<Product> pageModel = new PageModel<Product>();
		pageModel.setList(productList);
		pageModel.setTotalRecords(count);
		pageModel.setPageNo(productQuery.getPageNo());
		pageModel.setPageSize(productQuery.getPageSize());

		return pageModel;
	}
}
