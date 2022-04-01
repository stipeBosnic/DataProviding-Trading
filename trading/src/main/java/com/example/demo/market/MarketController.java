package com.example.demo.market;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
public class MarketController {

    @Autowired
    MarketService marketService;

    @PostMapping("addmarket")
    public Market addMarket(@Valid @RequestBody Market market) {
        return marketService.addMarket(market);
    }

    @GetMapping("getmarkets")
    public List<Market> getMarkets() {
        return marketService.getMarkets();
    }

    @GetMapping("getmarkets/today")
    public List<Market> getTodayMarket() {
        return marketService.getTodayMarket();
    }
}
