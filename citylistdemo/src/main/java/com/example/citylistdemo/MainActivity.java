package com.example.citylistdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.citylistdemo.util.DateUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private GridView grid;
    private ListView listview1;
    private ListView listview2;
    private List<Msg> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //GridView
        grid = findViewById(R.id.grid);
        String[] gridDate = {"北京","上海","广州","深圳","武汉","惠州"};
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,R.layout.hot_city,R.id.hotcity,gridDate);
        grid.setAdapter(adapter);

        //字母ListView
        listview1 = findViewById(R.id.list1);
        String[]  zimu= {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

        for (int i = 0; i < 26; i++) {
            list.add(new Msg(zimu[i],new ArrayAdapter(MainActivity.this,R.layout.city,R.id.name, DateUtil.date().get(i))));
        }

        BaseAdapter  adapter1 = new MyAdapter(list, MainActivity.this);
        listview1.setAdapter(adapter1);
    }

}
