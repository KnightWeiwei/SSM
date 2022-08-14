package com.knight.controller;

import com.alibaba.fastjson.JSON;
import com.knight.pojo.visit;
import com.knight.service.covid_provinceService;
import com.knight.service.visitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@Controller
public class visiterController {
    @Autowired
    @Qualifier("visitServiceImpl")
    private visitService visitService;

    @RequestMapping("/visiter")
    public void getVisiter(HttpServletResponse resp, HttpServletRequest req) throws IOException {
        String origin = req.getHeader("origin");
        resp.setHeader("Access-Control-Allow-Credentials", "true");
        resp.setHeader("Access-Control-Allow-Origin", origin);
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, HEAD, PUT,PATCH, DELETE");
        resp.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        resp.setHeader("Access-Control-Allow-Credentials", "true");
        resp.setCharacterEncoding("utf-8");

        List<visit> list = visitService.getVisiter();

        String str = JSON.toJSONString(list);

        resp.getWriter().write(str);
    }
}
