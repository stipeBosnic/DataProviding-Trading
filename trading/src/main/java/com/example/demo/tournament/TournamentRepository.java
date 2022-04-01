package com.example.demo.tournament;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {

    Tournament findByTournamentName(String tournamentName);

}
