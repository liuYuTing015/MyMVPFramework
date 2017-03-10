package com.yuanzi.ting.mvpframework.mvp.view;

import com.yuanzi.ting.mvpframework.mvp.model.AccessToken;
import com.yuanzi.ting.mvpframework.mvp.model.CircleResponse;

/**
 * Created by Ting on 17/3/6.
 */

public interface LoginView {
    void qqLogin(AccessToken response);

    void wechatLogin(AccessToken response);

    void sinaLogin(AccessToken response);

    void getDataFail(String msg);
}
