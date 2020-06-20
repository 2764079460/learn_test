package com.markehub.service.impl;

import java.util.List;

import com.markehub.entity.UserBean;
import com.markehub.mapper.UserMapper;
import com.markehub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * 文 件 名:  UserService.java
 * 描       述:  唯一编号
 * 作者:  xiangmiao
 * 时间:  2020-06-11 11:10:43 星期四
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserMapper userMapper;
    

    @Override
    public void add(UserBean bean) {
        userMapper.add(bean);

    }

    @Override
    public int updateBySelective(UserBean bean) {
        return userMapper.updateBySelective(bean);
    }

    @Override
    public int delete(Long id) {
        return userMapper.delete(id);
    }

    @Override
    public int queryByCount(UserBean bean) {
        return userMapper.queryByCount(bean);
    }

    @Override
    public List<UserBean> queryByPage(UserBean bean) {
        return userMapper.queryByPage(bean);
    }
    
    @Override
    public List<UserBean> queryByList(UserBean bean) {
        return userMapper.queryByList(bean);
    }

    @Override
    public UserBean queryById(Long id) {
        return userMapper.queryById(id);
    }

    @Override
    public void batchAdd(List<UserBean> list) {
        userMapper.batchAdd(list);
    }

    @Override
    public void batchDelete(List<Long> list) {
        userMapper.batchDelete(list);
    }

    @Override
    public void deleteByCondtion(UserBean bean) {
        userMapper.deleteByCondtion(bean);
    }
}
