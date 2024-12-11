package com.example.futoverseny.controller;

import com.example.futoverseny.entity.Race;
import com.example.futoverseny.entity.Result;
import com.example.futoverseny.service.RaceService;
import com.example.futoverseny.service.ResultService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RaceController {
    private final RaceService raceService;
    private final ResultService resultService;

    public RaceController(RaceService raceService, ResultService resultService) {
        this.raceService = raceService;
        this.resultService = resultService;
    }

    @GetMapping("/getRaceRunners/{id}")
    public List<Result> getRaceRunners(@PathVariable Long id) {
        return resultService.findByRaceSorted(id);
    }

    @PostMapping("/updateRace")
    public Race updateRace(@RequestBody Race race) {
        return raceService.updateRace(race.getId(), race.getNev(), race.getTavolsagKm());
    }

    @GetMapping("/getAverageTime/{raceId}")
    public Double getAverageTime(@PathVariable Long raceId) {
        return resultService.getAverageTime(raceId);
    }
}
