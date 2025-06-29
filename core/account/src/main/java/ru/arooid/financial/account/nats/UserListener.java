package ru.arooid.financial.account.nats;

import io.micronaut.nats.annotation.NatsListener;
import io.micronaut.nats.annotation.Subject;
import io.micronaut.scheduling.annotation.Async;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@NatsListener
public class UserListener {

    List<Integer> messageLengths = Collections.synchronizedList(new ArrayList<>());

    @Async
    @Subject("user.>")
    public void receive(byte[] data) throws InterruptedException {
        messageLengths.add(data.length);
        System.out.println(Thread.currentThread() + " Get From Nats - " + new String(data));
    }

}


