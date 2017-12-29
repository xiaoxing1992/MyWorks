package motoband.com.motobands.model.http.api;

/**
 * 配置
 * Created by Eric on 16/3/15.
 */
public class Constants {

    /*-----环境地址-----*/
    // 生产环境
    public static final String MOTOBAND_SERVICE_URL = "https://service.motuobang.com/";
    /*-----腾讯云TLS-----*/
    public static final int kTLSAppid = 1400025196;
    public static final int kSdkAccountType = 2440;

    // 测试环境
//    public static final String MOTOBAND_SERVICE_URL = "http://123.206.24.130:8080/";
//    /*-----腾讯云TLS-----*/
//    public static final int kTLSAppid = 1400025315;
//    public static final int kSdkAccountType = 2440;

    // 方和斌
//    public static final String MOTOBAND_SERVICE_URL = "http://192.168.50.54:8080/";
//    /*-----腾讯云TLS-----*/
//    public static final int kTLSAppid = 1400025315;
//    public static final int kSdkAccountType = 2440;

    // 鹏哥
//    public static final String MOTOBAND_SERVICE_URL = "http://192.168.50.213:8080/";
//    /*-----腾讯云TLS-----*/
//    public static final int kTLSAppid = 1400025315;
//    public static final int kSdkAccountType = 2440;

    /**********************************************************************************************/

    /**
     * 动态分享URL
     */
    public static final String MOTOBAND_DYNAMIC_URL = "http://web.motuobang.com/motoweb/news/index?nid=";

    public static final String MOTOBAND_RUN_URL = "http://www.motuobang.com/run.html?runid=";

    public static final String MOTOBAND_URL = "http://www.motuobang.com";

    /**
     * 问答分享URL
     */
    public static final String SHAREURL_DISCUSS = "http://web.motuobang.com/motoweb/news/discuss?discusskeyword=";

    /**
     * 二手车分享URL
     */
    public static final String SHAREURL_SECONDCAR = "http://web.motuobang.com/motoweb/secondcar/getsecondcarbyid?secondcarid=";

    // 个人名片二维码
    public static final String MOTOBAND_UID_URL = "http://www.motuobang.com/user.html?uid=";

    // 存储注册时所在国家，国家码
    public static final String COUNTRY_CODE = "86";

    // 客户端类型 2为Android
    public static final String CTYPE = "2";

    //Bugly AppID
    public static final String BUGLY_APPID = "900022401";
//    public static final String BUGLY_APPKEY = "Rk9N97VmWt1d8T5B";

    /**
     * 信鸽
     */
    public static final String XG_V2_ACCESS_ID = "2100242637";
    public static final String XG_V2_ACCESS_KEY = "AB66R9WX29SV";

    /**
     * 小米Push
     */
    public static final String XiaoMiPush_APPID = "2882303761517454869";
    public static final String XiaoMiPush_APPKEY = "5941745497869";
    // 将离线推送相关证书上传到腾讯云的时候分配的ID
    public static final long XiaoMiPush_BUSSID = 482;

    /**
     * 华为Push
     */
    // 将离线推送相关证书上传到腾讯云的时候分配的ID
    public static final long HuaWeiPush_BUSSID = 483;

    /**
     * 阿里百川
     */
    public static final String ALIBC_APPKEY = "23578060";

    /**
     * 科大讯飞
     */
    public static final String KDXF_APPID = "=572dc6c2";

    /**
     * 有赞
     */
    public static final String YOUZAN_CLIENTID = "5f7d5616a9f8abfddd";

    /*-----数据库-----*/
    /**
     * 2.5.
     */
    public static final int DATABASE_VERSION = 28;
    /**
     * 2.6.0
     */
    public static final int DATABASE_COMMON_VERSION = 2;
    public static final String DATABASE_COMMON_NAME = "mbcommon.db";

    /*-----微信-----*/
    public static final String WECHAT_AppID = "wxecd59a3fde347acc";
    public static final String WECHAT_AppSecret = "07ee9471c4b576f2caf8e1c794e8cc34";

    /*-----QQ-----*/
    public static final String QQ_AppID = "1105134212";
    public static final String QQ_AppKEY = "JHrtr6kqXlkHAbTs";

    /*-----微博-----*/
    public static final String Sina_AppID = "985069388";
    public static final String Sina_AppKEY = "1ccb3d44410063dd470acf336ad79b0d";

