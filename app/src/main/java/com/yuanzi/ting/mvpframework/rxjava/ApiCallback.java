package com.yuanzi.ting.mvpframework.rxjava;

import retrofit2.adapter.rxjava.HttpException;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import rx.Subscriber;

/**
 * Created by Ting on 17/3/4.
 */

public abstract class ApiCallback<M> extends Subscriber<M> {

    public abstract void onSuccess(M model);

    public abstract void onFailure(String msg);

    public abstract void onFinish();


    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            //httpException.response().errorBody().string()
            int code = httpException.code();
            String msg = httpException.getMessage();
            //LogUtil.d("code=" + code);
            if (code == 504) {
                msg = "网络不给力";
            }
            if (code == 502 || code == 404) {
                msg = "服务器异常，请稍后再试";
            }
            onFailure(msg);
        } else {
            onFailure(e.getMessage());
        }
        onFinish();
    }

    @Override
    public void onNext(M model) {
        onSuccess(model);

    }



    @Override
    public void onCompleted() {
        onFinish();
    }

}
