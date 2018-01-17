package com.base.dao.impl;

import com.base.dao.BaseDao;
import org.mybatis.spring.SqlSessionTemplate;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by DaiLiang on 2018/1/11.
 */
public class BaseDaoImpl<T extends  Serializable>  implements BaseDao<T>  {
    //从spring注入原有的sqlSessionTemplate
    @Resource
    private SqlSessionTemplate sqlSession;
    protected Class<T> entityClass;
    protected String sqlMapNamespace;
    public static final String selectByPrimaryKey = ".selectByPrimaryKey";
    public static final String insert = ".insert";
    public BaseDaoImpl() {
        // 获取超类对象类型
        Type type = getClass().getGenericSuperclass();
        // 获取实际类型参数
        Type[] parameterizedType = ((ParameterizedType)type).getActualTypeArguments();
        // 获取实体类模版
        entityClass = (Class<T>) parameterizedType[0];
        sqlMapNamespace = entityClass.getName();
    }

 /*   protected <T> String getStatement(Class<T> clazz, String prefix) {
        String entityName = clazz.getSimpleName();
        if (entityName.endsWith("Model")) {
            entityName = entityName.substring(0, entityName.length() - 5);
        }
        entityName = prefix + entityName;
        return entityName;
    }*/

    @Override
    public int save(T pojo) {

       return sqlSession.insert(sqlMapNamespace+insert,pojo);
    }

    @Override
    public int deleteById(Class clazz, Serializable id) {
        return 0;
    }

    @Override
    public Serializable getById(Class clazz, Serializable id) {
        return null;
    }
}
