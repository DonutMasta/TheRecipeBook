package estu;

import java.util.ArrayList;

public class Meal extends Ingredient {
    private String mealName;

    Meal(String mealName, ArrayList<String> ingredients) {
        super(ingredients);
        this.mealName = mealName;

    }

    @Override
    public String toString() {
        return "mealName= " + mealName +
                ", ingredients=" + super.getIngredientList() + "\n";
    }

    public String getMealName() {
        return mealName;
    }

}