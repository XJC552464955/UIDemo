package com.example.listview;

import android.app.Dialog;
import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class MyDialog extends Dialog {
    private boolean flag;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public MyDialog(@NonNull final Context context, int themeResId) {
        super(context, themeResId);
        setContentView(R.layout.setname);

        findViewById(R.id.yes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //判断输入框是否为空，不为空则继续输入，否退出
                EditText editText = findViewById(R.id.set_name);
                if(editText.getText().toString().equals("")){
                    Toast.makeText(context,"昵称不能为空", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(context,"更改昵称为："+editText.getText().toString(), Toast.LENGTH_SHORT).show();
                    setFlag(true);
                    dismiss();
                }

            }
        });

        findViewById(R.id.no).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFlag(false);
                dismiss();
            }
        });

    }
}
