package cn.edu.nju.sweets.resourcemanagement.resourcelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.edu.nju.sweets.resourcemanagement.R;

/**
 * Created by chen on 2016/8/27.
 * Date 2016/8/27. 15:10
 */
public class ResourceListAdapter extends BaseAdapter implements View.OnClickListener {

    private final String TAG = getClass().getSimpleName();
    private Context mContext;
    private List<Rows> mData;

    public ResourceListAdapter(Context context, List<Rows> data) {
        mContext = context;
        mData = data;

    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return (long) (mData.get(position).getId());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_resource, null);
            holder = new ViewHolder(convertView, (int) getItemId(position));
            convertView.setTag(holder);
        }

        Rows item = mData.get(position);



        holder = (ViewHolder) convertView.getTag();
        holder.tv_resource_use_state.setText(item.getUseStatusName());

        holder.tv_resource_seq_id.setText(item.getSeqId());

        holder.tv_resource_serialnum.setText(item.getSequenceid());

        holder.tv_resource_code.setText(item.getCode());

        holder.tv_resource_position.setText(item.getPosition());

        holder.tv_resource_model_name.setText(item.getModelName());
        //点击打开menu
//        holder.resource_list_item.setTag(position);
//        holder.resource_list_item.setOnClickListener(this);



        return convertView;
    }





    @Override
    public void onClick(View v) {

        Rows item = mData.get((int) v.getTag());
        Toast.makeText(mContext,String.valueOf(item.getId()),Toast.LENGTH_SHORT);
        //跳转到详情fragment





//        CourseItem item = mData.get((int) v.getTag());
////        String status = getStatus(item);
////        Log.e("status",status);
//
//        MenuOption option = new MenuOption();
//        Bundle bundle = new Bundle();
//        bundle.putString("url", SysConfig.DLURL + item.getCid() + "/" + item.getCid() + ".lwyr");
//        bundle.putString("name", item.getName());
//        bundle.putString("status", item.getStatus());
//        bundle.putInt("id", item.getId());
//        bundle.putString("cid", item.getCid());
//        option.setArguments(bundle);
//        option.show(((AppCompatActivity) mContext).getSupportFragmentManager(), "");

    }

    class ViewHolder {

        View mView;
        int mId;


//        @BindView(R.id.iv_course_thumb)
//        ImageView mIvCourseThumb;
        @BindView(R.id.tv_resource_use_state)
        TextView tv_resource_use_state;
        @BindView(R.id.tv_resource_seq_id)
        TextView tv_resource_seq_id;


        @BindView(R.id.tv_resource_serialnum)
        TextView tv_resource_serialnum;

        @BindView(R.id.tv_resource_position)
        TextView tv_resource_position;

        @BindView(R.id.tv_resource_model_name)
        TextView tv_resource_model_name;

        @BindView(R.id.tv_resource_code)
        TextView tv_resource_code;

        @BindView(R.id.resource_list_item)
        LinearLayout resource_list_item;

        public ViewHolder(View view, int id) {
            this.mView = view;
            this.mId = id;
            ButterKnife.bind(this, mView);
//            mIvCourseThumb.setImageResource(R.mipmap.ic_launcher);
        }

        public int getId() {
            return mId;
        }
    }



}
