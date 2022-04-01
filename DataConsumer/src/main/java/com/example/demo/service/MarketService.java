package com.example.demo.service;

import com.example.demo.model.Market;
import com.example.demo.repository.MarketRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@NoArgsConstructor
public class MarketService {

    @Autowired
    MarketRepository marketRepository;

    public void saveMarket(Market market) {
        marketRepository.save(market);
    }

    public Integer findMarketId(UUID marketId) {
        return marketRepository.NqGetMarketFromProviderId(marketId);
    }

}
