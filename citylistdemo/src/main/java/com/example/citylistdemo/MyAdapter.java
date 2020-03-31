package com.example.citylistdemo;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyAdapter extends BaseAdapter {
    private List<Msg> list;
    private Context context;
    private ArrayAdapter adapter;

    public MyAdapter(List list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.fenlei,parent,false);
        Msg msg = list.get(position);

        TextView zimu = convertView.findViewById(R.id.zimu);
        zimu.setText(msg.getZimu());


        ListView listView = convertView.findViewById(R.id.list2);
        adapter = msg.getAdapter();
        listView.setAdapter(adapter);

        //设置listView高度随项目数变化
        setListViewHeight(listView);

        return convertView;
    }

    private void setListViewHeight(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        int height = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i,null,listView);
            //计算子项的View宽高
            listItem.measure(0,0);
            //统计所有子项的总高度
            height+=listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        //listView.getDividerHeight()获取子项间分隔符占用的高度
        //params.height得到整个listView完整显示需要的额高度
        params.height = height+(listView.getDividerHeight()*(listAdapter.getCount())-1);
        listView.setLayoutParams(params);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}
