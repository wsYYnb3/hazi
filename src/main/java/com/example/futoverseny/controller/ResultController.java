package com.example.futoverseny.controller;

import com.example.futoverseny.entity.Result;
import com.example.futoverseny.service.ResultService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ResultController {
    private final ResultService resultService;

    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @PostMapping("/addResult")
    public Result addResult(@RequestParam Long runnerId, @RequestParam Long raceId, @RequestParam Integer idoPerc) {
        return resultService.addResult(runnerId, raceId, idoPerc);
    }
}
