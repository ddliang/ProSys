package com.base.dao.impl;

import com.base.dao.CommDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * Created by DaiLiang on 2018/1/13.
 */
@Repository("commonDao")
public class CommDaoImpl implements CommDao{
    //从spring注入原有的sqlSessionTemplate
    @Resource
    private SqlSessionTemplate sqlSession;

    /**
     *
     * @param clazz Class
     * @param prefix sql id
     * @param <T>
     * @return 得到mpper中的namespace + sqlId
     */
    protected <T> String getStatement(Class<T> clazz, String prefix) {
        String statement="";
       // String entityName = clazz.getSimpleName();//得到类名
        StringBuffer entityClass =new StringBuffer();
        entityClass.append(clazz.getName());// clazz.getName() 得到类的限定类全名
        entityClass.append("Mapper").append(".").append(prefix);
        statement = entityClass.toString().replace("model","dao") ;//得到mpper中的namespace
        return statement;
    }
    @Override
    public <T extends Serializable> int save(T pojo) {
        String statement = getStatement(pojo.getClass(), "insert");
        return sqlSession.insert(statement, pojo);
    }

    @Override
    public <T extends Serializable> int deleteById(Class<T> clazz, Serializable id) {
        String statement = getStatement(clazz, "deleteByPrimaryKey");
        return sqlSession.update(statement, id);
    }

    @Override
    public <T extends Serializable> T getById(Class<T> clazz, Serializable id) {
        String statement = getStatement(clazz, "selectByPrimaryKey");
        return sqlSession.selectOne(statement, id);
    }
}
