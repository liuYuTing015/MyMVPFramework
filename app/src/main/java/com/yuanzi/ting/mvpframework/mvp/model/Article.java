package com.yuanzi.ting.mvpframework.mvp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaoyan on 17/2/10.
 */

public class Article {
    public String articleId;    //帖子id
    public Owner owner;         //发帖者
    public int collectedCount;  //帖子收藏数
    public int praisesCount;    //帖子点赞数
    public int reportsCount;    //帖子举报数
    public int commentsCount;     //帖子评论数
    public boolean isCollected; //是否收藏
    public boolean isPraised;   //是否点赞
    public boolean isReported;  //是否举报
//    public List<Comment> comments;//评论列表
    public List<String> photos = new ArrayList<>();//图片列表
    public String title;
    public String createdAt;
    public String operatedAt;
    private boolean opened;
    public List<Labels> labels;
    public Circle circle;
//    public Additional additional;
//
//    public Additional getAdditional() {
//        return additional;
//    }
//
//    public void setAdditional(Additional additional) {
//        this.additional = additional;
//    }

    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    public List<Labels> getLabels() {
        return labels;
    }

    public void setLabels(List<Labels> labels) {
        this.labels = labels;
    }

    public String getOperatedAt() {
        return operatedAt;
    }

    public void setOperatedAt(String operatedAt) {
        this.operatedAt = operatedAt;
    }

    public void addImage(String url) {
        photos.add(url);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

//    public List<Comment> getComments() {
//        return comments;
//    }
//
//    public void setComments(List<Comment> comments) {
//        this.comments = comments;
//    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public int getCollectedCount() {
        return collectedCount;
    }

    public void setCollectedCount(int collectedCount) {
        this.collectedCount = collectedCount;
    }

    public int getPraisesCount() {
        return praisesCount;
    }

    public void setPraisesCount(int praisesCount) {
        this.praisesCount = praisesCount;
    }

    public int getReportsCount() {
        return reportsCount;
    }

    public void setReportsCount(int reportsCount) {
        this.reportsCount = reportsCount;
    }

    public boolean isCollected() {
        return isCollected;
    }

    public void setCollected(boolean collected) {
        isCollected = collected;
    }

    public boolean isPraised() {
        return isPraised;
    }

    public void setPraised(boolean praised) {
        isPraised = praised;
    }

    public boolean isReported() {
        return isReported;
    }

    public void setReported(boolean reported) {
        isReported = reported;
    }

//    public String getCreatedAtTime() {
//        return TimeUtils.SIMPLE_TIME_FORMAT.format(TimeUtils.parseDate(createdAt));
//    }
//
//    public String getSimpleCreatedAtTime() {
//        return TimeUtils.SIMPLE_DATE_FORMAT.format(TimeUtils.parseDate(createdAt));
//    }

    public boolean isOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }
}
