
package com.qwildz.digitallibrary.models;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Videos {

    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("total_videos")
    @Expose
    private Integer totalVideos;
    @SerializedName("videos")
    @Expose
    private List<Video> videos = new ArrayList<Video>();
    @SerializedName("showing")
    @Expose
    private String showing;
    @SerializedName("pages")
    @Expose
    private Pages pages;
    @SerializedName("category")
    @Expose
    private List<Category> category = new ArrayList<Category>();

    /**
     * 
     * @return
     *     The total
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * 
     * @param total
     *     The total
     */
    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * 
     * @return
     *     The totalVideos
     */
    public Integer getTotalVideos() {
        return totalVideos;
    }

    /**
     * 
     * @param totalVideos
     *     The total_videos
     */
    public void setTotalVideos(Integer totalVideos) {
        this.totalVideos = totalVideos;
    }

    /**
     * 
     * @return
     *     The videos
     */
    public List<Video> getVideos() {
        return videos;
    }

    /**
     * 
     * @param videos
     *     The videos
     */
    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    /**
     * 
     * @return
     *     The showing
     */
    public String getShowing() {
        return showing;
    }

    /**
     * 
     * @param showing
     *     The showing
     */
    public void setShowing(String showing) {
        this.showing = showing;
    }

    /**
     * 
     * @return
     *     The pages
     */
    public Pages getPages() {
        return pages;
    }

    /**
     * 
     * @param pages
     *     The pages
     */
    public void setPages(Pages pages) {
        this.pages = pages;
    }

    /**
     * 
     * @return
     *     The category
     */
    public List<Category> getCategory() {
        return category;
    }

    /**
     * 
     * @param category
     *     The category
     */
    public void setCategory(List<Category> category) {
        this.category = category;
    }

}
