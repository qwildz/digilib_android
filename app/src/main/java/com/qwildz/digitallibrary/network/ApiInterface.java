package com.qwildz.digitallibrary.network;

import com.qwildz.digitallibrary.models.Book;
import com.qwildz.digitallibrary.models.Books;
import com.qwildz.digitallibrary.models.News;
import com.qwildz.digitallibrary.models.News_;
import com.qwildz.digitallibrary.models.User;
import com.qwildz.digitallibrary.models.Video;
import com.qwildz.digitallibrary.models.Videos;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by resna on 2016-06-12.
 */
public interface ApiInterface {
    @GET("book")
    Observable<Books> getBook();

    @GET("book")
    Observable<Book> getBook(@Query("id") String id);

    @GET("video")
    Observable<Videos> getVideo();

    @GET("video")
    Observable<Video> getVideo(@Query("id") String id);

    @GET("news")
    Observable<News> getNews();

    @GET("video")
    Observable<News_> getNews(@Query("id") String id);

    @GET("user")
    Observable<User> getUser();

    @GET("user")
    Observable<User> getUser(@Query("id") String id);
}