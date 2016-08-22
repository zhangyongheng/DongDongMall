package com.dongdongmall.core.service.product;

import com.dongdongmall.core.bean.product.Brand;
import com.dongdongmall.core.dao.product.BrandDao;
import com.dongdongmall.core.query.product.BrandQuery;
import common.PageModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 品牌Service实现类
 */
@Service
@Transactional
public class BrandServiceImpl implements BrandService {

    @Resource
    private BrandDao brandDao;

    @Transactional(readOnly = true)
    public List<Brand> getAll() {
        return brandDao.getAll();
    }

    @Transactional(readOnly = true)
    public PageModel<Brand> getWithPage(BrandQuery brandQuery) {

        PageModel<Brand> pageModel = new PageModel<Brand>();

        pageModel.setPageSize(brandQuery.getPageSize());
        pageModel.setPageNo(brandQuery.getPageNo());

        pageModel.setList(brandDao.getWithPage(brandQuery));
        pageModel.setTotalRecords(brandDao.getCountAll(brandQuery));

        return pageModel;

    }

    public void addBrand(Brand brand) {
        brandDao.add(brand);
    }

    public void removeBrand(int id) {
        brandDao.remove(id);
    }

    public void removeBrands(int[] ids) {
        brandDao.removeList(ids);
    }


}
