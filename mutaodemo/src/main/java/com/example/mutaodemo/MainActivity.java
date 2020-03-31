package com.example.mutaodemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.example.mutaodemo.fragment.FindFragment;
import com.example.mutaodemo.fragment.IndexFragment;
import com.example.mutaodemo.fragment.MeFragment;

public class MainActivity extends AppCompatActivity {
    private IndexFragment index;
    private FindFragment find;
    private MeFragment me;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        index = new IndexFragment();
        find = new FindFragment();
        me = new MeFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.container, index);
        transaction.commit();
    }

    public void myClick(View v){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (v.getId()){
            case R.id.index_btn:
                transaction.replace(R.id.container, index);
                break;
            case R.id.find_btn:
                transaction.replace(R.id.container, find);
                break;
            case R.id.me_btn:
                transaction.replace(R.id.container, me);
                break;
        }
        transaction.commit();
    }
}
