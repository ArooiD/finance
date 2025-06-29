package ru.arooid.financial.account.config;

import com.nimbusds.jwt.JWT;
import io.micronaut.context.annotation.Replaces;
import io.micronaut.security.authentication.Authentication;
import io.micronaut.security.token.jwt.validator.JwtAuthenticationFactory;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Singleton
@Replaces(JwtAuthenticationFactory.class)
public class AuthProviderCustom implements JwtAuthenticationFactory {

    @SuppressWarnings("unchecked")
    @Override
    public Optional<Authentication> createAuthentication(JWT token) {
        try {
            Map<String, Collection<String>> roles = (Map<String, Collection<String>>) token.getJWTClaimsSet().getClaim("realm_access");
            var auth = Authentication.build(token.getJWTClaimsSet().getClaimAsString("preferred_username"), roles.get("roles"));
            return Optional.of(auth);
        } catch (ParseException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
