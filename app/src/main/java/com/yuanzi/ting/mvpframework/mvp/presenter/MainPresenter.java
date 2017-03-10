package com.yuanzi.ting.mvpframework.mvp.presenter;

import com.yuanzi.ting.mvpframework.base.BasePresenter;
import com.yuanzi.ting.mvpframework.mvp.model.CircleResponse;
import com.yuanzi.ting.mvpframework.mvp.view.MainView;
import com.yuanzi.ting.mvpframework.retrofit.Headers;
import com.yuanzi.ting.mvpframework.rxjava.ApiCallback;
import com.yuanzi.ting.mvpframework.utils.PLog;

/**
 * Created by Ting on 17/3/6.
 */

public class MainPresenter extends BasePresenter<MainView> {

    public MainPresenter(MainView view) {
        Headers headers = new Headers() {
            @Override
            public void getHeaders(Object o) {
                okhttp3.Headers headers = (okhttp3.Headers) o;
                for (int i = 0, count = headers.size(); i < count; i++) {
                    String name = headers.name(i);
                    PLog.i("请求头在这里           :"+name + ": " + headers.value(i));
                }
            }
        };
        attachView(view,headers);
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
