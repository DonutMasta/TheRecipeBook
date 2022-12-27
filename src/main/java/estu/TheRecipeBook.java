package estu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class TheRecipeBook {
        static ArrayList<Meal> mealList = new ArrayList<>();
        static ArrayList<Event> eventList = new ArrayList<>();

        public static void main(String[] args) {

                Meal pumpkinPie = new Meal("Pumpkin pie",
                                new ArrayList<String>(Arrays.asList("Flour", "Butter", "Sugar", "Water", "Pumpkin",
                                                "Egg", "Water")));
                mealList.add(pumpkinPie);
                Meal roastTurkey = new Meal("Roast Turkey", new ArrayList<String>(
                                Arrays.asList("Turkey", "Salt", "Black pepper", "Onion", "Garlic", "Butter")));
                mealList.add(roastTurkey);
                Meal birthdayCake = new Meal("Birthday Cake", new ArrayList<String>(
                                Arrays.asList("Flour", "Salt", "Egg", "Sugar", "Milk", "Butter", "Olive oil",
                                                "Baking powder")));
                mealList.add(birthdayCake);
                Meal pizza = new Meal("Pizza", new ArrayList<String>(
                                Arrays.asList("Flour", "Water", "Olive oil", "Salt", "Cheese", "Tomato", "Pepper",
                                                "Sausage")));
                mealList.add(pizza);
                Meal pumpkinCinnamonRoll = new Meal("Pumpkin Cinnamon Roll",
                                new ArrayList<String>(Arrays.asList("Milk", "Olive oil", " Sugar", "Flour",
                                                "Pumpkin", "Cinnamon", "Baking powder", "Butter", "Salt")));
                mealList.add(pumpkinCinnamonRoll);
                Meal pumpkinRisotto = new Meal("Pumpkin Risotto", new ArrayList<String>(
                                Arrays.asList("Chicken", "Onion", "Garlic", "Rice", "Salt", "Pumpkin", "Cheese",
                                                "Black pepper")));
                mealList.add(pumpkinRisotto);
                Meal kavurmaliYumurta = new Meal("Kavurmalı Yumurta", new ArrayList<String>(
                                Arrays.asList("Meat", "Egg", "Olive oil", "Salt")));
                mealList.add(kavurmaliYumurta);
                Meal kavurma = new Meal("Kavurma", new ArrayList<String>(
                                Arrays.asList("Meat", "Olive oil", "Tomato", "Green Pepper", "Salt", "Onion",
                                                "Garlic")));
                mealList.add(kavurma);
                Meal manti = new Meal("Mantı", new ArrayList<String>(
                                Arrays.asList("Flour", "Water", "Salt", "Egg", "Meat", "Onion", "Black pepper",
                                                "Butter", "Tomato")));
                mealList.add(manti);
                Meal zeytinyagliyapraksarmasi = new Meal("Zeytinyağlı Yaprak Sarması",
                                new ArrayList<String>(
                                                Arrays.asList("Olive oil", "Onion", "Rice", "Salt", "Sugar", "Water",
                                                                "Vine Leaf")));
                mealList.add(zeytinyagliyapraksarmasi);

                Event birthday = new Event("Birthday");
                birthday.addMeal(pizza);
                birthday.addMeal(birthdayCake);
                eventList.add(birthday);
                Event thanksGiving = new Event("Thanks Giving");
                thanksGiving.addMeal(roastTurkey);
                thanksGiving.addMeal(pumpkinPie);
                eventList.add(thanksGiving);
                Event halloween = new Event("Halloween");
                halloween.addMeal(pumpkinRisotto);
                halloween.addMeal(pumpkinCinnamonRoll);
                eventList.add(halloween);
                Event kurbanBayrami = new Event("Kurban Bayramı");
                kurbanBayrami.addMeal(kavurma);
                kurbanBayrami.addMeal(kavurmaliYumurta);
                eventList.add(kurbanBayrami);
                Event ramazanBayrami = new Event("Ramazan Bayramı");
                ramazanBayrami.addMeal(zeytinyagliyapraksarmasi);
                ramazanBayrami.addMeal(manti);
                eventList.add(ramazanBayrami);

                OptionScreen();
                System.out.println("================================================================================");
                Option1();
                System.out.println("================================================================================");
                Option2();
                System.out.println("================================================================================");
                Option3();
                System.out.println("================================================================================");
                Option4(birthdayCake);
                System.out.println("=========================== Alternate Path =====================================");
                Option4(kavurmaliYumurta);
        }

        public static void OptionScreen() {
                System.out.println(
                                "Please select a option: \n" +
                                                "1) Ingredient Option (Select the ingredients you want to enter) \n" +
                                                "2) Meal Name Option (Enter a meal name to find the recipe) \n" +
                                                "3) Event Meal Option (Select an event and find meals according to that event) \n"
                                                +
                                                "4) Similar Meal Option (Select a meal and find similar meals) \n");
        }

        public static void Option1() {// for test manti selected

                ArrayList<String> tempIngredientList = new ArrayList<String>(
                                Arrays.asList("Flour", "Salt", "Rice"));// users ingredients
                ArrayList<Meal> tempMealList = new ArrayList<>();
                System.out.println(
                                "Ingredient Option selected, please enter the ingredients. \n");

                Ingredient userIngredients = new Ingredient(tempIngredientList); // Ingredients that user has been
                                                                                 // entered
                System.out.println("Entered ingredients are: " + userIngredients.getIngredientList()
                                + "\n\nSearching for meals based on your ingredients...\n");
                tempMealList = MatchIngredient(userIngredients);
                while (tempMealList.isEmpty()) {
                        System.out.println("The application couldn't find a meal based on your ingredients \n" +
                                        "Please enter more ingredients or return back to Option Screen");

                        tempMealList = MatchIngredient(userIngredients);
                }
                for (Meal meal : tempMealList) {
                        System.out.println(meal.getMealName() + "\n");
                }
                System.out.println("Please select a meal\n"
                                + "If you didn't like the meals you can add more ingredients or return to the Option Screen\n");

                System.out.println(
                                tempMealList.get(4).getMealName() + " selected\n");// randomly selected for test

                System.out.println("Selected meal's ingredients:\n" + tempMealList.get(4).getIngredientList());

        }

        public static void Option2() {
                String userMealName = "Kavurma"; // for test kavurma selected
                System.out.println("Meal Name Option selected, please enter a meal name\n");
                System.out.println("Kavurma entered");
                Meal meal = FindMeal(userMealName);
                while (meal == null) {
                        System.out.println(
                                        "The application couldn't find the meal based on the meal name you have entered\n"
                                                        +
                                                        "Please enter another meal name or return to the Option Screen ");
                        meal = FindMeal(userMealName);
                }

                System.out.println("Meal has been found\n" + meal.toString());
        }

        public static void Option3() {
                System.out.println("Event Meal Option selected, please select a event.\n");

                for (Event event : eventList) {
                        System.out.println(event.getEventName() + "\n");
                }

                System.out.println(
                                "If you can't find the event you desired you can return back to the Option Screen\n");

                Event event = FindEvent("Halloween");// for test third event selected
                System.out.println(event.getEventName() + " has been chosen \n");

                for (Meal meal : event.getMealList()) {
                        System.out.println(meal.getMealName());
                }
                System.out.println("\n"
                                + "If you can't find the desired meal you can select another event or return back to Option Screen \n");

                Meal selectedMeal = event.getMealList().get(0);// for test first meal selected
                System.out.println(selectedMeal.getMealName() + " selected\n");
                System.out.println("Ingredients: " + selectedMeal.getIngredientList());
        }

        public static void Option4(Meal userMeal) {
                ArrayList<Meal> tempMealList;
                String userMealName = userMeal.getMealName();// for test birthday cake selected
                System.out.println("Similar Meal Option selected, please enter a meal name\n" + userMealName
                                + " selected \n");

                Meal meal = FindMeal(userMealName);
                tempMealList = SimilarIngredient(meal);
                if (tempMealList.isEmpty()) {
                        System.out.println("The application couldn't find a similar meal based on your meal \n"
                                        + "Please enter another meal name or return back to Option Screen\n");
                        meal = FindMeal(userMealName);// another meal name can be entered
                        tempMealList = SimilarIngredient(meal);
                        return;
                }
                for (Meal tempMeal : tempMealList) {
                        System.out.println(tempMeal.getMealName());
                }

                Meal selectedMeal = tempMealList.get(0); // for test first meal selected
                System.out.println(selectedMeal.getMealName() + " selected");
                System.out.println(selectedMeal.toString());

        }

        public static ArrayList<Meal> SimilarIngredient(Meal meal) {
                ArrayList<Meal> tempMealList = new ArrayList<>();
                Iterator<Meal> mealIt = mealList.iterator();
                ArrayList<String> mealIngredients = meal.getIngredientList();
                ArrayList<String> meal1Ingredients;
                while (mealIt.hasNext()) {
                        Meal meal1 = mealIt.next();
                        if (meal1.getMealName() == meal.getMealName())
                                continue;
                        meal1Ingredients = new ArrayList<>(meal1.getIngredientList());
                        meal1Ingredients.retainAll(mealIngredients);// takes same ingredients
                        if (meal1Ingredients.size() > 3) {
                                tempMealList.add(meal1);
                        }
                }

                return tempMealList;

        }

        public static ArrayList<Meal> MatchIngredient(Ingredient ingredients) {
                ArrayList<Meal> tempMealList = new ArrayList<>();
                Iterator<Meal> mealIt = mealList.iterator();
                ArrayList<String> mealIngredients;
                while (mealIt.hasNext()) {
                        ArrayList<String> userIngredients = new ArrayList<>(ingredients.getIngredientList());
                        Meal meal = mealIt.next();
                        mealIngredients = meal.getIngredientList();
                        userIngredients.retainAll(mealIngredients);// takes same ingredients

                        if (userIngredients.size() > 1) {
                                tempMealList.add(meal);
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

        public static Event FindEvent(String userEventName) {
                Iterator<Event> eventIt = eventList.iterator();
                while (eventIt.hasNext()) {
                        Event event = eventIt.next();
                        if (event.getEventName().equals(userEventName)) {
                                return event;
                        }
                }
                return null;

        }

}
