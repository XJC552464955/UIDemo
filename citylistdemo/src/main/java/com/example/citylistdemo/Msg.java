package com.example.citylistdemo;

import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Msg {
    private String zimu;
    private ArrayAdapter adapter;

    public String getZimu() {
        return zimu;
    }

    public void setZimu(String zimu) {
        this.zimu = zimu;
    }

    public ArrayAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(ArrayAdapter adapter) {
        this.adapter = adapter;
    }

    public Msg(String zimu, ArrayAdapter adapter) {
        this.zimu = zimu;
        this.adapter = adapter;
    }
}
