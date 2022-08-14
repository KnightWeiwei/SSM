package com.knight.controller;

import com.alibaba.fastjson.JSON;
import com.knight.pojo.ConfirmNum;
import com.knight.service.confirmNumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller

public class confirmNumController {

    @Autowired
    @Qualifier("confirmNumServiceImpl")
    private confirmNumService confirmNumService;
    @RequestMapping("/AllConfirmNum")
    public void AllConfirmNum(HttpServletResponse resp, HttpServletRequest req) throws IOException {
        String origin = req.getHeader("origin");
        resp.setHeader("Access-Control-Allow-Credentials", "true");
        resp.setHeader("Access-Control-Allow-Origin", origin);
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, HEAD, PUT,PATCH, DELETE");
        resp.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        // 接受跨域的cookie
        resp.setHeader("Access-Control-Allow-Credentials", "true");
        //前端中文乱码问题!!!
        resp.setCharacterEncoding("utf-8");

        List<ConfirmNum> list= confirmNumService.AllConfirmNum();

        //System.out.println(list);
        String str= JSON.toJSONString(list);
        //System.out.println(str);

        resp.getWriter().write(str);
    }
}
