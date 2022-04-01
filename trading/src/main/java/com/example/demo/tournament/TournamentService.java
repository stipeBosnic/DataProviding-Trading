package com.example.demo.tournament;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class TournamentService {

    @Autowired
    TournamentRepository tournamentRepository;

    public Tournament addTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    public List<Tournament> getTournaments() {
        return tournamentRepository.findAll();
    }

    public Tournament getTournament(String tournamentName) {
        return tournamentRepository.findByTournamentName(tournamentName);
    }
}
