package cn.edu.nju.sweets.resourcemanagement.resourcelist;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.edu.nju.sweets.resourcemanagement.R;
import cn.edu.nju.sweets.resourcemanagement.base.BaseFragment;
import cn.edu.nju.sweets.resourcemanagement.base.IBaseView;
import cn.edu.nju.sweets.resourcemanagement.resourcedetail.DetailTableActivity;
import cn.edu.nju.sweets.resourcemanagement.util.GlobalConfig;
import cn.edu.nju.sweets.resourcemanagement.util.IHttpService;
import cn.edu.nju.sweets.resourcemanagement.util.NetWorkUtils;
import cn.edu.nju.sweets.resourcemanagement.util.XListView;

public class ResourceListFragment extends BaseFragment implements IBaseView, AdapterView.OnItemClickListener, XListView.IXListViewListener {
    private final String TAG = getClass().getSimpleName();
    private ResourceListPresenter resourceListPresenter;

    @BindView(R.id.xlv_resource_list_all)
    XListView xlv_resourcelist;
    List<Rows> mData = new ArrayList<>();
    int pageSize = 10;
    int curPage = 1;
    private View loaded = null;
    private boolean loadFinished = false; //已经全部加载完成

    private ResourceListAdapter mAdapter;
    private int clicked = -1;

    // 初始化Fragment布局
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (loaded == null) {
            View view = inflater.inflate(R.layout.fragment_resource_list, null);
            ButterKnife.bind(this, view);
            initXList();
            loaded = view;
        }
        setPresenter(resourceListPresenter);
        return loaded;
    }


    @Override
    public View initView() {

//        if (loaded == null) {
//            View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_resource_list, null);
//            ButterKnife.bind(this, view);
//            initXList();
//            loaded = view;
//        }
        return loaded;
    }

    private void initXList() {
        xlv_resourcelist.setXListViewListener(this);
        xlv_resourcelist.setOnItemClickListener(this);
        xlv_resourcelist.setPullRefreshEnable(true);
        xlv_resourcelist.setPullLoadEnable(true);
        mAdapter = new ResourceListAdapter(getContext(), mData);
        xlv_resourcelist.setAdapter(mAdapter);


    }

    @Override
    public void setPresenter(Object presenter) {
        resourceListPresenter = new ResourceListPresenter(this);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(mActivity,msg,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void jumpActivity() {

    }

    @Override
    public void onRefresh() {
        curPage = 1;
        mData.clear();
        getData();
        xViewLoadFinished();

    }

    @Override
    public void onResume() {
        super.onResume();

        //刷新一下课件 之后需要进行修改
        curPage = 1;
        mData.clear();
        getData();


    }
    @Override
    public void onLoadMore() {
        if (!loadFinished) {//没有加载完成执行 加载更多
            curPage++;
            getData();
            xViewLoadFinished();
        }else{
//            mylistView.stopLoadMore();
//            xViewLoadFinished();
            xlv_resourcelist.setPullLoadEnable(false); //下拉加载取消
//            mylistView.setPullRefreshEnable(false);//上面刷新取消
            xViewLoadFinished();
//            mylistView.footer
//            mylistView
//            mylistView.set
            // 怎么显示这里的呢
        }
    }
    private void getData() {
        //检查是否有网络，没有网络启动本地方案。
//        SharedPreferences ini = Global.getmIniUser(getContext());
//        int uid = ini.getInt("Id", -1);
        Log.e(TAG,"get data +-----" + curPage );
        boolean netWork = NetWorkUtils.isNetworkConnected(getContext());
        if (!netWork) {
            Log.e(TAG,"no network");
            showToast("无网络");
        } else {

            IHttpService service = GlobalConfig.getHttpService();

            List<Rows> newData = resourceListPresenter.getResourceList(curPage,pageSize);


            mData.addAll(newData);
            Log.e(TAG,mData.toString());
            xlv_resourcelist.stopRefresh();

            mAdapter.notifyDataSetChanged();
//            Call<ResourceListBean> call = service.getCourses(curPage++, pageSize, ini.getInt("Id", -1), ini.getString("Token", ""));
//            call.enqueue(new Callback<CourseResult>() {
//                @Override
//                public void onResponse(Call<CourseResult> call, Response<CourseResult> response) {
//                    if (response.isSuccessful()) {
////                    Log.e(TAG, response.raw().toString());
//                        CourseResult result = response.body(); // 把这个对象存储在手机上json ，离线的时候就把他读出来
//                        if (result.getCode() == 0) {
//                            CourseResult.CourseItem[] courses = result.getData();
//                            for (int i = 0; i < courses.length; i++) {
//                                mData.add(courses[i]);
//                            }
//                        }
//                        mXlvCourses.stopRefresh();
//                        mAdapter.notifyDataSetChanged();
//                    }
//                }

//                @Override
//                public void onFailure(Call<CourseResult> call, Throwable t) {
//                    Log.e(TAG, t.getMessage());
//                }
//            });

        }



//        SharedPreferences ini = Global.getmIniUser(this);
//        IHttpService service = Global.getHttpService();
//        Call<PushMessageResult> call = service.getPushMessages(page, pageSize, ini.getInt("Id", -1), ini.getString("Token", ""));
//        call.enqueue(new Callback<PushMessageResult>() {
//            @Override
//            public void onResponse(Call<PushMessageResult> call, Response<PushMessageResult> response) {
//                if (response.isSuccessful()) {
////                    Log.e(TAG, response.raw().toString());
//                    PushMessageResult result = response.body();
//                    if (result.getCode() == 0) {
//                        PushMessageResult.PushMessageItem[] itemss = result.getData();
//
//                        for (int i = 0; i < itemss.length; i++) {
//                            mData.add(itemss[i]);
//                        }
//                        if(itemss.length<mPageSize){//数据已近加载完毕 无需再进行加载
//                            loadFinished = true;
////                            mylistView.stopLoadMore();//已经全部加载了
//                        }
//                    }
////                    mylistView.stopRefresh();
//                    mAdapter.notifyDataSetChanged();
//                }
//            }
//
//
//
//            @Override
//            public void onFailure(Call<PushMessageResult> call, Throwable t) {
//                Log.e(TAG, t.getMessage());
//            }
//        });



    }

    private void setXiewRefreshTime(){

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期显示格式
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        String str = formatter.format(curDate);// 将时间装换为设置好的格式
        xlv_resourcelist.setRefreshTime(str);//设置时间
    }

    private void xViewLoadFinished() {
        xlv_resourcelist.stopRefresh();//停止刷新
        xlv_resourcelist.stopLoadMore();//停止加载更多
        setXiewRefreshTime();
    }

    @Override
    public void onPause() {
        super.onPause();
    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        position--;
        clicked = position;

        Rows row = mData.get(position);

        Log.e(TAG,"test detail+ id="+row.getId());


        Bundle bundle = new Bundle();
        bundle.putSerializable("row",row);
        Intent intent = new Intent(mActivity, DetailTableActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);

        }





}
