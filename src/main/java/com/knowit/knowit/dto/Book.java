package com.knowit.knowit.dto;

public class Book {
    private String tittel;
    private String ISBN;
    private Integer price;
    private Integer antall;

    public Book(String tittel, String ISBN, Integer price, Integer antall) {
        this.tittel = tittel;
        this.ISBN = ISBN;
        this.price = price;
        this.antall = antall;
    }

    public String getTittel() {
        return tittel;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getAntall() {
        return antall;
    }

    public void setAntall(Integer antall) {
        this.antall = antall;
    }
}
