package com.knight.service;

import com.knight.dao.rankMapper;
import com.knight.pojo.rank;

import java.util.List;

public class rankServiceImpl implements rankService{
    private rankMapper rankMapper;

    public void setRankMapper(rankMapper rankMapper) {
        this.rankMapper = rankMapper;
    }

    @Override
    public List<rank> getWorldRank() {
        List<rank> list = rankMapper.getWorldRank();
        return list;
    }
}
