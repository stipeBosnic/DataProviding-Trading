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
@NoArgsConstructor
@Table(name = "category")
public class Category {

    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "category_name")
    @NotNull(message = "category name is required")
    private String categoryName;

    @Column(name = "sport_id")
    @NotNull(message = "sport id is required")
    private int sportId;

    @ManyToOne
    @JoinColumn(name = "sport_id", insertable = false, updatable = false)
    Sport sport;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "category_id")
    private List<Tournament> tournaments;
}
