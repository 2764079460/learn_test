package com.vueblog.payClient.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by xiangmiao on 2020/8/13.
 */
public class PayKeys {

    /**
     * 支付宝商家参数
     */
    public static final String aliAppId = "2021002140655503";
    public static final String aliPrivateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCTAVJ/5hw0LVCswsWSbphK3p7d3Ueyt7pLqblJokfRsv/zhY1tpkiS1U0RsIE7oPuklA2+E0Dj8taA2b153ySFXTVQDe2NWbQANYWaS9EdUhnHd/PJGU9fOockff6QvxdteBdP175XmhBYvnFX8GCDSDKD2Ywrh50RybLtHPnfaNPp2v24hsHm6zRxZZQsPGw8kY0I5lgIL3MkC9YaB3ewAELizREt1IpLKrij+031TYfMZQGgAwlaYwHcRFs3TeJjkO+lH+BjlIhnY20ffMZI2ptTJ6PVD70PM/cESZ9K0k/ToSQ1B5O0W5pjV/C0/m4eKP8cwIcJcmeILbC76iSPAgMBAAECggEAMpac5miwwf/qKFmqlfa7L+CmeSFCIC17zbftjHptDqvzysDl55r2lJkUuYatInEGyB8vD38esJML4DGOM9dngQGPbCou2prJB91jSbLXlqh/OJZ97XFpUBMbGKLHLNal4EUYeKB83zakc3WuGZ4eCG+a+qatxvkXQ1zO1yxGjOvHN8yep6COHcwK6jv6irO0RwILKyjs0J0HCD2c/WiqSQRuVVT6p37jImk6qC36xwfcoP4ZO7/0Abi0wd0iRjWbJH11pbhd70+n6dPD8R90OXyLDX6Mp3ZF64wGdMFXpo0SyV/SfWh2nYCzo7fHbI21prKHByD1P3XQzpPpItR3uQKBgQDSGocADIuSMl8gUS/Gzw/qKI2gc1Q6WzohIreWrvR4chbGhQQB8YsgmrJ7E7GoTkCmvoAFoZVGHBck8Q8ajw42aiDuhEMjmU9dkcScaEBpylKeESpv3p9eqmMYXrU9+Mhhs8+i0AFgZ5ihZkYzmdZg8+ZPCZRcV+j/1gXqwSwOCwKBgQCzHi+DzeJmCee67Rvm0/WuzfbkIwPXn0sdklqf2FfeBV1I/oYfYfRou4KXhBblpks792ZZfn0z7cZ7mY+sYtO9+dytfer8p5vXYEnPWttFnHpW1vnaTPf/enxTvyISEZc5XYEecetme2kpXKbSVxDTKwH0t/HC6uSP7k7HXgMKDQKBgDO6Ejih3g7tVdw4AMI6olltCIlTO45ufV5BFOAFTO0GcbMIdpcf57fsPjrs+1VLhsFGr3AzevPa4JvYuXY5eC9Pa7ItX/Y4vYB07enwBMPG6xY9daw7LBN7cZBDaO3L/VGImnskKOKaPsqlymzT2CLgiXg2DI+7mQK7p5NHYdhHAoGBAKIePxlH3pNGgdQBSdC5pdPKnZzNSGv/xGgGkDm/AYB1UIKBxHlhGms01DU5G9RNmCi1epCj2MSIgK5cRdrcNBPts9vfbTGyrm3Yu9WOwYoW3+/7cXcxVQGKJj9Sbo72Fu6YAAbDSzGdn4gNUPxuS08lzQZm+s3V9nuDURBHue59AoGBAMMoaR/jLfOrs/q3mTgt+woArfBFwDrpZ50u6BQG/AtxwTWaag6S9CyXd5pW72gdivb+t2nTrTuUi1k8xseZI25GWAP8oc0/tO1ytN//4S2CmxLTqssTO9Q9wqmkJSIAHwX7OsXZUgA5mDtI8jJyak/6RYODINPW4Rh7ySsJLsT+";
    public static final String aliPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyNz9D07npCAktAQBtR3ojdwREjf2SWwVcqLIyr/9mlbydNOlqFUv++GYdR6hX/L+MnLWvdd0nerhk0ZPTHPn2wdC7CWEgHM10GaQy6PVZVJJUW2931q1Lsv/4UHsJ51AovRFaf757xiVXnFZQnB+kA/obztZ3zSz4e9u5IAC1rPQJWEprqFtnGNJxQWf+8nbkJn7aWdzOvBh8KLFi3kl6qq/kTYepzFk7zNjkp1vNNpWu4HxEODKigKAfSP5C+w2u3iQ8biRkJriVw/ghSess3Gq9lflWgGrHbNCXG0IBFHqttIJ23JTuh/mrSftNRTaEVh2eUVy52FuUSc3/J4/cQIDAQAB";
    //沙箱
    public static final String aliAppId2 = "2016102200735052";
    public static final String aliPublicKey2 = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiHV4+vKS9uPduczOaEs5wGoxqwAsNx5IAW0EL6D0Y8Jb04eQ+AJZP9ZdSqroDsi5yMOaMTFZqwK0S/lVIucJyEutj6OQBBv9RofL5zypCOZrg7CCOeZSfkbQ4ymVZ2OPr17w0kAgh1nCXrLG764oJ9zqpwGt7eQnLBt4aU3i0M0dSiNEAnw+AmWbqHB6LFiP5lVM/jDsxRCZYdpJAkQA9naVBKdiH6BDbzwcSfiB9WLHCwPqB73ZR1syG+85RQV5sAoBPbv1FB5C+7lyw+jNqw2eAQGiNsiuXHTCkURFfvBgivJ1SrhPuNUbNCqFfmq+RYN9r2K0zNczs2xmKDz3hQIDAQAB";

    /**
     * 微信商家参数
     */
    public static final String wxAppId = "wx141fc0353520a43a";
    public static final String wxMchId = "1601849074";
    public static final String wxMchKey = "MingTengHealthweixinPay20200814Z";
    public static final String wxSandboxMchKey = "dea3d3030f9c199e80473a162370f401";
    public static final String wxkeyPath2 = "D:\\\\cert\\\\wechat\\\\cert_1601849074_mingteng\\\\apiclient_cert.p12";
    public static final String wxkeyPath = "/opt/cert/apiclient_cert.p12";

    //公众号
    public static final String gzhToken = "111111111111111111111sdadasda";

    //access_token
    public static String gzhAccessToken = "";

    public static Map<String, Object> couponInfoMap = new ConcurrentHashMap<>();


    //税号
    public static final String invoice = "91320982MA1XWF9D8R";
    //public static final String invoice = "500102000000159";
    //开票机号
    public static final String kpjh = "667001737448";
    //public static final String kpjh = "100004781600100F6200";
    //开票成功响应
    public static final String invoiceCallBack = "/mingteng/invoice/callBack";
    //初始化开票方信息
    public static final String invoiceRegister = "http://ek.caikaixin.cn/register";
    //系统提交开票请求
    public static final String invoiceSendFpInfo = "http://ek.caikaixin.cn/sendFpInfo";
    //返回开票二维码url
    public static final String invoiceSendRequest = "http://ek.caikaixin.cn/sendRequest";
    //项目存储发票token(单机)
    public static String invoiceToken = "";


    //pos机秘钥jiangsumingtengyiliaoqixiegongsi
    public static final String posKey = "jiangsumingtengyiliaoqixiegongsi";
}
