package com.dongdongmall.core.controller.admin;

import com.dongdongmall.core.bean.product.*;
import com.dongdongmall.core.query.product.ColorQuery;
import com.dongdongmall.core.query.product.FeatureQuery;
import com.dongdongmall.core.query.product.ProductQuery;
import com.dongdongmall.core.query.product.TypeQuery;
import com.dongdongmall.core.service.product.*;
import common.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/control")
public class ProductController {


    @Autowired
    private ProductService productService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private FeatureService featureService;

    @Autowired
    private ColorService colorService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private SkuService skuService;

    @RequestMapping(value = "/product/list.do")
    public String productList(String name, Integer brandId, Integer page, Model model) {

        ProductQuery productQuery = new ProductQuery();
        productQuery.setPageSize(3);
        if (page != null) {
            productQuery.setPageNo(page);
        }
        if (!StringUtils.isEmpty(name)) {
            productQuery.setNameLike(true);
            productQuery.setName(name);
        }
        if (brandId != null) {
            productQuery.setBrandId(brandId);
        }

        PageModel<Product> productPageModel = productService.getProductListWithPage(productQuery);

        List<Brand> brands = brandService.getAll();

        model.addAttribute("productPageModel", productPageModel);
        model.addAttribute("brands", brands);
        model.addAttribute("name", name);
        model.addAttribute("brandId", brandId);

        return "product/list";
    }

    @RequestMapping(value = "/product/toAdd.do")
    public String toAdd(Model model) {

        FeatureQuery featureQuery = new FeatureQuery();
        List<Feature> featureList = featureService.getFeatureList(featureQuery);
        ColorQuery colorQuery = new ColorQuery();
        colorQuery.setStartRow(10);
        List<Color> colorList = colorService.getColorListWithPage(colorQuery);
        TypeQuery typeQuery = new TypeQuery();
        List<Type> typeList = typeService.getTypeList(typeQuery);
        List<Brand> brandList = brandService.getAll();

        model.addAttribute("featureList", featureList);
        model.addAttribute("colorList", colorList);
        model.addAttribute("typeList", typeList);
        model.addAttribute("brandList", brandList);

        return "product/add";
    }

    @RequestMapping(value = "/product/add.do")
    public String add(Product product, Model model) {
        String no = new SimpleDateFormat("yyMMddHHmmyyYYY").format(new Date());
        product.setNo(no);
        productService.addProduct(product);
        Integer productId = product.getId();

        for (String color : product.getColor().split(",")) {
            for (String size : product.getSize().split(",")) {

                Sku sku = new Sku();
                sku.setColorId(Integer.parseInt(color));
                sku.setSize(size);
                sku.setProductId(productId);
                sku.setCreateTime(new Date());
                sku.setMarketPrice(0.00);
                sku.setSkuPrice(0.00);
                sku.setDeliveFee(10.00);
                sku.setStockInventory(0);

                skuService.addSku(sku);

            }
        }

        return "redirect:list.do";
    }

    @RequestMapping(value = "/product/show.do")
    public String show(Integer[] ids, Integer show) {

        if (ids != null) {
            if (show == 1 || show == 0) {
                for (Integer id : ids) {
                    Product product = new Product();
                    product.setId(id);
                    product.setIsShow(show);
                    productService.updateProductByKey(product);
                }
            }

        }
        return "redirect:list.do";
    }


}
