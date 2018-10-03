/*
 * This program runs in NetBeans IDE version 8.2
 * @author Delaney Desmond
 * Assignment: Pizza Simulator
 * Class: CSS 143
 */
package pizza;
import java.awt.*;
/* Class Shape
 *
 * By Rob Nash
 * 
 * This is the superclass in a hierarchy of shapes that you have to construct
 */

//the superclass in our inheritance hierarchy
//all "common" features, functions and data should go here
//for example, all shapes in Java2D have a x,y that declares their position
//and many of the shapes exposed have a width and a height (but not all, so we didn't put width and height here)
//note that this class is mostly empty, as there is no algorithm generic enough to guess an arbitrary shape's area (future subclasses must override getArea() to provide something reasonable)
//also, the draw method is empty too, as we don't know what shape to draw here! (again, our subclasses will need to replace this method with one that actually draws things)
abstract class Shape extends Object implements Cloneable{
	protected int x = 0;
	protected int y = 0;
	
        /**
         * Constructor sets the position of the shape
         * @param a the x value
         * @param b the y value
         */
	public Shape( int a, int b) {
		x=a;
		y=b;
	}
        
        /**
         * Constructor sets the x of the shape
         * @param r is the x value
         */
        public Shape(int r){
            x=r;
        }
	
        /**
         * Abstract method to be implemented in subclasses
         * @return -1 in this case, the area of shapes in subclasses
         */
	public double getArea(){ return -1; }
	
        /**
         * Abstract method to be implemented in subclasses
         * @param g the Graphics obj
         */
	public void draw( Graphics g ){}
	
        /**
         * getX() returns the x value
         * @return the x value
         */
	public int getX() { return x; }
        /**
         * getY() returns the y value
         * @return the y value
         */
	public int getY() { return y; }
        
        /**
         * sets the x variable
         * @param x the new x value
         */
        public void setX(int x){
            this.x = x;
        }
        
        /**
         * sets the y variable
         * @param y the new y variable
         */
        public void setY(int y){
            this.y = y;
        }
        
        /**
         * makes shallow copy
         * @return a shallow copy
         */
        @Override
        public abstract Shape clone();
}