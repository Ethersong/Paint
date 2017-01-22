package paint.command;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

import paint.Point;
import paint.shapes.Triangle;
/**
 * This class builds Triangles.
 */
public class TriangleCommand implements Command{
	
	private Triangle triangle;
	private Graphics2D g2d;
	int[] set1; // Set of x points of each corner
	int[] set2; // Set of y points of each corner
	
	public TriangleCommand(Triangle triangle, Graphics2D g2d) {
		/**
		 * Takes a triangle and a 2D graphic to construct the triangle on screen.
		 */
		this.triangle = triangle;
		this.g2d = g2d;
		Point p1 = triangle.getStart();
		Point p2 = triangle.getTwo();
		Point p3 = triangle.getThree();	
		set1 = new int[] {p1.getX(), p2.getX(), p3.getX()};
		set2 = new int[] {p1.getY(), p2.getY(), p3.getY()};
	}

	public void buildOutline() {
		/**
		 * Fills the shape if it has a fill.
		 */
		if(triangle.getOutline() != true) {		
			g2d.fillPolygon(set1, set2, 3);				
		}			
	}

	public void buildGraphic() {
		/**
		 * Draws the graphic on screen.
		 */
		g2d.drawPolygon(set1, set2, 3);		
	}

	public void buildColor() {
		/**
		 * Sets the color of the graphic.
		 */
		g2d.setColor(triangle.getColor());	
	}

	public void buildThickness() {
		/**
		 * Sets the thickness of the graphic.
		 */
		g2d.setStroke(new BasicStroke(triangle.getThickness()));		
	}

	public void execute() {
		/**
		 * Executes the building commands.
		 */
		buildColor();			
		buildThickness();
		buildOutline();		
		buildGraphic();	
	}
}
