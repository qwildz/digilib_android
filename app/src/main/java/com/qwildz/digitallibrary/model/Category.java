
package com.qwildz.digitallibrary.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Category {

    @SerializedName("kategori")
    @Expose
    private String kategori;
    @SerializedName("total")
    @Expose
    private Integer total;

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
     *     The total
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * 
     * @param total
     *     The total
     */
    public void setTotal(Integer total) {
        this.total = total;
    }

}
