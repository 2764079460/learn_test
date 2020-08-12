package com.vueblog.payClient.wechat;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayConstants;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiangmiao on 2020/8/12.
 */
public class NewWxPaymentClient implements Serializable{

    private WXPay wxPay;

    private WXPaymentConfig config;

    public NewWxPaymentClient(String appId, String mchId, String mchKey, String keyPath) throws Exception{
        config = new WXPaymentConfig();
        config.setAppID(appId);
        config.setMchID(mchId);
        InputStream inputStream = new FileInputStream(keyPath);
        config.setCertStream(inputStream);
        config.setKey(mchKey);
        wxPay = new WXPay(config, WXPayConstants.SignType.MD5,true);
    }

    public String pay() throws Exception{
        Map<String, String> request = new HashMap<>();
        request.put("out_trade_no", "20150806125346");
        request.put("product_id", "1");
        request.put("body", "门店微信收款");
        request.put("total_fee", "101");
        request.put("attach", "1");
        request.put("notify_url", "1");
        request.put("trade_type", "NATIVE");
        Map<String, String> respons = wxPay.unifiedOrder(request);
        JSONObject object = JSONObject.parseObject(JSON.toJSONString(respons));
        return object.toString();
    }

    public String getSandboxSignKey() throws Exception{
        Map<String, String> map = new HashMap<>();
        map.put("mch_id", "1498781952");
        map.put("nonce_str", "5K8264ILTKCH16CQ2502SI8ZNMTM67VS");
        map.put("sign", "DSFFDDSFFDDSFFDDSFFDDSFFDDSFFDEE");
        String result = wxPay.requestWithoutCert("https://api.mch.weixin.qq.com/sandboxnew/pay/getsignkey",map,
                config.getHttpConnectTimeoutMs(),config.getHttpReadTimeoutMs());
        return result;
    }

    public static void main(String[] args) throws Exception{
        String appId = "wx65fd1bd441fb768f";
        String mchId = "1498781952";
        String mchKey = "DSFFDDSFFDDSFFDDSFFDDSFFDDSFFDEE";
        String signkey = "fd8a0926e11dc84bb1514bdfc6e6068f";
        String keyPath = "D:\\\\cert\\\\wechat\\\\cert_1498781952\\\\apiclient_cert.p12";
        NewWxPaymentClient paymentClient = new NewWxPaymentClient(appId, mchId, signkey, keyPath);
        //String ss = paymentClient.pay();
        String aa = paymentClient.getSandboxSignKey();
        System.out.println(aa);
    }
}
