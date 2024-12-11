package com.example.futoverseny.entity;

import jakarta.persistence.*;

@Entity
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nev;
    private Double tavolsagKm;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNev() { return nev; }
    public void setNev(String nev) { this.nev = nev; }

    public Double getTavolsagKm() { return tavolsagKm; }
    public void setTavolsagKm(Double tavolsagKm) { this.tavolsagKm = tavolsagKm; }
}
