package com.example.uidemo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TabHost;
import android.widget.Toast;

public class PopupWindowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window);

        Button button = findViewById(R.id.button7);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showArrayDialog();
            }
        });
    }

    //设置数组适配器
    private void showArrayDialog() {
        final String[] items = {"...", "Baidu", "Android", "Music", "Video"};
        //数组适配器 参数1：环境    参数2：布局资源索引，指的是每一项数据所呈现的样式   参数3：数据源
//        //安卓自带样式  android.R.layout.xxx
////        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, items);

        //数组适配器
        // 参数1：环境
        // 参数2：布局资源索引，指的是每一项数据所呈现的样式
        // 参数3：int textViewId 指定对应的TextView
        // 参数4：数据源
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.array_item_layout, R.id.item_txt, items);
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("请选择:")
                //参数1：适配器对象(对数据显示样式的规则制定器)
                //参数2：监听器对象
                .setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(PopupWindowActivity.this,items[which], Toast.LENGTH_SHORT).show();
                    }
                });

        builder.show();
    }

    //设置popupwindow
    public void showPopupWindow(View view){
        // 要将布局变成一个View，需要使用LayoutInflater.from()
        View v = LayoutInflater.from(this).inflate(R.layout.popupwindow,null);

        //1.实例化popupwindow
        //参数1：用在弹窗中view
        //参数2，3：弹窗的宽高
        //参数4：能否获取焦点
        final PopupWindow popupWindow = new PopupWindow(v, 480, 90, true);

        //2.设置动画
        //设置背景
        //设置透明背景
        /**
        popupWindow.setBackgroundDrawable(new Drawable() {
            @Override
            public void draw(@NonNull Canvas canvas) {

            }

            @Override
            public void setAlpha(int alpha) {

            }

            @Override
            public void setColorFilter(@Nullable ColorFilter colorFilter) {

            }

            @Override
            public int getOpacity() {
                return 0;
            }
        });*/
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        //设置响应外部的点击事件
        popupWindow.setOutsideTouchable(true);

        //动画
        //1.创建动画资源  2.创建一个style应用动画资源   3.对当前弹窗动画风格设置为第二部的资源索引
        popupWindow.setAnimationStyle(R.style.translate_anim);


        //3.显示
        //参数一(anchor)：描点，对其的控件
        //参数2，3：相对于锚点的偏移量
        popupWindow.showAsDropDown(view, -180, 0);

        v.findViewById(R.id.copy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PopupWindowActivity.this,"复制", Toast.LENGTH_SHORT).show();
                popupWindow.dismiss();
            }
        });

        v.findViewById(R.id.paste).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PopupWindowActivity.this,"粘贴", Toast.LENGTH_SHORT).show();
                popupWindow.dismiss();
            }
        });

        v.findViewById(R.id.chose).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PopupWindowActivity.this,"全选", Toast.LENGTH_SHORT).show();
                popupWindow.dismiss();
            }
        });
    }

}
