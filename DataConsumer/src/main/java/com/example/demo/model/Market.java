package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@Table(name = "market")
@NoArgsConstructor
@Getter
@Setter
public class Market {

    public Market(Long matchId, int marketTypeId, int marketStateId) {
        this.matchId = matchId;
        this.marketTypeId = marketTypeId;
        this.marketStateId = marketStateId;
    }

    @Id
    @Column(name = "market_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "match_id")
    @NotNull(message = "match is required")
    private Long matchId;

    @JoinColumn(name = "match_id", insertable = false, updatable = false)
    @ManyToOne
    private Match match;

    @Column(name = "market_type")
    @NotNull(message = "marketType is required")
    private int marketTypeId;

    @JoinColumn(name = "market_type", insertable = false, updatable = false)
    @ManyToOne
    private MarketType marketType;

    @Column(name = "marketstate")
    @NotNull(message = "market state is required")
    private int marketStateId;

    @JoinColumn(name = "marketstate", insertable = false, updatable = false)
    @ManyToOne
    private MarketState marketState;

    @OneToMany
    @JsonIgnore
    @JoinColumn(name = "market_id")
    List<MarketPick> marketPicks;
}

