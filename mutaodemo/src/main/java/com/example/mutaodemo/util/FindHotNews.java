package com.example.mutaodemo.util;

import android.widget.ImageView;

public class FindHotNews {
    //头条描述 展示图像 头条来源  观看图像 观看人数 点赞图片 点赞人数
    private String describe;
    private int portrait;
    private String from;
    private int see_num;
    private int zan_num;

    public FindHotNews(String describe, int portrait, String from, int see_num, int zan_num) {
        this.describe = describe;
        this.portrait = portrait;
        this.from = from;
        this.see_num = see_num;
        this.zan_num = zan_num;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public int getPortrait() {
        return portrait;
    }

    public void setPortrait(int portrait) {
        this.portrait = portrait;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public int getSee_num() {
        return see_num;
    }

    public void setSee_num(int see_num) {
        this.see_num = see_num;
    }

    public int getZan_num() {
        return zan_num;
    }

    public void setZan_num(int zan_num) {
        this.zan_num = zan_num;
    }
}
