package com.example.demo.market;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class MarketService {

    @Autowired
    MarketRepository marketRepository;

    public Market addMarket(Market market) {
        System.out.println(market.toString());
        return marketRepository.save(market);
    }

    public List<Market> getMarkets() {
        return marketRepository.findAll();
    }

    public List<Market> getTodayMarket() {
        return marketRepository.NqGetTodayMarket();
    }
}
