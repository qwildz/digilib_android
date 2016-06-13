package com.qwildz.digitallibrary.injector.components;

import com.qwildz.digitallibrary.injector.modules.NetworkModule;
import com.qwildz.digitallibrary.injector.modules.ThreadingModule;
import com.qwildz.digitallibrary.injector.scopes.Application;
import com.qwildz.digitallibrary.network.ApiInterceptor;
import com.qwildz.digitallibrary.network.ApiInterface;

import javax.inject.Named;

import dagger.Component;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import rx.Scheduler;

/**
 * Created by resna on 2016-06-12.
 */
@Application
@Component(modules = {NetworkModule.class, ThreadingModule.class}, dependencies = AppComponent.class)
public interface BaseComponent {

    ApiInterceptor apiInterceptor();
    HttpLoggingInterceptor httpLoggingInterceptor();
    OkHttpClient okHttpClient();
    Retrofit retrofit();
    ApiInterface apiInterface();


    @Named("ui_thread")
    Scheduler mainThread();

    @Named("executor_thread")
    Scheduler executorThread();

}
