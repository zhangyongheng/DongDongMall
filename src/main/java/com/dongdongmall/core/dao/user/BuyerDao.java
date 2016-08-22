package com.dongdongmall.core.dao.user;

import com.dongdongmall.core.bean.user.Buyer;
import com.dongdongmall.core.query.user.BuyerQuery;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BuyerDao {

	/**
	 * 添加
	 * @param buyer
	 */
	public Integer addBuyer(Buyer buyer);

	/**
	 * 根据主键查找
	 */
	public Buyer getBuyerByKey(String id);

	/**
	 * 根据主键批量查找
	 */
	public List<Buyer> getBuyersByKeys(List<String> idList);

	/**
	 * 根据主键删除
	 */
	public Integer deleteByKey(String id);

	/**
	 * 根据主键批量删除
	 */
	public Integer deleteByKeys(List<String> idList);

	/**
	 * 根据主键更新
	 */
	public Integer updateBuyerByKey(Buyer buyer);

	/**
	 * 分页查询
	 * @param buyerQuery
	 */
	public List<Buyer> getBuyerListWithPage(BuyerQuery buyerQuery);

	/**
	 * 集合查询
	 * @param buyerQuery
	 */
	public List<Buyer> getBuyerList(BuyerQuery buyerQuery);
	
	/**
	 * 总条数
	 * @param buyerQuery
	 */
	public int getBuyerListCount(BuyerQuery buyerQuery);
}
