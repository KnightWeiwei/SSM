package com.knight.service;

import com.knight.dao.confirmNumMapper;
import com.knight.pojo.ConfirmNum;


import java.util.List;

public class confirmNumServiceImpl implements confirmNumService {

    private confirmNumMapper confirmNumMapper;

    public void setConfirmNumMapper(confirmNumMapper confirmNumMapper) {
        this.confirmNumMapper=confirmNumMapper;
    }


    public List<ConfirmNum> AllConfirmNum(){
        List<ConfirmNum> AllConfirmNumlist = confirmNumMapper.AllConfirmNum();

        //System.out.println(AllConfirmNumlist);

        return AllConfirmNumlist;
    }


}
