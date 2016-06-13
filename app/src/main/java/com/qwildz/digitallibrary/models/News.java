
package com.qwildz.digitallibrary.models;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class News {

    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("total_news")
    @Expose
    private Integer totalNews;
    @SerializedName("news")
    @Expose
    private List<News_> news = new ArrayList<News_>();
    @SerializedName("showing")
    @Expose
    private String showing;
    @SerializedName("pages")
    @Expose
    private Pages pages;

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
     *     The totalNews
     */
    public Integer getTotalNews() {
        return totalNews;
    }

    /**
     * 
     * @param totalNews
     *     The total_news
     */
    public void setTotalNews(Integer totalNews) {
        this.totalNews = totalNews;
    }

    /**
     * 
     * @return
     *     The news
     */
    public List<News_> getNews() {
        return news;
    }

    /**
     * 
     * @param news
     *     The news
     */
    public void setNews(List<News_> news) {
        this.news = news;
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

}
