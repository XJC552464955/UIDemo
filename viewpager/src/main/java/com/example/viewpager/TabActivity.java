package com.example.viewpager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.androidkun.xtablayout.XTabLayout;

import java.util.ArrayList;
import java.util.List;

public class TabActivity extends AppCompatActivity {

    XTabLayout tab;
    ViewPager2 pagers;
    List<Fragment> frag_list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        //1.找到xTabLayout
        tab = findViewById(R.id.tab);

        //2.动态添加内容
        //2.1 实例化导航块
        XTabLayout.Tab t1 = tab.newTab();
        //2.2 设置名字
        t1.setText("财经");
        //2.3 添加
        tab.addTab(t1);
        tab.addTab(tab.newTab().setText("军事"));
        tab.addTab(tab.newTab().setText("科技"));
        tab.addTab(tab.newTab().setText("视频"));
        tab.addTab(tab.newTab().setText("体育"));
        tab.addTab(tab.newTab().setText("搞笑"));
        tab.addTab(tab.newTab().setText("军事"));
        tab.addTab(tab.newTab().setText("科技"));
        tab.addTab(tab.newTab().setText("视频"));
        tab.addTab(tab.newTab().setText("体育"));
        tab.addTab(tab.newTab().setText("搞笑"));
        tab.addTab(tab.newTab().setText("军事"));
        tab.addTab(tab.newTab().setText("科技"));
        tab.addTab(tab.newTab().setText("视频"));
        tab.addTab(tab.newTab().setText("体育"));
        tab.addTab(tab.newTab().setText("搞笑"));

        //3.设置切换效果
        tab.setOnTabSelectedListener(new XTabLayout.OnTabSelectedListener() {
            //被选中
            @Override
            public void onTabSelected(XTabLayout.Tab tab) {
                //设置当前导航页的位置及文本
                int positiion = tab.getPosition();
//                String txt = tab.getText().toString();
                //与Viewpager进行关联
                pagers.setCurrentItem(positiion);
            }
            //没被选中
            @Override
            public void onTabUnselected(XTabLayout.Tab tab) {

            }
            //恢复选中
            @Override
            public void onTabReselected(XTabLayout.Tab tab) {

            }
        });

        //找到ViewPager
        pagers = findViewById(R.id.pagers);

        //添加Fragment
        frag_list.add(new Fragment1());
        frag_list.add(new Fragment2());
        frag_list.add(new Fragment3());
        frag_list.add(new Fragment4());
        frag_list.add(new Fragment5());

        Log.e("TAG", "长度: "+frag_list.size() );

        //设置适配器,Fragment与Viewpager一起使用，需要使用FragmentStateAdapter，该适配器要一个Fragment管理器
       pagers.setAdapter(new FragmentStateAdapter(getSupportFragmentManager()) {
            @NonNull
            //当前选中的Fragment
            @Override
            public Fragment getItem(int position) {
                return frag_list.get(position);
            }

            @Override
            public int getItemCount() {
                return frag_list.size();
            }
        });

       //关联TabLayout
       pagers.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
           @Override
           public void onPageSelected(int position) {
               super.onPageSelected(position);
               tab.getTabAt(position).select();
           }
       });
    }
}
