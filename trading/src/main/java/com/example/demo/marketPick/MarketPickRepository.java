package com.example.demo.marketPick;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MarketPickRepository extends JpaRepository<MarketPick, Long> {

    @Query(value = "\tSELECT * FROM marketpick\n" +
            "\tWHERE marketpick.market_id IN(\n" +
            "\tSELECT market_id FROM market\n" +
            "\tWHERE market.match_id IN(\n" +
            "\tSELECT match.match_id FROM match where DATE(start_time) = CURRENT_DATE))", nativeQuery = true)
    List<MarketPick> NqGetTodayMarketPicks();

    @Query(value = "SELECT * FROM marketpick\n" +
            "WHERE marketpick.market_id IN(\n" +
            "SELECT market_id FROM market\n" +
            "WHERE market_id IN(\n" +
            "SELECT match_id FROM match WHERE\n" +
            "tournament_id = ?1))", nativeQuery = true)
    List<MarketPick> NqGetMarketPicksFromTournament(Long tournament_id);

}
