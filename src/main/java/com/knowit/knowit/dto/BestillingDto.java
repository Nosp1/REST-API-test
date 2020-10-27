package com.knowit.knowit.dto;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestillingDto {
    private List<Book> books;

    public BestillingDto(List<Book> books) {
        this.books = books;
    }

    public BestillingDto() {}

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
