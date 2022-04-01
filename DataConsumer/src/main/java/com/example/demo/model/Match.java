package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "match")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Match {

    public Match(int id) {
        this.id = id;
    }

    public Match(long homeTeam, long awayTeam, ZonedDateTime startTime, int tournamentid, UUID providerId) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.startTime = startTime;
        this.tournamentid = tournamentid;
        this.providerId = providerId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_id")
    private long id;

    @Column(name = "home_team")
    @NotNull(message = "home team is required")
    private long homeTeam;

    @ManyToOne
    @JoinColumn(name = "home_team", insertable = false, updatable = false)
    @Transient
    Team homeTeam1;

    @Column(name = "away_team")
    @NotNull(message = "away team is required")
    private long awayTeam;

    @ManyToOne
    @JoinColumn(name = "away_team", insertable = false, updatable = false)
    @Transient
    private Team awayTeam1;

    @Column(name = "start_time")
    @NotNull(message = "start time is required")
    private ZonedDateTime startTime;

    @Column(name = "tournament_id")
    @Min(value = 1, message = "The tournament id must be greater than 1")
    @NotNull(message = "tournament id is required")
    private int tournamentid;

    @Column(name = "provider_id")
    UUID providerId;

    @ManyToOne
    @JoinColumn(name = "tournament_id", insertable = false, updatable = false)
    Tournament tournament;

    @OneToMany
    @JsonIgnore
    @JoinColumn(name = "match_id")
    List<Market> markets;
}
