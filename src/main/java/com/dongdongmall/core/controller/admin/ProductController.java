package com.dongdongmall.core.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/control")
public class ProductController{

    @RequestMapping(value = "/product/list.do")
    public String productList() {
        return "product/list";
    }

}
