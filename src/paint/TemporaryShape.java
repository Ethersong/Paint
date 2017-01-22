package paint;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Observable;

import paint.shapes.Circle;
import paint.shapes.Circleline;
import paint.shapes.Line;
import paint.shapes.Rectangle;
import paint.shapes.Triangle;
/**
 *  Creates a temporary shape so the user can see the outline
 *  of the shape they are drawing.
 */
public class TemporaryShape extends Observable {
	
	private Rectangle r;
	private Circle c;
	private Triangle t;
	private Line l;
	private Circleline cl;
	private Color color;
	private int thickness;
	private ArrayList<Point> lines = new ArrayList<Point>();
	private Point start; // Point where shape began
	private Point end;  // Current position of shape
	
	public TemporaryShape(Point start) {
		/**
		 * Creates the temporary shape with a starting point.
		 */
		this.start = start;
	}
	
	public void drawRectangle() {
		/**
		 * Draws a temporary basic rectangle with thickness
		 * 1 and no color.
		 */
		this.r = null;
		this. r = new Rectangle(start);
		int minX = Math.min(start.getX(), end.getX());
	    int minY = Math.min(start.getY(), end.getY());
	    int maxX = Math.max(start.getX(), end.getX());
	    int maxY = Math.max(start.getY(), end.getY());	
	    this.r.setDimensions(maxY - minY, maxX - minX);
	    Point p = new Point(minX, minY);
	    this.r.setStart(p);		
		this.setChanged();
		this.notifyObservers();	
	}
	
	public void drawCircle() {
		/**
		 * Draws a temporary basic circle with thickness
		 * 1 and no color.
		 */
		this.c= null;
		this.c = new Circle(start);
		int minX = Math.min(start.getX(), end.getX());
	    int minY = Math.min(start.getY(), end.getY());
	    int maxX = Math.max(start.getX(), end.getX());
	    int maxY = Math.max(start.getY(), end.getY());	
	    this.c.setRadiusX(maxX - minX);
		this.c.setRadiusY(maxY - minY);
		Point p = new Point(minX, minY);
		this.c.setStart(p);		
		this.setChanged();
		this.notifyObservers();	
	}
	
	public void drawTriangle() {
		/**
		 * Draws a temporary basic triangle with thickness
		 * 1 and no color.
		 */
		this.t = new Triangle(start);
		Point p2 = new Point(end.getX(), end.getY());
		this.t.setTwo(p2);	
		Point p3 = new Point(Math.abs(start.getX() - end.getX()), Math.abs(start.getY() - end.getY()));	
		this.t.setThree(p3);	
		this.setChanged();
		this.notifyObservers();	

	}
	
	public void drawSquiggle(){
		/**
		 * Draws a temporary squiggle with it's desired
		 * color and thickness.
		 */
		this.l = new Line(start);
		this.l.setPoints(lines);
		this.l.setColor(color);
		this.l.setThickness(thickness);
		this.setChanged();
		this.notifyObservers();	
	}
	
	public void drawCircleline(){
		/**
		 * Draws a temporary circleline with it's desired
		 * color and thickness.
		 */
		this.cl = new Circleline(start);
		this.cl.setPoints(lines);
		this.cl.setColor(color);
		this.cl.setThickness(thickness);
		this.setChanged();
		this.notifyObservers();	
	}
	
	public void addSquiggle(Point p){
		/**
		 * Adds a point to the line.
		 */
		this.lines.add(p);
	}
	
	public void setEnd(Point end) {
		/**
		 * Sets the current point of the shape which changes
		 * as the user moves the cursor.
		 */
		this.end = end;
	}
	
	public void setStyle(Color color, int thickness) {
		/**
		 * Adds color and thickness to the outline.
		 */
		this.color = color;
		this.thickness = thickness;		
	}
		
	public Circle getCircle() {
		/**
		 * Returns the temporary circle.
		 * @return Circle
		 */
		return c;
	}
	
	public Rectangle getRectangle() {
		/**
		 * Returns the temporary rectangle.
		 * @return Rectangle
		 */
		return r;
	}
	
	public Triangle getTriangle() {
		/**
		 * Returns the temporary triangle.
		 * @return Triangle
		 */
		return t;
	}
	
	public Line getSquiggle() {
		/**
		 * Returns the temporary line.
		 * @return Line
		 */
		return l;
	} 
	
	public Circleline getCircleline() {
		/**
		 * Returns the temporary circleline.
		 * @return Circleline
		 */
		return cl;
	} 
}

