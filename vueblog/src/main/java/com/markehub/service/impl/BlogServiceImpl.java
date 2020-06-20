package com.markehub.service.impl;

import java.util.List;

import com.markehub.entity.BlogBean;
import com.markehub.mapper.BlogMapper;
import com.markehub.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * 文 件 名:  BlogService.java
 * 描       述:  唯一编号
 * 作者:  xiangmiao
 * 时间:  2020-06-11 11:11:12 星期四
 */
@Service("blogService")
public class BlogServiceImpl implements BlogService {
    
    @Autowired
    private BlogMapper blogMapper;
    
    
    @Override
    public void add(BlogBean bean) {
        blogMapper.add(bean);

    }

    @Override
    public int updateBySelective(BlogBean bean) {
        return blogMapper.updateBySelective(bean);
    }

    @Override
    public int delete(Long id) {
        return blogMapper.delete(id);
    }

    @Override
    public int queryByCount(BlogBean bean) {
        return blogMapper.queryByCount(bean);
    }

    @Override
    public List<BlogBean> queryByPage(BlogBean bean) {
        return blogMapper.queryByPage(bean);
    }
    
    @Override
    public List<BlogBean> queryByList(BlogBean bean) {
        return blogMapper.queryByList(bean);
    }

    @Override
    public BlogBean queryById(Long id) {
        return blogMapper.queryById(id);
    }

    @Override
    public void batchAdd(List<BlogBean> list) {
        blogMapper.batchAdd(list);
    }

    @Override
    public void batchDelete(List<Long> list) {
        blogMapper.batchDelete(list);
    }

    @Override
    public void deleteByCondtion(BlogBean bean) {
        blogMapper.deleteByCondtion(bean);
    }
}
