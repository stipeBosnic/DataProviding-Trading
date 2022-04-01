package com.example.demo.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
public class TournamentController {

    @Autowired
    TournamentService tournamentService;

    @PostMapping("addtournament")
    public Tournament addTournament(@Valid @RequestBody Tournament tournament) {
        return tournamentService.addTournament(tournament);
    }

    @GetMapping("gettournaments")
    public List<Tournament> getTournaments() {
        return tournamentService.getTournaments();
    }

    @GetMapping("gettournament")
    public Tournament getTournament(String tournamentName) {
        return tournamentService.getTournament(tournamentName);
    }
}
