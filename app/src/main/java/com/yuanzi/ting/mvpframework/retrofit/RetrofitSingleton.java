package com.yuanzi.ting.mvpframework.retrofit;

import android.util.Log;

import com.yuanzi.ting.mvpframework.BuildConfig;
import com.yuanzi.ting.mvpframework.base.BaseApplication;
import com.yuanzi.ting.mvpframework.utils.CommonUtil;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by zk on 2015/12/16.
 * update by hugo thanks for brucezz
 */
public class RetrofitSingleton {

    private static ApiService sApiService = null;
    private static Retrofit sRetrofit = null;
    private static OkHttpClient sOkHttpClient = null;

    private void init() {
        initOkHttp();
        initRetrofit();
        sApiService = sRetrofit.create(ApiService.class);
    }

    public RetrofitSingleton() {
        init();
    }

    public static RetrofitSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final RetrofitSingleton INSTANCE = new RetrofitSingleton();
    }

    private static void initOkHttp() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        // 缓存 http://www.jianshu.com/p/93153b34310e
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
            builder.addInterceptor(loggingInterceptor);
        }

        File cacheFile = new File(BaseApplication.getAppCacheDir(), "/NetCache");
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);
        Interceptor cacheInterceptor = chain -> {
            Request request = chain.request();
            if (!CommonUtil.isNetworkConnected(BaseApplication.getAppContext())) {
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build();
            }
            Response response = chain.proceed(request);
            Response.Builder newBuilder = response.newBuilder();
            if (CommonUtil.isNetworkConnected(BaseApplication.getAppContext())) {
                int maxAge = 0;
                // 有网络时 设置缓存超时时间0个小时
                newBuilder.header("Cache-Control", "public, max-age=" + maxAge);
            } else {
                // 无网络时，设置超时为4周
                int maxStale = 60 * 60 * 24 * 28;
                newBuilder.header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale);
            }
            return newBuilder.build();
        };
        Interceptor requestInterceptor = chain -> {
            Request request = chain.request()
                    .newBuilder()
                    .addHeader("Accept", "application/vnd.yuanzi.v4+json")
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Range", "page:1,max:10")
                    .addHeader("Authorization", "Bearer unsign")
                    .build();
            Log.v("zcb", "request:" + request.toString());
            Log.v("zcb", "request headers:" + request.headers().toString());
            return chain.proceed(request);
        };
        builder.cache(cache).addInterceptor(cacheInterceptor);
        builder.addNetworkInterceptor(requestInterceptor);

        //设置超时
        builder.connectTimeout(15, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.writeTimeout(20, TimeUnit.SECONDS);
        //错误重连
        builder.retryOnConnectionFailure(true);
        sOkHttpClient = builder.build();
    }

    private static void initRetrofit() {
        sRetrofit = new Retrofit.Builder()
                .baseUrl(ApiService.HOST)
                .client(sOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public ApiService getApiService() {
        return sApiService;
    }

}
