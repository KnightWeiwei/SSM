package com.knight.service;

import com.knight.dao.covid_provinceMapper;

import java.util.List;

public class covid_provinceServiceImpl implements covid_provinceService {
    private covid_provinceMapper covid_provinceMapper;

    public void setCovid_provinceMapper(covid_provinceMapper covid_provinceMapper) {
        this.covid_provinceMapper = covid_provinceMapper;
    }

    @Override
    public List<String> Allcovid_province() {
        List<String> Allcovid_province=covid_provinceMapper.Allcovid_province();

        return Allcovid_province;
    }


}
