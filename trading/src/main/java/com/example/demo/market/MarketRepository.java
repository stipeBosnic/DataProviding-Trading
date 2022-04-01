package com.example.demo.market;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MarketRepository extends JpaRepository<Market, Long> {

    @Query(value = "\tSELECT * FROM market\n" +
            "\tWHERE market.match_id IN(\n" +
            "\tSELECT match_id FROM match where DATE(start_time) = CURRENT_DATE)", nativeQuery = true)
    List<Market> NqGetTodayMarket();
}
