package com.example.demo.repository;

import com.example.demo.model.Market;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.UUID;

public interface MarketRepository extends JpaRepository<Market, Long> {

    @Query(value = "SELECT market_id\n" +
            "from market WHERE\n" +
            "market.match_id IN(\n" +
            "SELECT match_id from match WHERE\n" +
            "provider_id = ?1)", nativeQuery = true)
    Integer NqGetMarketFromProviderId(UUID providerId);

}
