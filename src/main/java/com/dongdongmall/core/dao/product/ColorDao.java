package com.dongdongmall.core.dao.product;

import com.dongdongmall.core.bean.product.Color;
import com.dongdongmall.core.query.product.ColorQuery;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ColorDao {

	/**
	 * 添加
	 * @param color
	 */
	public Integer addColor(Color color);

	/**
	 * 根据主键查找
	 */
	public Color getColorByKey(Integer id);

	/**
	 * 根据主键批量查找
	 */
	public List<Color> getColorsByKeys(List<Integer> idList);

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
	public Integer updateColorByKey(Color color);

	/**
	 * 分页查询
	 * @param colorQuery
	 */
	public List<Color> getColorListWithPage(ColorQuery colorQuery);

	/**
	 * 集合查询
	 * @param colorQuery
	 */
	public List<Color> getColorList(ColorQuery colorQuery);
	
	/**
	 * 总条数
	 * @param colorQuery
	 */
	public int getColorListCount(ColorQuery colorQuery);
}