    /*-----万象优图-----*/
    public static final int PicCloud_AppId = 10013836;
    public static final String PicCloudBucket_User = "mbuser";
    public static final String PicCloudBucket_Garage = "garage";
    //    public static final String PicCloudBucket_Rideline = "rideline";
    public static final String PicCloudBucket_RidelineData = "ridelinedata";
    //    public static final String PicCloudBucket_Mbnews = "mbnews";
    public static final String PicCloudBucket_RouteBook = "routebook";
    public static final String PicCloudBucket_MLocation = "mlocation";
    public static final String PicCloudBucket_Insurance = "insurance";
    public static final String PicCloudBucket_News2 = "news2";
    public static final String PicCloudBucket_Business = "business";
    public static final String PicCloudBucket_ShortVideo = "shortvideo";

    /**
     * 图片宽高比
     */
    public static final float PIC_MAX_WH_RATIO = 2;// 最大宽高比
    public static final float PIC_MIN_WH_RATIO = 0.5f;// 最小宽高比
    public static final float PIC_MAX_HW_RATIO = 1.2f;// 最大高宽比
    public static final int PIC_NEWS_VIDEO_WIDTH = 145;// NEWS:PIC/VIDEO图片宽

    /**
     * 推荐的人位置
     */
    public static final int RECOMMEND_USER_LOCATION = 6;

    /*-----故事最小长度-----*/
    public static final int STORY_MIN_LENGTH = 3;

    /*-----集结人数-----*/
    public static final int Rally_MaxMembers = 30;

    /*-----商家搜索每页数量-----*/
    public static final int BUSINESSSEARCH_LIMIT = 20;

    /*-----二手车搜索每页数量-----*/
    public static final int SECONDCARSEARCH_PAGESIZE = 20;
    /*-----二手车相关推荐每页数量-----*/
    public static final int SECONDCARRECOMMEND_PAGESIZE = 5;

    public static final int SECONDCARPUBLISH_PIC_COUNT = 9;

    /*-----广告数-----*/
    public static final int ADPOOL_COUNT_SINGLE = 1;
    public static final int ADPOOL_COUNT_MULTIPLE = 5;
    /*-----广告位置-----*/
    public static final int AD_INSERT_SPACE_THREE = 6;
    public static final int AD_INSERT_SPACE_SIX = 9;
    public static final int AD_INSERT_SPACE_NINE = 9;

    /*----超时----*/
    public static final double ExpireTime_GetUserProfile = 60 * 60 * 0.5 * 1000;
    public static final double ExpireTime_GetRideData = 60 * 60 * 0.5 * 1000;
    //    public static final double ExpireTime_GetFriendList = 60 * 60 * 0.5 * 1000;
    public static final long ExpireTime_RefreshRank = 10 * 60 * 1000;
    // 广告刷新时间间隔
//    public static final int AD_REFRESH_TIMESAPN = 60 * 60 * 1000;

    public static final String SMS_CONTENT = "我刚刚在摩托邦炫了一次骑行动态，没谁了，你一定要看看！下载地址>> http://dwz.cn/3cLei7";

    // 邦帮保
    public static final String INSURANCE = "http://www.motuobang.com/insurance/insurance.html";
    //安心骑
    public static final String ANXINQI = "https://open.zhongan.com/promote/entrance/promoteEntrance.do?promotionCode=INST160840805002&redirectType=h5";
    //维权
    public static final String WEIQUANXIAN = "https://open.zhongan.com/promote/entrance/promoteEntrance.do?promotionCode=INST160857826002&redirectType=h5";
    // 保险服务说明
    public static final String INSURANCE_SERVICE = "http://www.motuobang.com/insurance/service_insurance.html";
    // 保险公司介绍
    public static final String INSURANCE_YINGDA = "http://www.motuobang.com/insurance/yingda_insurance.html";
    //淘车
    public static final String TAO_CHE = "http://www.motuobang.com/buymoto/buymoto.html";
    // 卖车
    public static final String MAI_CHE = "http://www.motuobang.com/salemoto/salemoto.html";
    //招商
    public static final String ZHAO_SHANG = "http://www.motuobang.com/zhaoshang/zhaoshang.html";
    // 摩托邦担保交易
    public static final String SECONDCAR_DANBAO = "http://www.motuobang.com/motoservice/motoservice.html";

    /**
     * 神圣车行
     */
    // UA
    public static final String MOTOBAND_UA_EXTRA = "motoband";
    // 商店
    public static final String MOTOBAND_SHOP = "http://mall.motuobang.com/?mobile=&preview_theme_id=26215";
    //金融分期贷款付款
    public static final String FINANCING_URL = "http://www.motuobang.com/fenqi/finance_fenqi.html";
    public static final String FINANCING_PDFURL = "http://finance-10013836.cos.myqcloud.com/%E6%91%A9%E6%89%98%E9%82%A6%E8%B4%B7%E6%AC%BE%E7%94%B3%E8%AF%B7%E8%A1%A8.pdf";
    // QQ群的key  群号：(423711595)
    public static final String MOTOBAND_QQ_GROUP = "J4qcSwLqviBKksx3OIp2niwo0biVeqGM";
    // QQ客服
    public static final String MOTOBAND_QQ_SERVICE = "2826615697";
    // 有赞商城
    public static final String MALLYOUZAN = "https://h5.youzan.com/v2/showcase/homepage?alias=1ar2dpl8z";
    // 使用帮助
    public static final String MOTOBAND_FAQ = "http://www.motuobang.com/faq/faq.html";
    // 服务协议
    public static final String TERMSSERVICE = "http://www.motuobang.com/terms/termsservice.html";

