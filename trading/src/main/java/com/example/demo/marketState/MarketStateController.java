package com.example.demo.marketState;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class MarketStateController {

    @Autowired
    MarketStateService marketStateService;

    public MarketState addMarketState(@RequestBody MarketState marketState) {
        return marketStateService.addMarketState(marketState);
    }
}
