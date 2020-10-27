package com.knowit.knowit.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.knowit.knowit.dto.BestillingDto;
import com.knowit.knowit.dto.BestillingsResponseDto;
import com.knowit.knowit.dto.Book;

@RunWith(SpringRunner.class)
public class BestillingRepositoryTest {


    public BestillingRepository bestillingRepository = new BestillingRepository();

    @Test
    public void skalReturnereBestilling() {
        bestillingRepository.addBook(new Book("God Bok 1","1234567",199,15),new Book("God Bok 2","1234568",299,10),new Book("God Bok 3","1234569",249,10));
        Double price = 8465.00;
        List<Book> books = List.of(new Book("God Bok 1","1234567",199,15),new Book("God Bok 2","1234568",299,10),new Book("God Bok 3","1234569",249,10));
        BestillingDto bestillingDto = new BestillingDto(books);
        BestillingsResponseDto actual = bestillingRepository.bestilling(bestillingDto);
        assertThat(actual.getBestilling().size()).isEqualTo(3);
        assertThat(actual.getTotalPrice()).isEqualTo(price);
    }
    @Test
    public void skalKlargjoreBestilling() {
        bestillingRepository.addBook(new Book("God Bok 1","1234567",199,15),new Book("God Bok 2","1234568",299,10),new Book("God Bok 3","1234569",249,10));
        Double price = 8465.00;
        List<Book> books = List.of(new Book("God Bok 1","1234567",199,15),new Book("God Bok 2","1234568",299,10),new Book("God Bok 3","1234569",249,10));
        BestillingDto bestillingDto = new BestillingDto(books);
        BestillingsResponseDto actual = bestillingRepository.klargjorBestilling(bestillingDto);
        assertThat(actual.getBestilling().size()).isEqualTo(3);
        assertThat(actual.getTotalPrice()).isEqualTo(price);
    }
    @Test
    public void skalSummerePris() {
        bestillingRepository.addBook(new Book("God Bok 1","1234567",199,15),new Book("God Bok 2","1234568",299,10),new Book("God Bok 3","1234569",249,10));
        Double price = 8465.00;
        List<Book> books = List.of(new Book("God Bok 1","1234567",199,15),new Book("God Bok 2","1234568",299,10),new Book("God Bok 3","1234569",249,10));
        Double actualPrice = bestillingRepository.sumPrice(books);
        assertThat(actualPrice).isEqualTo(price);

    }
    @Test
    public void skalRetunereNokAmount() {
        bestillingRepository.addBook(new Book("God Bok 1","1234567",199,15),new Book("God Bok 2","1234568",299,10),new Book("God Bok 3","1234569",249,10));
        Integer amount = 35;
    }
}
