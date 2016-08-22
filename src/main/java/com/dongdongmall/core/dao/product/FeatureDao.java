package com.dongdongmall.core.dao.product;

import com.dongdongmall.core.bean.product.Feature;
import com.dongdongmall.core.query.product.FeatureQuery;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FeatureDao {

	/**
	 * 添加
	 * @param feature
	 */
	public Integer addFeature(Feature feature);

	/**
	 * 根据主键查找
	 */
	public Feature getFeatureByKey(Integer id);

	/**
	 * 根据主键批量查找
	 */
	public List<Feature> getFeaturesByKeys(List<Integer> idList);

	/**
	 * 根据主键删除
	 */
	public Integer deleteByKey(Integer id);

	/**
	 * 根据主键批量删除
	 */
	public Integer deleteByKeys(List<Integer> idList);

	/**
	 * 根据主键更新
	 */
	public Integer updateFeatureByKey(Feature feature);

	/**
	 * 分页查询
	 * @param featureQuery
	 */
	public List<Feature> getFeatureListWithPage(FeatureQuery featureQuery);

	/**
	 * 集合查询
	 * @param featureQuery
	 */
	public List<Feature> getFeatureList(FeatureQuery featureQuery);
	
	/**
	 * 总条数
	 * @param featureQuery
	 */
	public int getFeatureListCount(FeatureQuery featureQuery);
}
