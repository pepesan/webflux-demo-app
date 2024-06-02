package com.cursosdedesarrollo.webfluxdemoapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dato {
    private String id;
    private String cadena;

    public Dato(DatoDto datoDto){
        this.cadena = datoDto.getCadena();
    }
}
