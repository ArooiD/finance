package ru.arooid.financial.account.repository;

import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.r2dbc.annotation.R2dbcRepository;
import io.micronaut.data.r2dbc.repository.ReactorCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.arooid.financial.account.model.User;

import java.util.UUID;

@R2dbcRepository(dialect = Dialect.POSTGRES)
public interface UserRepo extends ReactorCrudRepository<User, UUID> {

    Mono<User> findByUsername(String username);

    Flux<User> findByFirstname(String firstName);
}
