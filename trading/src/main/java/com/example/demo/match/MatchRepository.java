package com.example.demo.match;

import com.example.demo.marketPick.MarketPick;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MatchRepository extends JpaRepository<Match, Long> {

    @Query(value = "SELECT * FROM match where DATE(start_time) = CURRENT_DATE", nativeQuery = true)
    List<Match> NqGetTodayMatches();

    @Query(value = "\tSELECT * FROM marketpick\n" +
            "\tWHERE marketpick.market_id IN(\n" +
            "\tSELECT market_id FROM market\n" +
            "\tWHERE market_id IN(\n" +
            "\tSELECT match_id FROM match where DATE(start_time) = CURRENT_DATE))", nativeQuery = true)
    List<MarketPick> NqGetTodayMarketPicks();

    @Query(value = "SELECT * FROM match WHERE\n" +
            "tournament_id = ?1", nativeQuery = true)
    List<Match> NqGetMatchesFromTournament(Long tournament_id);
}
