package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleActivity extends AppCompatActivity {
    private List<Map<String,Object>> date = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);

        //实例化ListView对象
        ListView listView = findViewById(R.id.simple_list);
        //准备数据源
        initDate();

        String[] from = {"img","name","mood"};

        int[] to = {R.id.img,R.id.name,R.id.mood};

        //实例化适配器
        SimpleAdapter adapter = new SimpleAdapter(this,date,R.layout.simple_list,from,to);

        //为listview设置适配器
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Map<String,Object> map = date.get(position);
                String name = map.get("name").toString();
                String mood = map.get("mood").toString();
                Toast.makeText(SimpleActivity.this,name+"\n"+mood,Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initDate() {
        Map<String,Object> map1 = new HashMap<>();
        map1.put("img",R.mipmap.aa);
        map1.put("name","梦琪");
        map1.put("mood","米开机");

        Map<String,Object> map2 = new HashMap<>();
        map2.put("img",R.mipmap.bb);
        map2.put("name","韩信");
        map2.put("mood","枪出如龙，照一身肝胆");


        Map<String,Object> map3 = new HashMap<>();
        map3.put("img",R.mipmap.luobo);
        map3.put("name","李白");
        map3.put("mood","阿哥之剑天上来");


        Map<String,Object> map4 = new HashMap<>();
        map4.put("img",R.mipmap.bb);
        map4.put("name","后裔");
        map4.put("mood","我射穿了太阳");


        Map<String,Object> map5 = new HashMap<>();
        map5.put("img",R.mipmap.bb);
        map5.put("name","韩信");
        map5.put("mood","枪出如龙，照一身肝胆");


        Map<String,Object> map6 = new HashMap<>();
        map6.put("img",R.mipmap.bb);
        map6.put("name","韩信");
        map6.put("mood","枪出如龙，照一身肝胆");


        Map<String,Object> map7 = new HashMap<>();
        map7.put("img",R.mipmap.bb);
        map7.put("name","韩信");
        map7.put("mood","枪出如龙，照一身肝胆");


        Map<String,Object> map8 = new HashMap<>();
        map8.put("img",R.mipmap.bb);
        map8.put("name","韩信");
        map8.put("mood","枪出如龙，照一身肝胆");

        Map<String,Object> map9 = new HashMap<>();
        map9.put("img",R.mipmap.bb);
        map9.put("name","韩信");
        map9.put("mood","枪出如龙，照一身肝胆");

        date.add(map1);
        date.add(map2);
        date.add(map3);
        date.add(map4);
        date.add(map5);
        date.add(map6);
        date.add(map7);
        date.add(map8);
        date.add(map9);
    }
}
