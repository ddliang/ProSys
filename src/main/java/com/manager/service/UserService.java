package com.manager.service;

import com.manager.model.Paget;
import com.manager.model.SysUser;

import java.util.List;
import java.util.Map;

/**
 * Created by DaiLiang on 2018/1/10.
 */
public interface UserService {
    SysUser selectByPrimaryKey(String id);
    List<SysUser> findByPage();
    List<SysUser> findByPage1(Map<String,String> map);
    List<Paget> findByPage2(Map<String,String> map);
}
