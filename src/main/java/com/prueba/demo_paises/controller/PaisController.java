package com.prueba.demo_paises.controller;

import com.prueba.demo_paises.model.Pais;
import com.prueba.demo_paises.repo.IPaisRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PaisController {

    @Autowired
    private IPaisRepo repo;

    @GetMapping("/inicio")
    public String welcome(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
 
    
    Pais country = new Pais();
   country.setIdPais(2);
    country.setName("Italia");
   country.setInfectados(153000);
    country.setRecuperados(90000);
    country.setFallecidos(63000);
   repo.save(country);
   
    model.addAttribute("name", name);
    return "welcome";
}
    
}