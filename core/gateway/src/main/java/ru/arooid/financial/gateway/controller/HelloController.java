package ru.arooid.financial.gateway.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Controller
public class HelloController {

    @Get(value = "/health")
    public Mono<HttpResponse<String>> hello() {
        HttpResponse<String> response = HttpResponse
                .status(HttpStatus.OK)
                .header("Content-Type", "text/plain")
                .body("It`s Okey");
        return Mono.just(response);
    }

    @Get(value = "/")
    public Mono<HttpResponse<String>> test() {
        HttpResponse<String> response = HttpResponse
                .status(HttpStatus.OK)
                .header("Content-Type", "text/plain")
                .body("Hello");
        return Mono.just(response);
    }
}