package estu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TheRecipeBook {
    ArrayList<Meal> mealList = new ArrayList<>();
    ArrayList<Event> eventList = new ArrayList<>();
    
    

    public static void main(String[] args) {



        
        menuScreen();
    }

    public static void menuScreen() {
        System.out.println(
                "Please select a option: \n" +
                        "1) Ingredient Option (Select the ingredients you want to enter) \n" +
                        "2) Meal Name Option (Enter a meal name to find the recipe \n" +
                        "3) Event Meal Option (Select an event and find meals according to that event \n" +
                        "4) Similar Meal Option (Select a meal and find similar meals \n");
    }

    
}
