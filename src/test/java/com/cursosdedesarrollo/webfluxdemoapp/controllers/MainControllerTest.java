package com.cursosdedesarrollo.webfluxdemoapp.controllers;

import com.cursosdedesarrollo.webfluxdemoapp.domain.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@WebFluxTest(MainController.class)
public class MainControllerTest{
    @Autowired
    private WebTestClient webClient;

    @MockBean
    private MainController mainController;
    @Test
    public void testGetPerson() {
        Person person = new Person();
        person.setId("1L");
        person.setName("David");
        person.setLastName("Vaquero");

        when(mainController.getPerson()).thenReturn(Mono.just(person));

        webClient.get().uri("/api/main")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Person.class)
                .isEqualTo(person);
    }


    @Test
    public void testGetPersonsIterable() {
        Person person1 = new Person();
        person1.setId("1L");
        person1.setName("David");
        person1.setLastName("Vaquero");

        Person person2 = new Person();
        person2.setId("2L");
        person2.setName("Lorena");
        person2.setLastName("Reyes");

        List<Person> persons = Arrays.asList(person1, person2);

        when(mainController.getPersonsIterable()).thenReturn(Flux.fromIterable(persons));

        webClient.get().uri("/api/main/list-iterable")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Person.class)
                .isEqualTo(persons);
    }

}