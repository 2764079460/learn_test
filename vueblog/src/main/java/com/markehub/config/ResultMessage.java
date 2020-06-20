package com.markehub.config;

import javax.xml.crypto.Data;
import java.io.Serializable;

/**
 * Created by xiangmiao on 2020/6/11.
 */
public class ResultMessage implements Serializable{
    private static final long serialVersionUID = 1L;
    private Object Data;
    private Integer status;
    private String msg;

    public Object getData() {
        return Data;
    }

    public void setData(Object data) {
        Data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
