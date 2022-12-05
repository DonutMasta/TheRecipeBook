package estu;

import java.util.ArrayList;

import java.util.Iterator;

public class TheRecipeBook {
    static ArrayList<Meal> mealList = new ArrayList<>();
    static ArrayList<Event> eventList = new ArrayList<>();

    public static void main(String[] args) {

        OptionScreen();
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
        String userMealName = "Kavurma";
        System.out.println("Similar Meal Option selected, please enter a meal name\n");
        Meal meal = FindMeal(userMealName);
        tempMealList = SimilarIngredient(meal);
        while (tempMealList.isEmpty()) {
            System.out.println("The application couldn't find a similar meal based on your meal \n"
                    + "Please enter another meal name or return back to Option Screen\n");
            meal = FindMeal(userMealName);//another meal name can be entered
            tempMealList = SimilarIngredient(meal);
        }
        System.out.println(tempMealList.toString());
        
        Meal selectedMeal = tempMealList.get(0); // test icin ilk yemek secildi
        selectedMeal.toString();

    }

    public static ArrayList<Meal> SimilarIngredient(Meal meal) {
        ArrayList<Meal> tempMealList = new ArrayList<>();
        Iterator<Meal> mealIt = mealList.iterator();
        while (mealIt.hasNext()) {
            Meal meal1 = mealIt.next();
            if (meal1.getIngrediantList().contains(meal.getIngrediantList())) { // duzgun algoritma lazim
                tempMealList.add(meal1);
            }
        }

        return tempMealList;

    }

    public static Meal FindMeal(String userMealName) {
        Iterator<Meal> mealIt = mealList.iterator();
        while (mealIt.hasNext()) {
            Meal meal = mealIt.next();
            if (meal.getMealName().contains(userMealName)) { // duzgun algoritma lazim
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
            if (meal.getIngrediantList().contains(ingredients)) { // duzgun algoritma lazim
                tempMealList.add(meal);
            }
        }
        return tempMealList;
    }
}
