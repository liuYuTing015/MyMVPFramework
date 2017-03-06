package com.yuanzi.ting.mvpframework.mvp;

import android.os.Bundle;

import com.yuanzi.ting.mvpframework.base.BaseActivity;
import com.yuanzi.ting.mvpframework.base.BasePresenter;

/**
 * Created by Ting on 17/3/6.
 */

public abstract class MvpActivity<P extends BasePresenter> extends BaseActivity {
    protected P mMvpPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mMvpPresenter = createPresenter();
        super.onCreate(savedInstanceState);
    }

    protected abstract P createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mMvpPresenter != null) {
            mMvpPresenter.detachView();
        }
    }
}
