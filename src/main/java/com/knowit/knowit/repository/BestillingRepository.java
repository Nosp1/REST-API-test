package com.knowit.knowit.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.knowit.knowit.dto.BestillingDto;
import com.knowit.knowit.dto.BestillingsResponseDto;
import com.knowit.knowit.dto.Book;

@Component
public class BestillingRepository {
    private List<Book> books;

    @Autowired
    public BestillingRepository() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book... book) {
        books.addAll(Arrays.asList(book));
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }



    public boolean isBookPresent(String ISBN) {
        return books.stream().anyMatch(book -> book.getISBN().equals(ISBN));
    }

    public Book hentBook(String ISBN, Integer amount) {
        if ((isBookPresent(ISBN) && harNokAntall(ISBN, amount))) {
         return   books.stream().filter(book -> book.getISBN().equals(ISBN)).findFirst().get();
        } else {
            return null;
        }
    }

    private boolean harNokAntall(String ISBN, Integer amount) {
         return books.stream().filter(book -> book.getISBN().equals(ISBN)).allMatch(amountToGet -> amountToGet.getAntall() >= amount);
    }
    public BestillingsResponseDto bestilling(BestillingDto bestillingDto) {

        return  klargjorBestilling(bestillingDto);
    }
    public Double sumPrice(List<Book> bestilling) {
        return bestilling.stream().mapToDouble(book -> book.getPrice() * book.getAntall()).sum();
    }

    public BestillingsResponseDto klargjorBestilling(BestillingDto bestillingDto) {
        List<Book> bestilling = new ArrayList<>();
        List<String> ISBNS = bestillingDto.getBooks().stream().map(Book::getISBN).collect(Collectors.toList());
        List<Integer> antall = bestillingDto.getBooks().stream().map(Book::getAntall).collect(Collectors.toList());
        Map<String,Integer> map = IntStream.range(0,ISBNS.size()).boxed().collect(Collectors.toMap(ISBNS::get,
            antall::get));
            for (String e : map.keySet()) {
                Book toAdd = hentBook(e,map.get(e));
                bestilling.add(toAdd);
            }
            Double price = sumPrice(bestilling);
            return new BestillingsResponseDto(bestilling, price);
        }
    }

