package com.markerhub.common.Lang;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by xiangmiao on 2020/6/12.
 */
@Data
public class Result implements Serializable{

    private int code;
    private String msg;
    private Object data;

    public static Result succ(Object data) {
        return succ(200,"操作成功",data);
    }

    public static Result succ(int code, String msg, Object data) {
        Result res = new Result();
        res.setCode(code);
        res.setMsg(msg);
        res.setData(data);
        return res;
    }

    public static Result fail(String msg) {
        return fail(400,msg);
    }

    public static Result fail(int code,String msg) {
        Result res = new Result();
        res.setCode(code);
        res.setMsg(msg);
        res.setData(null);
        return res;
    }
}
