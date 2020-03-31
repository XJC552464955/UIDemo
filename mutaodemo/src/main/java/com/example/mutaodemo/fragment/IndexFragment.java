package com.example.mutaodemo.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;

import com.example.mutaodemo.R;
import com.example.mutaodemo.util.DateUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IndexFragment extends Fragment {
    private ViewPager2 pagers;
    private GridView grid;
    private List<Map<String, Object>> date = new ArrayList<>();
    private int index = 0;
    private SimpleAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_index, container, false);

        setViewPagers(view);
        setGridView(view);

        return view;

    }

    private void setGridView(View view) {
        grid = view.findViewById(R.id.grid);

        if(adapter==null) {
            for (int i = 0; i < DateUtils.index_menu_img.length; i++) {
                Map<String, Object> map = new HashMap<>();
                map.put("img", DateUtils.index_menu_img[i]);
                map.put("txt", DateUtils.index_txts[i]);
                date.add(map);
            }

            String[] from = {"img", "txt"};

            int[] to = {R.id.grid_img, R.id.grid_txt};

            adapter = new SimpleAdapter(getContext(), date, R.layout.indexgrid_item, from, to);
        }

        grid.setAdapter(adapter);
    }

    private void setViewPagers(View v) {
        pagers = v.findViewById(R.id.pagers);

        RecyclerView.Adapter adapter = new RecyclerView.Adapter() {
            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(getContext()).inflate(R.layout.indexpager_item,parent,false);
                return new ViewHolder(v);
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
                ViewHolder h = (ViewHolder) holder;
                //设置轮播图片
                h.v.setBackgroundResource(DateUtils.adv_img[position%DateUtils.adv_img.length]);
            }

            @Override
            public int getItemCount() {
                return Integer.MAX_VALUE;
            }
        };

        pagers.setAdapter(adapter);

        //指示器根布局
        final LinearLayout dots = v.findViewById(R.id.pointers);
        pagers.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                //将指示器设置为unselect
                for (int i = 0; i < DateUtils.adv_img.length; i++) {
                    ((ImageView)dots.getChildAt(i)).setImageResource(R.drawable.dot_unselected);
                }
                ((ImageView)dots.getChildAt(position%DateUtils.adv_img.length)).setImageResource(R.drawable.dot_selected);
            }
        });

        //开启一个线程
        new Thread(){
            @Override
            public void run() {
                super.run();
                while (true){
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    pagers.setCurrentItem(index);

                    index++;
                }
            }
        }.start();
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
           public View v;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            v = itemView;
        }
    }
}
