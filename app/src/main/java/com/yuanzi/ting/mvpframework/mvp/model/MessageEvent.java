package com.yuanzi.ting.mvpframework.mvp.model;

/**
 * Created by Ting on 17/3/8.
 */

public class MessageEvent {

    public String getKey() {
        return message;
    }

    public final String message;

    public Object getDate() {
        return date;
    }

    public void setDate(Object date) {
        this.date = date;
    }

    public Object date;

    public MessageEvent(String message,Object o) {
        this.message = message;
        this.date = o;
    }
}
