package com.knight.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//除了有参构造全都有了
@Data
//有参构造函数
@AllArgsConstructor
//有参构造有了无参构造就会消失，现在再来个无参构造函数
@NoArgsConstructor
public class user {

    private String username;
    private String pwd;

}
