
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
public abstract class User implements Parcelable {

    @SerializedName("id")
    @Expose
    @Nullable
    public abstract String id();
    @SerializedName("username")
    @Expose
    @Nullable
    public abstract String username();
    @SerializedName("nama")
    @Expose
    @Nullable
    public abstract String nama();
    @SerializedName("jurusan")
    @Expose
    @Nullable
    public abstract String jurusan();
    @SerializedName("pp")
    @Expose
    @Nullable
    public abstract String pp();
    @SerializedName("level")
    @Expose
    @Nullable
    public abstract String level();
    @SerializedName("book_activity")
    @Expose
    @Nullable
    public abstract List<Book> bookActivity();
    @SerializedName("video_activity")
    @Expose
    @Nullable
    public abstract List<Video> videoActivity();

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
//     *     The username
//     */
//    public String getUsername() {
//        return username;
//    }
//
//    /**
//     *
//     * @param username
//     *     The username
//     */
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    /**
//     *
//     * @return
//     *     The nama
//     */
//    public String getNama() {
//        return nama;
//    }
//
//    /**
//     *
//     * @param nama
//     *     The nama
//     */
//    public void setNama(String nama) {
//        this.nama = nama;
//    }
//
//    /**
//     *
//     * @return
//     *     The jurusan
//     */
//    public String getJurusan() {
//        return jurusan;
//    }
//
//    /**
//     *
//     * @param jurusan
//     *     The jurusan
//     */
//    public void setJurusan(String jurusan) {
//        this.jurusan = jurusan;
//    }

    /**
     * 
     * @return
     *     The pp
     */
    public String getPp() {
        return Repository.MEDIA_POINT + "pp/" + pp();
    }

//    /**
//     *
//     * @param pp
//     *     The pp
//     */
//    public void setPp(String pp) {
//        this.pp = pp;
//    }
//
//    /**
//     *
//     * @return
//     *     The level
//     */
//    public String getLevel() {
//        return level;
//    }
//
//    /**
//     *
//     * @param level
//     *     The level
//     */
//    public void setLevel(String level) {
//        this.level = level;
//    }
//
//    /**
//     *
//     * @return
//     *     The bookActivity
//     */
//    public List<BookActivity> getBookActivity() {
//        return bookActivity;
//    }
//
//    /**
//     *
//     * @param bookActivity
//     *     The book_activity
//     */
//    public void setBookActivity(List<BookActivity> bookActivity) {
//        this.bookActivity = bookActivity;
//    }
//
//    /**
//     *
//     * @return
//     *     The videoActivity
//     */
//    public List<VideoActivity> getVideoActivity() {
//        return videoActivity;
//    }
//
//    /**
//     *
//     * @param videoActivity
//     *     The video_activity
//     */
//    public void setVideoActivity(List<VideoActivity> videoActivity) {
//        this.videoActivity = videoActivity;
//    }

}
