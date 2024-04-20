package com.integrationninjas.springbootexample.service.impl;

import com.integrationninjas.springbootexample.dto.BitcoinDataDto;
import com.integrationninjas.springbootexample.service.CoinDeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CoinDeskServiceImpl implements CoinDeskService {

    private final String API_URL = "https://api.coindesk.com/v1/bpi/currentprice.json";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public BitcoinDataDto getCurrentBitcoinData() {
        ResponseEntity<BitcoinDataDto> response = restTemplate.getForEntity(API_URL, BitcoinDataDto.class);
        return response.getBody();
    }
}
