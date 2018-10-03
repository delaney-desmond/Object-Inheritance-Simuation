/*
 * This program runs in NetBeans IDE version 8.2
 * @author Delaney Desmond
 * Assignment: Pizza Simulator
 * Class: CSS 143
 */
package pizza;

/**
 * Goat Child Class
 * @author Delaney
 */
public class Goat extends Cheese{
    /**
     * Sole constructor passes necessary data to the parent class(s)
     * @param desc the description of the goat cheese
     * @param money the price of the goat cheese
     * @param cals the calories of the goat cheese
     */
    public Goat(String desc, Money money, int cals) {
        super(desc, money, cals);
    }
    
}