    // 部落管理员申请
    public static final String BULUO_SHENQING_URL = "http://www.motuobang.com/buluoshenqing/shenqing.html";

    /**
     * 积分规则连接
     */
    public static final String CREDIT_RULE = "http://motoband.com/creditrule.html";

    /**
     * 有赞商城个人中心
     */
    public static final String YOUZAN_USERCENTER = "https://h5.youzan.com/v2/showcase/usercenter?alias=10b3rfz8q";

    /**
     * ServiceConfig
     */
//    public static final String ServiceConfigKey_ProductPicURL = "productpic";
//
//    public static final String ServiceConfigKey_ActivitiyCount = "activitiesCount";
//    public static final int DefaultCount_ActivitiyCount = 5;

//    public static final String ServiceConfigKey_UserHobbyCount = "userhobbycount";
//    public static final int Default_UserHobbyCount = 20;

    public static final String ServiceConfigKey_SplashADTime = "splashadtime";
    public static final int Default_SplashADTime = 12 * 60 * 60;// （单位：秒）

    public static final String ServiceConfigKey_LoopADTime = "loopadtime";
    public static final int Default_LoopADTime = 24 * 60 * 60;// （单位：秒）

    public static final String ServiceConfigKey_MissUserRadius = "searchradius";
    public static final int Default_MissUserRadius = 250;// （单位：米）

    public static final String ServiceConfigKey_MissUserTimeRange = "searchtime";
    public static final int Default_MissUserTimeRange = 900;// （单位：秒）

    public static final String ServiceConfigKey_MissUserDistanceSpan = "searchdistance";
    public static final int Default_MissUserDistanceSpan = 250;// （单位：米）

    public static final String ServiceConfigKey_SearchProductDefault = "search_product_default";

    /**
     * 正则：手机号（简单）
     */
    public static final String REGEX_MOBILE_SIMPLE = "^[1]\\d{10}$";
    /**
     * 正则：手机号（精确）
     * <p>移动：134(0-8)、135、136、137、138、139、147、150、151、152、157、158、159、178、182、183、184、187、188</p>
     * <p>联通：130、131、132、145、155、156、175、176、185、186</p>
     * <p>电信：133、153、173、177、180、181、189</p>
     * <p>全球星：1349</p>
     * <p>虚拟运营商：170</p>
     */
//    public static final String REGEX_MOBILE_EXACT = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|(147))\\d{8}$";

    /**
     * 正则：邮箱
     */
    public static final String REGEX_EMAIL = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";

    /**
     * 服务器公钥
     */
    public static String servicePublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCc/zxMr6rd/OkHV5j62iMZtKSOwSr0M9WixetzWLFK8AMnZGYKGo+X1BkoEWOK/vKMUK9FqTXioZfyKlGDsmwWzWxUjCo7HA5LvCkKzVni0Uv54+MvoFNAYfH0G6EXqdHn1rCCHGGCROZzyV1MrZ+EFroIJkwLMcJ7G3NWrDq6RQIDAQAB";

    /**
     * 客户端私钥
     */
    public static String clientPrivateKey = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAJ23+SwoKvJ0BJtPGnZ1YyzNeWwwS1DRicPst3ok2Iz2EjQj4Ur43DRHEYKOr4NrNAFYt629ol3SgQ+/wc4F5R+xprA6bcdUWErwCLZgySdhsWDlHISj/RGMLts1Kv985pJPlMQ35v05Ux6r6MwbaLGdWUlbhsoohviPpuId38A3AgMBAAECgYBU5qc0dP8BeyDLth5prDFR+d4mNi0k+Vcu5+uwzcrgvsn31WS+5g4r+iHb5RFoLjpVizt9RHr2BI5DOxeJ3zSCLXVn2CZYnkoNgJnf1ZW6fv1/LqKvlA6Rf9np/UdACNC9FFw4dqoXNWP2GZlPD1yuCYdWWS9fckygyOgm1IyQ4QJBANV4EVwffOa3p1QZ3LWAQumv/NTUpmS5iqmv60UgzyncC5TiGlEfQwDDZEREWxGlleH/WFkiS7KrMgwKSVw2tTECQQC9JF9OIE7v55+E3K8qLmnB00SGsTrp63G1GLeILTadgEjaV1BJB0QII1ITLoFNXXMvWZ+ATvAR0hZleeX3mhHnAkEApXhx9HgQCIPZ+A4oEKVAuQaLNKs15CQTAV/1PlulWixQ6fKuNa3G8WOEaIqYEUDKwyl84XL9PJ0JqV2b6hgaMQI/OaDbaPJvGql38QNMW43Iq0Wzm1ZknOEfxA3D3bno6hQsHlp8G8Qa9l/MoguJWgkfD04/StjCTKu2JzT83HQVAkB87LIZax1bga8vux38vV/wXAF7bMzQqwXV8xrQ+JgFrlqrtNjMs3NLHlGVsjjO+CXX/rK5fEEazcy2yNhY2b8p";

