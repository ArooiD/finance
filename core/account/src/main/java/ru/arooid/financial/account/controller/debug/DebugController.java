package ru.arooid.financial.account.controller.debug;


import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.authentication.Authentication;
import io.micronaut.security.rules.SecurityRule;

import java.util.Map;

@Secured(SecurityRule.IS_ANONYMOUS)
@Controller("/debug")
public class DebugController {

    @Get("/auth")
    public Map<String, Object> debug(Authentication authentication) {

        return Map.of(
                "name", authentication.getName() != null ? authentication.getName() : "anonymous",
                "roles", authentication.getRoles() != null ? authentication.getRoles(): "anonymous",
                "all", authentication.getAttributes()
        );
    }
}
