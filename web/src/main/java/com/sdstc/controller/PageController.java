package com.sdstc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
@RequestMapping("/")
public class PageController {

    @RequestMapping("/direct")
    public String direct() {
        String result = "https://resource.yuntest.top/中文.docx";
        try {
            //result = URLEncoder.encode("https://resource.yuntest.top/中文.docx", "utf-8");
            return "redirect:" + result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;


    }

}
