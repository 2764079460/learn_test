package com.markehub;

/**
 * Created by xiangmiao on 2020/6/23.
 */
public enum WorkList {
    aa(1, "1号"),
    bb(2, "2号"),
    cc(3, "3号");

    private int value;
    private String msg;

    WorkList(int value, String msg) {
        this.value = value;
        this.msg = msg;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
