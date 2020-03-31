package com.example.fragmenttest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1.获取FragmentManeger
        FragmentManager manager = getSupportFragmentManager();

        //2.获取FragmentTransaction
        FragmentTransaction transaction = manager.beginTransaction();


        //3.动态添加Fragment
        //参数1:容器ID
        //参数2：Fragment对象
        final  Fragment f2 = new Fragment2();
        transaction.add(R.id.container, f2);

        //4.提交事务
        transaction.commit();

        //添加点击事件
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1.获取FragmentManeger
                FragmentManager manager = getSupportFragmentManager();

                //2.获取Fragment对象
                Fragment f1 = manager.findFragmentById(R.id.fragment1);

                //3.获取Fragment对象视图
                View v1 = f1.getView();

                //4.在视图里找到指定的控件
                TextView txt1 = v1.findViewById(R.id.txt1);

                //5.修改控件内容
                txt1.setText("改变了Text");

                View v2 = f2.getView();
                TextView txt2 = v2.findViewById(R.id.txt2);
                txt2.setText("改变了Text2");
            }
        });
    }
}
