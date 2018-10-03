/*
 * This program runs in NetBeans IDE version 8.2
 * @author Delaney Desmond
 * Assignment: Pizza Simulator
 * Class: CSS 143
 */
package pizza;

/**
 * Sausage Child Class
 * @author Delaney
 */
public class Sausage extends Meat{
    /**
     * Sole constructor passes necessary data to the parent class(s)
     * @param desc the description of the sausage
     * @param money the price of the sausage
     * @param cals the calories of the sausage
     */
    public Sausage(String desc, Money money, int cals) {
        super(desc, money, cals);
    }
    
}
