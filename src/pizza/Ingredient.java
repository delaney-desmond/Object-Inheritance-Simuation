/*
 * This program runs in NetBeans IDE version 8.2
 * @author Delaney Desmond
 * Assignment: Pizza Simulator
 * Class: CSS 143
 */
package pizza;

import java.util.InputMismatchException;

/**
 * This class holds all the data for an ingredient
 * @author Delaney
 */
public class Ingredient implements Comparable{
    public final String description;
    public final Money cost;
    public final int calories;
    
    /**
     * Constructor takes a description, a Money Object and an int for calories
     * @param desc the desc of the ingredient
     * @param money the price of ingredient
     * @param cals the cals in said ingredient
     */
    public Ingredient(String desc, Money money, int cals){
        description = desc;
        cost = money;
        calories = cals;
    }
    
    /**
     * toString returns a String desc of the data inside Ingredient
     * @return a String
     */
    @Override
    public String toString(){
        String retVal = description+" The Cost: "+cost+" The Calories: "+calories;
        return retVal;
    }
    
    /**
     * Compares two Ingredients to see if they are equal
     * @param o the other Ingredient being compared
     * @return true if equals, else false
     */
    @Override
    public boolean equals(Object o){
        if(o==null || !(o instanceof Ingredient)){
            return false;
        }
        
        Ingredient that = (Ingredient) o;
        return this.description.equals(that.description) && this.cost.equals(that.cost) && this.calories == that.calories;
       }
    
    /**
     * Compares two Ingredients
     * @param o the other ingredient
     * @return -num if other is bigger, 0 if same, +num is other is smaller
     */
    @Override
    public int compareTo(Object o) {
        if(!(o instanceof Ingredient)){
            throw new InputMismatchException();
        }
        Ingredient that = (Ingredient) o;
        return Double.compare(this.cost.getMoney(), that.cost.getMoney());
    }
    
}
