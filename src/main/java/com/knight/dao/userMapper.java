package com.knight.dao;

import com.knight.pojo.user;
import org.apache.ibatis.annotations.Param;

import javax.naming.BinaryRefAddr;
import java.util.List;

public interface userMapper {

    //增加
    void addUser(user user);

    //删除
    String deleteUser(@Param("id") String username);

    //修改
    String updateUser(user user);

    //查找
    user quaryUserById(@Param("id") String username);

    //查找全部
    List<user> quaryAllUser();
}
