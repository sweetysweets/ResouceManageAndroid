package cn.edu.nju.sweets.resourcemanagement.personal;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.widget.QMUILoadingView;
import com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.edu.nju.sweets.resourcemanagement.R;
import cn.edu.nju.sweets.resourcemanagement.about.AboutActivity;
import cn.edu.nju.sweets.resourcemanagement.base.BaseFragment;

public class SettingFragment extends BaseFragment{
    private final int ME = 0;
    private final int CHANGE_PASSWORD = 1;
    private final int ABOUT = 2;
    private final int FEED_BACK = 3;


    @BindView(R.id.groupListView)
    QMUIGroupListView mGroupListView;

    @Override
    public View initView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_setting, null);
        ButterKnife.bind(this, view);
        initGroupListView();
        return view;



    }

    private void initGroupListView() {

        QMUICommonListItemView me = mGroupListView.createItemView(
                ContextCompat.getDrawable(getContext(), R.mipmap.avater_143),
                "烤面包杀手圆圆",
                null,
                QMUICommonListItemView.VERTICAL,
                QMUICommonListItemView.ACCESSORY_TYPE_CUSTOM);
        TextView myName = new TextView(mActivity);
        myName.setText("烤面包杀手圆圆");
        me.addAccessoryCustomView(myName);
        me.setOrientation(QMUICommonListItemView.VERTICAL);
        me.setDetailText("工号：S00450");
        me.setTag(ME);


             QMUICommonListItemView changePassword = mGroupListView.createItemView(
                ContextCompat.getDrawable(getContext(), R.drawable.ic_setting_change_password),
                "修改密码",
                null,
                QMUICommonListItemView.HORIZONTAL,
                QMUICommonListItemView.ACCESSORY_TYPE_NONE);
        changePassword.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);
        changePassword.setTag(CHANGE_PASSWORD);



        QMUICommonListItemView feedback = mGroupListView.createItemView(
                ContextCompat.getDrawable(getContext(), R.drawable.ic_setting_feedback),"反馈与建议",null, QMUICommonListItemView.HORIZONTAL,
                QMUICommonListItemView.ACCESSORY_TYPE_NONE);
        feedback.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);
        feedback.setTag(FEED_BACK);


        QMUICommonListItemView about = mGroupListView.createItemView(
                ContextCompat.getDrawable(getContext(), R.drawable.ic_setting_about_20),"关于",null, QMUICommonListItemView.HORIZONTAL,
                QMUICommonListItemView.ACCESSORY_TYPE_NONE);
        about.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);
        about.setTag(ABOUT);






        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v instanceof QMUICommonListItemView) {

                    int tag = (int)((QMUICommonListItemView) v).getTag();
                    switch (tag){
                        case ME:

                            break;
                        case CHANGE_PASSWORD:
//                            if (mid == -1) {
//                                Global.showToast(getContext(), "您还未登录,请您先登录");
//                            } else {
//                                if (mIni.getInt("Type", -1) == 1) {
//                                    Intent intent = new Intent(getContext(), UntranslatedActivity.class);
//                                    startActivity(intent);
//                                } else { //normal user
//                                    Intent intent = new Intent(getContext(), FavoriteActivity.class);
//                                    startActivity(intent);
//                                }
//                            }
//                            break;
                            break;
                        case FEED_BACK:
                            break;
                        case ABOUT:
                            Intent intent = new Intent(getContext(), AboutActivity.class);
                            startActivity(intent);
                            break;
                        default:
                            break;
                    }

//
//                    Toast.makeText(getActivity(), text + " is Clicked", Toast.LENGTH_SHORT).show();
                }
            }
        };

        QMUIGroupListView.newSection(getContext())
                .setTitle("")
                .addItemView(me, onClickListener)
                .addTo(mGroupListView);

        QMUIGroupListView.newSection(getContext())
                .setTitle("")
                .addItemView(changePassword, onClickListener)
                .addTo(mGroupListView);
        QMUIGroupListView.newSection(getContext())
                .setTitle("")
                .addItemView(feedback, onClickListener)
                .addItemView(about,onClickListener)
                .addTo(mGroupListView);


    }
}
