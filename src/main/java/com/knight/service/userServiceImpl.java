package com.knight.service;

import com.knight.dao.userMapper;
import com.knight.pojo.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/* @Service */

public class userServiceImpl implements userService{

    //Service层调dao层
    /* @Autowired */
    private userMapper userMapper;

    public void setUserMapper(userMapper userMapper) {
        this.userMapper = userMapper;
    }

    public void addUser(user user) {
        userMapper.addUser(user);
    }

    public String deleteUser(String username) {
        return userMapper.deleteUser(username);
    }

    public String updateUser(user user) {
        return userMapper.updateUser(user);
    }

    public user quaryUserById(String username) {
        return userMapper.quaryUserById(username);
    }

    public List<user> quaryAllUser() {
        List<user> list = userMapper.quaryAllUser();
        //System.out.println("@!@!@zhe"+list);
        return list;
    }
}
