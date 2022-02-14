package com.david.optional.demo;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class OrElseAndOrElseGetDemo {

    public static void main(String[] args) {

        String message = "Do only what you need to do and do it only when you need to";

        String veryImportantMessage = Optional.ofNullable(message)
                .filter(text -> !text.isEmpty())
                .map(String::toUpperCase)
                .orElse(recoverMessageFromSource());

        printIfAny(veryImportantMessage);

        message = "Make It Better!";

        veryImportantMessage = Optional.ofNullable(message)
                .filter(text -> !text.isEmpty())
                .map(String::toUpperCase)
                .orElseGet(OrElseAndOrElseGetDemo::recoverMessageFromSource);

        printIfAny(veryImportantMessage);

    }

    public static String recoverMessageFromSource() {

        try {

            System.out.println("Requesting to source, this could take a while...");

            TimeUnit.SECONDS.sleep(5);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "We need to improve our efficiency!";
    }

    private static void printIfAny(String veryImportantMessage) {
        Optional.of(veryImportantMessage)
                .ifPresent(msj -> {
                    System.out.println("Finally! what you should know is: " + msj);
                });
    }

}
