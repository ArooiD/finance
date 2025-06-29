package ru.arooid.financial.account.controller.admin;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import jakarta.annotation.security.RolesAllowed;
import reactor.core.publisher.Mono;

@Controller
@Secured(SecurityRule.IS_AUTHENTICATED)
public class GetController {

    @RolesAllowed({"USER"})
    @Get
    public Mono<String> hello(){
        return Mono.just("Hello");
    }

}
