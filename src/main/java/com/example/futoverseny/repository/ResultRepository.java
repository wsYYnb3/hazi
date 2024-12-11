package com.example.futoverseny.repository;

import com.example.futoverseny.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ResultRepository extends JpaRepository<Result, Long> {
    List<Result> findByRaceIdOrderByIdoEredmenyPercAsc(Long raceId);
}