    /**
     * 登录服务器公钥
     */
    public static String loginServicePublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCE6UtC/XHpXXGnYhqZO85zJSLHkwEILIr83DouPAfIxShFC8FnMeNoLUDt6KptKWnqp5Z8bFwVz6cIdoLBVihJrLXZ+0ZqdKyMttP7C4TDA5zTgrC15/Q11xdTRAemQkBEeEy+svyvwTUDeXfkh2Hy7a2PlsxgxAy59JKkXy+4dQIDAQAB";

    /**
     * 登录客户端私钥
     */
    public static String loginClientPrivateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJRM2wXk4muMWAErvOx94oJt0fdfZBq4KO7mmGpxwQbhEzFzNElgTJxNYVk9nOuOpiXiBt6RIGPgAaTU5aSaB+qjr7Hd+mkipEr9Ydh+EWZnTbwSwDqfZk8WLriJBjklO4BiFlslfakoVWVkvOSlZeCFp9uM6dc0UhlPd3xZGPo9AgMBAAECgYEAhe3Kt033tUzvhU8stR8S2tu3DYJWc1LxlJ8n8ql8u2u026nBBKs1RMsVKXTdLFaNchToQ0QpTklU8rlaEwcQMdGIWTrLwqeiCuM8yy6vl2R1h8rH8YUdEtTWzONlgqZsHPqMrd/CwFhUK235eG0gGnQ/xvCLP4h0lvI+gc6IvfkCQQDh9ahkF8Bz1es1lALsShfBUJebJa+ocYufCPuLvSQLe1NCJ1YDKkw+plGFAXRFihYamjo+W9DoMNm1Vg2e6v5XAkEAqAQgfZwLsVILStH3rDhqKoE8yqbIQkimSXks5Nh1dgHNkzA38A3CTY3O4BmrU4vcL2fcQFUNAMF/Gmw56QeHiwJAIk8prWEJ4MzHdRAvTW+Gody52F3liR8Mgy5a+4HRmki0gKP2ZG6kuxKH6DkrTW/FIW7vjw5j7w2T0Pvq/4lQ6wJAelQm482Npdk6Z4tgbH/WrIPUIygzfi8vAye6zBPd0cGWT6g30gvygEzTZs7JstaNxeY0spI6GWbIiBBsSYI16QJAY3AJwl50j46Dsi4bTvqYpvvhM1hv4KI9+rQXWANp3a0SE6s1oXSvUDK19R9xCX2RysmiqCCiKYACLFFsjxGWFA==";

    /**
     * 支付支付渠道
     */
    public static final String CHANNEL_ALIPAY = "alipay";

    /**
     * 微信支付渠道
     */
    public static final String CHANNEL_WECHAT = "wx";

    /**
     * 通知栏进入
     */
    public static final String EXTRA_BUNDLE = "launchBundle";

    /**
     * 分享
     */
    public static final String shareContent = "摩托车狂热爱好者的乌托邦，最好的骑士都在这里！http://www.motuobang.com/share.html";
    public static final String shareContentTitle = "和你一起记录骑行精彩！";
    public static final String shareUrl = "http://www.motuobang.com/share.html";

    public static final String BEST_BOX_STORY_690_322 = "?imageMogr2/crop/690x322";
    public static final String BANNER_640_299 = "?imageMogr2/thumbnail/640x299";
    public static final String NEWS_DISCUSS_TOPIC_640X = "?imageMogr2/thumbnail/640x";
    public static final String IMAGE_USED_CAR_DETAIL_CROP = "?imageMogr2/crop/640x444";
    public static final String THUMB_IMAGE = "!thumb";

    /**
     * 是否有赞链接
     */
    public static final String YOUZAN_LINK_CONTAINS = "youzan.com";

    /**
     * 版本不支持图片
     */
    public static final String NEWS_SORRY = "http://libres-10013836.cos.myqcloud.com/newssorry.jpg";
}
