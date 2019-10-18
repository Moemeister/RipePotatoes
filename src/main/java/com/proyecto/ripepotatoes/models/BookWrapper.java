package com.proyecto.ripepotatoes.models;

import java.util.List;

public class BookWrapper {
    public String status;
    public String copyright;
    public Integer numResults;
    public String last_modified;
    public List<BookResult> results = null;

    public List<BookResult> getResults() {
        return results;
    }

    public void setResults(List<BookResult> results) {
        this.results = results;
    }
}
