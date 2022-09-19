package org.example.basic_get_controller.service;

import java.util.concurrent.ThreadLocalRandom;

public class Magic8Service {
    private static String[] magic8Responses = {"Without a doubt", "Ask again later", "My sources say no"};
    public String answer() {
        int randomInt = ThreadLocalRandom.current().nextInt(magic8Responses.length);
        return magic8Responses[randomInt];
    }
}
