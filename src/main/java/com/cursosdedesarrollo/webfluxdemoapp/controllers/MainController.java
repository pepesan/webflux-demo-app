package com.cursosdedesarrollo.webfluxdemoapp.controllers;


import com.cursosdedesarrollo.webfluxdemoapp.domain.Dato;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;


@RestController
@RequestMapping("/api/v1/main")
public class MainController {
    /*
        Entrada / Mono<Dato>
     */
    @GetMapping("/")
    public Mono<Dato> index(){
        Dato d = new Dato("1L", "Lufegaba");
        return Mono.just(d);
    }

    @GetMapping("/list")
    public Flux<Dato> getList(){
        ArrayList<Dato> listado = new ArrayList<>();
        Dato d = new Dato("1L", "anmi_0309");
        listado.add(d);
        return  Flux.fromIterable(listado); // Convierte la lista en un Flux<Person>
    }
}
