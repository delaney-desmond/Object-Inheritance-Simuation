/*
 * This program runs in NetBeans IDE version 8.2
 * @author Delaney Desmond
 * Assignment: Pizza Simulator
 * Class: CSS 143
 */
package pizza;

/**
 * the Meat subClass/parentClass
 * @author Delaney
 */
public class Meat extends Ingredient{
    /**
     * passes data to the parent class
     * @param desc the desc of the meat
     * @param money the price of the meat
     * @param cals the calories in the meat
     */
    public Meat(String desc, Money money, int cals) {
        super(desc, money, cals);
    }
    
}
