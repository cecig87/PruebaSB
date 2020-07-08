package com.prueba.demo_paises.rest;

import java.util.List;

import javax.validation.Valid;

import com.prueba.demo_paises.model.Pais;
import com.prueba.demo_paises.model.Respuesta;
import com.prueba.demo_paises.repo.IPaisRepo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static Logger Log = LoggerFactory.getLogger(RestPaisesController.class);

    @GetMapping   
    public List<Pais> listar() {
        return repo.findAll();
    }

    @PostMapping
    public ResponseEntity<?> InsertarPais(@Valid @RequestBody Pais pais ) {
     
    String compara = pais.getName();
      Pais repet = repo.findByName(compara);
      
    if(repet != null){
      Log.warn("Este país ya se encuentra registrado.");
                                  //probar con "name": "mensaje"
     // Object msg ={"Error", "Ese país ya existe."};
     //String error = "Ese país ya existe";

     Respuesta msg = new Respuesta();
     msg.setError("Ese país ya existe.");
       return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
      } 

       try{
          repo.save(pais);
       
       } catch(Exception e){
          System.out.println("Error: " + e.getMessage());
       }

       return new ResponseEntity<Pais>(pais, HttpStatus.OK);
         
              }
 
}
