package com.qwildz.digitallibrary.models;

import com.qwildz.digitallibrary.network.ApiInterface;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by resna on 2016-06-12.
 */
public class Repository {

    public static String BASE_POINT = "http://220.119.249.201/_project/elib/";
    public static String END_POINT = BASE_POINT + "app_json/";
    public static String MEDIA_POINT = BASE_POINT + "media/";

    ApiInterface apiInterface;
    Scheduler executorThread, uiThread;

    @Inject
    public Repository(ApiInterface apiInterface,
                      @Named("executor_thread") Scheduler executorThread,
                      @Named("ui_thread") Scheduler uiThread) {

        this.apiInterface = apiInterface;
        this.executorThread = executorThread;
        this.uiThread = uiThread;
    }


    public Observable<Books> getBook() {
        return apiInterface.getBook().observeOn(uiThread).subscribeOn(executorThread);
    }

    public Observable<Book> getBook(String id) {
        return apiInterface.getBook(id).observeOn(uiThread).subscribeOn(executorThread);
    }

    public Observable<Videos> getVideo() {
        return apiInterface.getVideo().observeOn(uiThread).subscribeOn(executorThread);
    }

    public Observable<Video> getVideo(String id) {
        return apiInterface.getVideo(id).observeOn(uiThread).subscribeOn(executorThread);
    }

    public Observable<News> getNews() {
        return apiInterface.getNews().observeOn(uiThread).subscribeOn(executorThread);
    }

    public Observable<News_> getNews(String id) {
        return apiInterface.getNews(id).observeOn(uiThread).subscribeOn(executorThread);
    }

    public Observable<User> getUser() {
        return apiInterface.getUser().observeOn(uiThread).subscribeOn(executorThread);
    }

    public Observable<User> getUser(String id) {
        return apiInterface.getUser(id).observeOn(uiThread).subscribeOn(executorThread);
    }
}
