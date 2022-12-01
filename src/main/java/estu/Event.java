package estu;
import java.util.ArrayList;

import estu.TheRecipeBook;

public class Event extends TheRecipeBook
{
    private ArrayList<Meal> mealList = new ArrayList<>();
    private String eventName;
    Event(String eventName)
    {
        
        this.eventName =eventName;
    }
    public void addMeal(Meal meal)
    {
        this.mealList.add(meal);
    }
    public String getEventName()
    {
        return this.eventName;
    }
    public void setEventName(String newName)
    {
        this.eventName = newName;
    }

}