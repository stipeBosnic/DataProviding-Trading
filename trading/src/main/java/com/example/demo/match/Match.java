package com.example.demo.match;

import com.example.demo.market.Market;
import com.example.demo.team.Team;
import com.example.demo.tournament.Tournament;
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
@Getter
@Setter
@Table(name = "match")
@NoArgsConstructor
@AllArgsConstructor
public class Match {

    Match(int id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "home_team")
    @NotNull(message = "home team is required")
    Team homeTeam;

    @ManyToOne
    @JoinColumn(name = "away_team")
    @NotNull (message = "away team is required")
    private Team awayTeam;

    @Column(name = "start_time")
    @NotNull (message = "start time is required")
    private ZonedDateTime startTime;

    @Column(name = "tournament_id")
    @Min(value = 1, message = "The tournament id must be greater than 1")
    @NotNull (message = "tournament id is required")
    private int tournamentId;

    @ManyToOne
    @JoinColumn(name = "tournament_id", insertable = false, updatable = false)
    Tournament tournament;

    @Column(name = "provider_id")
    UUID providerId;

    @OneToMany
    @JsonIgnore
    @JoinColumn(name = "match_id")
    List<Market> markets;
}
