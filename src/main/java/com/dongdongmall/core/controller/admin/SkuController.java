package com.dongdongmall.core.controller.admin;


import com.dongdongmall.core.bean.product.Sku;
import com.dongdongmall.core.query.product.SkuQuery;
import com.dongdongmall.core.service.product.SkuService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping(value = "/control")
public class SkuController {

    @Autowired
    private SkuService skuService;


    @RequestMapping(value = "/sku/list.do")
    public String list(Integer id, String productNo, Model model) {

        SkuQuery skuQuery = new SkuQuery();
        skuQuery.setProductId(id);
        List<Sku> skuList = skuService.getSkuList(skuQuery);

        model.addAttribute("skuList", skuList);
        model.addAttribute("productNo", productNo);

        return "sku/list";
    }

    @RequestMapping(value = "/sku/update.do")
    public void update(Sku sku, HttpServletResponse response) throws IOException {

        Integer state = skuService.updateSkuByKey(sku);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hasSuccess", 1);

        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();
        writer.write(jsonObject.toString());
        writer.close();

    }

}
