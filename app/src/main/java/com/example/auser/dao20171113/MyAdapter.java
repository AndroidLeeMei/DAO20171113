package com.example.auser.dao20171113;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.auser.dao20171113.data.Student;

/**
 * Created by auser on 2017/11/13.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    Student data[];
    Context context;
    public MyAdapter(Context context,Student data[]){
        this.context=context;
        this.data=data;
    }
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        holder.tv.setText(data[position].name);
        holder.tv2.setText(data[position].tel);
        holder.tv3.setText(data[position].addr);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }


    static class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView tv,tv2,tv3;
        public ViewHolder(View itemView) {
            super(itemView);
            tv=(TextView)itemView.findViewById(R.id.textView);
            tv2=(TextView)itemView.findViewById(R.id.textView2);
            tv3=(TextView)itemView.findViewById(R.id.textView3);
        }
    }
}
