package com.knight.controller;

import com.alibaba.fastjson.JSON;
import com.knight.pojo.user;
import com.knight.service.userService;
import org.omg.IOP.Encoding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    //controller层调service层
    @Autowired
    @Qualifier("userServiceImpl")
    private userService userService;
    //查询全部user，返回指定页面
    @RequestMapping("/AllUser")
    //@ResponseBody 返回的就不是Alluser了，
    // 而是Alluser这个字符串了，把返回的都按照字符串处理
    public void AllUser(HttpServletResponse resp, HttpServletRequest req) throws IOException {

        String origin = req.getHeader("origin");
        resp.setHeader("Access-Control-Allow-Credentials", "true");
        resp.setHeader("Access-Control-Allow-Origin", origin);
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, HEAD, PUT,PATCH, DELETE");
        resp.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        // 接受跨域的cookie
        resp.setHeader("Access-Control-Allow-Credentials", "true");
        //前端中文乱码问题!!!
        resp.setCharacterEncoding("utf-8");

        List<user> list=userService.quaryAllUser();
        //System.out.println(list);
        String str= JSON.toJSONString(list);

        //System.out.println(str);
        resp.getWriter().write(str);

        /*
        * 使用gson：
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        String str = gson.toJson(list);
        model.addAttribute("msg",str);
         */

    }

    @RequestMapping("/login")
    public void login(user user,HttpServletResponse resp, HttpServletRequest req) throws IOException {

        String origin = req.getHeader("origin");
        resp.setHeader("Access-Control-Allow-Credentials", "true");
        resp.setHeader("Access-Control-Allow-Origin", origin);
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, HEAD, PUT,PATCH, DELETE");
        resp.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        // 接受跨域的cookie
        resp.setHeader("Access-Control-Allow-Credentials", "true");
        //前端中文乱码问题!!!
        resp.setCharacterEncoding("utf-8");

        //SSM写法
        System.out.println(user);
        user User=userService.quaryUserById(user.getUsername());
        System.out.println(User);
        if(User == null) {
            resp.getWriter().write("fail");
        }else {
            if(User.getPwd().equals(user.getPwd())) {
                resp.getWriter().write("success");
            }else {
                resp.getWriter().write("pwd-error");
            }

        }

        //第二种写法：传统
        /*String name=req.getParameter("username");
        String pwd=req.getParameter("pwd");
        user user=userService.quaryUserById(name);
        System.out.println(name+"---"+pwd);
        if(user == null) {
            resp.getWriter().write("fail");
        }else {
            if(user.getPwd().equals(pwd)) {
                resp.getWriter().write("success");
            }else {
                resp.getWriter().write("pwd-error");
            }

        }*/

    }

    @RequestMapping("/regist")
    public void regist(user user,HttpServletResponse resp, HttpServletRequest req) throws IOException {

        String origin = req.getHeader("origin");
        resp.setHeader("Access-Control-Allow-Credentials", "true");
        resp.setHeader("Access-Control-Allow-Origin", origin);
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, HEAD, PUT,PATCH, DELETE");
        resp.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        // 接受跨域的cookie
        resp.setHeader("Access-Control-Allow-Credentials", "true");
        //前端中文乱码问题!!!
        resp.setCharacterEncoding("utf-8");



/*        String username=req.getParameter("username");
        String pwd=req.getParameter("pwd");*/
        user User=userService.quaryUserById(user.getUsername());
        System.out.println("存在"+User);
        System.out.println("前端username"+user.getUsername());
        System.out.println(user);
        if(User == null) {
            userService.addUser(user);

            resp.getWriter().write("insert_success");
        }else {
            resp.getWriter().write("user_exit");
        }

    }

}



