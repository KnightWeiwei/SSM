package com.knight.controller;

import com.alibaba.fastjson.JSON;
import com.knight.pojo.ConfirmNum;
import com.knight.pojo.chinese_approach;
import com.knight.pojo.chinese_confirm;
import com.knight.service.chineseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@Controller
public class ChineseController {

    @Autowired
    @Qualifier("chineseServiceImpl")
    private chineseService chineseService;
    @RequestMapping("/getChinese_approach")
    public void getChinese_approach(HttpServletResponse resp, HttpServletRequest req) throws IOException {
        String origin = req.getHeader("origin");
        resp.setHeader("Access-Control-Allow-Credentials", "true");
        resp.setHeader("Access-Control-Allow-Origin", origin);
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, HEAD, PUT,PATCH, DELETE");
        resp.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        resp.setHeader("Access-Control-Allow-Credentials", "true");
        resp.setCharacterEncoding("utf-8");

        List<chinese_approach> list= chineseService.getChinese_approach();

        System.out.println(list);
        String str= JSON.toJSONString(list);
        System.out.println(str);

        resp.getWriter().write(str);
    }

    @RequestMapping("/getChinese_confirm")
    public void getChinese_confirm(HttpServletResponse resp, HttpServletRequest req) throws IOException {
        String origin = req.getHeader("origin");
        resp.setHeader("Access-Control-Allow-Credentials", "true");
        resp.setHeader("Access-Control-Allow-Origin", origin);
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, HEAD, PUT,PATCH, DELETE");
        resp.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        resp.setHeader("Access-Control-Allow-Credentials", "true");
        resp.setCharacterEncoding("utf-8");

        List<chinese_confirm> list= chineseService.getChinese_confirm();

        System.out.println(list);
        String str= JSON.toJSONString(list);
        System.out.println(str);

        resp.getWriter().write(str);
    }

}
