package com.example.futoverseny.controller;

import com.example.futoverseny.entity.Race;
import com.example.futoverseny.service.RaceService;
import com.example.futoverseny.service.ResultService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ViewController {
    private final RaceService raceService;
    private final ResultService resultService;

    public ViewController(RaceService raceService, ResultService resultService) {
        this.raceService = raceService;
        this.resultService = resultService;
    }

    @GetMapping("/races")
    public String listRaces(Model model) {
        model.addAttribute("races", raceService.findAll());
        return "races";
    }

    @GetMapping("/races/new")
    public String newRaceForm(Model model) {
        model.addAttribute("race", new Race());
        return "new_race";
    }

    @PostMapping("/races")
    public String createRace(@ModelAttribute Race race) {
        raceService.addRace(race);
        return "redirect:/races";
    }

    @GetMapping("/races/{id}")
    public String raceDetails(@PathVariable Long id, Model model) {
        var race = raceService.findById(id).orElseThrow(() -> new IllegalArgumentException("Nincs ilyen verseny"));
        var results = resultService.findByRaceSorted(id);
        model.addAttribute("race", race);
        model.addAttribute("results", results);
        return "race_details";
    }
}
