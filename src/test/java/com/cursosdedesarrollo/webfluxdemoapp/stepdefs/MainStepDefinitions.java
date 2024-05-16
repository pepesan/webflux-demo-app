package com.cursosdedesarrollo.webfluxdemoapp.stepdefs;


import com.cursosdedesarrollo.webfluxdemoapp.domain.Person;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MainStepDefinitions {

    private static final String API_MIME_TYPE = "application/json";
    private static final String API_BASE_URL = "http://localhost:8080";
    private static final String USER_AGENT = "Spring 5 WebClient";
    private final WebClient webClient = WebClient.builder()
            .baseUrl(API_BASE_URL)
            .defaultHeader(HttpHeaders.CONTENT_TYPE, API_MIME_TYPE)
            .defaultHeader(HttpHeaders.USER_AGENT, USER_AGENT)
            .build();
    private Mono<Person> mono;


    @Given("I send a GET request to {string}")
    public void i_send_a_get_request_to(String url) {
        mono = webClient
                .get()
                .uri(url)
                .exchangeToMono(response -> response.bodyToMono(Person.class));
    }
    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(Integer int1) {
        Person person = new Person();
        person.setId("1L");
        person.setName("David");
        person.setLastName("Vaquero");
        mono.subscribe(responsePerson -> {
            System.out.println("comprobando");
            assertEquals(responsePerson, person);
        });
    }
}

