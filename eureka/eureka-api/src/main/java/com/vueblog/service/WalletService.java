package com.vueblog.service;

import com.vueblog.entity.WalletBean;

import java.util.List;


/*
 * 版    权:  operate Copyright 2014-2016,All rights reserved
 * 文 件 名:  WalletService.java
 * 描       述:  唯一编号
 * 作者:  xiangmiao
 * 时间:  2020-07-11 11:24:47 星期六
 */


public interface WalletService{
	
    /**
     * 
     * @Title: add
     * @author xiangmiao
     * @Description: (新增对象)
     * @return void 返回类型
     * @throws
     */
    public void add(WalletBean bean);

    /**
     * 
     * @Title: updateBySelective
     * @author xiangmiao
     * @Description: (根据内容修改对象)
     * @return
     * @return int 返回类型
     * @throws
     */
    public int updateBySelective(WalletBean bean);
    
    /**
     * 
     * @Title: delete
     * @author xiangmiao
     * @Description: (删除对象)
     * @param id
     * @return
     * @return int 返回类型
     * @throws
     */
    public int delete(Long id);

    /**
     * 减余额
     * @param userId
     * @param money
     */
    void substractMoney(Long userId, Double money);

    /**
     * 
     * @Title: queryByCount
     * @author xiangmiao
     * @Description: (获取数量)
     * @return
     * @return int 返回类型
     * @throws
     */
    public int queryByCount(WalletBean bean);

    /**
     * 
     * @Title: queryByPage
     * @author xiangmiao
     * @Description: (获取分页对象)
     * @return
     * @return List<WalletBean> 返回类型
     * @throws
     */
    public List<WalletBean> queryByPage(WalletBean bean);
    
    /**
     * 
     * @Title: queryByList
     * @author xiangmiao
     * @Description: (获取集合对象)
     * @return
     * @return List<WalletBean> 返回类型
     * @throws
     */
    public List<WalletBean> queryByList(WalletBean bean);

    /**
     * 
     * @Title: queryById
     * @author xiangmiao
     * @Description: (获取一个对象)
     * @return
     * @return WalletBean 返回类型
     * @throws
     */
    public WalletBean queryById(Long id);

    /**
     * 
     * @Title: batchAdd
     * @author xiangmiao
     * @Description: (批量添加)
     * @param list
     * @return void 返回类型
     * @throws
     */
    public void batchAdd(List<WalletBean> list);

    /**
     * 
     * @Title: batchDelete
     * @author 圣彬彬
     * @Description: (批量删除)
     * @return void 返回类型
     * @throws
     */
    public void batchDelete(List<Long> list);

    /**
     * 
     * @Title: deleteByCondtion
     * @author xiangmiao
     * @Description: (根据条件删除)
     * @return void 返回类型
     * @throws
     */
    public void deleteByCondtion(WalletBean bean);

}
