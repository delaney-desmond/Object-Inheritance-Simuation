/*
 * This program runs in NetBeans IDE version 8.2
 * @author Delaney Desmond
 * Assignment: Pizza Simulator
 * Class: CSS 143
 */
package pizza;

/**
 * Mozzarella Child Class
 * @author Delaney
 */
public class Mozzarella extends Cheese{
    /**
     * Sole constructor passes necessary data to the parent class(s)
     * @param desc the description of the mozzarella
     * @param money the price of the mozzarella
     * @param cals the calories of the mozzarella
     */
    public Mozzarella(String desc, Money money, int cals) {
        super(desc, money, cals);
    }
    
}
