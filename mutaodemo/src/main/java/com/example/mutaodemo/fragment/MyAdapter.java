package com.example.mutaodemo.fragment;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mutaodemo.R;
import com.example.mutaodemo.util.FindHotNews;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

public class MyAdapter extends BaseAdapter {
    private List<FindHotNews> list = new ArrayList<>();
    private Context context;
    private ViewHolder holder;

    public MyAdapter(Context context,List<FindHotNews> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.find_hot,parent,false);
            holder = new ViewHolder();
            holder.describe = convertView.findViewById(R.id.describe);
            holder.portrait= convertView.findViewById(R.id.portrait);
            holder.from = convertView.findViewById(R.id.from);
            holder.see = convertView.findViewById(R.id.see_num);
            holder.zan = convertView.findViewById(R.id.zan_num);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        //获取FIndHotNews对象
        FindHotNews news = list.get(position);

        holder.describe.setText(news.getDescribe());

        holder.portrait.setImageResource(news.getPortrait());

        holder.from.setText(news.getFrom());

        holder.see.setText(String.valueOf(news.getSee_num()));

        holder.zan.setText(String.valueOf(news.getZan_num()));

        return convertView;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    static class ViewHolder{
        public ImageView portrait;
        public TextView describe, from, see, zan;
    }
}
