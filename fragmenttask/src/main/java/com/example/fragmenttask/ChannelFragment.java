package com.example.fragmenttask;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ChannelFragment extends Fragment {
    String s;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        s = ((MainActivity)context).sendMsg();
        Toast.makeText(context, s,Toast.LENGTH_SHORT).show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        View v = inflater.inflate(R.layout.fragment_channel, container, false);
        ((TextView)v.findViewById(R.id.txt1)).setText(bundle.getString("msg1"));
        ((TextView)v.findViewById(R.id.txt2)).setText(s);
        return v;
    }
}
