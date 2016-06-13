package com.qwildz.digitallibrary.network;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by resna on 2016-06-12.
 */
public class ApiInterceptor implements Interceptor {

    private final String token;
    private final String userId;

    public ApiInterceptor(String token, String userId) {
        this.token = token;
        this.userId = userId;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request oldRequest = chain.request();

        HttpUrl.Builder authorizedUrlBuilder = oldRequest.url().newBuilder()
                .scheme(oldRequest.url().scheme())
                .host(oldRequest.url().host());


        authorizedUrlBuilder.addQueryParameter("token", token)
                .addQueryParameter("userid", userId);

        Request newRequest = oldRequest.newBuilder()
                .method(oldRequest.method(), oldRequest.body())
                .url(authorizedUrlBuilder.build())
                .build();

        return chain.proceed(newRequest);
    }
}
