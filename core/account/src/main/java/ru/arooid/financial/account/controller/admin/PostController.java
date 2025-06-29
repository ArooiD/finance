package ru.arooid.financial.account.controller.admin;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.scheduling.annotation.Async;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;
import ru.arooid.financial.account.dto.UserDto;
import ru.arooid.financial.account.service.UserService;

@Controller
public class PostController {

    private final UserService userService;
    private final Logger log;

    public PostController(UserService userService) {
        this.userService = userService;
        this.log = LoggerFactory.getLogger(this.getClass());
    }

    @Post("/user")
    public Mono<UserDto> saveUser(@Body UserDto userDto) {
        log.trace("Saving user: {}", userDto);
        return userService.save(userDto)
                .log(log.getName())
                .onErrorReturn(new UserDto())
                .doOnError(err -> {
                            log.error(err.getMessage());
                            throw new RuntimeException("HELLO!");
                        }
                )
                .switchIfEmpty(Mono.empty());
    }
}
