package com.vueblog.service.impl;

import com.vueblog.entity.GoodsBean;
import com.vueblog.mapper.GoodsMapper;
import com.vueblog.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * 文 件 名:  GoodsService.java
 * 描       述:  唯一编号
 * 作者:  xiangmiao
 * 时间:  2020-07-11 11:24:07 星期六
 */
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
    
    @Autowired(required = false)
    private GoodsMapper goodsMapper;
    
    
    @Override
    public void add(GoodsBean bean) {
        goodsMapper.add(bean);

    }

    @Override
    public int updateBySelective(GoodsBean bean) {
        return goodsMapper.updateBySelective(bean);
    }

    @Override
    public int delete(Long id) {
        return goodsMapper.delete(id);
    }

    @Override
    public void substractStock(Long id,Integer stock) {
        goodsMapper.substractStock(id, stock);
    }

    @Override
    public int queryByCount(GoodsBean bean) {
        return goodsMapper.queryByCount(bean);
    }

    @Override
    public List<GoodsBean> queryByPage(GoodsBean bean) {
        return goodsMapper.queryByPage(bean);
    }
    
    @Override
    public List<GoodsBean> queryByList(GoodsBean bean) {
        return goodsMapper.queryByList(bean);
    }

    @Override
    public GoodsBean queryById(Long id) {
        return goodsMapper.queryById(id);
    }

    @Override
    public void batchAdd(List<GoodsBean> list) {
        goodsMapper.batchAdd(list);
    }

    @Override
    public void batchDelete(List<Long> list) {
        goodsMapper.batchDelete(list);
    }

    @Override
    public void deleteByCondtion(GoodsBean bean) {
        goodsMapper.deleteByCondtion(bean);
    }
}
