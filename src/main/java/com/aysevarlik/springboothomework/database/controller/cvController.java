package com.aysevarlik.springboothomework.database.controller;

import com.aysevarlik.springboothomework.database.dao.cvDao;
import com.aysevarlik.springboothomework.database.dao.daoConnection;
import com.aysevarlik.springboothomework.database.dto.CvDto;

import java.util.ArrayList;

public class cvController implements daoConnection<CvDto> {
    cvDao cvDao;

    @Override
    public void create(CvDto cvDto) {
        this.cvDao.create(cvDto);

    }

    @Override
    public void update(CvDto cvDto) {
        this.cvDao.update(cvDto);

    }

    @Override
    public void delete(CvDto cvDto) {
        this.cvDao.delete(cvDto);

    }

    @Override
    public ArrayList<CvDto> list() {
        return this.cvDao.list();
    }
}
