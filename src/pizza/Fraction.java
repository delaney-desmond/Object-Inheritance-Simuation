/*
 * This program runs in NetBeans IDE version 8.2
 * @author Delaney Desmond
 * Assignment: Pizza Simulator
 * Class: CSS 143
 */
package pizza;

import java.util.InputMismatchException;

/**
 * Fraction Class holds a Fraction
 * @author Delaney
 */
public class Fraction implements Comparable{
    private final int numerator;
    private final int denominator;
    /**
     * no-arg constructor creates a fraction of 1/1
     */
    public Fraction(){
    numerator = 1;
    denominator = 1;
    }
    /**
     * creates a fraction with n/d, simplified
     * @param n the numerator being passed
     * @param d the denominator being passed
     */
    public Fraction(int n, int d){
       if(d == 0){
           throw new ArithmeticException();
       }else{
           int gcd = gcd(n,d);
           numerator = n/gcd;
           denominator = d/gcd;        
       }
    }
    
    /**
     * gcd finds the greatest common denominator between a num and den
     * @param n the numerator
     * @param d the denominator
     * @return the gcd
     */
    public int gcd(int n, int d){
        int gcd, higher, lower;
            higher = (n > d)?n:d;
            lower = (n < d)?n:d;
            gcd = lower;
            while(higher % lower != 0){
                gcd = higher % lower;
                higher = lower;
                lower = gcd;
            }
        return gcd;   
    }
    
    /**
     * Copy Constructor makes a deep Copy of o
     * @param o the Object being copied
     * @throws PizzaException 
     */
    public Fraction(Object o) throws PizzaException{
        if(o == null ||!(o instanceof Fraction)){
            throw new PizzaException();
        }
        
        Fraction that = (Fraction) o;
        int n = that.getNumerator();
        int d = that.getDenominator();
        numerator = n;
        denominator = d;
    }
    /**
     * getNumerator returns the numerator
     * @return the numerator
     */
    public int getNumerator(){
        return numerator;
    }
    
    /**
     * getDenominator returns the denominator
     * @return the denominator
     */
    public int getDenominator(){
        return denominator;
    }
    
    /**
     * tests to see is two Fractions are equal
     * @param other the other Fraction being tested against
     * @return true if equals, else false
     */
    public boolean equals(Fraction other){
        return numerator == other.getNumerator() && denominator == other.getDenominator();
        
    }
    
    /**
     * toString returns a String representation of the data in Fraction
     * @return "(numerator/denominator)"
     */
    @Override
    public String toString(){
        String returned = "("+numerator+"/"+denominator+")";
        return returned;
    }
    
    /**
     * compareTo compare two Fractions
     * @param o the other Fraction being compared
     * @return -1 if this is smaller than that, 0 if they are equal, 1 if this is bigger than that
     */
    @Override
    public int compareTo(Object o) {
        if(o==null || !(o instanceof Fraction)){
            throw new InputMismatchException("Fraction Mismatch Exception");
        }
        Fraction that = (Fraction) o;
        double frac1 = this.numerator/this.denominator;
        double frac2 = that.numerator/that.denominator;
        
        
        if((frac1) > (frac2)){
            return 1;
        }else if(frac1 == frac2){
            return 0;
        }else{
            return -1;
        }
    }
    
    /**
     * A main used for testing different aspects of Fraction
     * @param args 
     */
    public static void main(String[] args){
        Fraction frac1 = new Fraction(76,11);
        Fraction frac2 = new Fraction(4,22);
        Fraction frac3 = new Fraction(2,11);
        System.out.println(frac1+"  "+frac2);
        
        System.out.println("Compared diffs: "+frac1.compareTo(frac2));
        System.out.println("Compared diffs neg: "+frac2.compareTo(frac1));
        System.out.println("Compared same: "+frac2.compareTo(frac3));
    }
}
