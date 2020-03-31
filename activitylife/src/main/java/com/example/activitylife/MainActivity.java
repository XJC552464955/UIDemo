package com.example.activitylife;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("TAG", "onCreate: 创建");

        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //显示启动
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });

        //隐式启动系统界面
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //隐式启动系统界面
                Intent itn = new Intent(Intent.ACTION_VIEW, Uri.parse("tel://17725835670"));
                startActivity(itn);
            }
        });

        //隐式启动普通界面
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //com.second  在AndroidMainfest.xml文件中定义
                Intent intent = new Intent("com.second");
                startActivity(intent);
            }
        });


        //带返回的启动界面
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.second");
                //requestCode请求码，在返回时用来区分是哪个界面传回的信息
                startActivityForResult(intent, 1000);
            }
        });

        //将数据传输到第二个Activity
        findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                //putExtra函数可以传递的数据
                intent.putExtra("msg1","这是数据1");
                intent.putExtra("msg2",1000);
                startActivity(intent);
            }
        });

        //传递对象
        findViewById(R.id.button6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                People people = new People("张三",20,"男");
                intent.putExtra("peo", people);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            //requestCode用来区分结果是来自那个Activity
            if(requestCode == 1000){
                //resultCode ：0  RESULT_CANCEL 取消     -1，RESULT_OK   正常处理完返回
                Log.e("TAG", "onActivityResult: requestCode——"+requestCode+" resultCode——"+resultCode);
                Log.e("TAG", "onActivityResult: date——"+data.getStringExtra("myMsg"));
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TAG", "onStart: 启动");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TAG", "onResume: 恢复");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TAG", "onPause: 暂停");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("TAG", "onStop: 停止");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("TAG", "onDestroy: 销毁");
    }
}
