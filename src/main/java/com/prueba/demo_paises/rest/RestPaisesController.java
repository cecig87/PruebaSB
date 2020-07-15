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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

              @DeleteMapping(value = "/{id}")
              public ResponseEntity<Respuesta> eliminarPais(@PathVariable("id") Integer id) {
               
               if(repo.existsById(id)){
                repo.deleteById(id);
               
                Respuesta borrado = new Respuesta();
                borrado.setBorrado("País con id " + id);
                Log.warn("Se ha eliminado el país con id " + id);
                return new ResponseEntity<Respuesta>(borrado, HttpStatus.OK);
               } else {
                 Log.warn("Ese país no se encontraba registrado.");
                 Respuesta malBorrado = new Respuesta();
                 malBorrado.setError("El país no se encontraba registrado.");
                 return new ResponseEntity<Respuesta>(malBorrado, HttpStatus.BAD_REQUEST);
               }
              }


              @PutMapping(value = "/{id}")
              public ResponseEntity<?> Modificar( @PathVariable("id") Integer id, @Valid @RequestBody  Pais newPais) {
            
               String revisar = newPais.getName();
               Pais repetido = repo.findByName(revisar);
                
                if(repetido != null){
                 Log.warn("El país ya existe.");
                 Respuesta errorModificar = new Respuesta();
                 errorModificar.setError("Ese país ya se encontraba registrado.");
                 return new ResponseEntity<>(errorModificar, HttpStatus.BAD_REQUEST);
                 } 
                  
                if(repo.existsById(id)){
                 newPais.setIdPais(id);
                 repo.save(newPais);
                 Log.info("País actualizado.");
                 return new ResponseEntity<Pais>(newPais, HttpStatus.OK);
                } else {
                 Log.warn("Error: no se puede modificar porque no existe en la base de datos.");
                 Respuesta noExiste = new Respuesta();
                 noExiste.setError("No se puede modificar un país que no estaba registrado.");
                 return new ResponseEntity<>(noExiste, HttpStatus.BAD_REQUEST);  
              }

              }
 
}


