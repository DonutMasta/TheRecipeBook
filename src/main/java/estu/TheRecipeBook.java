package estu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class TheRecipeBook {
    static ArrayList<Meal> mealList = new ArrayList<>();
    static ArrayList<Event> eventList = new ArrayList<>();

    public static void main(String[] args) {

        Meal pumpkinPie = new Meal("Pumpkin pie",
                new ArrayList<String>(Arrays.asList("Flour", "Butter", "Sugar", "Water", "Pumpkin", "Egg", "Water")));
        mealList.add(pumpkinPie);
        Meal roastTurkey = new Meal("Roast Turkey", new ArrayList<String>(
                Arrays.asList("Turkey", "Salt", "Black pepper", "Onion", "Garlic", "Butter")));
        mealList.add(roastTurkey);
        Meal birthdayCake = new Meal("Birthday Cake", new ArrayList<String>(
                Arrays.asList("Flour", "Salt", "Egg", "Sugar", "Milk", "Butter", "Olive oil", "Baking powder")));
        mealList.add(birthdayCake);
        Meal pizza = new Meal("Pizza", new ArrayList<String>(
                Arrays.asList("Flour", "Water", "Olive oil", "Salt", "Cheese", "Tomato", "Pepper", "Sausage")));
        mealList.add(pizza);
        Meal pumpkinCinnamonRoll = new Meal("Pumpkin Cinnamon Roll",
                new ArrayList<String>(Arrays.asList("Milk", "Olive oil", " Sugar", "Flour",
                        "Pumpkin", "Cinnamon", "Baking powder", "Butter", "Salt")));
        mealList.add(pumpkinCinnamonRoll);
        Meal pumpkinRisotto = new Meal("Pumpkin Risotto", new ArrayList<String>(
                Arrays.asList("Chicken", "Onion", "Garlic", "Rice", "Salt", "Pumpkin", "Cheese", "Black pepper")));
        mealList.add(pumpkinRisotto);
        Meal kavurmaliYumurta = new Meal("Kavurmalı Yumurta ", new ArrayList<String>(
                Arrays.asList("Meal", "Egg", "Olive oil", "Salt")));
        mealList.add(kavurmaliYumurta);
        Meal kavurma = new Meal("Kavurma", new ArrayList<String>(
                Arrays.asList("Meat", "Olive oil", "Tomato", "Green Pepper", "Salt", "Onion", "Garlic")));
        mealList.add(kavurma);
        Meal manti = new Meal("Manti", new ArrayList<String>(
                Arrays.asList("Flour", "Water", "Salt", "Egg", "Meat", "Onion", "Black pepper", "Butter", "Tomato")));
        mealList.add(manti);
        Meal zeytinyagliyapraksarmasi = new Meal("Zeytinyağlı Yaprak Sarması",
                new ArrayList<String>(
                        Arrays.asList("Olive oil", "Onion", "Rice", "Salt", "Sugar", "Water", "Vine Leaf")));
        mealList.add(zeytinyagliyapraksarmasi);

        Event birthday = new Event("Birthday");

        OptionScreen();
    }

    public static void CreateEvent(ArrayList<String> events) {
        for (String event : events) {
            Event newEvent = new Event(event);
            // yemekler evente eklenecek
            eventList.add(newEvent);
        }

    }

    public static void OptionScreen() {
        System.out.println(
                "Please select a option: \n" +
                        "1) Ingredient Option (Select the ingredients you want to enter) \n" +
                        "2) Meal Name Option (Enter a meal name to find the recipe \n" +
                        "3) Event Meal Option (Select an event and find meals according to that event \n" +
                        "4) Similar Meal Option (Select a meal and find similar meals \n");
    }

    public static void Option1() {

        ArrayList<String> tempIngredientList = new ArrayList<>();
        ArrayList<Meal> tempMealList = new ArrayList<>();
        System.out.println(
                "Ingredient Option selected, please enter the ingredients. \n");

        // ingredientler userdan alindi ve eklendi
        Ingredient userIngredients = new Ingredient(tempIngredientList);
        System.out.println("Selected ingredients are: " + tempIngredientList.toString()
                + " Searching for meals based on your ingredients");
        tempMealList = MatchIngredient(userIngredients);
        while (tempMealList.isEmpty()) {
            System.out.println("The application couldn't find a meal based on your ingredients \n" +
                    "Please enter more ingredients or return back to Option Screen");
            // temp ingredientliste biraz daha malzeme eklendi
            tempMealList = MatchIngredient(userIngredients);
        }
        for (Meal meal : tempMealList) {
            System.out.println(meal.getMealName() + "\n");
        }
        System.out.println("Please select a meal\n"
                + "If you didn't like the meals you can add more ingredients or return to the Option Screen\n");
        System.out.println("Selected meal's ingredients:\n" + tempMealList.get(0).toString());

    }

    public static void Option2() {
        String userMealName = "Mantı"; // test icin manti secildi
        System.out.println("Meal Name Option selected, please enter a meal name\n");
        Meal meal = FindMeal(userMealName);
        while (meal == null) {
            System.out.println("The application couldn't find the meal based on the meal name you have entered\n" +
                    "Please enter another meal name or return to the Option Screen ");
            meal = FindMeal(userMealName);
        }

        meal.toString();
    }

    public static void Option3() {
        System.out.println("Event Meal Option selected, please select a event.\n");
        System.out.println(eventList.toString() + '\n'
                + "If you can't find the event you desired you can return back to the Option Screen");
        Event event = eventList.get(0);// test icin ilk event secildi
        System.out.println(event.getMealList().toString() + "\n"
                + " If you can't find the desired meal you can select another event or return back to Option Screen");
        Meal selectedMeal = event.getMealList().get(0);// test icin ilk yemek secildi
        selectedMeal.toString();
    }

    public static void Option4() {
        ArrayList<Meal> tempMealList;
        String userMealName = "Kavurma";// test icin manti secildi
        System.out.println("Similar Meal Option selected, please enter a meal name\n");
        Meal meal = FindMeal(userMealName);
        tempMealList = SimilarIngredient(meal);
        while (tempMealList.isEmpty()) {
            System.out.println("The application couldn't find a similar meal based on your meal \n"
                    + "Please enter another meal name or return back to Option Screen\n");
            meal = FindMeal(userMealName);// another meal name can be entered
            tempMealList = SimilarIngredient(meal);
        }
        System.out.println(tempMealList.toString());

        Meal selectedMeal = tempMealList.get(0); // test icin ilk yemek secildi
        selectedMeal.toString();

    }

    public static ArrayList<Meal> SimilarIngredient(Meal meal) {
        ArrayList<Meal> tempMealList = new ArrayList<>();
        Iterator<Meal> mealIt = mealList.iterator();
        ArrayList<String> mealIngredients = meal.getIngredientList();
        while (mealIt.hasNext()) {
            Meal meal1 = mealIt.next();
            ArrayList<String> meal1Ingredients = meal1.getIngredientList();
            meal1Ingredients.retainAll(mealIngredients);// ortak malzemeleri alir
            if (meal1Ingredients.size() > 2) {
                tempMealList.add(meal1);
            }
        }

        return tempMealList;

    }

    public static Meal FindMeal(String userMealName) {
        Iterator<Meal> mealIt = mealList.iterator();
        while (mealIt.hasNext()) {
            Meal meal = mealIt.next();
            if (meal.getMealName().equals(userMealName)) {
                return meal;
            }
        }
        return null;

    }

    public static ArrayList<Meal> MatchIngredient(Ingredient ingredients) {
        ArrayList<Meal> tempMealList = new ArrayList<>();

        Iterator<Meal> mealIt = mealList.iterator();
        while (mealIt.hasNext()) {
            Meal meal = mealIt.next();
            if (meal.getIngredientList().equals(ingredients.getIngredientList())) {
                tempMealList.add(meal);
            }
        }
        return tempMealList;
    }
}
