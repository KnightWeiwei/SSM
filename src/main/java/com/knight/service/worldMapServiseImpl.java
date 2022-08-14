package com.knight.service;

import com.knight.dao.worldMapMapper;
import com.knight.pojo.worldMap;

import java.util.List;

public class worldMapServiseImpl implements worldMapServise {
    private worldMapMapper worldMapMapper;

    public void setWorldMapMapper(worldMapMapper worldMapMapper) {
        this.worldMapMapper = worldMapMapper;
    }

    @Override
    public List<worldMap> getworldMap() {
        List<worldMap> list = worldMapMapper.getworldMap();
        return list;
    }
}
