package com.yuanzi.ting.mvpframework.mvp.model;

import java.util.List;

/**
 * Created by gaoyan on 17/2/10.
 */

public class CircleResponse {
    public List<Circle> circles;
    public List<Circle> hotCircles;
    public List<Banner> banners;

    public List<Circle> getHotCircles() {
        return hotCircles;
    }

    public void setHotCircles(List<Circle> hotCircles) {
        this.hotCircles = hotCircles;
    }

    public List<Banner> getBanners() {
        return banners;
    }

    public void setBanners(List<Banner> banners) {
        this.banners = banners;
    }

    public List<Circle> getCircles() {
        return circles;
    }

    public void setCircles(List<Circle> circles) {
        this.circles = circles;
    }
}
