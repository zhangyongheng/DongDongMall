package com.dongdongmall.core.controller.admin;

import org.apache.commons.io.FilenameUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Controller
@RequestMapping(value = "/upload")
public class UpLoadController {

    @RequestMapping(value = "/pic.do", method = RequestMethod.POST)
    public void uploadPic(@RequestParam(required = false) MultipartFile pic, HttpServletResponse response) {

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmSSsss");
        String fileName = dateFormat.format(date);
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            fileName += random.nextInt(10);
        }

        String extensionName = FilenameUtils.getExtension(pic.getOriginalFilename());

        String path = "E:\\MyCode\\JavaEE\\ProjectData\\DDM\\" + fileName + "." + extensionName;

        InputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            inputStream = pic.getInputStream();
            outputStream = new FileOutputStream(path);
            byte[] buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, len);
            }
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("url", path);

        response.setContentType("application/json; charset=utf-8");

        PrintWriter writer;
        try {
            writer = response.getWriter();
            writer.write(jsonObject.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
