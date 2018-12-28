package cn.edu.nju.sweets.resourcemanagement.login;

import cn.edu.nju.sweets.resourcemanagement.base.IBaseView;

public class LoginPresenter implements LoginContract.ILoginPresenter {

    private LoginModel loginPort;//登录接口
    private LoginActivity loginView;//登录veiw
    //实例化登录接口和登录view
    public LoginPresenter(LoginActivity loginView){
        this.loginView = loginView;
        loginPort = new LoginModel();
    }
    /**
     * 将从view层中获取的用户名和密码传送给Model层
     * 然后让activity中的登录按钮调用此方法
     */
    public void login(){
        String username = loginView.getUserId();
        String password = loginView.getPassword();
        loginPort.login(username,password,this);
    }
    @Override
    public void onVaildateFailure() {
        loginView.showToast("用户名或者密码错误");
    }
    @Override
    public void onSuccess() {
        loginView.showToast("登录成功！");
        loginView.jumpActivity();
    }
    @Override
    public void onFailure() {
        loginView.showToast("异常错误！");
    }


    @Override
    public void attachView(IBaseView view) {

    }

    @Override
    public void detachView() {

    }
}
