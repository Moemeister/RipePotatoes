package com.proyecto.ripepotatoes.models;

import java.util.List;

public class BookResult {
    public String list_name;
    public String display_name;
    public String bestsellers_date;
    public String published_date;
    public Integer rank;
    public Integer rank_last_week;
    public Integer weeks_on_list;
    public Integer asterisk;
    public Integer dagger;
    public String amazon_product_url;
    //public List<Isbn> isbns = null;
    public List<BookDetail> book_details = null;

    public List<BookDetail> getBookDetails() {
        return book_details;
    }

    public void setBookDetails(List<BookDetail> bookDetails) {
        this.book_details = bookDetails;
    }

    public String getList_name() {
        return list_name;
    }

    public void setList_name(String list_name) {
        this.list_name = list_name;
    }
//public List<Review> reviews = null;
}
