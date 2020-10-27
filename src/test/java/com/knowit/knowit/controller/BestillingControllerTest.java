package com.knowit.knowit.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.knowit.knowit.dto.BestillingDto;
import com.knowit.knowit.dto.BestillingsResponseDto;
import com.knowit.knowit.dto.Book;
import com.knowit.knowit.service.BestillingService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BestillingControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private BestillingService bestillingService;

    @Test
    public void returnerBestilling() {
        new Book("God Bok 1","1234567",199,15);
        new Book("God Bok 2","1234568",299,10);
        new Book("God Bok 3","1234569",249,10);
        Double price = 8465.00;
        List<Book> books = List.of(new Book("God Bok 1","1234567",199,15),new Book("God Bok 2","1234568",299,10),new Book("God Bok 3","1234569",249,10));
        BestillingDto bestillingDto = new BestillingDto(books);
        HttpEntity<BestillingDto> entity = new HttpEntity<>(bestillingDto);
        Mockito.when(bestillingService.bestilling(any(BestillingDto.class))).thenReturn(new BestillingsResponseDto(books,price));
        ResponseEntity<BestillingsResponseDto> response = restTemplate.postForEntity("/boker/bestill",entity,BestillingsResponseDto.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getTotalPrice()).isEqualTo(price);


    }

}
