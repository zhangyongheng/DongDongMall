package com.dongdongmall.core.dao.user;

import com.dongdongmall.core.bean.user.Employee;
import com.dongdongmall.core.query.user.EmployeeQuery;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeDao {

	/**
	 * 添加
	 * @param employee
	 */
	public Integer addEmployee(Employee employee);

	/**
	 * 根据主键查找
	 */
	public Employee getEmployeeByKey(String id);

	/**
	 * 根据主键批量查找
	 */
	public List<Employee> getEmployeesByKeys(List<String> idList);

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
	public Integer updateEmployeeByKey(Employee employee);

	/**
	 * 分页查询
	 * @param employeeQuery
	 */
	public List<Employee> getEmployeeListWithPage(EmployeeQuery employeeQuery);

	/**
	 * 集合查询
	 * @param employeeQuery
	 */
	public List<Employee> getEmployeeList(EmployeeQuery employeeQuery);
	
	/**
	 * 总条数
	 * @param employeeQuery
	 */
	public int getEmployeeListCount(EmployeeQuery employeeQuery);
}
