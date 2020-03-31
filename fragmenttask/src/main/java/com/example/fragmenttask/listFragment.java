package com.example.fragmenttask;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
public class listFragment extends Fragment {

    private myListener myListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        myListener = (myListener) context;
//        myListener.sendMsg("Fragment向Activity传递数据");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list, container, false);
        v.findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myListener.sendMsg("Fragment向Activity传递数据");
            }
        });
        return v;
    }

    public interface myListener{
        public void sendMsg(String msg);
    }
}
