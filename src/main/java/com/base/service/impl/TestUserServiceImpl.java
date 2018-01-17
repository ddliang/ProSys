package com.base.service.impl;

import com.base.dao.BaseDao;
import com.base.dao.TestUser;
import com.base.service.TestService;
import com.manager.dao.SysUserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by DaiLiang on 2018/1/11.
 */
@Service
public class TestUserServiceImpl extends BaseServiceImpl<TestUser> implements TestService{

    @Resource
    private SysUserMapper sysUserMapper;
    @Override
    public BaseDao<TestUser> getBaseDao() {
        return null;
    }
}
