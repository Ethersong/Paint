package paint.shapes;

import java.util.ArrayList;

import paint.Point;
/**
 * A polyline is made of many (x,y) points that connect.
 */
public class Polyline extends Shape{
	
	private ArrayList<Point> points = new ArrayList<Point>();

	public Polyline(Point start) {
		/**
		 * Initializes the line.
		 */
		super(start);	
	}
	
	public void setPoints(ArrayList<Point> points) {
		/**
		 * Creates the line with a set of points.
		 * @param ArrayList<Point> 
		 */
		this.points = points;
	}
	
	public ArrayList<Point> getPoints() {
		/** 
		 * Returns all the points in the line.
		 * @return ArrayList<Point>
		 */
		return this.points;
	}	
	
	public void addPoint(Point p) {
		/**
		 * Adds a point to ArrayList of points.
		 * @param Point
		 */
		points.add(p);
	}
}
