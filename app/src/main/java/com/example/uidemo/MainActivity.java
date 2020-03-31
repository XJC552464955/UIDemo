package com.example.uidemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.text.UnicodeSetSpanner;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.toTestbutton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建意图跳转Activity的对象
                Intent intent = new Intent(MainActivity.this,TestActivity.class);
                //开始跳转
                startActivity(intent);
            }
        });

        final Button popup_btn=findViewById(R.id.button3);
        popup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //实例化PopupMenu对象 参数1：环境上下文对象，参数2：控件
                PopupMenu menu = new PopupMenu(MainActivity.this,popup_btn);
                //加载菜单资源，利用MenuInflater
                menu.getMenuInflater().inflate(R.menu.popup,menu.getMenu());
                //监听器 setOnMenuItemClickListener设置菜单项的点击监听器
                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.copy:
                            Toast.makeText(MainActivity.this, "复制", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.paste:
                            Toast.makeText(MainActivity.this, "粘贴", Toast.LENGTH_SHORT).show();
                            break;
                        }
                        return false;
                    }
                });
                //显示菜单
                menu.show();
            }
        });

//        findViewById(R.id.button2).setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                startActionMode(cb);
//                return false;
//            }
//        });



        //1.注册  registerForContextMenu(关联的View)
        registerForContextMenu(findViewById(R.id.button2));
        //2.创建
        //3.菜单项操作
    }

    //创建上下文菜单，关联xml文件
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context,menu);
    }

//    菜单项操作
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.copy:
                Toast.makeText(this,"复制",Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                Toast.makeText(this,"删除",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }
//
//    ActionMode.Callback cb = new ActionMode.Callback() {
//        @Override
//        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
//            //关联菜单资源
//            Toast.makeText(MainActivity.this, "创建", Toast.LENGTH_SHORT).show();
//            getMenuInflater().inflate(R.menu.context,menu);
//            return true;
//        }
//
//        @Override
//        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
//            Toast.makeText(MainActivity.this, "准备", Toast.LENGTH_SHORT).show();
//            return true;
//        }
//
//        @Override
//        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
//                    switch(item.getItemId()) {
//                        case R.id.copy:
//                            Toast.makeText(MainActivity.this, "复制", Toast.LENGTH_SHORT).show();
//                            break;
//                        case R.id.delete:
//                            Toast.makeText(MainActivity.this, "删除", Toast.LENGTH_SHORT).show();
//                            break;
//                    }
//            return true;
//        };
//
//        @Override
//        public void onDestroyActionMode(ActionMode mode) {
//            Toast.makeText(MainActivity.this, "结束了", Toast.LENGTH_SHORT).show();
//        }
//    };

    //关联菜单资源OncreatOptionMenu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //加载菜单资源
        //参数1：关联的资源文件
        //参数2：显示的菜单
        getMenuInflater().inflate(R.menu.option,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.newItem:
                Toast.makeText(this,"新建",Toast.LENGTH_SHORT).show();
                break;
            case R.id.saveItem:
                Toast.makeText(this,"保存",Toast.LENGTH_SHORT).show();
                break;
            case R.id.settingItem:
                Toast.makeText(this,"设置",Toast.LENGTH_SHORT).show();
                break;
            default:
                super.onOptionsItemSelected(item);
        }
        return true;
    }


    public void myClick(View view) {
        switch (view.getId()){
            case R.id.button4:
                //实例一个Builder对象
              AlertDialog.Builder builder = new AlertDialog.Builder(this);
              //设置对话框样式
                builder.setTitle("提示");  //提示
                builder.setMessage("是否退出程序？");  //提示内容
                //设置确定按钮
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();  //退出程序
                    }
                });
                //设置取消按钮
                builder.setNegativeButton("取消", null);
                builder.create();
                builder.show();
                break;

            case R.id.button5:
                final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
                alertDialog.setTitle("提示");
                alertDialog.setMessage("是否退出程序？");
                alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertDialog.show();
                break;

            case R.id.button6:
                Toast.makeText(MainActivity.this, "点击了", Toast.LENGTH_SHORT).show();
//                MyDialog dialog = new MyDialog(this);     使用默认主题风格
                MyDialog dialog = new MyDialog(this, R.style.mydialog);
                dialog.show();
                break;
        }
    }

}
