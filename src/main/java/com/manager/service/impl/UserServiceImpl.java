package com.manager.service.impl;

import com.base.service.CommService;
import com.manager.dao.SysUserMapper;
import com.manager.model.Paget;
import com.manager.model.SysUser;
import com.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by DaiLiang on 2018/1/10.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private SysUserMapper sysUserMapper;
    public SysUser selectByPrimaryKey(String id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SysUser> findByPage() {
        return sysUserMapper.findByPage();
    }

    @Override
    public List<SysUser> findByPage1(Map<String, String> map) {
        return sysUserMapper.findByPage1(map);
    }

    @Override
    public List<Paget> findByPage2(Map<String, String> map) {
        return sysUserMapper.findByPage2(map);
    }

}
