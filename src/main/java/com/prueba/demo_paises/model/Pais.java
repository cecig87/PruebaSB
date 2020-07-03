package com.prueba.demo_paises.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

@Entity
public class Pais {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Nombre", length = 50, unique = true) 
    @NotNull(message="Por favor escriba un nombre") 
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