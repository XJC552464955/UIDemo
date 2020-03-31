package com.example.viewpager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    List<Integer> pics = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pics.add(R.mipmap.bg1);
        pics.add(R.mipmap.bg2);
        pics.add(R.mipmap.bg3);
        pics.add(R.mipmap.bg4);
        RecyclerView.Adapter adapter = new RecyclerView.Adapter() {
            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(MainActivity.this).inflate(R.layout.item,parent,false);
                return new ViewHolder(v);
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
                ViewHolder h = (ViewHolder) holder;
                h.container.setBackgroundResource(pics.get(position));
            }

            @Override
            public int getItemCount() {
                return pics.size();
            }
        };

        //设置适配器
       ViewPager2 pagers = findViewById(R.id.pagers);
       pagers.setAdapter(adapter);

        //onPageSelected当页面选中时触发
        //onPageScrolled 当页面滑动时触发
        //onPageScrollStateChanged 页面滚动滑动状态改变时触发
        final LinearLayout dots = findViewById(R.id.dots);
       pagers.registerOnPageChangeCallback(new OnPageChangeCallback() {
           @Override
           public void onPageSelected(int position) {
               super.onPageSelected(position);
               //通过循环遍历将所有点设置成未被选中状态
               for (int i = 0; i < dots.getChildCount(); i++) {
                   //getChildAt(int index) 该函数返回一个View对象
                   ((ImageView)dots.getChildAt(i)).setImageResource(R.drawable.dot_unselect);
               }
               //将当前点设置成选中状态
               ((ImageView)dots.getChildAt(position)).setImageResource(R.drawable.dot_select);
           }
       });
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public LinearLayout container;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            container = itemView.findViewById(R.id.contaier);
        }
    }
}
