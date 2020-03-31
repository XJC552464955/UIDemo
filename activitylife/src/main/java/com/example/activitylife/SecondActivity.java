package com.example.activitylife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent itn = getIntent();
        //获取序列化对象
        //需要进行强制类型转换
        People p = (People) itn.getSerializableExtra("peo");

        TextView txt1 = findViewById(R.id.textView2);
        txt1.setText("姓名："+p.getName() +"年龄："+ p.getAge() + "性别："+p.getSex());


        //获取上一个界面传来的数据，需要先获取启动的意图
        //使用getIntent函数，该函数返回Intent的对象

        String msg1 = itn.getStringExtra("msg1");
        int msg2 = itn.getIntExtra("msg2", 0);

        TextView txt = findViewById(R.id.textView);
        txt.setText("msg1："+msg1 + "msg2:"+msg2);


        Log.d("TAG", "onCreate2: 创建");

        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itn = new Intent();   //此时意图不做跳转使用，只传递信息
                itn.putExtra("myMsg","这是来自第二个界面的信息");
                //设置结果
                // 参数1：结果码，在上一个界面的回调函数中通过resultCode获取
                // 参数2：意图对象 ，用来放数据，在上一界面的回调函数中通过date获取
                setResult(RESULT_OK,itn);
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TAG", "onStart2: 启动");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TAG", "onResume2: 恢复");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TAG", "onPause2: 暂停");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("TAG", "onStop2: 停止");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("TAG", "onDestroy2: 销毁");
    }
}
