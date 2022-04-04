package com.example.demo.consumer;

import com.example.demo.model.Data;
import com.example.demo.model.Market;
import com.example.demo.model.MarketPick;
import com.example.demo.model.Match;
import com.example.demo.service.MarketPickService;
import com.example.demo.service.MarketService;
import com.example.demo.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class DataConsumer {

    @Autowired
    MatchService matchService;
    @Autowired
    MarketService marketService;
    @Autowired
    MarketPickService marketPickService;

    @KafkaListener(topics = "data", groupId = "spring-kafka")
    public void dataConsumer(Data data) {
        Match match = new Match(data.getHomeTeam(), data.getAwayTeam(), data.getStartTime(), data.getTournamentId(), data.getDataId());
        matchService.saveMatch(match);
        System.out.println(data.getDataId());
        System.out.println(matchService.findMatchIdByProviderId(data.getDataId()));
        Market market = new Market(matchService.findMatchIdByProviderId(data.getDataId()), data.getMarketTypeId(), data.getMarketStateId());
        marketService.saveMarket(market);
        MarketPick marketPickX = new MarketPick("X", data.getDrawOdds(), marketService.findMarketId(data.getDataId()));
        MarketPick marketPick1 = new MarketPick("1", data.getHomeOdds(), marketService.findMarketId(data.getDataId()));
        MarketPick marketPick2 = new MarketPick("2", data.getAwayOdds(), marketService.findMarketId(data.getDataId()));
        marketPickService.saveMarketPick(marketPick1);
        marketPickService.saveMarketPick(marketPickX);
        marketPickService.saveMarketPick(marketPick2);

    }

}
