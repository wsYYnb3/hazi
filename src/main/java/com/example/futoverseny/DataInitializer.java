package com.example.futoverseny;

import com.example.futoverseny.entity.Race;
import com.example.futoverseny.entity.Result;
import com.example.futoverseny.entity.Runner;
import com.example.futoverseny.repository.RaceRepository;
import com.example.futoverseny.repository.ResultRepository;
import com.example.futoverseny.repository.RunnerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RunnerRepository runnerRepository;
    private final RaceRepository raceRepository;
    private final ResultRepository resultRepository;

    public DataInitializer(RunnerRepository runnerRepository, RaceRepository raceRepository, ResultRepository resultRepository) {
        this.runnerRepository = runnerRepository;
        this.raceRepository = raceRepository;
        this.resultRepository = resultRepository;
    }

    @Override
    public void run(String... args) {
        Runner r1 = new Runner(); r1.setNev("Kovács István"); r1.setEletkor(30); r1.setNem("M");
        Runner r2 = new Runner(); r2.setNev("Szabó Anna"); r2.setEletkor(25); r2.setNem("F");
        Runner r3 = new Runner(); r3.setNev("Nagy Béla"); r3.setEletkor(40); r3.setNem("M");
        Runner r4 = new Runner(); r4.setNev("Tóth Edit"); r4.setEletkor(35); r4.setNem("F");

        runnerRepository.saveAll(List.of(r1,r2,r3,r4));

        Race v1 = new Race(); v1.setNev("Tavaszi Futás"); v1.setTavolsagKm(10.0);
        Race v2 = new Race(); v2.setNev("Őszi Maraton"); v2.setTavolsagKm(42.195);

        raceRepository.saveAll(List.of(v1, v2));

        Result res1 = new Result(); res1.setRunner(r1); res1.setRace(v1); res1.setIdoEredmenyPerc(50);
        Result res2 = new Result(); res2.setRunner(r2); res2.setRace(v1); res2.setIdoEredmenyPerc(55);
        Result res3 = new Result(); res3.setRunner(r3); res3.setRace(v1); res3.setIdoEredmenyPerc(48);

        Result res4 = new Result(); res4.setRunner(r1); res4.setRace(v2); res4.setIdoEredmenyPerc(200);
        Result res5 = new Result(); res5.setRunner(r4); res5.setRace(v2); res5.setIdoEredmenyPerc(220);
        Result res6 = new Result(); res6.setRunner(r2); res6.setRace(v2); res6.setIdoEredmenyPerc(210);

        resultRepository.saveAll(List.of(res1,res2,res3,res4,res5,res6));
    }
}
