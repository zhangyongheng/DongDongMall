package com.dongdongmall.core.controller.admin;

import com.dongdongmall.core.bean.product.Brand;
import com.dongdongmall.core.query.product.BrandQuery;
import com.dongdongmall.core.service.product.BrandService;
import common.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/control")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @RequestMapping(value = "/brand/list.do")
    public String list(Integer page, String name, Integer visit, Model model) {

//        PageModel<Brand> queryPageModel = new PageModel<Brand>();
//        queryPageModel.setPageNo(page != null ? page : 2);

        BrandQuery brandQuery = new BrandQuery();
        brandQuery.setPageNo(page != null ? page : 1);
        if (!StringUtils.isEmpty(name)) {
            brandQuery.setName(name);
            model.addAttribute("name", name);
        }

        if (visit != null) {
            brandQuery.setIsVisit(visit);
            model.addAttribute("visit", visit);
        }

        PageModel<Brand> pageModel = brandService.getWithPage(brandQuery);

        model.addAttribute(pageModel);

        return "brand/list";
    }


    @RequestMapping(value = "brand/add.do")
    public String add() {

        return "brand/add";
    }

    @RequestMapping(value = "brand/addBrand.do")
    public String addBrand(Brand brand) {
        brandService.addBrand(brand);

        return "redirect:list.do";
    }

    @RequestMapping(value = "brand/deleteBrand.do")
    public String deleteBrand(Integer id, String findName, Integer visit, Model model) {
        model.addAttribute("name", findName);
        model.addAttribute("visit", visit);
        if (id != null) {
            brandService.removeBrand(id);
        }
        return "redirect:list.do";
    }

    @RequestMapping(value = "brand/deleteBrands.do")
    public String deleteBrands(int[] ids, String findName, Integer visit, Model model) {
        model.addAttribute("name", findName);
        model.addAttribute("visit", visit);

        if (ids != null && ids.length > 0) {
            brandService.removeBrands(ids);
        }

        return "redirect:list.do";
    }

}
