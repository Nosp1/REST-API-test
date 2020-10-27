package com.knowit.knowit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knowit.knowit.dto.BestillingDto;
import com.knowit.knowit.dto.BestillingsResponseDto;
import com.knowit.knowit.repository.BestillingRepository;

@Service
public class BestillingService {
    BestillingRepository bestillingRepository;

    @Autowired
    public BestillingService(BestillingRepository bestillingRepository) {
        this.bestillingRepository = bestillingRepository;
    }

    public BestillingsResponseDto bestilling(BestillingDto bestillingDto) {
        return bestillingRepository.bestilling(bestillingDto);
    }
}
