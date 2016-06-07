
package com.qwildz.digitallibrary.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Book {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("judul")
    @Expose
    private String judul;
    @SerializedName("penulis")
    @Expose
    private String penulis;
    @SerializedName("kategori")
    @Expose
    private String kategori;
    @SerializedName("readed")
    @Expose
    private String readed;
    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("rater")
    @Expose
    private String rater;
    @SerializedName("gambar")
    @Expose
    private String gambar;
    @SerializedName("deskripsi")
    @Expose
    private String deskripsi;
    @SerializedName("filebook")
    @Expose
    private String filebook;
    @SerializedName("downloadable")
    @Expose
    private String downloadable;
    @SerializedName("passpdf")
    @Expose
    private String passpdf;
    @SerializedName("related")
    @Expose
    private List<Related> related = new ArrayList<Related>();
    @SerializedName("reader")
    @Expose
    private List<Reader> reader = new ArrayList<Reader>();

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
     *     The penulis
     */
    public String getPenulis() {
        return penulis;
    }

    /**
     * 
     * @param penulis
     *     The penulis
     */
    public void setPenulis(String penulis) {
        this.penulis = penulis;
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
     *     The readed
     */
    public String getReaded() {
        return readed;
    }

    /**
     * 
     * @param readed
     *     The readed
     */
    public void setReaded(String readed) {
        this.readed = readed;
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
     *     The filebook
     */
    public String getFilebook() {
        return filebook;
    }

    /**
     * 
     * @param filebook
     *     The filebook
     */
    public void setFilebook(String filebook) {
        this.filebook = filebook;
    }

    /**
     * 
     * @return
     *     The downloadable
     */
    public String getDownloadable() {
        return downloadable;
    }

    /**
     * 
     * @param downloadable
     *     The downloadable
     */
    public void setDownloadable(String downloadable) {
        this.downloadable = downloadable;
    }

    /**
     * 
     * @return
     *     The passpdf
     */
    public String getPasspdf() {
        return passpdf;
    }

    /**
     * 
     * @param passpdf
     *     The passpdf
     */
    public void setPasspdf(String passpdf) {
        this.passpdf = passpdf;
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
     *     The reader
     */
    public List<Reader> getReader() {
        return reader;
    }

    /**
     * 
     * @param reader
     *     The reader
     */
    public void setReader(List<Reader> reader) {
        this.reader = reader;
    }

}
