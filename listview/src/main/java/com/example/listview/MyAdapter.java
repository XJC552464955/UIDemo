package com.example.listview;

import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.security.PublicKey;
import java.util.List;
import java.util.PriorityQueue;

import javax.security.auth.login.LoginException;

public class MyAdapter extends BaseAdapter {
    private List<Msg> list;
    private Context context;
    private ViewHolder holder;

    public MyAdapter(Context context, List<Msg> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

//        Log.e("TAG","----"+ position);
        if(convertView == null){
            Log.e("TAG","----"+ position);
            convertView = LayoutInflater.from(context).inflate(R.layout.base_list,null);
            //实例化ViewHolder
            holder = new ViewHolder();
            holder.portraait = convertView.findViewById(R.id.portrait);
            holder.name = convertView.findViewById(R.id.name);
            holder.comment = convertView.findViewById(R.id.comment_txt);
            holder.like = convertView.findViewById(R.id.support);
            //调用setTag()将holder也加入resysclebin中
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        final Msg m = list.get(position);

        //设置头像
//        ImageView portraait = convertView.findViewById(R.id.portrait);
        holder.portraait.setImageResource(m.getPortrait());

        //昵称
//        final TextView name = convertView.findViewById(R.id.name);
        holder.name.setText(m.getName());
        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final MyDialog myDialog = new MyDialog(context,R.style.mydialog);
                myDialog.setCancelable(false);
                final EditText text = myDialog.findViewById(R.id.set_name);

                myDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        if(myDialog.isFlag()){
                            holder.name.setText(text.getText());
                        }
                    }
                });

                myDialog.show();
            }
        });

        //说说内容
//        TextView  comment= convertView.findViewById(R.id.comment_txt);
        holder.comment.setText(m.getComment());

        //点赞
//        final ImageView like = convertView.findViewById(R.id.support);
        holder.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m.setIssupport(true);
                if(m.isIssupport()){
                    holder.like.setImageResource(R.mipmap.support);
                }else {
                    holder. like.setImageResource(R.mipmap.upsupported);
                }
            }
        });


        return convertView;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    //自定义内部类
    static class ViewHolder{
        public ImageView portraait,like;
        public TextView name,comment;
    }
}
