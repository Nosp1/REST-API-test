package com.knowit.knowit.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.knowit.knowit.dto.BestillingDto;
import com.knowit.knowit.dto.BestillingsResponseDto;
import com.knowit.knowit.service.BestillingService;

@RestController
@RequestMapping("/boker")
public class BestillingKontroller {
    private final BestillingService bestillingService;

    public BestillingKontroller(BestillingService bestillingService) {this.bestillingService = bestillingService;}


    @PostMapping(value = "/bestill", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<BestillingsResponseDto> bestilling(@RequestBody BestillingDto bestillingDto) {
        return new ResponseEntity<>(bestillingService.bestilling(bestillingDto), HttpStatus.OK);

    }



}
