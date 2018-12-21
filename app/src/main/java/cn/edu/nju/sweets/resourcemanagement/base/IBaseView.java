package cn.edu.nju.sweets.resourcemanagement.base;

public interface IBaseView<T> {
    // 规定View必须要实现setPresenter方法，则View中保持对Presenter的引用。
    void setPresenter(T presenter);

    /**
     *  显示进度
     */
    void showLoading();

    /**
     *  隐藏进度
     */
    void hideLoading();


    //Toast形式提示
    public void showToast(String msg);




}