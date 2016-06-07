
package com.qwildz.digitallibrary.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Pages {

    @SerializedName("range")
    @Expose
    private List<Integer> range = new ArrayList<Integer>();
    @SerializedName("total")
    @Expose
    private Integer total;

    /**
     * 
     * @return
     *     The range
     */
    public List<Integer> getRange() {
        return range;
    }

    /**
     * 
     * @param range
     *     The range
     */
    public void setRange(List<Integer> range) {
        this.range = range;
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
