package com.qwildz.digitallibrary.injector.modules;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.qwildz.digitallibrary.injector.scopes.Application;
import com.qwildz.digitallibrary.network.ApiInterceptor;
import com.qwildz.digitallibrary.network.ApiInterface;

import javax.inject.Named;

import auto.parcelgson.gson.AutoParcelGsonTypeAdapterFactory;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by resna on 2016-06-12.
 */
@Module
public class NetworkModule {

    private String uri;

    public NetworkModule(String uri) {
        this.uri = uri;
    }

//    @Application
//    @Provides
//    ApiInterceptor provideApiInterceptor() {
//        return new ApiInterceptor("0218fab2e24e70085b0faa085032ecd3", "6");
//    }

    @Application
    @Provides
    HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    @Application
    @Provides
    OkHttpClient provideOkHttpClient(ApiInterceptor apiInterceptor, HttpLoggingInterceptor httpLoggingInterceptor) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(apiInterceptor);
        builder.addInterceptor(httpLoggingInterceptor);
        return builder.build();
    }

    @Application
    @Provides
    @Named("GSON_PARCEABLE")
    Gson provideGson() {
        return new GsonBuilder().registerTypeAdapterFactory(new AutoParcelGsonTypeAdapterFactory()).create();
    }

    @Application
    @Provides
    Retrofit provideRetrofit(OkHttpClient okHttpClient, @Named("GSON_PARCEABLE") Gson gson) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(uri)
                .client(okHttpClient)

                .build();
        return retrofit;
    }

    @Application
    @Provides
    ApiInterface provideApiInterface(Retrofit retrofit) {
        return retrofit.create(ApiInterface.class);
    }

}
