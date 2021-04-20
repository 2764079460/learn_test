package com.vueblog.payClient.alipay;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayConstants;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.vueblog.payClient.util.PayKeys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;

/**
 * Created by xiangmiao on 2020/8/12.
 */
public class AliPaymentClient implements Serializable{
    private static final long serialVersionUID = 7906047137087772562L;

    protected static final Logger LOG = LoggerFactory.getLogger(AliPaymentClient.class);

    private AlipayClient alipayClient;

    private static Properties properties;

    /*static {
        properties = new Properties();
        InputStream inputStream = null;
        try {
            String path = TypeData.ClassName.class.getClassLoader().getResource("alipay.properties").getPath();
            inputStream = new BufferedInputStream(new FileInputStream(path));
            properties.load(inputStream);
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
        }
    }*/

    public AliPaymentClient(String appid, String privateKey, String publicKey) {
        //沙箱
        String open_api_domain = "https://openapi.alipaydev.com/gateway.do";
        String format = "json";
        String charset = "UTF-8";
        String encipherment = "RSA2";
        alipayClient = new DefaultAlipayClient(open_api_domain, appid, privateKey,
                format != null ? format : AlipayConstants.FORMAT_JSON,
                charset != null ? charset : AlipayConstants.CHARSET_UTF8, publicKey, encipherment);
    }

    public String preCreateTrade(String params) throws Exception {
        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
        //重定向地址
        String returnUrl = "http://180.175.66.233:2171/pay_responser/alipayResponse/paySuccess";
        //异步通知地址
        String notifyUrl = "http://180.175.66.233:2171/pay_responser/alipayResponse/notice";
        /*request.setReturnUrl(returnUrl);
        request.setNotifyUrl(notifyUrl);*/
        request.setProdCode("FACE_TO_FACE_PAYMENT");
        request.setBizContent(params);
        AlipayTradePrecreateResponse response = alipayClient.execute(request);
        if(response.isSuccess()){
            LOG.info("支付宝扫码支付调用成功！");
        } else {
            LOG.error("支付宝扫码支付调用失败！");
        }
        return response.getBody();
    }

    /**
     * 退款
     * @param params
     * @return
     * @throws Exception
     */
    public String Refund(String params) throws Exception{
        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
        request.setBizContent(params);  //设置业务参数
        AlipayTradeRefundResponse response = alipayClient.execute(request);
        return response.getBody();
    }

    public static void main(String[] args) throws Exception{
        //自己的沙箱
        AliPaymentClient aliPaymentClient = new AliPaymentClient(PayKeys.aliAppId2, PayKeys.aliPrivateKey, PayKeys.aliPublicKey2);
        JSONObject json = new JSONObject();
        json.put("out_trade_no", "20150320010101002");
        json.put("total_amount", 11);
        json.put("subject", "门店支付宝收款");
        json.put("goods_id", "1");
        json.put("goods_name", "测试商品");
        json.put("quantity", 1);
        json.put("price", 2000);
        json.put("timeout_express", "5m");
        String response = aliPaymentClient.preCreateTrade(json.toJSONString());
        System.out.println(response);
    }
}
