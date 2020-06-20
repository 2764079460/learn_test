package com.markehub.config;

import java.io.Serializable;

/**
 * Created by xiangmiao on 2020/6/11.
 */
public class PageBean implements Serializable{
    private static final long serialVersionUID = 1L;
    private Integer start = 0;
    private Integer pageNum = 10;

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
}
