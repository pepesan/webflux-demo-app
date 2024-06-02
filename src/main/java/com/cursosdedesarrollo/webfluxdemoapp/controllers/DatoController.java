package com.cursosdedesarrollo.webfluxdemoapp.controllers;

import com.cursosdedesarrollo.webfluxdemoapp.domain.Dato;
import com.cursosdedesarrollo.webfluxdemoapp.domain.DatoDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/dato")
public class DatoController {
    private List<Dato> listado;
    private Integer lastID;

    public DatoController(){
        this.listado = new ArrayList<Dato>();
        Dato d = new Dato("1L", "SQLDevDBA");
        this.listado.add(d);
        this.lastID = 1;
    }

    @GetMapping("/")
    public Flux<Dato> index(){
        return Flux.fromIterable(this.listado);
    }

    @PostMapping("/")
    public Mono<ResponseEntity<Dato>> addItem(@Valid @RequestBody DatoDto datoDto){
        this.lastID++;
        String iden = this.lastID + "L";
        Dato d = new Dato(datoDto);
        d.setId(iden);
        this.listado.add(d);
        return Mono.just(ResponseEntity.ok(d));
    }

}
