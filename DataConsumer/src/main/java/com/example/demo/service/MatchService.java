package com.example.demo.service;

import com.example.demo.model.Match;
import com.example.demo.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MatchService {

    @Autowired
    MatchRepository matchRepository;

    public void saveMatch(Match match) {
        matchRepository.save(match);
    }
    public Long findMatchIdByProviderId(UUID providerId) {
        return matchRepository.NqFindMatchIdFromProviderId(providerId);
    }
}
