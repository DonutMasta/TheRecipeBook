package estu;

import java.util.ArrayList;

public class Meal extends Ingredient {
    private String Meal;

    Meal(String meal, ArrayList<String> ingredients) {
        super(ingredients);
        this.Meal = meal;

    }

    public ArrayList<String> getIngredients() {
        return super.getIngrediantList();
    }

}