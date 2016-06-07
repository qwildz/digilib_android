
package com.qwildz.digitallibrary.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Video {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("judul")
    @Expose
    private String judul;
    @SerializedName("deskripsi")
    @Expose
    private String deskripsi;
    @SerializedName("filevideo")
    @Expose
    private String filevideo;
    @SerializedName("gambar")
    @Expose
    private String gambar;
    @SerializedName("kategori")
    @Expose
    private String kategori;
    @SerializedName("watched")
    @Expose
    private String watched;
    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("rater")
    @Expose
    private String rater;
    @SerializedName("posted")
    @Expose
    private String posted;
    @SerializedName("related")
    @Expose
    private List<Related> related = new ArrayList<Related>();
    @SerializedName("watcher")
    @Expose
    private List<Watcher> watcher = new ArrayList<Watcher>();

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The judul
     */
    public String getJudul() {
        return judul;
    }

    /**
     * 
     * @param judul
     *     The judul
     */
    public void setJudul(String judul) {
        this.judul = judul;
    }

    /**
     * 
     * @return
     *     The deskripsi
     */
    public String getDeskripsi() {
        return deskripsi;
    }

    /**
     * 
     * @param deskripsi
     *     The deskripsi
     */
    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    /**
     * 
     * @return
     *     The filevideo
     */
    public String getFilevideo() {
        return filevideo;
    }

    /**
     * 
     * @param filevideo
     *     The filevideo
     */
    public void setFilevideo(String filevideo) {
        this.filevideo = filevideo;
    }

    /**
     * 
     * @return
     *     The gambar
     */
    public String getGambar() {
        return gambar;
    }

    /**
     * 
     * @param gambar
     *     The gambar
     */
    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    /**
     * 
     * @return
     *     The kategori
     */
    public String getKategori() {
        return kategori;
    }

    /**
     * 
     * @param kategori
     *     The kategori
     */
    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    /**
     * 
     * @return
     *     The watched
     */
    public String getWatched() {
        return watched;
    }

    /**
     * 
     * @param watched
     *     The watched
     */
    public void setWatched(String watched) {
        this.watched = watched;
    }

    /**
     * 
     * @return
     *     The rating
     */
    public String getRating() {
        return rating;
    }

    /**
     * 
     * @param rating
     *     The rating
     */
    public void setRating(String rating) {
        this.rating = rating;
    }

    /**
     * 
     * @return
     *     The rater
     */
    public String getRater() {
        return rater;
    }

    /**
     * 
     * @param rater
     *     The rater
     */
    public void setRater(String rater) {
        this.rater = rater;
    }

    /**
     * 
     * @return
     *     The posted
     */
    public String getPosted() {
        return posted;
    }

    /**
     * 
     * @param posted
     *     The posted
     */
    public void setPosted(String posted) {
        this.posted = posted;
    }

    /**
     * 
     * @return
     *     The related
     */
    public List<Related> getRelated() {
        return related;
    }

    /**
     * 
     * @param related
     *     The related
     */
    public void setRelated(List<Related> related) {
        this.related = related;
    }

    /**
     * 
     * @return
     *     The watcher
     */
    public List<Watcher> getWatcher() {
        return watcher;
    }

    /**
     * 
     * @param watcher
     *     The watcher
     */
    public void setWatcher(List<Watcher> watcher) {
        this.watcher = watcher;
    }

}
