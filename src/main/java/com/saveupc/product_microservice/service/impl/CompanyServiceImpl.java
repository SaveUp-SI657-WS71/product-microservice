package com.saveupc.product_microservice.service.impl;

import com.saveupc.product_microservice.dto.CompanyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CompanyServiceImpl {

    @Autowired
    private WebClient.Builder webClientBuilder;

    public CompanyDto getCompanyById(int companyId) {
        return webClientBuilder.build()
                .get()
                .uri("http://localhost:8080/api/saveup/v1/companies/" + companyId)
                .retrieve()
                .bodyToMono(CompanyDto.class)
                .block();
    }

}
