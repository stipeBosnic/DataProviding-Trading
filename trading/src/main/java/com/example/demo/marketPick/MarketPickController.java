package com.example.demo.marketPick;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
public class MarketPickController {

    @Autowired
    MarketPickService marketPickService;

    @PostMapping("addmarketpick")
    public MarketPick addMarketPick(@Valid @RequestBody MarketPick marketPick) {
        return marketPickService.addMarketPick(marketPick);
    }

    @GetMapping("getmarketpicks")
    public List<MarketPick> getMarketPicks() {
        return marketPickService.getMarketPicks();
    }

    @GetMapping("getmarketpicks/today")
    public List<MarketPick> getTodayMarketPicks() {
        return marketPickService.getTodayMarketPicks();
    }

    @GetMapping("tournament/getmarketpicks")
    public List<MarketPick> getMarketPicksForTournament(@RequestParam Long tournamentId) {
        return marketPickService.getMarketPicksForTournament(tournamentId);
    }
}
