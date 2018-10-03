/*
 * This program runs in NetBeans IDE version 8.2
 * @author Delaney Desmond
 * Assignment: Pizza Simulator
 * Class: CSS 143
 */
package pizza;

/**
 * The Cheese subClass/ParentClass
 * @author Delaney
 */
public class Cheese extends Ingredient{
    /**
     * passes data to the parent calss
     * @param desc the desc of the cheese
     * @param money the price of the cheese
     * @param cals the calories in the cheese
     */
    public Cheese(String desc, Money money, int cals) {
        super(desc, money, cals);
    }
    
    
}
