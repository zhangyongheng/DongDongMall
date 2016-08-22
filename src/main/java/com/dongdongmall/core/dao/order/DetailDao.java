package com.dongdongmall.core.dao.order;

import com.dongdongmall.core.bean.order.Detail;
import com.dongdongmall.core.query.order.DetailQuery;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DetailDao {

	/**
	 * 添加
	 * @param detail
	 */
	public Integer addDetail(Detail detail);

	/**
	 * 根据主键查找
	 */
	public Detail getDetailByKey(Integer id);

	/**
	 * 根据主键批量查找
	 */
	public List<Detail> getDetailsByKeys(List<Integer> idList);

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
	public Integer updateDetailByKey(Detail detail);

	/**
	 * 分页查询
	 * @param detailQuery
	 */
	public List<Detail> getDetailListWithPage(DetailQuery detailQuery);

	/**
	 * 集合查询
	 * @param detailQuery
	 */
	public List<Detail> getDetailList(DetailQuery detailQuery);
	
	/**
	 * 总条数
	 * @param detailQuery
	 */
	public int getDetailListCount(DetailQuery detailQuery);
}
