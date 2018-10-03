/*
 * This program runs in NetBeans IDE version 8.2
 * @author Delaney Desmond
 * Assignment: Pizza Simulator
 * Class: CSS 143
 */
package pizza;

import java.io.Serializable;
import java.util.InputMismatchException;


/**
 *class Money is an object that holds a number of dollars and a number of cents. 
 * 
 */
public class Money implements Comparable, Cloneable, Serializable{
    private int dol;
    private int cent;
    
    /**
     * Constructor Money takes one integer as a formal argument and creates a 
     *      new instance of the Money Object
     * @param dol is the dollar amount of the new Money obj
     */
    public Money(int dol){
        this.dol = dol;
        cent = 0; //cent is equal to zero because cent must be initialized even 
                    //though the program wasn't given a value for cent
    }
    
    /**
     * Constructor Money takes two ints, and creates an instance of Money obj 
     *      with dollars and cents
     * @param dol the value for this.dol
     * @param cent  the value for this.cent
     */
    public Money(int dol, int cent){
        if(cent > 99){ //if cent is more than 100, Money finds how many dollars are 
            //in the cents. 
            int tmp = (Math.floorDiv(cent, 100));
            cent -= (tmp*100); //extra cents are removed from cent
            dol += tmp; //and the dollars are added to dollar
            this.dol = dol; //then the values are set to the vars beloning to this
            this.cent = cent;
        }else{ //if the cents aren't > 99, just set the vars
            this.dol = dol;
            this.cent = cent;
        }
    }
    
    /**
     * Money copy constructor copies vars from another object.
     * @param other the other Money obj
     */
    public Money(Money other){
        this.dol = other.dol;
        this.cent = other.cent;
    }
    
    /**
     * getDollars Accessor
     * @return a copy of the dol var to avoid privacy leaks
     */
    public int getDollars(){
        int copy = dol;
        return copy;
    }
    
    /**
     * getCents Accessor
     * @return a copy of the cent var to avoid privacy leaks
     */
    public int getCents(){
        int copy = cent;
        return cent;
    }
    
    /**
     * SetMoney Mutator sets the vars in this obj to be that of two inputted ints
     * @param dollars the amount of dollars
     * @param cents the amount of cents, which must be under 99, or it will be
     *      divided up and added to dollars
     */
    public void setMoney(int dollars, int cents){
        if(cents > 99){ //this block is the same as the int,int constructor
            int tmp = (Math.floorDiv(cent, 100));
            cent -= (tmp*100);
            dollars += tmp;
            this.dol = dollars;
            this.cent = cents;
        }else{
            this.dol = dollars;
            this.cent = cents;
        }
    }
    
    /**
     * getMoney returns the two variables as a complete price/bill i.e. if dol==5 
     *      && cent==23, getMoney will return 5.23
     * @return 
     */
    public double getMoney(){
        double cents = cent*.01;
        double total = dol + cents;
        return total;
    }
    
    /**
     * Simple mutator that adds to dol
     * @param dollars the amount being added to dol
     */
    public void add(int dollars){
        dol += dollars;
    }
    
    /**
     * More complicated mutator, adds dollars and cents to dol and cent. If 
     *      cents > 99, some will be converted to dollars
     * @param dollars
     * @param cents 
     */
    public void add(int dollars, int cents){
        if(cents > 99){
            int tmp = (Math.floorDiv(cent, 100));
            cent -= (tmp*100);
            dollars += tmp;
            this.dol += dollars;
            this.cent += cents;
            if(this.cent>99){ //once we add the cents to the number already held 
                    //by cent, we check again to ensure the value isn't over 99.
                int tmp2 = (Math.floorDiv(cent, 100));
                cent -= (tmp2*100);
                this.dol+=tmp2;
            }
        }else{ //even if the inputted cents isn't over 99, we still check cent 
                //after they are added
            this.dol += dollars;
            this.cent += cents;
            if(this.cent>99){
                int tmp2 = (Math.floorDiv(cent, 100));
                cent -= (tmp2*100);
                this.dol+=tmp2;
            }
        }
    }
    
    /**
     * Mutator add takes another Money obj as FA and adds the values of other's 
     *      values to the values of this instance's variables. 
     * @param other 
     */
    public void add(Money other){
        this.dol += other.dol;
            this.cent += other.cent;
            if(this.cent>99){ //if cent is over 99 when added, convert some to dollars
                int tmp2 = (Math.floorDiv(cent, 100));
                this.dol+=tmp2;
                this.cent-=(tmp2*100);
            }
    }
    
    /**
     * Equals checks to see if two (Money) objects are equal
     * @param other the other Obj
     * @return true if they are equal, else false
     */
    @Override
    public boolean equals(Object other){
        if(other == null || !(other instanceof Money)) return false;
        Money that = (Money) other;
        return this.dol == that.dol && this.cent == that.cent;
    }
    
    /**
     * toString returns the num as a String. I used String.format / printf method
     *      to force two sig figs after decimal point.
     * @return 
     */
    @Override
    public String toString(){
        String retString = String.format("$%.2f", getMoney());
        return retString;
    }
    /**
     * compareTo compares this instance with o and determines whether is comes
     *      before, after or is equal to o
     * @param o the other instance of Money this is being compared with
     * @return -1 if o comes before, 0 is they are the same, 1 if o comes after
     */
    @Override
    public int compareTo(Object o){
        if(!(o instanceof Money)){
            throw new InputMismatchException();
        }
        Money that = (Money) o;
        return Double.compare(this.getMoney(), that.getMoney());
    }
    /**
     * clone returns a deep copy of this instance
     * @return a deep copy of this instance
     * @throws CloneNotSupportedException if the class doesn't implement Cloneable
     */
    @Override
    public Money clone() throws CloneNotSupportedException{
        Object tmp = super.clone(); //calling super method of clone,
        Money retVal = (Money) tmp; //typecasting the copy
        return retVal; //return typecasted copy
    }
}
