package com.example.demo.sport;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class SportService {

    @Autowired
    private SportRepository sportsRepository;

    public List<Sport> getAllSports() {
        return sportsRepository.findAll();
    }

    public Sport addSport(Sport sport) {
        return sportsRepository.save(sport);
    }
}
