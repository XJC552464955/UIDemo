package com.example.fragmenttask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements listFragment.myListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.container, new IndexFragment());
        transaction.commit();
    }

    public void myClick(View v){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (v.getId()){
            case R.id.rb_index:
                //replace  只保留一个Fragment进行切换样式
                transaction.replace(R.id.container, new IndexFragment());
                break;
            case R.id.rb_channel:
                Fragment f1 = new ChannelFragment();
                Bundle bundle = new Bundle();
                bundle.putString("msg1","通过setArguments传递信息");
                f1.setArguments(bundle);
                transaction.replace(R.id.container, f1);
                break;
            case R.id.rb_list:
                transaction.replace(R.id.container, new listFragment());
                break;
            case R.id.rb_me:
                transaction.replace(R.id.container, new MeFragment());
                break;
        }
        transaction.commit();
    }

    public String sendMsg(){
        return "这是普通方法传递数据";
    }

    @Override
    public void sendMsg(String msg) {
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
    }
}
