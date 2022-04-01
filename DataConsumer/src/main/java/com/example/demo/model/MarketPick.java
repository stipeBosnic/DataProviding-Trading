package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "marketpick")
@NoArgsConstructor
@Getter
@Setter
public class MarketPick {

    public MarketPick(String pick, Double odd, int marketId) {
        this.pick = pick;
        this.odd = odd;
        this.marketId = marketId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "marketpick_id")
    private Long id;

    @Column(name = "marketpick")
    @NotNull(message = "Market pick must have a pick")
    private String pick;

    @Column(name = "odd")
    @NotNull(message = "Market pick must have odds")
    @Min(value = 1, message = "odds value must be higher than 1")
    private Double odd;

    @Column(name = "market_id")
    @NotNull(message = "market is required")
    private int marketId;

    @JoinColumn(name = "market_id", insertable = false, updatable = false)
    @ManyToOne
    private Market market;
}