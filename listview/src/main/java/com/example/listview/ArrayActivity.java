package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ArrayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array);
        //布局
        ListView listView = findViewById(R.id.list_view);

        //数据源
        String[] date = getResources().getStringArray(R.array.date);

        //new ArrayAdapter(环境上下文, 应用布局资源，数据源);
        // 自己设置的资源
        //ArrayAdapter adapter = new ArrayAdapter(this,R.layout.array_list, date);
        //使用自带资源
        //simple_list_item_1   纯文字普通样式的资源
//        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, date);

        //new ArrayAdapter(环境上下文, 应用布局资源, 指定TextView,数据源);
        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.array_list2, R.id.Array_txt,date);
        listView.setAdapter(adapter);
    }
}
