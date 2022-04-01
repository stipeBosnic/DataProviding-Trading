package com.example.demo.match;

import com.example.demo.marketPick.MarketPick;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class MatchService {

    @Autowired
    MatchRepository matchRepository;

    public Match addMatch(Match match) {
        return matchRepository.save(match);
    }

    public List<Match> getMatches() {
        return matchRepository.findAll();
    }

    public Match getMatch(Long id) {
        return matchRepository.findById(id).orElse(null);
    }

    public List<Match> getTodayMatches() {
        return matchRepository.NqGetTodayMatches();
    }

    public List<MarketPick> getTodayMarketPicks() {
        return matchRepository.NqGetTodayMarketPicks();
    }

    public void deleteMatch(Long matchId) {
        matchRepository.deleteById(matchId);
    }

    public List<Match> getTournamentMatches(Long tournamentId) {
        return matchRepository.NqGetMatchesFromTournament(tournamentId);

    }
}
