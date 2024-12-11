package com.example.futoverseny.service;

import com.example.futoverseny.entity.Runner;
import com.example.futoverseny.repository.RunnerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RunnerService {
    private final RunnerRepository runnerRepository;

    public RunnerService(RunnerRepository runnerRepository) {
        this.runnerRepository = runnerRepository;
    }

    public List<Runner> findAll() {
        return runnerRepository.findAll();
    }

    public Runner addRunner(Runner runner) {
        return runnerRepository.save(runner);
    }
}
