package com.proyecto.ripepotatoes.models;

import java.util.List;

public class MovieWrapper {

    private Integer page;
    private Integer total_results;
    private Integer total_pages;
    private List<Movie> results = null;

    public MovieWrapper() {
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public MovieWrapper withPage(Integer page) {
        this.page = page;
        return this;
    }

    public Integer getTotal_results() {
        return total_results;
    }

    public void setTotal_results(Integer total_results) {
        this.total_results = total_results;
    }

    public MovieWrapper withTotalResults(Integer totalResults) {
        this.total_results = totalResults;
        return this;
    }

    public Integer getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(Integer total_pages) {
        this.total_pages = total_pages;
    }

    public MovieWrapper withTotalPages(Integer totalPages) {
        this.total_pages = totalPages;
        return this;
    }

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }
}