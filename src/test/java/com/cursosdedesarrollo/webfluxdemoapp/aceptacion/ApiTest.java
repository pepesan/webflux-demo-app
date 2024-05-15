package com.cursosdedesarrollo.webfluxdemoapp.aceptacion;

import com.cursosdedesarrollo.webfluxdemoapp.domain.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Arrays;
import java.util.List;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiTest {

    @Autowired
    private WebTestClient webClient;

    @Test
    public void testGetPerson() {
        Person person = new Person();
        person.setId("1L");
        person.setName("David");
        person.setLastName("Vaquero");

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

        webClient.get().uri("/api/main/list-iterable")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Person.class)
                .isEqualTo(persons);
    }
}

