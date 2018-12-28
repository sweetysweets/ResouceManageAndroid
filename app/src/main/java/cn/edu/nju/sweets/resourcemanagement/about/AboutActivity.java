package cn.edu.nju.sweets.resourcemanagement.about;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.edu.nju.sweets.resourcemanagement.R;

/**
 * Created by chen on 2016/7/2.
 * Date 2016/7/2. 12:43
 */
public class AboutActivity extends AppCompatActivity {
    @BindView(R.id.tv_about_website)
    TextView mTvAboutWebsite;
    @BindView(R.id.tv_about_phone)
    TextView mTvAboutPhone;
    @BindView(R.id.tv_about_version)
    TextView mTvAboutVersion;
    @BindView(R.id.topbar)
    QMUITopBarLayout mToolbar;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);
        // 沉浸式状态栏
        QMUIStatusBarHelper.translucent(this);


        mToolbar.setTitle("关于");

//        mToolbar.setNavigationIcon(R.drawable.ic_chevron_left);
//        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });

        mToolbar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });
        mTvAboutVersion.setText("资源管理系统 Ver."+getAppVersionName(this));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mToolbar = null;
    }

    @OnClick({R.id.tv_about_website, R.id.tv_about_phone})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_about_website:
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setClassName("com.android.browser","com.android.browser.BrowserActivity");
                Uri url = Uri.parse(getResources().getString(R.string.aboutWebsite));
                intent.setData(url);
                startActivity(intent);
//                openUrl();
                break;
            case R.id.tv_about_phone:
                Uri uri = Uri.parse("tel:" + getResources().getString(R.string.aboutPhone));
                Intent it = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(it);
                break;
        }
    }

    public void openUrl() {
        Intent intent;
        Uri uri = Uri.parse(getResources().getString(R.string.aboutWebsite));
        intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setType("text/html");
        intent.setData(uri);
//        intent.putExtra("url", getResources().getString(R.string.aboutWebsite));
        PackageManager pm = getPackageManager();
        List<ResolveInfo> resolveList = pm.queryIntentActivities(intent, PackageManager.MATCH_ALL);
        if (resolveList.size() > 1) {
            String title = "选择打开方式";
            Intent intentChooser = Intent.createChooser(intent, title);
            startActivity(intentChooser);
        } else if (resolveList.size() == 1) {
            startActivity(intent);
        } else {
            Toast.makeText(AboutActivity.this, "no match activity to start!", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 返回当前程序版本名
     */
    public static String getAppVersionName(Context context) {
        String versionName = "";
        try {
            // ---get the package info---
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
            versionName = pi.versionName;
            if (versionName == null || versionName.length() <= 0) {
                return "";
            }
        } catch (Exception e) {
//            Log.e("VersionInfo", "Exception", e);
        }
        return versionName;
    }
}
