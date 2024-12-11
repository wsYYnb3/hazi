package com.example.futoverseny.entity;

import jakarta.persistence.*;

@Entity
public class Runner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nev;
    private Integer eletkor;
    private String nem; // "F" vagy "M"

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNev() { return nev; }
    public void setNev(String nev) { this.nev = nev; }

    public Integer getEletkor() { return eletkor; }
    public void setEletkor(Integer eletkor) { this.eletkor = eletkor; }

    public String getNem() { return nem; }
    public void setNem(String nem) { this.nem = nem; }
}
