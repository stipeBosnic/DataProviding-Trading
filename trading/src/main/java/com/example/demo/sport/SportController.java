package com.example.demo.sport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
public class SportController {

    @Autowired
    SportService sportService;

    @PostMapping("addsport")
    public Sport addSport(@Valid @RequestBody Sport sport) {
        return sportService.addSport(sport);
    }
    @GetMapping("getsports")
    public List<Sport> getSports() {
        return sportService.getAllSports();
    }
}
