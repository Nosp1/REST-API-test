package com.knowit.knowit.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.knowit.knowit.dto.BestillingDto;
import com.knowit.knowit.dto.BestillingsResponseDto;
import com.knowit.knowit.dto.Book;
import com.knowit.knowit.repository.BestillingRepository;

@RunWith(SpringRunner.class)

public class BestillingServiceTest {
    @Mock
    private BestillingRepository bestillingRepository;

    @InjectMocks
    private BestillingService bestillingService;

    @Test
    public void skalreturnereBestilling() {
        new Book("God Bok 1","1234567",199,15);
        new Book("God Bok 2","1234568",299,10);
        new Book("God Bok 3","1234569",249,10);
        Double price = 8465.00;
        List<Book> books = List.of(new Book("God Bok 1","1234567",199,15),new Book("God Bok 2","1234568",299,10),new Book("God Bok 3","1234569",249,10));
        BestillingDto bestillingDto = new BestillingDto(books);
        Mockito.when(bestillingService.bestilling(any(BestillingDto.class))).thenReturn(new BestillingsResponseDto(books,price));
        BestillingsResponseDto actual = bestillingService.bestilling(bestillingDto);
        assertThat(actual.getTotalPrice()).isEqualTo(price);
        assertThat(actual.getBestilling().size()).isEqualTo(3);
        assertThat(actual.getBestilling().get(0).getISBN()).isEqualTo(books.get(0).getISBN());
    }

}
