package com.vueblog.payClient.response;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.vueblog.payClient.wechat.helper.WXPayHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiangmiao on 2020/8/14.
 */
@Controller
@RequestMapping("/mingteng/wxpay")
public class WXPaymentResponse {

    private static final Logger LOG = LoggerFactory.getLogger(WXPaymentResponse.class);

    /*@Autowired
    WebSocket webSocket;

    @Autowired(required = false)
    WXPaymentService wxPaymentService;

    @Autowired(required = false)
    SoMasterService soMasterService;*/

    /*@RequestMapping("/pay")
    @ResponseBody
    public CommonResult pay(CommonResult res,String str) throws Exception {
        LOG.info("微信扫码参数:"+str);
        Map<String, String> prepay = wxPaymentService.pay(str);
        JSONObject json = new JSONObject();
        json.put("code_url", prepay.get("code_url"));
        json.put("out_trade_no", prepay.get("out_trade_no"));
        String ws = "ws://shop.anmogongfang.com/mingteng/websocket/" + prepay.get("out_trade_no");
        if (System.getProperty("os.name").contains("Windows")) {
            ws = "ws://192.168.0.32:8080/mingteng/websocket/" + prepay.get("out_trade_no");
        }
        json.put("websocket", ws);
        res.setData(json);
        res.setSuccess(true);
        res.setCode(ResultCodeEnum.SUCCESS.getValue());
        res.setMessage(ResultCodeEnum.SUCCESS.getDesc());
        return res;
    }*/


    /**
     * 异步支付结果通知地址
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/notice")
    public void notify(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.info("微信异步通知");
        try {
            JSONObject jsonObject = getResult(request);
            LOG.debug(jsonObject.toString());
            String xml = payNotice(jsonObject);
            responseToWeixin(response,xml);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error(e.getMessage(),e);
            throw e;
        }

    }

    public String payNotice(JSONObject jsonObject) throws Exception{
        //微信扫描
        String out_trade_no = jsonObject.getString("out_trade_no");
        LOG.info("订单号："+out_trade_no);
        Map<String,String> result = new HashMap<>();
        result.put("return_code", "SUCCESS");
        result.put("return_msg", "OK");
        String xml = WXPayHelper.mapToXml(result);
        /*if (out_trade_no != null && out_trade_no != "") {
            String[] order = out_trade_no.split("_");
            QueryWrapper<SoMaster> wrapper = new QueryWrapper<>();
            wrapper.eq("SOID",order[0]);
            SoMaster soMaster = soMasterService.getOne(wrapper);
            //防止支付宝多次通知
            if (soMaster.getStatus() == 4) {
                return xml;
            }
            //修改订单状态
            soMasterService.updateBySoMasterId(order[0]);
            JSONObject message = new JSONObject();
            message.put("out_trade_no", order[0]);
            message.put("msg", "success");
            //通知前端
            webSocket.AppointSending(out_trade_no, message.toString());
        }*/
        return xml;
    }

    public void responseToWeixin(HttpServletResponse response, String xml) throws Exception, IOException {
        response.setContentType("text/xml;charset=utf-8");
        if (StringUtils.isEmpty(xml)) {
            Map<String,String> result = new HashMap<>();

            result.put("return_code", "SUCCESS");
            result.put("return_msg", "OK");
            xml = WXPayHelper.mapToXml(result);
        }
        response.getWriter().write(xml);
    }

    private JSONObject getResult(HttpServletRequest request)
            throws Exception {
        InputStream inStream = request.getInputStream();
        ByteArrayOutputStream outStream = null;
        Map<String, String> map = new HashMap<String, String>();
        int buffer_size = 10240;
        if (inStream != null) {
            outStream = new ByteArrayOutputStream();
            byte[] tempBytes = new byte[buffer_size];
            int count = -1;
            while ((count = inStream.read(tempBytes, 0, buffer_size)) != -1) {
                outStream.write(tempBytes, 0, count);
            }
            tempBytes = null;
            outStream.flush();
            String result = new String(outStream.toByteArray(), "UTF-8");
            Map<String,String> data = WXPayHelper.xmlToMap(result);
            map.putAll(data);
            inStream.close();
        }
        if (outStream != null) {
            outStream.close();
        }
        JSONObject jsonObject = JSONObject.parseObject(JSON.toJSONString(map));
        return jsonObject;
    }
}
