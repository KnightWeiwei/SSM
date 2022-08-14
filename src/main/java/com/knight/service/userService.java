package com.knight.service;

import com.knight.pojo.user;

import java.util.List;

public interface userService {

    //增加
    void addUser(user user);

    //删除
    String deleteUser(String username);

    //修改
    String updateUser(user user);

    //查找
    user quaryUserById(String username);

    //查找全部
    List<user> quaryAllUser();
}
