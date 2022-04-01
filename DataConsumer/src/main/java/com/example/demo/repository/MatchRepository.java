package com.example.demo.repository;

import com.example.demo.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface MatchRepository extends JpaRepository<Match, Long> {

    @Query(value =  "SELECT match_id from match WHERE\n" +
            "provider_id = ?1", nativeQuery = true)
    Long NqFindMatchIdFromProviderId(UUID providerId);

}
