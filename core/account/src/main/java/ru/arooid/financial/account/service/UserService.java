package ru.arooid.financial.account.service;

import io.micronaut.scheduling.annotation.Async;
import jakarta.inject.Singleton;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Mono;
import ru.arooid.financial.account.dto.UserDto;
import ru.arooid.financial.account.model.User;
import ru.arooid.financial.account.nats.UserProducer;
import ru.arooid.financial.account.repository.UserRepo;

import java.nio.charset.StandardCharsets;

@Singleton
public class UserService {

    private final UserRepo userRepo;
    private final UserProducer producer;

    public UserService(UserRepo userRepo, UserProducer producer) {
        this.userRepo = userRepo;
        this.producer = producer;
    }

    public Mono<UserDto> save(UserDto userDto) {
        return userRepo.save(new User(userDto))
                .map(user -> {
                    var res = new UserDto(user.getUsername(),
                            user.getFirstname(),
                            user.getLastname(),
                            user.getEmail(),
                            user.getPhone());
                    producer.sendReactive(user.toJson().getBytes(StandardCharsets.UTF_8))
                            .subscribe(new Subscriber<String>() {
                        @Override
                        public void onSubscribe(Subscription s) {
                            System.out.println("Subscription ".concat(Thread.currentThread().getName()));
                        }

                        @Override
                        public void onNext(String s) {
                            System.out.println("Next");
                        }

                        @Override
                        public void onError(Throwable t) {
                            System.out.println(t.getMessage());
                        }

                        @Override
                        public void onComplete() {
                            System.out.println("Complete");
                        }
                    });
                    return res;
                });
    }
}
