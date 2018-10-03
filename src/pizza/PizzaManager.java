/*
 * This program runs in NetBeans IDE version 8.2
 * @author Delaney Desmond
 * Assignment: Pizza Simulator
 * Class: CSS 143
 */
package pizza;
import java.util.Scanner;


public class PizzaManager {
    ArrayList<Pizza> pizzas = new ArrayList<>();
    int count = 0;
    /* 
     * The console interface is defined in the start method 
     * You can exit or extend the code below to accomplish all of 
     * the outcomes defined in the homework document
     */
    public void start() {
        char selection='q';
        
        Scanner foo = new Scanner(System.in);
        boolean go = true;
        while(go) {
            displayAllPizzas();
            displayInstructions();
            
            if(foo.hasNext()){
                String s = foo.nextLine();
                selection = s.charAt(0);
            }
            
            /**
             * this switch statement chooses what to do based on the inserted char
             */
            switch(selection) {
                case 'A':    
                case 'a':    System.out.println("Adding a random pizza to the ArrayList<Pizza>.");
                                addRandomPizza(); //adds a random pizza
                                count++;
                                break;
                case 'H':    
                case 'h':    System.out.println("Adding one hundred random pizzas to the ArrayList<Pizza>.");
                                for(int i = 0; i < 99; i++){ //adds 100 random pizza
                                    addRandomPizza();
                                    count++;
                                    System.out.println(i);
                                }
                                break;                    
                case 'E':    
                case 'e':    System.out.println("(E)ating a fraction of a pizza. How much? (a/b)");
                                
                                eatSomePizza(foo); //eats some pizza with the foo scanner
                                break;            
                case 'P':    
                case 'p':     System.out.println("Sorting pizzas by (P)rice");
                                try{ //attempts to sort by price
                                    sortByPrice();
                                }catch(PizzaException e){
                                    System.out.println(e.getMessage());
                                }
                                break;    
                case 'S':    
                case 's':     System.out.println("Sorting pizzas by (S)ize");
                                 try{ //attempts to sort by size
                                      sortBySize();
                                  }catch(PizzaException e){
                                      System.out.println(e.getMessage());
                                  }
                                 break;          
                case 'C':    
                case 'c':      System.out.println("Sorting pizzas by (C)alories");
                                  try{ //attempts to sort by cals
                                      sortByCalories();
                                  }catch(PizzaException e){
                                      System.out.println(e.getMessage());
                                  }
                                  break;
                case 'B':
                case 'b':    System.out.println("(B)inary search over pizzas by calories(int).  Sorting first.  What calorie count are you looking for?");
                                int cals = foo.nextInt(); //takes the next int in console
                                foo.skip("\n");
                                try{
                                    sortByCalories(); //attempts to sort by cals
                                    int index = binarySearchByCalories(cals); //the index returned by the binary search
                                    if(index == -1){
                                        System.out.println("Pizza with "+cals+" calories not found."); //if not found...
                                    }else{
                                        System.out.println(cals+" is at index: "+index); //if found...
                                    }
                                    
                                }catch(PizzaException e){
                                    System.out.println(e.getMessage());
                                }
                                
                                        
                                break;
                case 'Q':
                case 'q':    System.out.println("(Q)uitting!" );
                                go = false; //end loop
                                break;
                default:    System.out.println("Unrecognized input - try again");
            }
            
        }

    }
    
