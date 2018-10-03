/*
 * This program runs in NetBeans IDE version 8.2
 * @author Delaney Desmond
 * Assignment: Pizza Simulator
 * Class: CSS 143
 */
package pizza;

/**
 * Pepperoni Child Class
 * @author Delaney
 */
public class Pepperoni extends Meat{
    /**
     * Sole constructor passes necessary data to the parent class(s)
     * @param desc the description of the pepperoni
     * @param money the price of the pepperoni
     * @param cals the calories of the pepperoni
     */
    public Pepperoni(String desc, Money money, int cals) {
        super(desc, money, cals);
    }
    
}
