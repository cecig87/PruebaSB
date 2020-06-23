package com.prueba.demo_paises.repo;

import com.prueba.demo_paises.model.Pais;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaisRepo extends JpaRepository<Pais, Integer>{
    
}