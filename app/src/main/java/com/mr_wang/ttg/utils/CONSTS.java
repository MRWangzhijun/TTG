package com.mr_wang.ttg.utils;

/**
 * Created by MR_Wang on 2017/2/23.
 */

public class CONSTS {

    public static final  String HOST ="http://111.200.115.172:8088/groupon/CityShowServlet";

    //城市数据
    public  static final  String City_Data_URL=HOST+"/api/city";

    //数据分类
    public  static final  String Category_Data_URL=HOST+"/api/category";

    //商品列表信息
    public  static final  String Goods_Datas_URL=HOST+"/api/goods";

    //附近商品列表信息
    public  static final  String Goods_NearBy_URL=HOST+"/api/nearby";

    //登录验证的URL
    public  static final  String USER_LOGIN_URL=HOST+"/api/user?flag=login";
}
