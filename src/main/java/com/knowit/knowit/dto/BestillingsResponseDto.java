package com.knowit.knowit.dto;

import java.util.List;

public class BestillingsResponseDto {
    private List<Book> bestilling;
    private Double totalPrice;

    public BestillingsResponseDto(List<Book> bestilling, Double totalPrice) {
        this.bestilling = bestilling;
        this.totalPrice = totalPrice;

    }
    public BestillingsResponseDto() {}

    public List<Book> getBestilling() {
        return bestilling;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setBestilling(List<Book> bestilling) {
        this.bestilling = bestilling;
    }
}
