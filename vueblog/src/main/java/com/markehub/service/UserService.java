package com.markehub.service;

import com.markehub.entity.UserBean;

import java.util.List;


/*
 * 版    权:  operate Copyright 2014-2016,All rights reserved
 * 文 件 名:  UserService.java
 * 描       述:  唯一编号
 * 作者:  xiangmiao
 * 时间:  2020-06-11 11:10:43 星期四
 */


public interface UserService{
	
    /**
     * 
     * @Title: add
     * @author xiangmiao
     * @Description: (新增对象)
     * @return void 返回类型
     * @throws
     */
     void add(UserBean bean);

    /**
     * 
     * @Title: updateBySelective
     * @author xiangmiao
     * @Description: (根据内容修改对象)
     * @return
     * @return int 返回类型
     * @throws
     */
     int updateBySelective(UserBean bean);
    
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
     int delete(Long id);

    /**
     * 
     * @Title: queryByCount
     * @author xiangmiao
     * @Description: (获取数量)
     * @return
     * @return int 返回类型
     * @throws
     */
     int queryByCount(UserBean bean);

    /**
     * 
     * @Title: queryByPage
     * @author xiangmiao
     * @Description: (获取分页对象)
     * @return
     * @return List<UserBean> 返回类型
     * @throws
     */
     List<UserBean> queryByPage(UserBean bean);
    
    /**
     * 
     * @Title: queryByList
     * @author xiangmiao
     * @Description: (获取集合对象)
     * @return
     * @return List<UserBean> 返回类型
     * @throws
     */
     List<UserBean> queryByList(UserBean bean);

    /**
     * 
     * @Title: queryById
     * @author xiangmiao
     * @Description: (获取一个对象)
     * @return
     * @return UserBean 返回类型
     * @throws
     */
     UserBean queryById(Long id);

    /**
     * 
     * @Title: batchAdd
     * @author xiangmiao
     * @Description: (批量添加)
     * @param list
     * @return void 返回类型
     * @throws
     */
     void batchAdd(List<UserBean> list);

    /**
     * 
     * @Title: batchDelete
     * @author 圣彬彬
     * @Description: (批量删除)
     * @return void 返回类型
     * @throws
     */
     void batchDelete(List<Long> list);

    /**
     * 
     * @Title: deleteByCondtion
     * @author xiangmiao
     * @Description: (根据条件删除)
     * @return void 返回类型
     * @throws
     */
     void deleteByCondtion(UserBean bean);

}
