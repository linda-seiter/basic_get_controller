package org.example.basic_get_controller.service;

public class LunchService {
    public String getDailySpecial(String day) {
        String special;
        switch (day.toLowerCase()) {
            case "monday":
                special = "BLT Sandwich";
                break;
            case "tuesday":
                special =  "Veggie Burger";
                break;
            case "wednesday":
            case "thursday":
                special = "Chili";
                break;
            case "friday":
                special = "Mac and Cheese";
                break;
            default:
                special = "Not open for lunch";
        }
        return special;
    }
}
