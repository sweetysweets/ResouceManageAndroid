package cn.edu.nju.sweets.resourcemanagement.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public abstract class BaseActivity extends AppCompatActivity {


    /***封装toast对象**/
    private static Toast toast;
    /***获取TAG的activity名称**/
    protected final String TAG = this.getClass().getSimpleName();
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置布局
        setContentView(intiLayout());
        //初始化控件
        initView();
        //设置数据
        initData();
    }

    /**
     * 设置布局
     *
     * @return
     */
    public abstract View intiLayout();

    /**
     * 初始化布局
     */
    public abstract void initView();

    /**
     * 设置数据
     */
    public abstract void initData();

    /**
     * 设置标题栏
     *
     * @return
     */
    public abstract void setTitle(String title);



//    /**
//     * 显示长toast
//     * @param msg
//     */
//    public void toastLong(String msg){
//        if (null == toast) {
//            toast = new Toast(this);
//            toast.setDuration(Toast.LENGTH_LONG);
//            toast.setText(msg);
//            toast.show();
//        } else {
//            toast.setText(msg);
//            toast.show();
//        }
//    }

//    /**
//     * 显示短toast
//     * @param msg
//     */
//    public void toastShort(String msg){
//        if (null == toast) {
//            toast = new Toast(this);
//            toast.setDuration(Toast.LENGTH_SHORT);
//            toast.setText(msg);
//            toast.show();
//        } else {
//            toast.setText(msg);
//            toast.show();
//        }
//    }

}
