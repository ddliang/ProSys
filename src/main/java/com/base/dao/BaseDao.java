package com.base.dao;

import java.io.Serializable;

/**
 * Created by DaiLiang on 2018/1/11.
 */
public interface BaseDao<T extends Serializable> {
    /**
     *
     * 增加一个实体
     * @param pojo
     * @return 影响的行数 0失败，1成功
     */
    public  int save(T pojo);

    /**
     *
     * 通过id删除实体
     *
     * @param clazz
     * @param id
     * @return
     */
    public  int deleteById(Class<T> clazz,
                                                   Serializable id);

    /**
     *
     * 通过主键获取实体
     *
     * @param clazz
     * @param id
     * @return
     */
    public  T getById(Class<T> clazz, Serializable id);

}
