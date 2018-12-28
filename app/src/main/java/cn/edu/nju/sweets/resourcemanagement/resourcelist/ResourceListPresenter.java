package cn.edu.nju.sweets.resourcemanagement.resourcelist;

import java.util.List;

import cn.edu.nju.sweets.resourcemanagement.base.IBaseView;

public class ResourceListPresenter implements ResourceListContract.IResourceListPresenter {

    private ResourceListFragment resourceListView;
    private ResourceListModel resourceListPort;
    public ResourceListPresenter(ResourceListFragment resourceListView){
        this.resourceListView = resourceListView;
        resourceListPort = new ResourceListModel();
    }



    public List<Rows> getResourceList(int curPage, int pageSize){
       return resourceListPort.getList(curPage,pageSize);
    }
    @Override
    public void onGetListSuccess() {

    }

    @Override
    public void onGetLisError() {

    }

    @Override
    public void attachView(IBaseView view) {

    }

    @Override
    public void detachView() {

    }
}
