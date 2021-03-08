package com.william.segwareteste.controller;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.given;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PostControllerTest {


    @LocalServerPort
    private int port;
    private static String payloadCriarPost = "{\n" +
            "  \"autor\": \"William\",\n" +
            "  \"conteudo\": \"meu post feito pelo teste\"\n" +
            "}";

    @BeforeEach
    public void setup() {
        RestAssured.basePath = "/api/postagens";
        RestAssured.port = port;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    public void deveRetornarStatus200_quandoListarPosts() {
        given()
                .accept(ContentType.JSON)
                .when()
                .get()
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void deveRetornarStatus201_quandoCriarNovoPost() {
        given()
                .body(payloadCriarPost)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .post()
                .then()
                .statusCode(HttpStatus.CREATED.value());
    }

}
