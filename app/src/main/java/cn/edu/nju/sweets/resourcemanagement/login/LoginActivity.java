package cn.edu.nju.sweets.resourcemanagement.login;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.qmuiteam.qmui.widget.QMUITopBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.edu.nju.sweets.resourcemanagement.R;

public class LoginActivity extends Activity implements LoginContract.ILoginView,View.OnClickListener{

    private LoginPresenter loginPresenter;
    @BindView(R.id.topbar)
    QMUITopBar mTopBar;
    @BindView(R.id.edittext_name)
    EditText userId;
    @BindView(R.id.edittext_phonenumber)
    EditText phone;
    @BindView(R.id.edittext_password)
    EditText password;

    @BindView(R.id.button_register)
    Button loginBtn;

    final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 沉浸式状态栏
        QMUIStatusBarHelper.translucent(this);

        View root = LayoutInflater.from(this).inflate(R.layout.activity_login, null);
        ButterKnife.bind(this, root);
        //初始化状态栏
        initTopBar();
        loginBtn.setOnClickListener(this);

        setContentView(root);
        loginPresenter = new LoginPresenter(this);

    }

    private void initTopBar() {
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mTopBar.setTitle("注册账号");
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
    public void onClick(View v) {
        loginPresenter.login();
    }
}



