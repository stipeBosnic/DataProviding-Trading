package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class Data {

    private UUID dataId;
    private Integer homeTeam;
    private Integer awayTeam;
    private ZonedDateTime startTime;
    private Integer tournamentId;
    private Integer marketStateId;
    private Integer marketTypeId;
    private Double homeOdds;
    private Double drawOdds;
    private Double awayOdds;

    public Data(UUID dataId, Integer homeTeam, Integer awayTeam, ZonedDateTime startTime, Integer tournamentId, Integer marketStateId, Integer marketTypeId, Double homeOdds, Double drawOdds, Double awayOdds) {
        this.dataId = dataId;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.startTime = startTime;
        this.tournamentId = tournamentId;
        this.marketStateId = marketStateId;
        this.marketTypeId = marketTypeId;
        this.homeOdds = homeOdds;
        this.drawOdds = drawOdds;
        this.awayOdds = awayOdds;
    }
}
