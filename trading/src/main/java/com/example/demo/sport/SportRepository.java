package com.example.demo.sport;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SportRepository extends JpaRepository<Sport, Integer> {

    Sport findById(int id);

}
