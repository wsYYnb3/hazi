package com.example.futoverseny.service;

import com.example.futoverseny.entity.Race;
import com.example.futoverseny.repository.RaceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RaceService {
    private final RaceRepository raceRepository;

    public RaceService(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    public List<Race> findAll() {
        return raceRepository.findAll();
    }

    public Race addRace(Race race) {
        return raceRepository.save(race);
    }

    public Optional<Race> findById(Long id) {
        return raceRepository.findById(id);
    }

    public Race updateRace(Long id, String ujNev, Double ujTav) {
        Race race = raceRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Nincs ilyen verseny"));
        race.setNev(ujNev);
        race.setTavolsagKm(ujTav);
        return raceRepository.save(race);
    }
}