    /**
     * eatSomePizza takes in a Scanner, then creates a Fraction that will be subtracted
     *      from the Fraction held in the pizza at the given index
     * @param keys the Scanner passed in
     * @throws PizzaException 
     */
    private void eatSomePizza(Scanner keys){
        Scanner keyboard = keys;
        String string = keyboard.nextLine(); //takes the next line
        String[] nums = string.split("/"); //splits the string based on the '/'
        int n = Integer.parseInt(nums[0]); //typecasts the num to Integer
        int d = Integer.parseInt(nums[1]);//typecasts the den to Integer
        Fraction frac = new Fraction(n, d); //creating a new Fraction of the nums user inputted
        System.out.println("What index pizza would you like to be (E)aten?");
        int index = keys.nextInt(); //the index of the pizza that will be eaten
        keys.skip("\n");
        Object tmp = null; //initializing outside of the try catch block
        try{
            tmp = pizzas.get(index); //attempting to get the pizza @ index index
        }catch(PizzaException e){
            System.out.println("Error getting the pizza.");
        }
        Pizza thePizza = (Pizza) tmp; //typecastig pizza
        
        try{
            thePizza.eatSomePizza(frac); //attempting to eatSomePizza
        }catch(PizzaException | ArithmeticException e){ //if an exception is caught, remove the pizza
            pizzas.remove(index);
            System.out.println("Removed Pizza at index: "+index);
        }
        
        
        
        
    }
    /**
     * adds a random pizza to the ArrayList
     */
    private void addRandomPizza() {
        Pizza random = new Pizza();
        pizzas.insert(random, count);    
    }
    /**
     * Displays all pizzas 1 by 1
     */
    private void displayAllPizzas() {
        String s = "";
        for(Object tmp : pizzas){
            System.out.println(tmp);
        }
    }
    /**
     * findMinCalories finds the minimum amount of calories in pizzas. 
     * @param array the ArrayList we're searching in
     * @param start the index we will be searching from
     * @param end the index we will be searching to
     * @return the index of the pizza with the minimum calories
     * @throws PizzaException 
     */
    public int findMinCalories(ArrayList<Pizza> array, int start, int end)throws PizzaException{
        int minIndex = start;
        for(int i = start+1; i <= end; i++){
            Pizza tmp1 = (Pizza) array.get(i);
            Pizza tmp2 = (Pizza) array.get(minIndex);
            if(tmp1.getCalories() < tmp2.getCalories()){
                minIndex = i;
            }
        }
        return minIndex;
    }
    /**
     * findMinCalories finds the minimum Cost in pizzas. 
     * @param array the ArrayList we're searching in
     * @param start the index we will be searching from
     * @param end the index we will be searching to
     * @return the index of the pizza with the minimum Cost
     * @throws PizzaException 
     */
    public int findMinPrice(ArrayList<Pizza> array, int start, int end)throws PizzaException{
        int minIndex = start;
        for(int i = start+1; i <= end; i++){
            Pizza tmp1 = (Pizza) array.get(i);
            Pizza tmp2 = (Pizza) array.get(minIndex);
            if(tmp1.getCost().compareTo(tmp2.getCost()) < 0){
                minIndex = i;
            }
        }
        return minIndex;
    }
    /**
     * findMinCalories finds the minimum size in pizzas. 
     * @param array the ArrayList we're searching in
     * @param start the index we will be searching from
     * @param end the index we will be searching to
     * @return the index of the pizza with the minimum size
     * @throws PizzaException 
     */
    public int findMinSize(ArrayList<Pizza> array, int start, int end)throws PizzaException{
        int minIndex = start;
        for(int i = start+1; i <= end; i++){
            Pizza tmp1 = (Pizza) array.get(i);
            Pizza tmp2 = (Pizza) array.get(minIndex);
            if(tmp1.getRemainingArea() < tmp2.getRemainingArea()){
                minIndex = i;
            }
        }
        return minIndex;
    }
    /**
     * swap swaps two elements inside the pizzas ArrayList
     * @param idx1 the first index
     * @param idx2 the second index
     * @throws PizzaException 
     */
    public void swap(int idx1, int idx2)throws PizzaException{
            Pizza tmp = pizzas.get(idx1);
            pizzas.insert(pizzas.get(idx2), idx1);
            pizzas.remove(idx1+1);
            pizzas.insert(tmp, idx2);
            pizzas.remove(idx2+1);
        }
    /**
     * sortByPrice uses findMinPrice and swap to sort pizzas by price
     * @throws PizzaException 
     */
    private void sortByPrice() throws PizzaException{  
        for(int i = 0; i < count-1; i++){
           int minIdx = findMinPrice(pizzas, i, count-1);
           swap(i, minIdx);
        }
    }
    /**
     * sortBySize uses findMinSize and swap to sort pizzas by size
     * @throws PizzaException 
     */
    private void sortBySize() throws PizzaException {
        for(int i = 0; i < count-1; i++){
           int minIdx = findMinSize(pizzas, i, count-1);
           swap(i, minIdx);
        }
    }
    /**
     * sortByCalories uses findMinCalories and swap to sort pizzas by cals
     * @throws PizzaException 
     */
    private void sortByCalories() throws PizzaException{
        int length = count;
        for(int i = 0; i < length-1; i++){
           int minIdx = findMinCalories(pizzas, i, length-1);
           swap(i, minIdx);
        }
    }
    
    /**
     * searches a sorted list to find the element with the required cals
     * @param cals number of cals the pizza must have
     * @return the index of the pizza if found, else -1
     * @throws PizzaException 
     */
    private int binarySearchByCalories(int cals) throws PizzaException{
        int low =0;
        int high = count-1;
        int mid;
        
        while(low <= high){
            mid = (low+high)/2;
            if(pizzas.get(mid).getCalories() == cals){
                return mid;
            }else if(pizzas.get(mid).getCalories() < cals){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }
    
    /*
     * No need to edit functions below this line, unless extending the menu or
     * changing the instructions
     */
    private static final String instructions = "-----------------------\nWelcome to PizzaManager\n-----------------------\n(A)dd a random pizza\nAdd a (H)undred random pizzas\n(E)at a fraction of a pizza\nSort pizzas by (P)rice\nSort pizzas by (S)ize\nSort pizzas by (C)alories\n(B)inary Search pizzas by calories\n(Q)uit\n";

    private void displayInstructions() {
        System.out.println(instructions);    
    }

    /*
     * Notice the one-line main function.
     */
    public static void main(String[] args) {
        new PizzaManager().start();
        
    }
}
