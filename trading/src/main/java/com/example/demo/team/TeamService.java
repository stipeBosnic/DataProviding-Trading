package com.example.demo.team;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class TeamService {

    @Autowired
    TeamRepository teamRepository;

    public Team addTeam(Team team) {
        return teamRepository.save(team);
    }

    public List<Team> getTeams() {
        return teamRepository.findAll();
    }
}
