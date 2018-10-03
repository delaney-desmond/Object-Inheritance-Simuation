/*
 * This file runs in NetBeans 8.2
 * Class: CSSSKL143
 * Assignment: Lab5
 * Delaney Desmond
 */
package pizza;

import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * This method holds the information incase the pizza is a square
 * @author Delaney
 */
public class Square extends Shape{
    protected int width;
    protected int height;
    
    /**
     * This constructor sets the square up
     * @param x the x where the square would be drawn
     * @param y the y where the square would be drawn
     * @param width the width of the square
     * @param height the height of the square
     */
    public Square(int x, int y, int width, int height){
        super(x,y);
        this.width = width;
        this.height = height;
        
    }
    
    /**
     * getArea calculates the area and returns it
     * @return the area of the square
     */
    @Override
    public double getArea(){
        return width * height;
    }
    
    /**
     * draw draws a square
     * @param g used to draw the square
     */
    @Override
    public void draw(Graphics g) {
	Graphics2D g2d = (Graphics2D) g;
		
	g2d.drawRect(x,y,width,height);
	
    }
    
    /**
     * clone makes and returns a deep copy of the instance of this square
     * @return a deep copy of the square
     */
    @Override
    public Shape clone() {
        Square tmp = new Square(super.x, super.y, width, height);
        return tmp;
    }
    
    /**
     * toString returns "Square" because it is a square
     * @return "Square"
     */
    @Override
    public String toString(){
        return "Square";
    }
}
