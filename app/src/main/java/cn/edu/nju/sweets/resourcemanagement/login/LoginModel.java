package cn.edu.nju.sweets.resourcemanagement.login;

import android.os.AsyncTask;

public class LoginModel implements LoginContract.ILoginModel{
    @Override
    public void login(String username, String password, LoginContract.ILoginPresenter onLoginListener) {

        if(username.equals("admin")&&password.equals("123456")){
            onLoginListener.onSuccess();//登录成功
        }else if(!username.equals("admian")||!password.equals("123456")){
            onLoginListener.onVaildateFailure();//用户名或者密码错误
        }else {
            onLoginListener.onFailure();//登录失败
        }

    }

}
