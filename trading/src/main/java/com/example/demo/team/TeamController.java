package com.example.demo.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
public class TeamController {

    @Autowired
    TeamService teamService;

    @PostMapping("addteam")
    public Team addTeam(@Valid @RequestBody Team team) {
        return teamService.addTeam(team);
    }

    @GetMapping("getteams")
    public List<Team> getTeams() {
        return teamService.getTeams();
    }
}
