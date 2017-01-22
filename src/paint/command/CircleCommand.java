package paint.command;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import paint.shapes.Circle;
/**
 * This class builds Circles.
 */
public class CircleCommand implements Command{
	
	private Circle circle;
	private Graphics2D g2d; // Graphic that will be put on screen
	private int[] dimensions = new int[4]; // (x.y) coordinates of points  on the circle
	
	public CircleCommand(Circle circle, Graphics2D g2d) {
		/**
		 * Takes a circle and a 2D graphic to construct the circle on screen.
		 */
		this.circle = circle;
		this.g2d = g2d;
		int x = circle.getStart().getX();
		int y = circle.getStart().getY();
		int radiusX = circle.getRadiusX();
		int radiusY = circle.getRadiusY();
		this.dimensions[0] = x;
		this.dimensions[1] = y;
		this.dimensions[2] = radiusX;
		this.dimensions[3] = radiusY;
	}

	public void buildGraphic() {
		/**
		 * Draws the graphic on screen.
		 */
		g2d.drawOval(dimensions[0], dimensions[1], dimensions[2], dimensions[3]);	
	}

	public void buildColor() {
		/**
		 * Sets the color of the graphic.
		 */
		g2d.setColor(circle.getColor());		
	}

	public void buildThickness() {
		/**
		 * Sets the thickness of the graphic.
		 */
		g2d.setStroke(new BasicStroke(circle.getThickness()));		
	}

	public void buildOutline() {
		/**
		 * Fills the shape if it has a fill.
		 */
		if(circle.getOutline() != true) {
			g2d.fillOval(dimensions[0], dimensions[1], dimensions[2], dimensions[3]);		
		}
	}

	@Override
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
