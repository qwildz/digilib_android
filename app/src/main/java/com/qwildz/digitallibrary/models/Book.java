
package com.qwildz.digitallibrary.models;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import auto.parcelgson.AutoParcelGson;
import auto.parcelgson.gson.annotations.Expose;
import auto.parcelgson.gson.annotations.SerializedName;

@AutoParcelGson
@Generated("org.jsonschema2pojo")
public abstract class Book implements Parcelable {

    @SerializedName("id")
    @Expose
    @Nullable
    public abstract String id();
    @SerializedName("judul")
    @Expose
    @Nullable
    public abstract String judul();
    @SerializedName("penulis")
    @Expose
    @Nullable
    public abstract String penulis();
    @SerializedName("kategori")
    @Expose
    @Nullable
    public abstract String kategori();
    @SerializedName("readed")
    @Expose
    @Nullable
    public abstract String readed();
    @SerializedName("rating")
    @Expose
    @Nullable
    public abstract String rating();
    @SerializedName("rater")
    @Expose
    @Nullable
    public abstract String rater();
    @SerializedName("gambar")
    @Expose
    @Nullable
    public abstract String gambar();
    @SerializedName("deskripsi")
    @Expose
    @Nullable
    public abstract String deskripsi();
    @SerializedName("filebook")
    @Expose
    @Nullable
    public abstract String filebook();
    @SerializedName("downloadable")
    @Expose
    @Nullable
    public abstract String downloadable();
    @SerializedName("passpdf")
    @Expose
    @Nullable
    public abstract String passpdf();
    @SerializedName("related")
    @Expose
    @Nullable
    public abstract List<Related> related();
    @SerializedName("reader")
    @Expose
    @Nullable
    public abstract List<Reader> reader();

//    /**
//
//     * @return
//     *     The id
//     */
//    @auto.parcelgson.gson.annotations.SerializedName("id")
//    public abstract String getId();
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
//     *     The penulis
//     */
//    public String getPenulis() {
//        return penulis;
//    }
//
//    /**
//     *
//     * @param penulis
//     *     The penulis
//     */
//    public void setPenulis(String penulis) {
//        this.penulis = penulis;
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
//     *     The readed
//     */
//    public String getReaded() {
//        return readed;
//    }
//
//    /**
//     *
//     * @param readed
//     *     The readed
//     */
//    public void setReaded(String readed) {
//        this.readed = readed;
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
//     *     The gambar
//     */
    public String getGambar() {
        return Repository.MEDIA_POINT + "book/img/" + gambar();
    }
//
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
//
//    /**
//     *
//     * @return
//     *     The filebook
//     */
    public String getFilebook() {
        return filebook();
    }
//
//    /**
//     *
//     * @param filebook
//     *     The filebook
//     */
//    public void setFilebook(String filebook) {
//        this.filebook = filebook;
//    }
//
//    /**
//     *
//     * @return
//     *     The downloadable
//     */
//    public String getDownloadable() {
//        return downloadable;
//    }
//
//    /**
//     *
//     * @param downloadable
//     *     The downloadable
//     */
//    public void setDownloadable(String downloadable) {
//        this.downloadable = downloadable;
//    }
//
//    /**
//     *
//     * @return
//     *     The passpdf
//     */
//    public String getPasspdf() {
//        return passpdf;
//    }
//
//    /**
//     *
//     * @param passpdf
//     *     The passpdf
//     */
//    public void setPasspdf(String passpdf) {
//        this.passpdf = passpdf;
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
//     *     The reader
//     */
//    public List<Reader> getReader() {
//        return reader;
//    }
//
//    /**
//     *
//     * @param reader
//     *     The reader
//     */
//    public void setReader(List<Reader> reader) {
//        this.reader = reader;
//    }

}
