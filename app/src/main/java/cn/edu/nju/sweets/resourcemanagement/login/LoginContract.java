package cn.edu.nju.sweets.resourcemanagement.login;

import cn.edu.nju.sweets.resourcemanagement.base.IBaseModel;
import cn.edu.nju.sweets.resourcemanagement.base.IBasePresenter;
import cn.edu.nju.sweets.resourcemanagement.base.IBaseView;

public interface LoginContract{

    interface ILoginPresenter extends IBasePresenter {

        public void onVaildateFailure();
        public void onSuccess();
        public void onFailure();

    }

    interface ILoginView extends IBaseView<LoginPresenter> {

        String getUserId();
        String getPassword();
        String getPhone();
    }

     interface ILoginModel extends IBaseModel {
         void login(String username,String password,ILoginPresenter onLoginListener);
     }

}
