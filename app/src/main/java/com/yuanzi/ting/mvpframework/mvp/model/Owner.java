package com.yuanzi.ting.mvpframework.mvp.model;

import java.util.List;

/**
 * Created by gaoyan on 17/2/10.
 */

public class Owner {
    public String getAvatar() {
        return avatar;//+ "@200w_200h_1e_1c_200-0ci.png"
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperienceValue() {
        return experienceValue;
    }

    public void setExperienceValue(int experienceValue) {
        this.experienceValue = experienceValue;
    }

    public boolean isTalent() {
        return isTalent;
    }

    public void setIsTalent(boolean isTalent) {
        this.isTalent = isTalent;
    }

    public String avatar;
    public List<Label> labels;
    public String nickname;
    public String userId;
    private int level;
    private int experienceValue;
    private boolean isTalent;
}
