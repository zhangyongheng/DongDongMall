package com.dongdongmall.core.dao.order;

import com.dongdongmall.core.bean.order.Order;
import com.dongdongmall.core.query.order.OrderQuery;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderDao {

	/**
	 * 添加
	 * @param order
	 */
	public Integer addOrder(Order order);

	/**
	 * 根据主键查找
	 */
	public Order getOrderByKey(Integer id);

	/**
	 * 根据主键批量查找
	 */
	public List<Order> getOrdersByKeys(List<Integer> idList);

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
	public Integer updateOrderByKey(Order order);

	/**
	 * 分页查询
	 * @param orderQuery
	 */
	public List<Order> getOrderListWithPage(OrderQuery orderQuery);

	/**
	 * 集合查询
	 * @param orderQuery
	 */
	public List<Order> getOrderList(OrderQuery orderQuery);
	
	/**
	 * 总条数
	 * @param orderQuery
	 */
	public int getOrderListCount(OrderQuery orderQuery);
}
