
package com.qwildz.digitallibrary.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Related {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("judul")
    @Expose
    private String judul;
    @SerializedName("gambar")
    @Expose
    private String gambar;
    @SerializedName("score1")
    @Expose
    private String score1;
    @SerializedName("score2")
    @Expose
    private String score2;
    @SerializedName("score3")
    @Expose
    private String score3;

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
     *     The score1
     */
    public String getScore1() {
        return score1;
    }

    /**
     * 
     * @param score1
     *     The score1
     */
    public void setScore1(String score1) {
        this.score1 = score1;
    }

    /**
     * 
     * @return
     *     The score2
     */
    public String getScore2() {
        return score2;
    }

    /**
     * 
     * @param score2
     *     The score2
     */
    public void setScore2(String score2) {
        this.score2 = score2;
    }

    /**
     * 
     * @return
     *     The score3
     */
    public String getScore3() {
        return score3;
    }

    /**
     * 
     * @param score3
     *     The score3
     */
    public void setScore3(String score3) {
        this.score3 = score3;
    }

}
