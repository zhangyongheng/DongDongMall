package com.dongdongmall.core.dao.product;

import com.dongdongmall.core.bean.product.Img;
import com.dongdongmall.core.query.product.ImgQuery;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ImgDao {

	/**
	 * 添加
	 * @param img
	 */
	public Integer addImg(Img img);

	/**
	 * 根据主键查找
	 */
	public Img getImgByKey(Integer id);

	/**
	 * 根据主键批量查找
	 */
	public List<Img> getImgsByKeys(List<Integer> idList);

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
	public Integer updateImgByKey(Img img);

	/**
	 * 分页查询
	 * @param imgQuery
	 */
	public List<Img> getImgListWithPage(ImgQuery imgQuery);

	/**
	 * 集合查询
	 * @param imgQuery
	 */
	public List<Img> getImgList(ImgQuery imgQuery);
	
	/**
	 * 总条数
	 * @param imgQuery
	 */
	public int getImgListCount(ImgQuery imgQuery);
}
