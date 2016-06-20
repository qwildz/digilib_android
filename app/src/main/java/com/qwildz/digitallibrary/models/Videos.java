
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
public abstract class Videos implements Parcelable {

    @SerializedName("total")
    @Expose @Nullable
    public abstract Integer total();
    @SerializedName("total_videos")
    @Expose @Nullable
    public abstract Integer totalVideos();
    @SerializedName("videos")
    @Expose @Nullable
    public abstract List<Video> videos();
    @SerializedName("showing")
    @Expose @Nullable
    public abstract String showing();
    @SerializedName("pages")
    @Expose @Nullable
    public abstract Pages pages();
    @SerializedName("category")
    @Expose @Nullable
    public abstract List<Category> category();

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
//     *     The totalVideos
//     */
//    public Integer getTotalVideos() {
//        return totalVideos;
//    }
//
//    /**
//     *
//     * @param totalVideos
//     *     The total_videos
//     */
//    public void setTotalVideos(Integer totalVideos) {
//        this.totalVideos = totalVideos;
//    }
//
//    /**
//     *
//     * @return
//     *     The videos
//     */
//    public List<Video> getVideos() {
//        return videos;
//    }
//
//    /**
//     *
//     * @param videos
//     *     The videos
//     */
//    public void setVideos(List<Video> videos) {
//        this.videos = videos;
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
//
//    /**
//     *
//     * @return
//     *     The category
//     */
//    public List<Category> getCategory() {
//        return category;
//    }
//
//    /**
//     *
//     * @param category
//     *     The category
//     */
//    public void setCategory(List<Category> category) {
//        this.category = category;
//    }

}
