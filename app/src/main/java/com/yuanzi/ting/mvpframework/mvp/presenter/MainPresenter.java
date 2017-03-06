package com.yuanzi.ting.mvpframework.mvp.presenter;

import com.yuanzi.ting.mvpframework.base.BasePresenter;
import com.yuanzi.ting.mvpframework.mvp.model.CircleResponse;
import com.yuanzi.ting.mvpframework.mvp.view.MainView;
import com.yuanzi.ting.mvpframework.rxjava.ApiCallback;

/**
 * Created by Ting on 17/3/6.
 */

public class MainPresenter extends BasePresenter<MainView> {

    public MainPresenter(MainView view) {
        attachView(view);
    }

    public void loadCircle() {
        addSubscription(mApiService.getCircle(), new ApiCallback<CircleResponse>() {
            @Override
            public void onSuccess(CircleResponse model) {
                mMvpView.getDataSuccess(model);
            }

            @Override
            public void onFailure(String msg) {
                mMvpView.getDataFail(msg);
            }

            @Override
            public void onFinish() {

            }
        });
    }
}
