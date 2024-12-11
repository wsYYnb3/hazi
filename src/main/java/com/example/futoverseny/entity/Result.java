package com.example.futoverseny.entity;

import jakarta.persistence.*;

@Entity
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="runner_id")
    private Runner runner;

    @ManyToOne
    @JoinColumn(name="race_id")
    private Race race;

    private Integer idoEredmenyPerc;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Runner getRunner() { return runner; }
    public void setRunner(Runner runner) { this.runner = runner; }

    public Race getRace() { return race; }
    public void setRace(Race race) { this.race = race; }

    public Integer getIdoEredmenyPerc() { return idoEredmenyPerc; }
    public void setIdoEredmenyPerc(Integer idoEredmenyPerc) { this.idoEredmenyPerc = idoEredmenyPerc; }
}
