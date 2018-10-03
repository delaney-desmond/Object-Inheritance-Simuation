/*
 * This program runs in NetBeans IDE version 8.2
 * @author Delaney Desmond
 * Assignment: Pizza Simulator
 * Class: CSS 143
 */
package pizza;

/**
 * PizzaException is the exception that will be thrown in place of runtime errors
 */
public class PizzaException extends Exception{
    /**
     * This PizzaException takes a String as parameter and passes it through the super
     * @param s the String inserted
     */
    public PizzaException(String s){
        super(s);
    }
    /**
     * This PizzaException passes a default String to the super
     */
    public PizzaException(){
        super("Pizza ERROR");
    }
}
