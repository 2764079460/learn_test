package com.vueblog.service.impl;

import java.util.List;

import com.vueblog.entity.OrderBean;
import com.vueblog.mapper.OrderMapper;
import com.vueblog.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * 文 件 名:  OrderService.java
 * 描       述:  唯一编号
 * 作者:  xiangmiao
 * 时间:  2020-07-11 11:24:27 星期六
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    
    @Autowired(required = false)
    private OrderMapper orderMapper;
    
    
    @Override
    public void add(OrderBean bean) {
        orderMapper.add(bean);

    }

    @Override
    public int updateBySelective(OrderBean bean) {
        return orderMapper.updateBySelective(bean);
    }

    @Override
    public int delete(Long id) {
        return orderMapper.delete(id);
    }

    @Override
    public int queryByCount(OrderBean bean) {
        return orderMapper.queryByCount(bean);
    }

    @Override
    public List<OrderBean> queryByPage(OrderBean bean) {
        return orderMapper.queryByPage(bean);
    }
    
    @Override
    public List<OrderBean> queryByList(OrderBean bean) {
        return orderMapper.queryByList(bean);
    }

    @Override
    public OrderBean queryById(Long id) {
        return orderMapper.queryById(id);
    }

    @Override
    public void batchAdd(List<OrderBean> list) {
        orderMapper.batchAdd(list);
    }

    @Override
    public void batchDelete(List<Long> list) {
        orderMapper.batchDelete(list);
    }

    @Override
    public void deleteByCondtion(OrderBean bean) {
        orderMapper.deleteByCondtion(bean);
    }
}
