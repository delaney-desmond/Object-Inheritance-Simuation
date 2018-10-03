/*
 * This program runs in NetBeans IDE version 8.2
 * @author Delaney Desmond
 * Assignment: Pizza Simulator
 * Class: CSS 143
 */
package pizza;

import java.awt.Color;

/**
 * The Olive Child Class
 * @author Delaney
 */
public class Olive extends Vegetable{
    /**
     * Sole constructor passes necessary data to the parent class(s)
     * @param desc the description of the olive
     * @param money the price of the olive
     * @param cals the calories of the olive
     * @param color the color of the olive
     */
    public Olive(String desc, Money money, int cals, Color color) {
        super(desc, money, cals, color);
    }
    
}
