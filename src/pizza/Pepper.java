/*
 * This program runs in NetBeans IDE version 8.2
 * @author Delaney Desmond
 * Assignment: Pizza Simulator
 * Class: CSS 143
 */
package pizza;

import java.awt.Color;

/**
 * The Pepper child class
 * @author Delaney
 */
public class Pepper extends Vegetable{
    
    /**
     * Sole constructor passes necessary data to the parent class(s)
     * @param desc the description of the pepper
     * @param money the price of the pepper
     * @param cals the calories of the pepper
     * @param color the color of the pepper
     */
    public Pepper(String desc, Money money, int cals, Color color) {
        super(desc, money, cals, color);
    }
    
}
