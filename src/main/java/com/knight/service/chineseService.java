package com.knight.service;

import com.knight.pojo.chinese_approach;
import com.knight.pojo.chinese_confirm;

import java.util.List;

public interface chineseService {
    List<chinese_approach> getChinese_approach();

    List<chinese_confirm> getChinese_confirm();
}
