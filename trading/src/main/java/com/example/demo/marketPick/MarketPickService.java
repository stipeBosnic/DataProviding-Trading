package com.example.demo.marketPick;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class MarketPickService {

    @Autowired
    MarketPickRepository marketPickRepository;

    public MarketPick addMarketPick(MarketPick marketPick) {
        return marketPickRepository.save(marketPick);
    }

    public List<MarketPick> getMarketPicks() {
        return marketPickRepository.findAll();
    }

    public List<MarketPick> getTodayMarketPicks() {
        return marketPickRepository.NqGetTodayMarketPicks();
    }

    public List<MarketPick> getMarketPicksForTournament(Long tournamentId) {
        return marketPickRepository.NqGetMarketPicksFromTournament(tournamentId);
    }
}
