package com.example.futoverseny.service;

import com.example.futoverseny.entity.Result;
import com.example.futoverseny.repository.RaceRepository;
import com.example.futoverseny.repository.ResultRepository;
import com.example.futoverseny.repository.RunnerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.OptionalDouble;

@Service
@Transactional
public class ResultService {
    private final ResultRepository resultRepository;
    private final RunnerRepository runnerRepository;
    private final RaceRepository raceRepository;

    public ResultService(ResultRepository resultRepository, RunnerRepository runnerRepository, RaceRepository raceRepository) {
        this.resultRepository = resultRepository;
        this.runnerRepository = runnerRepository;
        this.raceRepository = raceRepository;
    }

    public Result addResult(Long runnerId, Long raceId, Integer idoPerc) {
        var runner = runnerRepository.findById(runnerId).orElseThrow(() -> new IllegalArgumentException("Nincs ilyen futó"));
        var race = raceRepository.findById(raceId).orElseThrow(() -> new IllegalArgumentException("Nincs ilyen verseny"));
        Result r = new Result();
        r.setRunner(runner);
        r.setRace(race);
        r.setIdoEredmenyPerc(idoPerc);
        return resultRepository.save(r);
    }

    public List<Result> findByRaceSorted(Long raceId) {
        return resultRepository.findByRaceIdOrderByIdoEredmenyPercAsc(raceId);
    }

    public Double getAverageTime(Long raceId) {
        List<Result> results = resultRepository.findByRaceIdOrderByIdoEredmenyPercAsc(raceId);
        OptionalDouble avg = results.stream().mapToInt(Result::getIdoEredmenyPerc).average();
        return avg.isPresent() ? avg.getAsDouble() : null;
    }
}
