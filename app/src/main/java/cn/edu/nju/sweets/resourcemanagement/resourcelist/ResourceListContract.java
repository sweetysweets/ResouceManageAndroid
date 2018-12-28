package cn.edu.nju.sweets.resourcemanagement.resourcelist;

import cn.edu.nju.sweets.resourcemanagement.base.IBaseModel;
import cn.edu.nju.sweets.resourcemanagement.base.IBasePresenter;
import cn.edu.nju.sweets.resourcemanagement.base.IBaseView;
import cn.edu.nju.sweets.resourcemanagement.login.LoginPresenter;

public interface ResourceListContract {

    interface IResourceListPresenter extends IBasePresenter {
        void onGetListSuccess();
        void onGetLisError();


    }

    interface IResourceListView extends IBaseView<LoginPresenter> {

    }

     interface IResourceListModel extends IBaseModel {
//         void getList(IResourceListPr
// esenter onGetResourceListener);
     }

}
