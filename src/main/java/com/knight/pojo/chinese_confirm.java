package com.knight.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class chinese_confirm {
    private String id;
    private  String name;
    private  int lon;
    private  int lat;
}
