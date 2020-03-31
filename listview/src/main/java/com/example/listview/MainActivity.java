package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void myClick(View view) {
        switch (view.getId()){
            case R.id.ary_btn:
                startActivity(new Intent(MainActivity.this, ArrayActivity.class));
                break;
            case R.id.simple_btn:
                startActivity(new Intent(MainActivity.this,SimpleActivity.class));
                break;
            case R.id.base_btn:
                startActivity(new Intent(MainActivity.this, BaseActivity.class));
                break;
        }
    }
}
