package ru.arooid.financial.account.nats;

import io.micronaut.nats.annotation.NatsClient;
import io.micronaut.nats.annotation.Subject;
import org.reactivestreams.Publisher;

@NatsClient
public interface UserProducer {

    @Subject(value = "user.create")
    Publisher<String> sendReactive(byte[] data);
}

