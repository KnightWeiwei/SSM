package com.knight.service;

import com.knight.dao.visitMapper;
import com.knight.pojo.visit;

import java.util.List;

public class visitServiceImpl implements visitService{
    private visitMapper visitMapper;

    public void setVisitMapper(visitMapper visitMapper) {
        this.visitMapper = visitMapper;
    }

    @Override
    public List<visit> getVisiter() {
        List<visit> list = visitMapper.getVisiter();
        return list;
    }
}
