package com.dongdongmall.core.service.country;

import java.util.List;

import javax.annotation.Resource;

import com.dongdongmall.core.bean.country.Province;
import com.dongdongmall.core.dao.country.ProvinceDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * &#x7701;
 * @author lixu
 * @Date [2014-3-27 &#x4e0b;&#x5348;03:31:57]
 */
@Service
@Transactional
public class ProvinceServiceImpl implements ProvinceService {

	@Resource
	ProvinceDao provinceDao;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addProvince(Province province) {
		return provinceDao.addProvince(province);
	}

	/**
	 * 根据主键查找
	 */
	@Transactional(readOnly = true)
	public Province getProvinceByKey(Integer id) {
		return provinceDao.getProvinceByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<Province> getProvincesByKeys(List<Integer> idList) {
		return provinceDao.getProvincesByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return provinceDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return provinceDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateProvinceByKey(Province province) {
		return provinceDao.updateProvinceByKey(province);
	}
	

}
