package com.example.mutaodemo.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.mutaodemo.LoginActivity;
import com.example.mutaodemo.R;
import com.example.mutaodemo.util.DateUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.security.auth.login.LoginException;

public class MeFragment extends Fragment {
    private List<Map<String,Object>> date = new ArrayList<>();
    private ListView listView;
    private SimpleAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
          View v = inflater.inflate(R.layout.fragment_me, container, false);

          v.findViewById(R.id.login_btn).setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  //getContext()获取当前Fragment所在Activity
                  startActivity(new Intent(getContext(), LoginActivity.class));
              }
          });

          listView = v.findViewById(R.id.listview);

        if(adapter==null){
              initDate();

              String[] from = {"img","txt"};
              int[] to = {R.id.me_img,R.id.me_txt};

              adapter = new SimpleAdapter(getContext(),date,R.layout.me_items,from,to);
          }
          listView.setAdapter(adapter);

        Log.e("TAG",""+adapter.getCount());
        return v;
    }

    private void initDate() {
        for (int i = 0; i < DateUtils.me_img.length; i++) {
            Map<String,Object> map = new HashMap<>();
            map.put("img",DateUtils.me_img[i]);
            map.put("txt",DateUtils.me_txt[i]);
            date.add(map);
        }
    }
}
