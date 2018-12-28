package cn.edu.nju.sweets.resourcemanagement.resourcedetail;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;
import com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.edu.nju.sweets.resourcemanagement.R;
import cn.edu.nju.sweets.resourcemanagement.about.AboutActivity;
import cn.edu.nju.sweets.resourcemanagement.base.BaseActivity;
import cn.edu.nju.sweets.resourcemanagement.base.BaseFragment;
import cn.edu.nju.sweets.resourcemanagement.resourcelist.Inventory;
import cn.edu.nju.sweets.resourcemanagement.resourcelist.Rows;
import cn.edu.nju.sweets.resourcemanagement.util.GlobalConfig;
import cn.edu.nju.sweets.resourcemanagement.util.IHttpService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 展示课件列表详情
 * Created by chen on 2016/8/27.
 * Date 2016/8/27. 20:27
 */
public class DetailTableActivity extends BaseActivity {

    private  final String TAG = getClass().getSimpleName();


    @BindView(R.id.topbar)
    QMUITopBarLayout mTopBar;



    @BindView(R.id.resource_detail_list)
    QMUIGroupListView mGroupListView;

    private Rows mItems;


    @Override
    public View intiLayout() {
        View root = LayoutInflater.from(this).inflate(R.layout.fragment_resource_detail_table, null);
        ButterKnife.bind(this, root);
        initGroupList();
        return root;
    }

    @Override
    public void initView(){

        QMUIStatusBarHelper.translucent(this);
        mTopBar.setTitle("资源详情");

        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mTopBar.addRightImageButton(R.mipmap.icon_topbar_overflow, R.id.topbar_right_change_button)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(DetailTableActivity.this,"跳转到编辑页面",Toast.LENGTH_SHORT).show();
                    }
                });

    }


    private void initGroupList() {
//        private Long id;
//        private String ctmid;
//        private String code;
//        private String assetctyid;
//        private String status;
//        private String brandid;
//        private String buyorgid;
//        private String keeporgid;
//        private String keepempid;
//        private String useorgid;
//        private String useempid;
//        private Date buydate;
//        private String addressid;
//        private String rack;
//        private String unum;
//        private String des;
//        private String qrcode;
//        private Date createtime;
//        private Date updatetime;
//        private String isdelete;
//        private String cabinet;
//        private String modelid;
//        private String sequenceid;
//        private int height;
//        private int originalvalue;
//        private String usestatus;
//        private int powernumber;
//        private String workflowstatus;
//        private String assettype;
//        private String assetctyName;
//        private String brandName;
//        private String modelName;
//        private String useStatusName;
//        private String assetTypeName;
//        private String teamName;
//        private String seqId;
//        private String buyOrgName;
//        private String keepOrgName;
//        private String keepEmpName;
//        private String useOrgName;
//        private String useEmpName;
//        private String addressName;
//        private String position;
//        private List<Inventory> inventory;

        QMUICommonListItemView  ctmid= mGroupListView.createItemView(
                ContextCompat.getDrawable(this, R.drawable.ic_setting_feedback),
                "序列号","1234567890",
                QMUICommonListItemView.HORIZONTAL,
                QMUICommonListItemView.ACCESSORY_TYPE_NONE);
//        TextView myName = new TextView(mActivity);
//        myName.setText("烤面包杀手圆圆");
//        me.addAccessoryCustomView(myName);
        QMUICommonListItemView  createTime= mGroupListView.createItemView(
                ContextCompat.getDrawable(this, R.drawable.ic_setting_feedback),
                "创建时间","2018-12-12 12：12：12",
                QMUICommonListItemView.HORIZONTAL,
                QMUICommonListItemView.ACCESSORY_TYPE_NONE);


        QMUICommonListItemView  test= mGroupListView.createItemView(
                ContextCompat.getDrawable(this, R.drawable.ic_setting_feedback),
                "长文本","Android中，想要实现TAB页面的切换时，做一些事情，\n" +
                        "\n" +
                        "后来得知就是去重写TabHost的OnTabChangeListener。所以要去搞懂如何重写OnTabChangeListener。\n" +
                        "\n",
                QMUICommonListItemView.HORIZONTAL,
                QMUICommonListItemView.ACCESSORY_TYPE_NONE);


        QMUICommonListItemView  test2= mGroupListView.createItemView(
                ContextCompat.getDrawable(this, R.drawable.ic_setting_feedback),
                "长文本","Android中，想要实现TAB页面的切换时，做一些事情后来得知就是去重写TabHost的O",
                QMUICommonListItemView.HORIZONTAL,
                QMUICommonListItemView.ACCESSORY_TYPE_NONE);







        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v instanceof QMUICommonListItemView) {

                    Toast.makeText(DetailTableActivity.this, ((QMUICommonListItemView) v).getDetailText(), Toast.LENGTH_LONG).show();


//                    int tag = (int)((QMUICommonListItemView) v).getTag();
//                    switch (tag){
//
//                        default:
//                            break;
//                    }

//
//                    Toast.makeText(getActivity(), text + " is Clicked", Toast.LENGTH_SHORT).show();
                }
            }
        };

        QMUIGroupListView.newSection(this)
                .setTitle("基本信息")
                .addItemView(ctmid, null)
                .addItemView(createTime,null)
                .addTo(mGroupListView);

        QMUIGroupListView.newSection(this)
                .setTitle("盘点信息")
                .addItemView(test, null)
                .addItemView(test2,onClickListener)
                .addTo(mGroupListView);

    }

    public void initData() {

//        int id = getArguments().getInt("id");

//        IHttpService service = GlobalConfig.getHttpService();
//        Call<CourseDetailList> call = service.getCourseDetailList(id);
//        call.enqueue(new Callback<CourseDetailList>() {
//            @Override
//            public void onResponse(Call<CourseDetailList> call, Response<CourseDetailList> response) {
//                if (response.isSuccessful()) {
//                    CourseDetailList result = response.body();
//                    if (result.getCode() == 0) {
//                        mItems = result.getData();
//                        for (int i = 0; i < mItems.length; i++) {
//                            mTexts.get(i).setText(mItems[i].getValue());
//                            Log.e(TAG, mItems[i].getValue());
//                        }
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<CourseDetailList> call, Throwable t) {
//
//            }
//        });



    }

    @Override
    public void setTitle(String title) {

    }
}
