
package com.qwildz.digitallibrary.models;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import javax.annotation.Generated;
import auto.parcelgson.gson.annotations.Expose;
import auto.parcelgson.gson.annotations.SerializedName;

import auto.parcelgson.AutoParcelGson;

@AutoParcelGson
@Generated("org.jsonschema2pojo")
public abstract class News_ implements Parcelable {

    @SerializedName("id")
    @Expose
    @Nullable
    public abstract String id();
    @SerializedName("judul")
    @Expose
    @Nullable
    public abstract String judul();
    @SerializedName("isi")
    @Expose
    @Nullable
    public abstract String isi();
    @SerializedName("gambar")
    @Expose
    @Nullable
    public abstract String gambar();
    @SerializedName("posted")
    @Expose
    @Nullable
    public abstract String posted();

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
//     *     The isi
//     */
//    public String getIsi() {
//        return isi;
//    }
//
//    /**
//     *
//     * @param isi
//     *     The isi
//     */
//    public void setIsi(String isi) {
//        this.isi = isi;
//    }

    /**
     * 
     * @return
     *     The gambar
     */
    public String getGambar() {
        return Repository.MEDIA_POINT + "news/" +  gambar();
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

}
