package ru.arooid.financial.account;

import io.micronaut.runtime.Micronaut;

public class Application {

    public static void main(String[] args) {
        printEnv();
        Micronaut.run(Application.class, args);
    }

    private static void printEnv(){
        System.out.println("ENVIRONMENT");
        System.getenv().forEach((k, v) -> System.out.println(k + "=" + v));
    }
}