package recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;

import java.util.ArrayList;

/**
 * Created by 赵泳霖 on 2017/8/3.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHodler> {
    private final Context context;
    private  ArrayList<String> datas;

    public MyRecyclerViewAdapter(Context context, ArrayList<String> datas) {
        this.context = context;
        this.datas = datas;
    }
    /*
    *绑定布局
    *
    * */
    @Override
    public MyViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(context,R.layout.item_recyclerview,null);
        return new MyViewHodler(itemView);
    }
/*
* 相当于getView绑定数据部分的代码
* */
    @Override
    public void onBindViewHolder(MyViewHodler holder, int position) {
        //根据位置得到对应的数据
        String data = datas.get(position);
        holder.tv_title.setText(data);

    }
/*
* 得到总条数
*
* */
    @Override
    public int getItemCount() {
        return datas.size();
    }
/*
* 添加数据
*
* */
    public void addData(int posotion, String data) {
        datas.add(posotion,data);
        //刷新适配器
        notifyItemInserted(posotion);
    }
/*
* 移除数据
*
* */
    public void removeData(int posotion) {
        datas.remove(posotion);
        //刷新适配器
        notifyItemRemoved(posotion);
    }

    class MyViewHodler extends RecyclerView.ViewHolder {

        private ImageView iv_icon;
        private TextView tv_title;
        public MyViewHodler(View itemView) {
            super(itemView);
            iv_icon = (ImageView) itemView.findViewById(R.id.iv_icon);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Toast.makeText(context,"data=="+datas.get(getLayoutPosition()),Toast.LENGTH_SHORT).show();
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(v,datas.get(getLayoutPosition()));
                    }
                }
            });
            iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "I is photo=="+getLayoutPosition(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }


    public interface OnItemClickListener{
        /*
        * 当RecyclerView某个被点击的时候回调
        * view 点击itew的视图
        * data 点击得到的数据
        *
        * */
        public void onItemClick(View view, String data);

    }
    private OnItemClickListener onItemClickListener;
    /*
    * 设置RecyclerView某个的监听
    *
    * */
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;

    }


}





