/*
 * This program runs in NetBeans IDE version 8.2
 * @author Delaney Desmond
 * Assignment: Pizza Simulator
 * Class: CSS 143
 */
package pizza;


/**
 * The Base Parent/ChildClass
 * @author Delaney
 */
public class Base extends Ingredient{
    /**
     * passes data to the parent class
     * @param desc the desc of the base
     * @param money the price of the base
     * @param cals the calories in the base
     */
    public Base(String desc, Money money, int cals) {
        super(desc, money, cals);
    } 
}
