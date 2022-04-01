package com.example.demo.match;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@Validated
public class MatchController {

    @Autowired
    MatchService matchService;

    @GetMapping("getmatches")
    public List<Match> getMatches() {
        return matchService.getMatches();
    }

    @PostMapping("addmatch")
    public Match addMatch(@Valid @RequestBody Match match) {
        return matchService.addMatch(match);
    }

    @GetMapping("getmatchbyid")
    public Match getMatch(@RequestParam @Min(value = 1, message = "Match id should be greater than 0") Long id) {
        return matchService.getMatch(id);
    }

    @GetMapping("getmatches/today")
    public List<Match> getTodayMatches() {
        return matchService.getTodayMatches();
    }

    @DeleteMapping("match/delete")
    public void deleteMatch(@RequestParam Long matchId) {
        matchService.deleteMatch(matchId);
    }

    @GetMapping("tournament/getmatches")
    public List<Match> getTournamentMatches(@RequestParam long tournamentId) {
        return matchService.getTournamentMatches(tournamentId);
    }
}
