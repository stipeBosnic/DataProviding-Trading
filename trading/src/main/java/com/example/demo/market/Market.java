package com.example.demo.market;

import com.example.demo.marketPick.MarketPick;
import com.example.demo.marketState.MarketState;
import com.example.demo.marketType.MarketType;
import com.example.demo.match.Match;
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

    @Id
    @Column(name = "market_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JoinColumn(name = "match_id", insertable = false, updatable = false)
    @ManyToOne
    @NotNull(message = "match is required")
    private Match match;

    @JoinColumn(name = "market_type")
    @ManyToOne
    @NotNull(message = "markettype is required")
    private MarketType marketType;

    @JoinColumn(name = "marketstate")
    @ManyToOne
    @NotNull(message = "market state is required")
    private MarketState marketState;

    @OneToMany
    @JsonIgnore
    @JoinColumn(name = "market_id")
    List<MarketPick> marketPicks;
}
