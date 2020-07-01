package com.prueba.demo_paises.rest;

import java.util.List;

import javax.validation.Valid;

import com.prueba.demo_paises.model.Pais;
import com.prueba.demo_paises.repo.IPaisRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping
    public ResponseEntity<Pais> InsertarPais(@Valid @RequestBody Pais pais ) {
       Pais returnValue = repo.save(pais);
       
            
       return new ResponseEntity<Pais>(returnValue, HttpStatus.OK);
      
         //if(pais.getName() == null) {
           // System.out.println("ERROR: el campo nombre no debe estar vacío.");
              //  } 
              }
 
}
