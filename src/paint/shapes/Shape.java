package paint.shapes;

import java.awt.Color;
import java.util.ArrayList;

import paint.Point;
/**
Shape which takes in a starting point with (x,y) coordinates.
A shape has thickness, color, and whether it's filled or not.
*/
public class Shape implements Cloneable{
	
	private Point start;
	private int thickness = 1;
	private Color color;
	private boolean outline = true; // Whether the shape has a filling
	protected String shape = "not set"; // String to pass into factory
	
	public Shape(Point start) {
		/** 
		 * Creates a basic shape with a starting point.
		 * @param start
		 */
		this.start = start;		
	}
	
	public Point getStart() {
		/**
		 * Gets the Point where the shape is drawn.
		 * @return : Point
		 */
		return this.start;
	}

	public void setStart(Point start) {
		/**
		 * Sets the starting coordinates of P as (x,y)
		 * @param Point
		 */
		this.start = start;
	}
	
	public int getThickness(){
		/**
		 * Representation of how thick the shape is.
		 * @return : int 
		 */
		return this.thickness;
	}
	
	public void setThickness(int i) {
		/**
		 * Sets how thick the shape should be.
		 * @param i
		 */
		this.thickness = i;
	}
	
	public void setColor(Color color){
		/**
		 * Sets the color of the shape.
		 * @param Color
		 */
		this.color = color;
	}
	
	public Color getColor(){
		/**
		 * Get what color the shape is.
		 * @return : Color 
		 */
		return this.color;
	}
	
	public void setOutline(boolean b){
		/**
		 * Sets whether the shape needs to be filled.
		 * @param boolean
		 */
		this.outline = b;
	}
	
	public boolean getOutline(){
		/**
		 * Whether the shape is filled or not.
		 * @return : boolean
		 */
		return outline;
	}
	
	public String getShape(){
		/**
		 * Returns a shape with its attributes.
		 * @return : Shape
		 */
		return shape;	
	}
	
	@Override
	public Shape clone() throws CloneNotSupportedException {
		/**
		 * Creates a copy of the shape with the exact same
		 * attributes.
		 * @return : Shape
		 */
        return (Shape) super.clone();
	}
}
