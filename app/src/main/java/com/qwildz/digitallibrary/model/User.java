
package com.qwildz.digitallibrary.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class User {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("jurusan")
    @Expose
    private String jurusan;
    @SerializedName("pp")
    @Expose
    private String pp;
    @SerializedName("level")
    @Expose
    private String level;
    @SerializedName("book_activity")
    @Expose
    private List<BookActivity> bookActivity = new ArrayList<BookActivity>();
    @SerializedName("video_activity")
    @Expose
    private List<VideoActivity> videoActivity = new ArrayList<VideoActivity>();

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
     *     The username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 
     * @param username
     *     The username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 
     * @return
     *     The nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * 
     * @param nama
     *     The nama
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * 
     * @return
     *     The jurusan
     */
    public String getJurusan() {
        return jurusan;
    }

    /**
     * 
     * @param jurusan
     *     The jurusan
     */
    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    /**
     * 
     * @return
     *     The pp
     */
    public String getPp() {
        return pp;
    }

    /**
     * 
     * @param pp
     *     The pp
     */
    public void setPp(String pp) {
        this.pp = pp;
    }

    /**
     * 
     * @return
     *     The level
     */
    public String getLevel() {
        return level;
    }

    /**
     * 
     * @param level
     *     The level
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * 
     * @return
     *     The bookActivity
     */
    public List<BookActivity> getBookActivity() {
        return bookActivity;
    }

    /**
     * 
     * @param bookActivity
     *     The book_activity
     */
    public void setBookActivity(List<BookActivity> bookActivity) {
        this.bookActivity = bookActivity;
    }

    /**
     * 
     * @return
     *     The videoActivity
     */
    public List<VideoActivity> getVideoActivity() {
        return videoActivity;
    }

    /**
     * 
     * @param videoActivity
     *     The video_activity
     */
    public void setVideoActivity(List<VideoActivity> videoActivity) {
        this.videoActivity = videoActivity;
    }

}
