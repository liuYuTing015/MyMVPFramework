package com.yuanzi.ting.mvpframework.retrofit;

import com.yuanzi.ting.mvpframework.mvp.model.CircleResponse;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import rx.Observable;

/**
 * Created by Ting on 17/3/4.
 */

public interface ApiService {

    String HOST = "https://test.iyuanzi.com/";

    @Headers({"Accept:application/vnd.yuanzi.v4+json"
            , "Content-Type: application/json",
            "Authorization: Bearer unsign"
    })
    @GET("circles")
    Observable<CircleResponse> getCircle();
}
