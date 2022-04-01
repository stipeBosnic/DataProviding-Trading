package com.example.demo.marketType;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class MarketTypeService {

    @Autowired
    MarketTypeRepository marketTypeRepository;

    public MarketType addMarketType(MarketType marketType) {
        return marketTypeRepository.save(marketType);
    }

    public List<MarketType> getMarketTypes() {
        return marketTypeRepository.findAll();
    }
}
