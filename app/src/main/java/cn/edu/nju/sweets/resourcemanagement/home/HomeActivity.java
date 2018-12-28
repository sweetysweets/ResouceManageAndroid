package cn.edu.nju.sweets.resourcemanagement.home;

import android.content.Intent;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.edu.nju.sweets.resourcemanagement.R;
import cn.edu.nju.sweets.resourcemanagement.base.BaseActivity;
import cn.edu.nju.sweets.resourcemanagement.personal.SettingFragment;
import cn.edu.nju.sweets.resourcemanagement.resourcedetail.ScanFragment;
import cn.edu.nju.sweets.resourcemanagement.resourcelist.ResourceListFragment;

public class HomeActivity extends BaseActivity implements TabHost.OnTabChangeListener {
    final String TAG = getClass().getSimpleName();
    @BindView(android.R.id.tabhost)
    FragmentTabHost tabHost;
    @BindColor(R.color.app_color_blue_2)
    int colorTextSelected;

    @BindView(R.id.topbar)
    QMUITopBarLayout mTopBar;

    String[] tabLables={"资源","扫描","设置"};

    String[] tabTitles={"资源列表","二维码/条码","我"};
    int[] tabImgs={R.mipmap.icon_tabbar_list,R.mipmap.icon_tabbar_scan,R.mipmap.icon_tabbar_setting};
    int[] tabImgSelected={R.mipmap.icon_tabbar_list_selected,R.mipmap.icon_tabbar_scan_selected,R.mipmap.icon_tabbar_setting_selected};

    Class[] fragments={ResourceListFragment.class,ScanFragment.class, SettingFragment.class};


    @Override
    public View intiLayout() {
        View root = LayoutInflater.from(this).inflate(R.layout.activity_home, null);
        ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void initView() {
        // 沉浸式状态栏
        QMUIStatusBarHelper.translucent(this);

        tabHost.setup(this,super.getSupportFragmentManager()
                ,R.id.tab_content);
        tabHost.getTabWidget().setDividerDrawable(null);
        tabHost.setOnTabChangedListener(this);
        initTab();
        initTopBar();

    }

    @Override
    public void initData() {

    }

    @Override
    public void setTitle(String title) {
        mTopBar.showTitlteView(false);
        mTopBar.setTitle(title);
        mTopBar.showTitlteView(true);

    }

    private void initTopBar() {


        mTopBar.setBackgroundDividerEnabled(true);

        mTopBar.setTitle("资源管理");
    }
    protected void popBackStack() {
//        getBaseFragmentActivity().popBackStack();
    }

    private void initTab(){
        String tabs[]=tabLables;
        for(int i=0;i<tabs.length;i++){
            TabHost.TabSpec tabSpec=tabHost.newTabSpec(tabs[i]).setIndicator(getTabView(i));
            tabHost.addTab(tabSpec,fragments[i],null);
            tabHost.setTag(i);
        }
    }

    private View getTabView(int idx){
        View view=LayoutInflater.from(this).inflate(R.layout.footer_tabs,null);
        ((TextView)view.findViewById(R.id.tvTab)).setText(tabLables[idx]);
        if(idx==0){
            ((TextView)view.findViewById(R.id.tvTab)).setTextColor(colorTextSelected);
            ((ImageView)view.findViewById(R.id.ivImg)).setImageResource(tabImgSelected[idx]);
        }else{
            ((ImageView)view.findViewById(R.id.ivImg)).setImageResource(tabImgs[idx]);
        }
        return view;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onTabChanged(String tabId) {
        // TODO Auto-generated method stub
        updateTab();

    }
    private void updateTab(){
        TabWidget tabw=tabHost.getTabWidget();
        for(int i=0;i<tabw.getChildCount();i++){

            View view=tabw.getChildAt(i);
            ImageView iv=view.findViewById(R.id.ivImg);
            if(i==tabHost.getCurrentTab()){
                ((TextView)view.findViewById(R.id.tvTab)).setTextColor(colorTextSelected);
                iv.setImageResource(tabImgSelected[i]);
                setTitle(tabTitles[i]);
            }else{
                ((TextView)view.findViewById(R.id.tvTab)).setTextColor(getResources().getColor(R.color.text_gray));
                iv.setImageResource(tabImgs[i]);

            }

        }
    }


    @Override
    public void onBackPressed() {

        //将back键的功能替换成home,这样不会重启应用
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);


    }

}
