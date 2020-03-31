package com.example.mutaodemo.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.mutaodemo.R;
import com.example.mutaodemo.util.FindHotNews;

import java.util.ArrayList;
import java.util.List;

public class FindFragment extends Fragment {
    private int likered = 0;
    private int likeblue = 0;
    private List<FindHotNews> list = new ArrayList<>();
    private BaseAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.fragment_find, container, false);

        setPk(view);

        //找到listview
         ListView listView = view.findViewById(R.id.hot_list);

         if(adapter==null){
             //实列化适配器
             initdate();
             adapter = new MyAdapter(getContext(),list);
         }

         //设置适配器
         listView.setAdapter(adapter);

         return view;
    }

    private void initdate() {
        FindHotNews news = new FindHotNews("从广州区东莞仅需半个小时，美食美景统统都在等你！",R.mipmap.find_hot_city,"源自：羊城攻略", 10256, 15);
        list.add(news);

        FindHotNews news1 = new FindHotNews("旅行前最最应该做的10件准备事项，千万别给忽略了！",R.mipmap.find_hot_home,"源自：冬夏旅游", 10036, 3);
        list.add(news1);

        FindHotNews news2 = new FindHotNews("北京周边竟然藏着20个绝美仙境，够你免费玩一年！",R.mipmap.find_hot_jiangnan,"源自：北京攻略", 11006, 26);
        list.add(news2);
    }

    private void setPk(View view) {
        //red
        final TextView rednum = view.findViewById(R.id.pk_redbarnum);
        final TextView redlikenum = view.findViewById(R.id.pk_likenum_red);
        final ProgressBar redbar = view.findViewById(R.id.pk_redbar_pro);
        view.findViewById(R.id.pk_likered).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(likered<101) {
                    likered++;
                    redlikenum.setText(String.valueOf(likered));
                    redbar.setProgress(likered);
                    rednum.setText(String.valueOf(likered) + "%");
                }
            }
        });


        //blue
        final TextView bluenum = view.findViewById(R.id.pk_bluebar_num);
        final TextView bluelikenum = view.findViewById(R.id.pk_likenum_blue);
        final ProgressBar bluebar = view.findViewById(R.id.pk_bluebar_pro);
        view.findViewById(R.id.pk_likeblue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(likeblue<101) {
                    likeblue++;
                    bluenum.setText(String.valueOf(likeblue) + "%");
                    bluelikenum.setText(String.valueOf(likeblue));
                    bluebar.setProgress(likeblue);
                }
            }
        });
    }

}
