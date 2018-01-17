package com.base.service.impl;

import com.base.dao.CommDao;
import com.base.service.CommService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * Created by DaiLiang on 2018/1/13.
 */
@Service
public class CommServiceImpl implements CommService{
    @Resource(name = "commonDao")
    protected CommDao commonDao;
    @Override
    public <T extends Serializable> int save(T pojo) {
        return commonDao.save(pojo);
    }

    @Override
    public <T extends Serializable> int deleteById(Class<T> clazz, Serializable id) {
        return commonDao.deleteById(clazz,id);
    }

    @Override
    public <T extends Serializable> T getById(Class<T> clazz, Serializable id) {
        return commonDao.getById(clazz,id);
    }
}
