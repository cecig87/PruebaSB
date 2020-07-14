package com.prueba.demo_paises.model;

public class Respuesta {
   private String error; 
   private String borrado;

public String getError(){
    return error;
}

public void setError(String error) {
 this.error = error;
}

public String getBorrado(){
    return borrado;
}

public void setBorrado(String borrado) {
 this.borrado = borrado;
}
}