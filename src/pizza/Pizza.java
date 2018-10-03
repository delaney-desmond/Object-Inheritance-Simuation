/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizza;

import static java.awt.Color.black;
import static java.awt.Color.green;
import java.util.InputMismatchException;

/**
 *
 * @author Delaney
 */
public class Pizza implements PizzaComparable{
    ArrayList<Ingredient> ingredients = new ArrayList<>();
    int calories = 0;
    Money Cost = new Money(0,0);
    Shape shape;
    Fraction fraction = new Fraction(1,1);
    
    /**
     * no-arg constructor that generates a pizza with a random shape, size,
     *      number of ingredients and type of ingredients
     */
    public Pizza(){
        int[] pizzaSize = {8,10,12};//the three sizes that the random number picks from
        
        int randSize = (int) (Math.random()*3); //randSize chooses index of above
        int randShape = (int) (Math.random()*2); //chooses the shape
        int randVegNum = (int) (Math.random()*10)+1; //chooses the number of ingredients
        //i just realized I called this VegNum, but it actually replresents the number of 
            //ingredients in the pizza
        
        if(randShape == 0){ //if the number turned out to be 0, then circle
            shape = new Circle(0,0,pizzaSize[randSize],pizzaSize[randSize],pizzaSize[randSize]/2);
        }else if(randShape == 1){ //if the number turned out to be 1, then square
            shape = new Square(0,0,pizzaSize[randSize],pizzaSize[randSize]);
        }
        //loops through the number of times chosen by randVegNum
        for(int i = 0; i < randVegNum; i++){ //for each iteration, creates an ingredient and adds
                //it to the ArrayList
            int randVeg = (int) (Math.random()*8);
            switch(randVeg){ //this switch is what chooses and creates the Ingredients
                
                case 0: 
                    Money price = new Money(0,50);
                    Mozzarella mozz = new Mozzarella("Mozzarella", price, 200);
                    addIngredient(mozz);
                    break;
                case 1: 
                    price = new Money(0,50);
                    Goat goat = new Goat("Goat", price, 300);
                    addIngredient(goat);
                    break;
                case 2: 
                    price = new Money(0,25);
                    Pepperoni pep = new Pepperoni("Pepperoni", price, 87);
                    addIngredient(pep);
                    break;
                case 3: 
                    price = new Money(0,50);
                    Sausage saus = new Sausage("Sausage", price, 120);
                    addIngredient(saus);
                    break;
                case 4: 
                    price = new Money(1,0);
                    Marinara mari = new Marinara("Marinara", price, 275);
                    addIngredient(mari);
                    break;
                case 5: 
                    price = new Money(2,00);
                    Alfredo alf = new Alfredo("Alfredo", price, 335);
                    addIngredient(alf);
                    break;
                case 6: 
                    price = new Money(0,50);
                    Pepper pepper = new Pepper("Pepper", price, 100, green);
                    addIngredient(pepper);
                    break;
                case 7: 
                    price = new Money(0,50);
                    Olive Olive = new Olive("Olive", price, 85, black);
                    addIngredient(Olive);
                    break;  
            }
        }
    }
    /**
     * Compares this pizza with another pizza to see which has a higher/lower cost
     * @param o the other pizza
     * @return -num if o is bigger, +num is o is smaller, 0 is equal
     */
    @Override
    public int compareTo(Object o) {
        if(o==null || !(o instanceof Pizza)){
            throw new InputMismatchException("Pizza Mismatch Exception");
        }
        
        Pizza that = (Pizza) o;
        return this.Cost.compareTo(that.Cost);
    }
    /**
     * Compares this pizza with another pizza to see which has a higher/lower size
     * @param o the other pizza
     * @return -num if o is bigger, +num is o is smaller, 0 is equal
     */
    @Override
    public int compareToBySize(Object o) {
        if(o==null || !(o instanceof Pizza)){
            throw new InputMismatchException("Pizza Mismatch Exception");
        }
        
        Pizza that = (Pizza) o;
        if(this.shape.getArea() > that.shape.getArea()){
            return (int) (this.shape.getArea()/that.shape.getArea());
        }else if(this.shape.getArea() == that.shape.getArea()){
            return 0;
        }else{
            return (int) (that.shape.getArea()/this.shape.getArea())*-1;
        }
    }
    /**
     * Compares this pizza with another pizza to see which has a higher/lower cals
     * @param o the other pizza
     * @return -num if o is bigger, +num is o is smaller, 0 is equal
     */
    @Override
    public int compareToByCalories(Object o) {
        if(o==null || !(o instanceof Pizza)){
            throw new InputMismatchException("Pizza Mismatch Exception");
        }
        
        Pizza that = (Pizza) o;
        if(this.calories > that.calories){
            return (this.calories/that.calories);
        }else if(this.calories == that.calories){
            return 0;
        }else{
            return (that.calories/this.calories)*-1;
        }
    }
    /**
     * getRemianing returns the fraction inside this instance
     * @return copy of the frac in this instance
     */
    public Fraction getRemaining(){
        Fraction copy = new Fraction(this.fraction.getNumerator(), this.fraction.getDenominator());
        return copy;
    }
    /**
     * setRemaining sets the fraction in this instance
     * @param f the fraction being passed into this instance
     */
    public void setRemaining(Fraction f){
        Fraction copy = new Fraction(f.getNumerator(), f.getDenominator());
        fraction = copy;
    }
    /**
     * getCalories returns the calories in this instance
     * @return the calories in this instance
     */
    public int getCalories(){
        return calories;
    }
    /**
     * getCost returns the cost in this instance
     * @return the cost in this instance
     */
    public Money getCost(){
        Money copy = new Money(Cost.getDollars(), Cost.getCents());
        return copy;
    }
    /**
     * returns the area scaled by the fraction 
     * @return the area remaining
     */
    public double getRemainingArea(){
        double retVal = (double) fraction.getNumerator()/fraction.getDenominator();
        retVal = shape.getArea() * retVal;
        return retVal;
    }
    /**
     * sets the shape of the pizza
     * @param s the shape with will be set
     */
    public void setShape(Shape s){
        shape = (Shape)s.clone();
    }
    /**
     * returns the shape 
     * @return the shape in this instance
     */
    public Shape getShape(){
        return (Shape) shape.clone();
    }
    /**
     * addIngredient adds an ingredient to the ingredients ArrayList
     * @param a the Ingredient being added
     */
    public void addIngredient(Ingredient a){
        ingredients.insert(a, 0);
        calories += a.calories;
        Cost.add(a.cost);
    }
    /**
     * eatSomePizza subtracts the given Fraction from the fraction in the instance
     * @param amt the fraction that will be subtracted
     * @throws PizzaException if the fraction is zero or less
     */
    public void eatSomePizza(Fraction amt) throws PizzaException{
        Fraction retVal;
        
        if(amt.getDenominator() == fraction.getDenominator()){
            retVal = new Fraction(fraction.getNumerator()-amt.getNumerator(), fraction.getDenominator());
        }else{
            int comDen = fraction.getDenominator() * amt.getDenominator(); //gets common denominator
            int comNum = fraction.getNumerator() * amt.getDenominator(); 
            comNum -= amt.getNumerator();
            
            retVal = new Fraction(comNum, comDen); //new fraction after subtracted
        }
        
        if(retVal.getNumerator() == 0 || retVal.getDenominator() == 0){
            throw new PizzaException("ERROR: Empty Pizza");
        }else if(retVal.getNumerator() < 0 || retVal.getDenominator() < 0){
            throw new PizzaException("ERROR: Negative Pizza. You ate too much!");
        }
        
        fraction = retVal;
    }
    /**
     * returns a String representing all the data inside this instance
     * @return a string
     */
    @Override
    public String toString(){
        String retVal = "Pizza has a price: "+Cost+" and calories: "+calories+", Fraction remaining: "+fraction+" and area left: "+getRemainingArea()+" and Shape: "+shape;
        return retVal;
    }
    /**
     * small main for testing
     * @param args 
     */
    public static void main(String[] args){
        Pizza pizza = new Pizza();
        
        System.out.println(pizza.toString());
        System.out.println(pizza.ingredients.toString());
        Fraction amt = new Fraction(1,2);
        try{
            pizza.eatSomePizza(amt);
        }catch(PizzaException e){
            System.out.println(e.getMessage());
        }
        System.out.println(pizza.toString());
        
    }
    
}
