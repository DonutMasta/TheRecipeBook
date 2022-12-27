package estu;

import java.util.ArrayList;

public class Ingredient {
    private ArrayList<String> ingredientList = new ArrayList<>();

    Ingredient(ArrayList<String> ingrediants) {

        this.ingredientList = ingrediants;
    }

    public ArrayList<String> getIngredientList() {
        return ingredientList;
    }

}