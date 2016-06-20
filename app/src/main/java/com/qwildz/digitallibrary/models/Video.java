
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
public abstract class Video implements Parcelable {

    @SerializedName("id")
    @Expose
    @Nullable
    public abstract String id();
    @SerializedName("judul")
    @Expose
    @Nullable
    public abstract String judul();
    @SerializedName("deskripsi")
    @Expose
    @Nullable
    public abstract String deskripsi();
    @SerializedName("filevideo")
    @Expose
    @Nullable
    public abstract String filevideo();
    @SerializedName("gambar")
    @Expose
    @Nullable
    public abstract String gambar();
    @SerializedName("kategori")
    @Expose
    @Nullable
    public abstract String kategori();
    @SerializedName("watched")
    @Expose
    @Nullable
    public abstract String watched();
    @SerializedName("rating")
    @Expose
    @Nullable
    public abstract String rating();
    @SerializedName("rater")
    @Expose
    @Nullable
    public abstract String rater();
    @SerializedName("posted")
    @Expose
    @Nullable
    public abstract String posted();
    @SerializedName("related")
    @Expose
    @Nullable
    public abstract List<Related> related();
    @SerializedName("watcher")
    @Expose
    @Nullable
    public abstract List<Watcher> watcher();

//    /**
//     *
//     * @return
//     *     The id
//     */
//    public String getId() {
//        return id;
//    }
//
//    /**
//     *
//     * @param id
//     *     The id
//     */
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    /**
//     *
//     * @return
//     *     The judul
//     */
//    public String getJudul() {
//        return judul;
//    }
//
//    /**
//     *
//     * @param judul
//     *     The judul
//     */
//    public void setJudul(String judul) {
//        this.judul = judul;
//    }
//
//    /**
//     *
//     * @return
//     *     The deskripsi
//     */
//    public String getDeskripsi() {
//        return deskripsi;
//    }
//
//    /**
//     *
//     * @param deskripsi
//     *     The deskripsi
//     */
//    public void setDeskripsi(String deskripsi) {
//        this.deskripsi = deskripsi;
//    }

    /**
     * 
     * @return
     *     The filevideo
     */
    public String getFilevideo() {
        return Repository.MEDIA_POINT + "video/flv/" + filevideo();
    }
//
//    /**
//     *
//     * @param filevideo
//     *     The filevideo
//     */
//    public void setFilevideo(String filevideo) {
//        this.filevideo = filevideo;
//    }

    /**
     * 
     * @return
     *     The gambar
     */
    public String getGambar() {
        return Repository.MEDIA_POINT + "video/img/" + gambar();
    }

//    /**
//     *
//     * @param gambar
//     *     The gambar
//     */
//    public void setGambar(String gambar) {
//        this.gambar = gambar;
//    }
//
//    /**
//     *
//     * @return
//     *     The kategori
//     */
//    public String getKategori() {
//        return kategori;
//    }
//
//    /**
//     *
//     * @param kategori
//     *     The kategori
//     */
//    public void setKategori(String kategori) {
//        this.kategori = kategori;
//    }
//
//    /**
//     *
//     * @return
//     *     The watched
//     */
//    public String getWatched() {
//        return watched;
//    }
//
//    /**
//     *
//     * @param watched
//     *     The watched
//     */
//    public void setWatched(String watched) {
//        this.watched = watched;
//    }
//
//    /**
//     *
//     * @return
//     *     The rating
//     */
//    public String getRating() {
//        return rating;
//    }
//
//    /**
//     *
//     * @param rating
//     *     The rating
//     */
//    public void setRating(String rating) {
//        this.rating = rating;
//    }
//
//    /**
//     *
//     * @return
//     *     The rater
//     */
//    public String getRater() {
//        return rater;
//    }
//
//    /**
//     *
//     * @param rater
//     *     The rater
//     */
//    public void setRater(String rater) {
//        this.rater = rater;
//    }
//
//    /**
//     *
//     * @return
//     *     The posted
//     */
//    public String getPosted() {
//        return posted;
//    }
//
//    /**
//     *
//     * @param posted
//     *     The posted
//     */
//    public void setPosted(String posted) {
//        this.posted = posted;
//    }
//
//    /**
//     *
//     * @return
//     *     The related
//     */
//    public List<Related> getRelated() {
//        return related;
//    }
//
//    /**
//     *
//     * @param related
//     *     The related
//     */
//    public void setRelated(List<Related> related) {
//        this.related = related;
//    }
//
//    /**
//     *
//     * @return
//     *     The watcher
//     */
//    public List<Watcher> getWatcher() {
//        return watcher;
//    }
//
//    /**
//     *
//     * @param watcher
//     *     The watcher
//     */
//    public void setWatcher(List<Watcher> watcher) {
//        this.watcher = watcher;
//    }

}
