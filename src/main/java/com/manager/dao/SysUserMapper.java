package com.manager.dao;

import com.manager.model.Paget;
import com.manager.model.SysUser;

import java.util.List;
import java.util.Map;

public interface SysUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    List<SysUser> findByPage();

    List<SysUser> findByPage1(Map<String,String> map);

    /**
     * left join 联合查询分页测试
     * @param map
     * @return
     */
    List<Paget> findByPage2(Map<String,String> map);
}