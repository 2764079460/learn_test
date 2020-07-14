package com.vueblog.service.impl;

import java.util.List;

import com.vueblog.entity.CartBean;
import com.vueblog.mapper.CartMapper;
import com.vueblog.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * 文 件 名:  CartService.java
 * 描       述:  唯一编号
 * 作者:  xiangmiao
 * 时间:  2020-07-11 11:23:46 星期六
 */
@Service("cartService")
public class CartServiceImpl implements CartService {
    
    @Autowired(required = false)
    private CartMapper cartMapper;
    
    
    @Override
    public void add(CartBean bean) {
        cartMapper.add(bean);

    }

    @Override
    public int updateBySelective(CartBean bean) {
        return cartMapper.updateBySelective(bean);
    }

    @Override
    public int delete(Long id) {
        return cartMapper.delete(id);
    }

    @Override
    public int queryByCount(CartBean bean) {
        return cartMapper.queryByCount(bean);
    }

    @Override
    public List<CartBean> queryByPage(CartBean bean) {
        return cartMapper.queryByPage(bean);
    }
    
    @Override
    public List<CartBean> queryByList(CartBean bean) {
        return cartMapper.queryByList(bean);
    }

    @Override
    public CartBean queryById(Long id) {
        return cartMapper.queryById(id);
    }

    @Override
    public void batchAdd(List<CartBean> list) {
        cartMapper.batchAdd(list);
    }

    @Override
    public void batchDelete(List<Long> list) {
        cartMapper.batchDelete(list);
    }

    @Override
    public void deleteByCondtion(CartBean bean) {
        cartMapper.deleteByCondtion(bean);
    }
}
