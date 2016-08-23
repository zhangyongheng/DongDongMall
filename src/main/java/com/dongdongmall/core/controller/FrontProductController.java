package com.dongdongmall.core.controller;

import com.dongdongmall.core.bean.product.Brand;
import com.dongdongmall.core.bean.product.Product;
import com.dongdongmall.core.bean.product.Type;
import com.dongdongmall.core.query.product.ProductQuery;
import com.dongdongmall.core.query.product.TypeQuery;
import com.dongdongmall.core.service.product.BrandService;
import com.dongdongmall.core.service.product.ProductService;
import com.dongdongmall.core.service.product.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 前台商品Controller
 */

@Controller
@RequestMapping(value = "/display")
public class FrontProductController {

    @Autowired
    private BrandService brandService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/product/product.shtml")
    public String productList(Integer brandId, String brandName, Integer typeId, String typeName, Model model) {

        Map<String, String> filterMap = new HashMap<String, String>();

        ProductQuery productQuery = new ProductQuery();

        if (brandId != null && !StringUtils.isEmpty(brandName)) {
            filterMap.put("brandId", String.valueOf(brandId));
            filterMap.put("brandName", brandName);
            productQuery.setBrandId(brandId);
        } else {
            List<Brand> brandList = brandService.getAll();
            model.addAttribute("brandList",brandList);
        }

        if (typeId != null && !StringUtils.isEmpty(typeName)) {
            filterMap.put("typeId", String.valueOf(typeId));
            filterMap.put("typeName", typeName);
            productQuery.setTypeId(typeId);
        } else {
            TypeQuery typeQuery = new TypeQuery();
            List<Type> typeList = typeService.getTypeList(typeQuery);
            model.addAttribute("typeList",typeList);
        }

        productQuery.orderbyCreateTime(true);

        List<Product> productList = productService.getProductList(productQuery);

        model.addAttribute("productList", productList);

        model.addAttribute("filterMap", filterMap);

        return "product/product";

    }

}
