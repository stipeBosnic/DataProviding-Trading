package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "tournament")
@NoArgsConstructor
public class Tournament {

    @Id
    @Column(name = "tournament_id")
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "tournament_name")
    @NotNull(message = "tournament name is required")
    private String tournamentName;

    @Column(name = "category_id")
    @NotNull(message = "category is required")
    private int categoryId;

    @ManyToOne
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    Category category;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "tournament_id")
    private List<Match> matches;
}
