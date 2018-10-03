/*
 * This program runs in NetBeans IDE version 8.2
 * @author Delaney Desmond
 * Assignment: Pizza Simulator
 * Class: CSS 143
 */
package pizza;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.NoSuchElementException;



/**
 * This class holds all the required methods for the ArrayList-like Structure outlined
 * They are tested in ArrayBasedFataStruturesDriver.java
 * This class also implements the Iterable interface. See bottom of file.
 * @param <T> the type of the obj being inserted into the array
 */
public class ArrayList <T> implements Iterable{
    protected Object[] array;
    protected int size;
    
    /**
     * no-argument constructor initializes an array with 10 cells, and a counter with a size of zero
     */
    public ArrayList(){ 
        array = new Object [10];
        size = 0;
    }
    
    /**
     * Mutator adds the element wherever the user commands, if there is already an Object there, it will be moved to the right, if there is already
     * //an object to the right, that object will be moved to the right and so on. Also doubles array size if needed
     * @param obj represents the object user is inputting
     * @param index represents the index where the object is being inserted
     */
    public void insert(T obj, int index){
        boolean illegal = false; //if the index is illegal, then the accumulator and array[index] will not be changed
        if(index > size || index < 0){ //if the index is out of bounds, inform the user
            System.out.println("Illegal Insertion Index: "+index); //informs the user of the problem
            illegal = true; //now that the booleanis true, the array and accumulator will not be mutated
        }
        else if(size == array.length-1){ //if the array is out of room...
            Object[] copyArray = new Object[(array.length*2)];//a new array will be created with double the room...
            System.arraycopy(array, 0, copyArray, 0, size); //the elements in the original array will be copied into it...
            array = copyArray; //and the array will now reference the copyArray's address instead of hte original array's address
        }
        
        if(!illegal){ //if the index is not illegal...
            for(int i = size; i >= index; i--){ //all other elements in the array will be shifted to the right, 
                array[i+1] = array [i];
            }
            array[index] = obj; //and the Object will be assigned to the index provided
            ++size; //accumulated incremented
        } //assigning
        
    }
    
    /**
     * Mutator removes Obj at the index provided, moves other elements to the left to fill the empty cell, and shrinks array if needed. 
     * @param index the index of the obj being removed
     * @return -1 if not found, else the Object being removed
     */
    public T remove(int index)throws InputMismatchException{
        T returned = null; //initialzed with -1, if it is never changed, it will return this
        boolean illegal = false;//this boolean and some other code here is duplicated above with comments explaining. 
        if(index >= size || index < 0){
            System.out.println("Illegal Removal Index: "+index);
            illegal = true;
        }
        else if(array.length >= (size*4)){ //if the size of the array is 4 times the accumulator...
            Object[] copyArray = new Object[array.length/2]; //then a new array will be made with half the size as before. Same as above, but dividing.
            System.arraycopy(array, 0, copyArray, 0, size);
            array = copyArray;
        }
        
        
        if(!illegal){
            returned = (T) array[index]; //if it isn't illegal, move the other elements left to fill empty cell
            for(int i = index; i <= size-1; i++){
                array[i] = array[i+1];
            }
            --size; //decrement the size of the array
        }
        if(returned == null){
            throw new InputMismatchException();
        }
        return returned;
    }
    
    /**
     * Accessor size returns a copy of the private accumulator to avoid privacy leaks, code is self-explanatory
     * @return a copy of the private accumulator
     */
    public int size(){
        int copy = size;
        return copy;
    }
    
    /**
     * toString overrides the default toString and returns the elements held in array 
     * @return String holding all the elements in order.
     */
    @Override
    public String toString(){
        String returned;
        returned = array[0]+", ";
        for(int i = 1; i < size; i++){
            returned = returned + array[i]+", ";
        }
        return returned;
    }
    
    /**
     * determines if this.array is empty and returns a boolean 
     * @return a boolean stating whether or not the array is empty
     */
    public boolean isEmpty(){
        return size == 0;
    }
    
    /**
     * indexOf searches through the array to try to find the provided Object
     * @param obj the object that is being searched for
     * @return the obj is it is found, else -1
     */
    public int indexOf(Object obj){
        int index = 0;//I used a boolean, and int accumulator and while loop toi search through the array
        int element = -1;
        boolean found = false;
        
        while(!found && index < size){ //if the Object is found, the boolean will be changed to true, ending the loop...
            if(array[index].equals(obj)){
                found = true;
                element = index;//and the index of the Object will be returned
            }
            index++;
        }
        return element;
    }
    
    /**
     * equals compares the arrays in two objects to determine if they are equal
     * @param obj the other object that this.array will be tested against
     * @return a boolean stating whether they are equal or not
     */
    @Override
    public boolean equals(Object obj){
        if(obj == null || !(obj instanceof ArrayList)) return false; //if the other obj is null
        //or not an instance of ArrayList then return false
        ArrayList that = (ArrayList) obj; //assign the other obj to be an Object of ArrayList
        return Arrays.equals(array, that.array); //if the two arrays are equal, return true
        //if they are not equal, return false
    }
    
    /**
     * get returns the Object at a provided index
     * @param index the index of the Object being returned
     * @return  the Object in the index provided
     */
    public T get(int index)throws PizzaException{
        T returned;
        if(index >= size || index < 0){ //if the index is invalid, return -1
            throw new PizzaException("index invalid");
            
        }else{
            returned = (T) array[index]; //else, return the Object held int the cell at index
        }
        
        return returned;
    }
    
    /**
     * Iterator returns a Iterator that can be used in a for each loop
     * @return an Iterator
     */
    @Override
    public Iterator iterator() {
        return new ArrayListIterator(); //returning the iterator
        
    }
    
    /**
     * ArrayListIterator defines the abstract methods within the Iterator class
     */
    private class ArrayListIterator implements Iterator<Object>{
        private int count = 0;
        /**
         * hasNext checks to see if there is another Object to read
         * @return true if there is next, else false
         */
        @Override
        public boolean hasNext() {
            return count < size;
        }
        
        /**
         * next returns the next Object available
         * @return the next Object available
         * @throws NoSuchElementException if there is no Object available
         */
        @Override
        public Object next() throws NoSuchElementException{
            if(this.hasNext()){
                Object tmp = array[count];
                count++;
                return tmp;
            }else{
                throw new NoSuchElementException();
            }
        }
        
        
        
    }
}
