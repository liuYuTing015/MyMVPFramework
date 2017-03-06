package com.yuanzi.ting.mvpframework.mvp.model;

import android.widget.TextView;

/**
 * Created by gaoyan on 17/2/10.
 */

public class Label {
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getLabelId() {
        return labelId;
    }

    public void setLabelId(String labelId) {
        this.labelId = labelId;
    }

    public String getLabelProperty() {
        return labelProperty;
    }

    public void setLabelProperty(String labelProperty) {
        this.labelProperty = labelProperty;
    }

    public String title;//": "魅力达人",
    public String cover;
    public String color;//": "#3e8ea1",
    public String labelId;
    public String labelProperty;

    public void fill(TextView mName) {
        mName.setText(title);
    }

}
