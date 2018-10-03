/*
 * This program runs in NetBeans IDE version 8.2
 * @author Delaney Desmond
 * Assignment: Pizza Simulator
 * Class: CSS 143
 */
package pizza;
import java.awt.Color;
import static java.awt.Color.green;
/**
 * The Vegetable parent/child class
 * @author Delaney
 */
public class Vegetable extends Ingredient{
    private Color veggieColor;
    
    /**
     * Vegetable constructor takes data, passes a number through to Parent Class
     * @param desc the desc of the veggie
     * @param money the price of the veggie
     * @param cals the calories of the veggie
     * @param color  the color of the veggie
     */
    public Vegetable(String desc, Money money, int cals, Color color) {
        super(desc, money, cals);
        veggieColor = color;
    }
    
    /**
     * This constructor does not have the extra color parameter, and sets a default color
     * @param desc the desc of the veggie
     * @param money the price of the veggie
     * @param cals  the calories of the veggie
     */
    public Vegetable(String desc, Money money, int cals){
        super(desc, money, cals);
        veggieColor = green;
    }
    
    /**
     * retuns the color
     * @return the color of the veggie
     */
    public Color getColor(){
        return veggieColor;
    }
    
    /**
     * sets the color of the veggie
     * @param color the new color
     */
    public void setColor(Color color){
        veggieColor = color;
    }
    
    /**
     * returns a String representing the data in Vegetable
     * @return a String
     */
    @Override
    public String toString(){
        return super.toString()+" Color: "+veggieColor;
    }
    
    /**
     * checks to see if two Veggies are equal to one another
     * @param o the other veggie
     * @return true is equal, else false
     */
    @Override
    public boolean equals(Object o){
        if(o == null ||!(o instanceof Vegetable)){
            return false;
        } 
        
        return super.equals(o);
    }
    
    
    
}
