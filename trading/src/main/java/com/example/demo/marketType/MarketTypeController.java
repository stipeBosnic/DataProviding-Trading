package com.example.demo.marketType;

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
public class MarketTypeController {

    @Autowired
    MarketTypeService marketTypeService;

    @PostMapping("addmarkettype")
    public MarketType addMarketType(@Valid @RequestBody MarketType marketType) {
        return marketTypeService.addMarketType(marketType);
    }
    @GetMapping("getmarkettypes")
    public List<MarketType> getMarketTypes() {
        return marketTypeService.getMarketTypes();
    }


}
