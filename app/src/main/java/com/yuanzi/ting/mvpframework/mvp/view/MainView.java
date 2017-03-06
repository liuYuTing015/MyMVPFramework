package com.yuanzi.ting.mvpframework.mvp.view;

import com.yuanzi.ting.mvpframework.mvp.model.CircleResponse;

/**
 * Created by Ting on 17/3/6.
 */

public interface MainView {
    void getDataSuccess(CircleResponse response);

    void getDataFail(String msg);
}
