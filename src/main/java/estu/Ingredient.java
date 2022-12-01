package estu;

import java.util.ArrayList;

public class Ingredient  {
    private ArrayList<String> ingrediantList = new ArrayList<>();

    Ingredient(ArrayList<String> ingrediants) {
    
        this.ingrediantList= ingrediants;
    }

    public ArrayList<String> getIngrediantList() {
        return ingrediantList;
    }

    
    
}