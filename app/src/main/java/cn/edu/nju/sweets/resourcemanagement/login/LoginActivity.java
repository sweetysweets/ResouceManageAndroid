package cn.edu.nju.sweets.resourcemanagement.login;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.edu.nju.sweets.resourcemanagement.R;
import cn.edu.nju.sweets.resourcemanagement.home.HomeActivity;

public class LoginActivity extends Activity implements LoginContract.ILoginView,View.OnLayoutChangeListener {

    private LoginPresenter loginPresenter;

    @BindView(R.id.iv_login_logo)
    ImageView iv_login_logo;
    @BindView(R.id.et_login_user_id)
    EditText userId;
    @BindView(R.id.et_login_password)
    EditText password;
    @BindView(R.id.et_login_phone)
    EditText et_login_phone;
    @BindView(R.id.et_login_code)
    EditText et_login_code;
    @BindView(R.id.ll_login_warning)
    LinearLayout ll_login_warning;
    @BindView(R.id.bt_login_getcode)
    Button bt_login_getcode;

    @BindView(R.id.tv_login_wraning)
    TextView tv_login_wraning;


    @BindView(R.id.bt_login_submit)
    Button bt_login_submit;
    @BindView(R.id.ll_login_root)



    LinearLayout activityRootView;//需要操作的布局
    @BindView(R.id.ll_login_logobg)
    LinearLayout ll_login_logobg;
    private int screenHeight = 0;//屏幕高度
    private int keyHeight = 0; //软件盘弹起后所占高度
    private Matcher phone_num;
    private Pattern phonenumber;
    private ProgressDialog progressDialog;
    private Handler handler;


    final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View root = LayoutInflater.from(this).inflate(R.layout.activity_login_v2, null);
        ButterKnife.bind(this, root);
        setContentView(root);
        loginPresenter = new LoginPresenter(this);
        screenHeight = this.getWindowManager().getDefaultDisplay().getHeight();//获取屏幕高度
        keyHeight = screenHeight / 3;//弹起高度为屏幕高度的1/3
        bt_login_submit.setClickable(false);



        et_login_phone.addTextChangedListener(new TextWatcher() {//为edittext添加文本改变监听，根据是否有文本输入更改确认按钮的背景颜色
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void afterTextChanged(Editable editable) {
                if (!et_login_phone.getText().toString().equals("")){
                    bt_login_submit.setClickable(true);
//                    bt_login_submit.setBackgroundResource(R.drawable.login_button);
                }else {
                    bt_login_submit.setClickable(false);
//                    bt_login_submit.setBackgroundResource(R.mipmap.login_button_gray);
                }
            }
        });


    }



    @Override
    public String getUserId() {
        return userId.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return password.getText().toString().trim();
    }

    @Override
    public String getPhone() {
        return null;
    }

    @Override
    public void setPresenter(LoginPresenter presenter) {
        loginPresenter = new LoginPresenter(this);

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void jumpActivity() {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra("link", "test");
        startActivity(intent);
    }


    @OnClick(value = {R.id.bt_login_submit, R.id.bt_login_getcode})
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.bt_login_submit://确认按钮事件
//                if (!CheckPhone(et_login_phone).matches()) {//判断手机号格式
//                    ll_login_warning.setVisibility(View.VISIBLE);
//                    tv_login_wraning.setText("手机号码格式不正确");
//                } else if (!et_login_code.getText().toString().equals("000")) {//验证码判断，为方便测试设置了默认值
//                    ll_login_warning.setVisibility(View.VISIBLE);
//                    tv_login_wraning.setText("验证码不正确");
//                } else {//条件全部满足，开始登陆
//                    ll_login_warning.setVisibility(View.GONE);
//                    progressDialog.setMessage("正在登录…");
//                    progressDialog.show();//弹出加载对话框
//                    handler.postDelayed(new Runnable() {//设置一个1s的延时操作模拟登陆的过程
//                        @Override
//                        public void run() {//登陆成功关掉对话框，跳转页面，关掉本页
//                            progressDialog.dismiss();//不能用hide
////                            Intent intent=new Intent(LoginActivity.this, HomeActivity.class);
////                            startActivity(intent);
////                            LoginActivity.this.finish();
//                        }
//                    },1000);
//
//                }
                loginPresenter.login();
                break;
            case R.id.bt_login_getcode:
                Log.e(TAG,"onClickCode");
                if (CheckPhone(et_login_phone).matches()) {//手机号正确则获取验证码，开启倒计时
                    ll_login_warning.setVisibility(View.GONE);
//                    bt_login_getcode.setBackgroundResource(R.mipmap.login_button_gray);
//                    timeCountUtils.start();
                } else {
                    ll_login_warning.setVisibility(View.VISIBLE);
                    tv_login_wraning.setText("手机号码格式不正确");
                }
                break;
        }
    }


    public Matcher CheckPhone(EditText editText) {//判断手机号格式
        phonenumber = Pattern
                .compile("^[1][3-8][0-9]{9}$");
        phone_num = phonenumber.matcher(editText.getText()
                .toString());
        return phone_num;
    }







    @Override
    protected void onResume() {
        super.onResume();
        activityRootView.addOnLayoutChangeListener(this);//给需要操作的布局设置监听
    }

    /**
     * 实现软键盘抬起后logo动态变小
     * @param v
     * @param left
     * @param top
     * @param right
     * @param bottom
     * @param oldLeft
     * @param oldTop
     * @param oldRight
     * @param oldBottom
     */
    @Override
    public void onLayoutChange(View v, int left, int top, int right,
                               int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
       /* old是改变前的左上右下坐标点值，没有old的是改变后的左上右下坐标点值
        现在认为只要控件将Activity向上推的高度超过了1/3屏幕高，就认为软键盘弹起*/
        if (oldBottom != 0 && bottom != 0 && (oldBottom - bottom > keyHeight)) {
            ViewGroup.LayoutParams params = iv_login_logo.getLayoutParams();//获取布局，设置键盘弹起后logo的宽高
            params.height = 300;
            params.width = 300;
            iv_login_logo.setLayoutParams(params);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ll_login_logobg.getLayoutParams());
            lp.setMargins(0, 80, 0, 30);//设置包含logo的布局的位置
            ll_login_logobg.setLayoutParams(lp);
        } else if (oldBottom != 0 && bottom != 0 && (bottom - oldBottom > keyHeight)) {//键盘收回后，logo恢复原来大小，位置同样回到初始位置
            ViewGroup.LayoutParams params = iv_login_logo.getLayoutParams();
            params.height = 480;
            params.width = 480;
            iv_login_logo.setLayoutParams(params);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ll_login_logobg.getLayoutParams());
            lp.setMargins(0, 240, 0, 90);
            ll_login_logobg.setLayoutParams(lp);
        }
    }





}



