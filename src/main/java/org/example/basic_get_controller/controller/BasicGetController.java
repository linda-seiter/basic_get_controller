package org.example.basic_get_controller.controller;


import org.example.basic_get_controller.service.Magic8Service;
import org.example.basic_get_controller.service.LunchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

@RestController
public class BasicGetController {

    //Version#1 Explicit instantiation of service objects
    //Version#2 Use @Service and @Autowired
    private Magic8Service magic8ball;
    private LunchService lunch;

    public BasicGetController() {
        magic8ball = new Magic8Service();
        lunch = new LunchService();
    }

    @GetMapping("/")
    //localhost:8080/
    public String index() {
        return "Welcome to Spring Boot!";
    }

    @GetMapping("/roll")
    //localhost:8080/roll
    public String roll() {
        int roll = ThreadLocalRandom.current().nextInt(6);
        return String.format("You rolled a %d", (roll+1));
    }

    @GetMapping("/greet")
    //localhost:8080/greet?name=Fred
    public String greet(@RequestParam(defaultValue = "World") String name) {
        return String.format("Greetings %s!", name);
    }

    @GetMapping("/costperperson")
    //localhost:8080/costperperson?bill=32.50&people=5
    public String costPerPerson(@RequestParam double bill, @RequestParam int people) {
        if (people == 0)
            return "#people must not be 0";
        else
            return String.format("$%.2f divided by %d people means each person owes $%.2f!", bill, people, bill/people);
    }

    @GetMapping("/farewell/{name}")
    //localhost:8080/farewell/Fred
    public String farewell(@PathVariable String name) {
        return String.format("Farewell %s, it was nice meeting you.", name);
    }

    @GetMapping("/magic8")
    //localhost:8080/magic8?question=Will it rain
    public String magic8(@RequestParam String question) {
        return String.format("You asked: %s 8Ball says: %s", question, magic8ball.answer());
    }

    @GetMapping("/lunch-special/{day}")
    //localhost:8080/lunch-special/monday
    public String lunchSpecial(@PathVariable String day) {
        return lunch.getDailySpecial(day);
    }
}


