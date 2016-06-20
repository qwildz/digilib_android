package com.qwildz.digitallibrary.network;

import android.content.SharedPreferences;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by resna on 2016-06-12.
 */
public class ApiInterceptor implements Interceptor {

 //   private final String token;
   // private final String userId;

    private SharedPreferences sharedPreferences;

    @Inject
    public ApiInterceptor(SharedPreferences sharedPreferences) {
        //this.token = token;
        //this.userId = userId;
        this.sharedPreferences = sharedPreferences;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request oldRequest = chain.request();

        HttpUrl.Builder authorizedUrlBuilder = oldRequest.url().newBuilder()
                .scheme(oldRequest.url().scheme())
                .host(oldRequest.url().host());


        authorizedUrlBuilder.addQueryParameter("token", sharedPreferences.getString("token", null))
                .addQueryParameter("userid", sharedPreferences.getString("userid", null));

        Request newRequest = oldRequest.newBuilder()
                .method(oldRequest.method(), oldRequest.body())
                .url(authorizedUrlBuilder.build())
                .build();

        return chain.proceed(newRequest);
    }
}
