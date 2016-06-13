
package com.qwildz.digitallibrary.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class VideoActivity {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("times")
    @Expose
    private String times;
    @SerializedName("judul")
    @Expose
    private String judul;
    @SerializedName("gambar")
    @Expose
    private String gambar;

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
     *     The times
     */
    public String getTimes() {
        return times;
    }

    /**
     * 
     * @param times
     *     The times
     */
    public void setTimes(String times) {
        this.times = times;
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

}
