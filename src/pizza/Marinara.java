/*
 * This program runs in NetBeans IDE version 8.2
 * @author Delaney Desmond
 * Assignment: Pizza Simulator
 * Class: CSS 143
 */
package pizza;

/**
 * Marinara Child Class
 * @author Delaney
 */
public class Marinara extends Base{
    /**
     * Sole constructor passes necessary data to the parent class(s)
     * @param desc the description of the marinara
     * @param money the price of the marinara
     * @param cals the calories of the marinara
     */
    public Marinara(String desc, Money money, int cals) {
        super(desc, money, cals);
    }
    
}
