package com.base.service;

import java.io.Serializable;

/**
 * Created by DaiLiang on 2018/1/13.
 */
public interface CommService {
    /**
     *
     * 增加一个实体
     * @param pojo
     * @return 影响的行数 0失败，1成功
     */
    public <T extends Serializable> int save(T pojo);

    /**
     *
     * 通过id删除实体
     *
     * @param clazz
     * @param id
     * @return
     */
    public <T extends Serializable> int deleteById(Class<T> clazz,
                                                   Serializable id);

    /**
     *
     * 通过主键获取实体
     *
     * @param clazz
     * @param id
     * @return
     */
    public <T extends Serializable> T getById(Class<T> clazz, Serializable id);
}
