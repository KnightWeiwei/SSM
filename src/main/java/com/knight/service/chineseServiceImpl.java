package com.knight.service;

import com.knight.dao.chineseMapper;
import com.knight.pojo.chinese_approach;
import com.knight.pojo.chinese_confirm;

import java.util.List;

public class chineseServiceImpl implements chineseService{
    private chineseMapper chineseMapper;

    public void setChineseMapper(chineseMapper chineseMapper) {
        this.chineseMapper = chineseMapper;
    }

    @Override
    public List<chinese_approach> getChinese_approach() {
        List<chinese_approach> chinese_approach= chineseMapper.getChinese_approach();
        return chinese_approach;
    }

    @Override
    public List<chinese_confirm> getChinese_confirm() {
        List<chinese_confirm> chinese_confirm= chineseMapper.getChinese_confirm();
        return chinese_confirm;
    }

}
