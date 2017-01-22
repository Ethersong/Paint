package paint.shapes;

import paint.Point;

/**
 * A triangle that has all the attributes of shape and 
 * has 2 other points to make 3 corners.
 */
public class Triangle extends Shape{
	
	private Point two;
	private Point three;

	public Triangle(Point one){
		/** Creates a basic Triangle with a starting point.
		 * @param start
		 */
		super(one);
		super.shape = "Triangle";
	}
		
	public void setTwo(Point p){
		/**
		 *  Sets corner 2 of the triangle.
		 *  @param Point
		 */
		this.two = p;
	}
	
	public Point getTwo(){
		/**
		 *  Gets Point 2, a corner of the triangle.
		 *  @return : int
		 */
		return this.two;
	}
	
	public void setThree(Point p){
		/**
		 *  Sets corner  of the triangle.
		 *  @param Point
		 */	
		this.three = p;
	}
	
	public Point getThree(){
		/**
		 *  Gets Point 3, a corner of the triangle.
		 *  @return : int
		 */
		return this.three;
	}
}
