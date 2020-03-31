package com.example.listview;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.view.View;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseActivity extends AppCompatActivity {
    private List<Msg> list = new ArrayList<>();
    private ListView listView;
    private ImageView write;
    private Intent intent;
    private BaseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        listView = findViewById(R.id.base_list);
        write = findViewById(R.id.write);

        initDate();
        adapter = new MyAdapter(this,list);

        listView.setAdapter(adapter);

        //添加新的说说
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //打开说说编辑界面
                intent = new Intent(BaseActivity.this,CommentActivity.class);
                startActivityForResult(intent,1000);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case 1000:
                    //接收消息
                    Msg m = (Msg) data.getSerializableExtra("Msg");
                    Toast.makeText(this, "返回成功"+m, Toast.LENGTH_SHORT).show();
                    list.add(m);
                    //通知适配器更新
                    adapter.notifyDataSetChanged();
                    //设置ListView自动显示到最新数据
                    listView.setTranscriptMode(AbsListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
                    break;
            }

        }
    }

    private void initDate() {
        int[] id = {R.mipmap.boy_portrait,R.mipmap.boy_portrait1,R.mipmap.boy_portrait2,R.mipmap.girl_portrait,R.mipmap.girl_portrait2,R.mipmap.girl_portrait3};
        for (int i = 1; i < 7; i++) {
            Msg msg = new Msg(id[i-1], "用户"+i,"哇哇，这真是一堆废话，赶快闭上嘴巴" + i,false);
            list.add(msg);
        }
    }
}
