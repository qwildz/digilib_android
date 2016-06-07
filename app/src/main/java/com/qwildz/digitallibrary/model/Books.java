
package com.qwildz.digitallibrary.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Books {

    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("total_books")
    @Expose
    private Integer totalBooks;
    @SerializedName("books")
    @Expose
    private List<Book> books = new ArrayList<Book>();
    @SerializedName("showing")
    @Expose
    private String showing;
    @SerializedName("pages")
    @Expose
    private Pages pages;
    @SerializedName("category")
    @Expose
    private List<Category> category = new ArrayList<Category>();

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

    /**
     * 
     * @return
     *     The totalBooks
     */
    public Integer getTotalBooks() {
        return totalBooks;
    }

    /**
     * 
     * @param totalBooks
     *     The total_books
     */
    public void setTotalBooks(Integer totalBooks) {
        this.totalBooks = totalBooks;
    }

    /**
     * 
     * @return
     *     The books
     */
    public List<Book> getBooks() {
        return books;
    }

    /**
     * 
     * @param books
     *     The books
     */
    public void setBooks(List<Book> books) {
        this.books = books;
    }

    /**
     * 
     * @return
     *     The showing
     */
    public String getShowing() {
        return showing;
    }

    /**
     * 
     * @param showing
     *     The showing
     */
    public void setShowing(String showing) {
        this.showing = showing;
    }

    /**
     * 
     * @return
     *     The pages
     */
    public Pages getPages() {
        return pages;
    }

    /**
     * 
     * @param pages
     *     The pages
     */
    public void setPages(Pages pages) {
        this.pages = pages;
    }

    /**
     * 
     * @return
     *     The category
     */
    public List<Category> getCategory() {
        return category;
    }

    /**
     * 
     * @param category
     *     The category
     */
    public void setCategory(List<Category> category) {
        this.category = category;
    }

}
