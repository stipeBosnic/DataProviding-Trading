package com.example.demo.marketState;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "marketstate")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MarketState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "marketstate_id")
    private Long id;

    @Column(name = "market_state")
    @NotNull(message = "market state is required")
    private String state;
}
