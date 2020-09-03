package com.vueblog.payClient.response;

import com.alibaba.fastjson.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Set;

/**
 * Created by xiangmiao on 2020/8/14.
 */
@Controller
@RequestMapping("/mingteng/alipay")
public class AliPaymentResponse {

    private static final Logger LOG = LoggerFactory.getLogger(AliPaymentResponse.class);

    /*@Autowired
    WebSocket webSocket;

    @Autowired(required = false)
    AliPaymentService aliPaymentService;

    @Autowired(required = false)
    SoMasterService soMasterService;*/

    /*@RequestMapping("/pay")
    @ResponseBody
    public CommonResult pay(CommonResult res, String str) throws Exception {
        LOG.info("支付宝扫码参数:"+str);
        String prepay =  aliPaymentService.pay(str);
        LOG.info(prepay);
        JSONObject json = JSONObject.parseObject(prepay);
        JSONObject json2 = JSONObject.parseObject(json.get("alipay_trade_precreate_response").toString());
        JSONObject json3 = new JSONObject();
        json3.put("code_url", json2.get("qr_code"));
        json3.put("out_trade_no", json2.get("out_trade_no"));
        String ws = "ws://shop.anmogongfang.com/mingteng/websocket/" + json2.get("out_trade_no");
        if (System.getProperty("os.name").contains("Windows")) {
            ws = "ws://192.168.0.32:8080/mingteng/websocket/" + json2.get("out_trade_no");
        }
        json3.put("websocket", ws);
        res.setData(json3);
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
        LOG.info("支付宝异步通知");
        try {
            JSONObject jsonObject = prepare(request);
            LOG.info("支付宝通知："+jsonObject.toString());
            if ("TRADE_SUCCESS".equals(jsonObject.get("trade_status"))) {
                String result = payNotice(jsonObject);
                response.getWriter().print(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error(e.getMessage(),e);
            throw e;
        }

    }

    public String payNotice(JSONObject jsonObject) throws Exception{
        //支付宝扫描
        String out_trade_no = jsonObject.getString("out_trade_no");
        LOG.info("订单号："+out_trade_no);
        /*if (out_trade_no != null && out_trade_no != "") {
            QueryWrapper<SoMaster> wrapper = new QueryWrapper<>();
            wrapper.eq("SOID",out_trade_no);
            SoMaster soMaster = soMasterService.getOne(wrapper);
            //防止支付宝多次通知
            if (soMaster.getStatus() == 4) {
                return "success";
            }
            //修改订单状态
            soMasterService.updateBySoMasterId(out_trade_no);
            JSONObject message = new JSONObject();
            message.put("out_trade_no", out_trade_no);
            message.put("msg", "success");
            //通知前端
            webSocket.AppointSending(out_trade_no, message.toString());
        }*/
        return "success";
    }

    public JSONObject prepare(HttpServletRequest request) throws Exception {
        Map<String, String[]> params = request.getParameterMap();
        JSONObject jsonObject = new JSONObject();
        Set<String> keys = params.keySet();
        for (String key : keys) {
            jsonObject.put(key, params.get(key)[0].trim());
        }
        return jsonObject;
    }
}
