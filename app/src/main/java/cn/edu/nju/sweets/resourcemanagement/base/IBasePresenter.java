package cn.edu.nju.sweets.resourcemanagement.base;

public interface IBasePresenter<V extends IBaseView> {

//    M mIModle;
//    V mIView;
//
//    public void attachV(V v){
//        this.mIView = v;
//        if (mIModle == null) {
//            mIModle = createModel();
//        }
//    }
//
//    //当View被销毁掉时删除Presenter层对View层的引用
//    public void detachV(){
//        mIView = null;
//    }
//
//    abstract M createModel();

    /**
     * presenter和对应的view绑定
     * @param mvpView  目标view
     */
    void attachView(V view);
    /**
     * presenter与view解绑
     */
    void detachView();
}