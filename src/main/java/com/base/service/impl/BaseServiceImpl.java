package com.base.service.impl;

import com.base.dao.BaseDao;
import com.base.service.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * Created by DaiLiang on 2018/1/11.
 */
@Transactional
public abstract class BaseServiceImpl<T extends Serializable> implements BaseService<T> {

    public  abstract  BaseDao<T> getBaseDao();

    @Override
    public int save(T pojo) {
        return getBaseDao().save(pojo);
    }
}
