package paint.shapes;

import java.util.ArrayList;

import paint.Point;

public class Circleline extends Shape{
	
	public ArrayList<Point> points = new ArrayList<Point>();

	public Circleline(Point start) {
		super(start);
		super.shape = "Circleline";
	}
	
	public ArrayList<Point> getPoints() {
		/** 
		 * Returns all the points in the line.
		 * @return ArrayList<Point>
		 */
		return this.points;
	}
	
	public void setPoints(ArrayList<Point> points) {
		/**
		 * Creates the line with a set of points.
		 * @param ArrayList<Point> 
		 */
		this.points = null;
		this.points = points;
	}
	
	public void addPoint(Point p) {
		/**
		 * Adds a point to ArrayList of points.
		 * @param Point
		 */
		points.add(p);
	}
}
