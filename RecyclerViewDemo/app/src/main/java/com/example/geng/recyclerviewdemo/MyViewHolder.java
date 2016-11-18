package com.example.geng.recyclerviewdemo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by geng on 2016/11/18.
 */

public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener {
    TextView tvName;
    CircleImageView circleImageView;
    private MyItemClickListener mListener;
    private MyItemLongClickListener mLongClickListener;
    public MyViewHolder(View view,MyItemClickListener listener,MyItemLongClickListener longClickListener) {
        super(view);
        tvName = (TextView) view.findViewById(R.id.content);
        circleImageView= (CircleImageView) view.findViewById(R.id.photo);
        this.mListener = listener;
        this.mLongClickListener = longClickListener;
        view.setOnClickListener(this);
        view.setOnLongClickListener(this);
    }

    @Override
    public boolean onLongClick(View view) {
        if(mLongClickListener != null){
            mLongClickListener.onItemLongClick(view, getPosition());
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        if(mListener != null){
            mListener.onItemClick(v,getPosition());
        }
    }
}
