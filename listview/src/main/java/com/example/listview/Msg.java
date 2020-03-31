package com.example.listview;

import java.io.Serializable;

public class Msg implements Serializable {
    //头像   名字   事件
    private int portrait;
    private String name;
    private String comment;
    private boolean issupport;

    public Msg(int portrait, String name, String comment, boolean issupport) {
        this.portrait = portrait;
        this.name = name;
        this.comment = comment;
        this.issupport = issupport;
    }

    public int getPortrait() {
        return portrait;
    }

    public void setPortrait(int portrait) {
        this.portrait = portrait;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isIssupport() {
        return issupport;
    }

    public void setIssupport(boolean issupport) {
        this.issupport = issupport;
    }
}
