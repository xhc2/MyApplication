package sudoku.myself.xhc.com.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by xhc on 2016/12/17.
 */

public class MyRecyleAdapter extends MyBaseAdapter<ClassifyBean  , MyRecyleAdapter.ViewHolder> {


    public MyRecyleAdapter(List<ClassifyBean> list, Context context) {
        super(list, context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup container, int type) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_item , container , false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ClassifyBean cb = list.get(position);
        Log.e("xhc" ," url "+cb.getUrl() );
        displayImageView(holder.imgLogo , cb.getUrl());
        holder.tvName.setText(cb.getName());
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imgLogo;
        TextView tvName;
        public ViewHolder(View itemView) {
            super(itemView);
            imgLogo =(ImageView)itemView.findViewById(R.id.img_logo);
            tvName =(TextView)itemView.findViewById(R.id.tv_name);
        }
    }

}
