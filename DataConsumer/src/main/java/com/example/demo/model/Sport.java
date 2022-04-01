package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "sport")
public class Sport {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sport_id")
    private int id;

    @Column(name = "sport_name")
    @NotNull(message = "sport name is required")
    private String sportName;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "sport_id")
    private List<Category> categories;
}
