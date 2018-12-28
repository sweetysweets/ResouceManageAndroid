package cn.edu.nju.sweets.resourcemanagement.util;

import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import retrofit2.Retrofit;

/**
 * 保存一些程序生命周期内需要保持的配置及工具信息
 */
public class GlobalConfig {

    private static IHttpService mService;

    /**
     * 服务器ip地址
     */
//   public static final  String HOSTIP="47.75.196.92";
    public static final  String HOSTIP="192.168.3.101";

    /**
     * 超时时间
     */
    public static final int TIMEOUT = 30000;
    /**
     * 服务器基础网址
     */
    public static final String HOSTURL = "http://"+HOSTIP+":8080/MinLanApp/";

    private static void initRetrofit() {
        //创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(GlobalConfig.HOSTURL)
                .build();

        //创建访问API的请求
        mService = retrofit.create(IHttpService.class);
    }


    public static IHttpService getHttpService() {
        if (mService==null){
            initRetrofit();
        }
        return mService;
    }
}
