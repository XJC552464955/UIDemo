package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

import javax.security.auth.callback.Callback;

public class CommentActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        final EditText input_name = findViewById(R.id.input_name);
        final EditText input_comment = findViewById(R.id.input_comment);
        Button toMsg = findViewById(R.id.toMsg);
        Button cancelMsg = findViewById(R.id.cancelMsg);

        final Intent intent = new Intent();

        toMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = input_name.getText().toString();
                String comment = input_comment.getText().toString();
                Msg m = new Msg(R.mipmap.boy_portrait1, name,comment,false);
                intent.putExtra("Msg",m);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        cancelMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
