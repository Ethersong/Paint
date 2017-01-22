package paint.command;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

import paint.shapes.Rectangle;
/**
 * This class builds Rectangles.
 */
public class RectangleCommand implements Command{
	
	private Rectangle rectangle;
	private Graphics2D g2d;
	private int[] dimensions  = new int[4]; // (x.y) coordinates of points  on the circle
	
	public RectangleCommand(Rectangle rectangle, Graphics2D g2d) {
		/**
		 * Takes a Rectangle and a 2D graphic to construct the rectangle on screen.
		 */
		this.rectangle = rectangle;
		this.g2d = g2d;
		int height = rectangle.getHeight();
		int width = rectangle.getWidth();
		int x = rectangle.getStart().getX();
		int y = rectangle.getStart().getY();
		this.dimensions[0] = x;
		this.dimensions[1] = y;
		this.dimensions[2] = width;
		this.dimensions[3] = height;
	}

	public void buildOutline() {
		/**
		 * Fills the shape if it has a fill.
		 */
		if(rectangle.getOutline() != true) {
			g2d.fillRect(dimensions[0], dimensions[1], dimensions[2], dimensions[3]);		
		}	
	}

	public void buildGraphic() {
		/**
		 * Draws the graphic on screen.
		 */
		g2d.drawRect(dimensions[0], dimensions[1], dimensions[2], dimensions[3]);			
	}

	public void buildColor() {
		/**
		 * Sets the color of the graphic.
		 */
		g2d.setColor(rectangle.getColor());		
	}

	public void buildThickness() {
		/**
		 * Sets the thickness of the graphic.
		 */
		g2d.setStroke(new BasicStroke(rectangle.getThickness()));			
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
