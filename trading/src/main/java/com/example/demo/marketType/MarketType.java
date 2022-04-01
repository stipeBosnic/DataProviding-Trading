package com.example.demo.marketType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "markettype")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MarketType {

    public MarketType(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "marketType_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotNull(message = "market type must have a name")
    private String name;
}
