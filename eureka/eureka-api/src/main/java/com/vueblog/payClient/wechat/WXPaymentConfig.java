package com.vueblog.payClient.wechat;

import com.github.wxpay.sdk.WXPayConfig;

import java.io.InputStream;

/**
 * Created by xiangmiao on 2020/8/12.
 */
public class WXPaymentConfig implements WXPayConfig{

    private String appID;
    private String mchID;
    private String key;
    private InputStream certStream;
    private int httpConnectTimeoutMs = 0;
    private int httpReadTimeoutMs = 0;

    @Override
    public String getAppID() {
        return this.appID;
    }

    @Override
    public String getMchID() {
        return this.mchID;
    }

    @Override
    public String getKey() {
        return this.key;
    }

    @Override
    public InputStream getCertStream() {
        return this.certStream;
    }

    @Override
    public int getHttpConnectTimeoutMs() {
        return this.httpConnectTimeoutMs;
    }

    @Override
    public int getHttpReadTimeoutMs() {
        return this.httpReadTimeoutMs;
    }

    public void setAppID(String appID) {
        this.appID = appID;
    }

    public void setMchID(String mchID) {
        this.mchID = mchID;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setCertStream(InputStream certStream) {
        this.certStream = certStream;
    }

    public void setHttpConnectTimeoutMs(int httpConnectTimeoutMs) {
        this.httpConnectTimeoutMs = httpConnectTimeoutMs;
    }

    public void setHttpReadTimeoutMs(int httpReadTimeoutMs) {
        this.httpReadTimeoutMs = httpReadTimeoutMs;
    }
}
