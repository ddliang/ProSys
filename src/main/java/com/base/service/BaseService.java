package com.base.service;

import java.io.Serializable;

/**
 * Created by DaiLiang on 2018/1/11.
 */
public interface BaseService<T extends  Serializable> {
    /**
     *
     * 增加一个实体
     * @param pojo
     * @return 影响的行数 0失败，1成功
     */
    public  int save(T pojo);
}
