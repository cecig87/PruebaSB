package com.prueba.demo_paises.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pais {
    
    @Id
    private int id;
    @Column(name = "Nombre", length = 50)
    private String name;
    @Column(name ="Infectados", length = 50)
    private int infectados;
    @Column(name = "Recuperados", length = 50)
    private int recuperados;
    @Column(name = "Fallecidos", length = 50)
    private int fallecidos;

    public int getIdPais(){
        return id;
    }

    public void setIdPais(int id) {
      this.id = id;
    }
    
    public String getName(){
        return name;
    }

    public void setName(String nombre) {
      this.name = nombre;
    }
    public int getInfectados(){
        return infectados;
    }

    public void setInfectados(int infect) {
      this.infectados = infect;
    }
    public int getRecuperados(){
        return recuperados;
    }

    public void setRecuperados(int recuperados) {
      this.recuperados = recuperados;
    }

    public int getFallecidos(){
        return fallecidos;
    }

    public void setFallecidos(int fallecidos) {
      this.fallecidos = fallecidos;
    }
}