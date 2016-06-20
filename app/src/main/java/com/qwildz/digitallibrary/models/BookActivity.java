
package com.qwildz.digitallibrary.models;

import android.support.annotation.Nullable;

import javax.annotation.Generated;
import auto.parcelgson.AutoParcelGson;
import auto.parcelgson.gson.annotations.Expose;
import auto.parcelgson.gson.annotations.SerializedName;

@AutoParcelGson
@Generated("org.jsonschema2pojo")
public abstract class BookActivity {

    @SerializedName("id")
    @Expose
    @Nullable
    public abstract String id();
    @SerializedName("times")
    @Expose
    @Nullable
    public abstract String times();
    @SerializedName("judul")
    @Expose
    @Nullable
    public abstract String judul();
    @SerializedName("gambar")
    @Expose
    @Nullable
    public abstract String gambar();

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
//     *     The times
//     */
//    public String getTimes() {
//        return times;
//    }
//
//    /**
//     *
//     * @param times
//     *     The times
//     */
//    public void setTimes(String times) {
//        this.times = times;
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

    /**
     * 
     * @return
     *     The gambar
     */
    public String getGambar() {
        return Repository.MEDIA_POINT + "book/img/" + gambar();
    }

//    /**
//     *
//     * @param gambar
//     *     The gambar
//     */
//    public void setGambar(String gambar) {
//        this.gambar = gambar;
//    }

}
