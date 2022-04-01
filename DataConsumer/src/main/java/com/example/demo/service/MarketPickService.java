package com.example.demo.service;

import com.example.demo.model.MarketPick;
import com.example.demo.repository.MarketPickRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class MarketPickService {

    @Autowired
    MarketPickRepository marketPickRepository;

    public void saveMarketPick(MarketPick marketPick) {
        marketPickRepository.save(marketPick);
    }



}
