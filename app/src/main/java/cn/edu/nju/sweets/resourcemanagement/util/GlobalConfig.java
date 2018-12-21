package cn.edu.nju.sweets.resourcemanagement.util;

import android.os.Environment;

import java.io.File;

public class GlobalConfig {

    /**
     * 服务器ip地址
     */
//   public static final  String HOSTIP="47.75.196.92";
    public static final  String HOSTIP="192.168.3.101";
    //   public static final  String HOSTIP="115.28.33.208";

    /**
     * 超时时间
     */
    public static final int TIMEOUT = 30000;
    /**
     * 服务器基础网址
     */
    //public static final String HOST URL = "http://115.28.33.208:8080/MinLanApp/";
    public static final String HOSTURL = "http://"+HOSTIP+":8080/MinLanApp/";

//    public static final String LOCALURL = "http://192.168.10.8:8080/MinLanApp/";
//    public static final String LOCALURL = "http://192.168.10.8:8080/MinLanApp/";


}
