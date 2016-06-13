
package com.qwildz.digitallibrary.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class News_ {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("judul")
    @Expose
    private String judul;
    @SerializedName("isi")
    @Expose
    private String isi;
    @SerializedName("gambar")
    @Expose
    private String gambar;
    @SerializedName("posted")
    @Expose
    private String posted;

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
     *     The isi
     */
    public String getIsi() {
        return isi;
    }

    /**
     * 
     * @param isi
     *     The isi
     */
    public void setIsi(String isi) {
        this.isi = isi;
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

}
