package com.example.futoverseny.controller;

import com.example.futoverseny.entity.Runner;
import com.example.futoverseny.service.RunnerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RunnerController {
    private final RunnerService runnerService;

    public RunnerController(RunnerService runnerService) {
        this.runnerService = runnerService;
    }

    @GetMapping("/getRunners")
    public List<Runner> getAllRunners() {
        return runnerService.findAll();
    }

    @PostMapping("/addRunner")
    public Runner addRunner(@RequestBody Runner runner) {
        return runnerService.addRunner(runner);
    }
}
