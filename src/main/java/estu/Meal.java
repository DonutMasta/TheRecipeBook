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
        return "Meal{" +
                "mealName= " + mealName +
                ", ingredients=" + super.getIngrediantList() +
                '}';
    }


    public String getMealName() {
        return mealName;
    }

}