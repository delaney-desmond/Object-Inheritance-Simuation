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
 * This is the circle class that holds the area of the pizza and the shape
 * @author Delaney
 */
public class Circle extends Shape{
    protected int width;
    protected int height;
    protected int radius;
    
    /**
     * This constructor sets everything to the things passed in
     * @param x the x where the shape would be drawn
     * @param y the y where the shape would be drawn
     * @param width the width of the circle
     * @param height the height of the circle
     * @param radius the radius of the circle
     */
    public Circle(int x, int y, int width, int height, int radius){
        super(x,y);
        this.width = width;
        this.height = height;
        this.radius = radius;
        
    }
    
    /**
     * This method returns the area of the circle
     * @return the area of the circle 
     */
    @Override
    public double getArea(){
        return Math.PI * radius * radius;
    }
    
    /**
     * This method would draw the Circle if needed. 
     * @param g used to draw the circle
     */
    @Override
    public void draw(Graphics g) {
	Graphics2D g2d = (Graphics2D) g;
		
	g2d.drawOval(x,y,width,height);
	
    }
    
    /**
     * This method makes a clone of the Circle
     * @return a deep-copy clone of the Circle
     */
    @Override
    public Shape clone() {
        Circle tmp = new Circle(super.x, super.y, width, height, radius);
        return tmp;
    }
    
    /**
     * This method returns "Circle" (because it is a circle)
     * @return 
     */
    @Override
    public String toString(){
        return "Circle";
    }
}
