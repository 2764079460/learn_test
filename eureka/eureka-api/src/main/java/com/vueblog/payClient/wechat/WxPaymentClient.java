package com.vueblog.payClient.wechat;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.bean.result.WxPayUnifiedOrderResult;
import com.github.binarywang.wxpay.config.WxPayConfig;
import com.github.binarywang.wxpay.service.WxPayService;
import com.github.binarywang.wxpay.service.impl.WxPayServiceImpl;
import com.vueblog.payClient.wechat.helper.WXPayHelper;
import com.vueblog.payClient.wechat.helper.WxPKCS7Decoder;


import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Properties;

/**
 * Created by xiangmiao on 2020/8/12.
 */
public class WxPaymentClient implements Serializable{
    private static final long serialVersionUID = 6171524813482973289L;

    private static String configFilePath;

    private WXPayHelper wxPayHelper;

    private WxPKCS7Decoder wxPKCS7Decoder;

    private Properties properties;

    private WxPayService wxPayService;

    private SSLContext context;

    private SSLSocketFactory ssf;

    private static final String CHARSET = "UTF-8";

    static {
        //configFilePath = TypeData.ClassName.class.getClassLoader().getResource("weixin.properties").getPath();
    }

    public WxPaymentClient(String appId, String mchId, String mchKey, String keyPath) throws Exception {
        /*this.wxPayHelper = new WXPayHelper(configFilePath);
        this.wxPKCS7Decoder = new WxPKCS7Decoder(configFilePath);*/
        /*properties = new Properties();
        InputStream inputStream = new FileInputStream(configFilePath);
        properties.load(inputStream);*/
        wxPayService = new WxPayServiceImpl();
        //inputStream.close();
        WxPayConfig config = new WxPayConfig();
        config.setAppId(appId);
        config.setMchId(mchId);
        config.setMchKey(mchKey);
        config.setKeyPath(keyPath);
        config.setTradeType("NATIVE");
        //开启沙箱
        config.setUseSandboxEnv(true);
        config.setSignType("MD5");
        wxPayService.setConfig(config);
    }

    public String pay(String params) throws Exception {
        JSONObject jsonObject = JSONObject.parseObject(params);
        WxPayUnifiedOrderRequest request = new WxPayUnifiedOrderRequest();
        String order = jsonObject.getString("outTradeNo");
        String productId = jsonObject.getString("productId");
        String spbillCreateIp = WXPayHelper.getHost().getHostAddress();
        Integer sideLength = jsonObject.getInteger("sideLength");
        File logFile = (File) jsonObject.get("logFile");
        request.setBody(jsonObject.getString("body"));
        request.setTotalFee(jsonObject.getInteger("totalFee"));
        request.setOutTradeNo(order);
        request.setSpbillCreateIp(spbillCreateIp);

        request.setLimitPay("no_credit");
        request.setProductId(productId != null ? productId : "1");
        request.setAttach(jsonObject.getString("orderNum"));

        request.setNotifyUrl("http://180.175.66.233:2171/pay_responser/weixinResponse/payStatus");

        WxPayUnifiedOrderResult wxPayUnifiedOrderResult = wxPayService.unifiedOrder(request);
        Map<String, String> result = wxPayUnifiedOrderResult.toMap();
        JSONObject object = JSONObject.parseObject(JSON.toJSONString(result));
        /*String codeUrl = result.get("code_url");
        byte[] bytes = wxPayService.createScanPayQrcodeMode2(codeUrl, logFile, sideLength);
        object.put("bytes", bytes);*/
        object.put("out_trade_no", order);
        return object.toString();
    }

    public String getSandboxSignKey() throws Exception{
        String key = wxPayService.getSandboxSignKey();
        return key;
    }

    public static void main(String[] args) throws Exception{
        String appId = "wx65fd1bd441fb768f";
        String mchId = "1498781952";
        String mchKey = "DSFFDDSFFDDSFFDDSFFDDSFFDDSFFDEE";
        String signkey = "fd8a0926e11dc84bb1514bdfc6e6068f";

        String keyPath = "D:\\\\cert\\\\wechat\\\\cert_1498781952\\\\apiclient_cert.p12";
        WxPaymentClient wxPaymentClient = new WxPaymentClient(appId, mchId, signkey, keyPath);
        JSONObject json = new JSONObject();
        json.put("outTradeNo", "20150806125346");
        json.put("productId", "1");
        json.put("body", "门店微信收款");
        json.put("totalFee", 101);
        json.put("orderNum", "1");

        wxPaymentClient.pay(json.toJSONString());
        //wxPaymentClient.getSandboxSignKey();
    }
}
