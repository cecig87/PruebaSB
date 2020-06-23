package com.prueba.demo_paises.rest;

import java.util.List;

import com.prueba.demo_paises.model.Pais;
import com.prueba.demo_paises.repo.IPaisRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paises")
public class RestPaisesController {
    
    @Autowired
    private IPaisRepo repo;

    @GetMapping   
    public List<Pais> listar() {
        return repo.findAll();
    }
}
