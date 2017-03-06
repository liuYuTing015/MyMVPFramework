package com.yuanzi.ting.mvpframework.mvp.model;

import android.content.Context;
import android.content.Intent;

/**
 * Created by gaoyan on 17/2/10.
 */

public class Banner {
    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public String cover;//: "http://assets-dev.iyuanzi.net/banner/481d390c-d08d-498e-943a-418ef3b05a15",
    public String url;//     "": "http://e-policy.minanins.com/prod/qyjy_1198001.html"
    public Label label;

    public Intent generateIntent(Context context) {
//        return URLParse.getIntent(context, url, cover, label);
        return null;
    }
}
