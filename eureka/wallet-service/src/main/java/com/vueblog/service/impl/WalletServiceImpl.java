package com.vueblog.service.impl;

import com.vueblog.entity.WalletBean;
import com.vueblog.mapper.WalletMapper;
import com.vueblog.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * 文 件 名:  WalletService.java
 * 描       述:  唯一编号
 * 作者:  xiangmiao
 * 时间:  2020-07-11 11:24:47 星期六
 */
@Service("walletService")
public class WalletServiceImpl implements WalletService {
    
    @Autowired(required = false)
    private WalletMapper walletMapper;
    
    
    @Override
    public void add(WalletBean bean) {
        walletMapper.add(bean);

    }

    @Override
    public int updateBySelective(WalletBean bean) {
        return walletMapper.updateBySelective(bean);
    }

    @Override
    public int delete(Long id) {
        return walletMapper.delete(id);
    }

    @Override
    public void substractMoney(Long userId, Double money) {
        walletMapper.substractMoney(userId,money);
        throw new RuntimeException("人为报错");
    }

    @Override
    public int queryByCount(WalletBean bean) {
        return walletMapper.queryByCount(bean);
    }

    @Override
    public List<WalletBean> queryByPage(WalletBean bean) {
        return walletMapper.queryByPage(bean);
    }
    
    @Override
    public List<WalletBean> queryByList(WalletBean bean) {
        return walletMapper.queryByList(bean);
    }

    @Override
    public WalletBean queryById(Long id) {
        return walletMapper.queryById(id);
    }

    @Override
    public void batchAdd(List<WalletBean> list) {
        walletMapper.batchAdd(list);
    }

    @Override
    public void batchDelete(List<Long> list) {
        walletMapper.batchDelete(list);
    }

    @Override
    public void deleteByCondtion(WalletBean bean) {
        walletMapper.deleteByCondtion(bean);
    }
}
