
package com.qwildz.digitallibrary.models;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import auto.parcelgson.gson.annotations.Expose;
import auto.parcelgson.gson.annotations.SerializedName;

import auto.parcelgson.AutoParcelGson;

@AutoParcelGson
@Generated("org.jsonschema2pojo")
public abstract class News implements Parcelable {

    @SerializedName("total")
    @Expose
    @Nullable
    public abstract Integer total();
    @SerializedName("total_news")
    @Expose
    @Nullable
    public abstract Integer totalNews();
    @SerializedName("news")
    @Expose
    @Nullable
    public abstract List<News_> news();
    @SerializedName("showing")
    @Expose
    @Nullable
    public abstract String showing();
    @SerializedName("pages")
    @Expose
    @Nullable
    public abstract Pages pages();

//    /**
//     *
//     * @return
//     *     The total
//     */
//    public Integer getTotal() {
//        return total;
//    }
//
//    /**
//     *
//     * @param total
//     *     The total
//     */
//    public void setTotal(Integer total) {
//        this.total = total;
//    }
//
//    /**
//     *
//     * @return
//     *     The totalNews
//     */
//    public Integer getTotalNews() {
//        return totalNews;
//    }
//
//    /**
//     *
//     * @param totalNews
//     *     The total_news
//     */
//    public void setTotalNews(Integer totalNews) {
//        this.totalNews = totalNews;
//    }
//
//    /**
//     *
//     * @return
//     *     The news
//     */
//    public List<News_> getNews() {
//        return news;
//    }
//
//    /**
//     *
//     * @param news
//     *     The news
//     */
//    public void setNews(List<News_> news) {
//        this.news = news;
//    }
//
//    /**
//     *
//     * @return
//     *     The showing
//     */
//    public String getShowing() {
//        return showing;
//    }
//
//    /**
//     *
//     * @param showing
//     *     The showing
//     */
//    public void setShowing(String showing) {
//        this.showing = showing;
//    }
//
//    /**
//     *
//     * @return
//     *     The pages
//     */
//    public Pages getPages() {
//        return pages;
//    }
//
//    /**
//     *
//     * @param pages
//     *     The pages
//     */
//    public void setPages(Pages pages) {
//        this.pages = pages;
//    }

}
