package com.example.fragmenttest;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 该啊方法返回一个view对象
        View v = inflater.inflate(R.layout.fragment_fragment2, container, false);
        v.findViewById(R.id.txt2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //通过管理器开启事务
                // getFragmentManager(),这里的管理器实例和Activity中实例调用的方法不同
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.add(R.id.container, new Fragment3());
                //移除Fragment
//                transaction.remove(Fragment2.this);
                transaction.commit();
            }
        });
        return v;
    }
}
