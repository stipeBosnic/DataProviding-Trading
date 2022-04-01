package com.example.demo.marketState;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class MarketStateService {

    @Autowired
    MarketStateRepository marketStateRepository;

    public MarketState addMarketState(MarketState marketState) {
        return marketStateRepository.save(marketState);
    }
}
