package paint.command;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.util.ArrayList;

import paint.Point;
import paint.shapes.Circleline;

public class CirclelineCommand implements Command{
	
	private Circleline cl;
	private Graphics2D g2d;

	public CirclelineCommand(Circleline cl, Graphics2D g2d){
		/**
		 * Takes a set of points and a 2D graphic to construct a line on screen.
		 */
		this.cl = cl;
		this.g2d = g2d;
	}

	public void buildGraphic() {
		/**
		 * Draws the graphic on screen.
		 */
		ArrayList<Point> points = cl.getPoints();
		for(int i = 0; i < points.size() -1; i++){
			Point p1 = points.get(i);
			g2d.drawOval(p1.getX(), p1.getY(), 15, 15);
		}		
	}

	public void buildColor() {
		/**
		 * Sets the thickness of the graphic.
		 */
		try {
			g2d.setStroke(new BasicStroke(cl.getThickness()));
		} catch (IndexOutOfBoundsException e) {			
		}				
	}

	public void buildThickness() {
		/**
		 * Sets the color of the graphic.
		 */
		g2d.setColor(cl.getColor());	
	}

	@Override
	public void execute() {
		/**
		 * Executes the building commands.
		 */
		buildColor();			
		buildThickness();
		buildGraphic();		
	}
}
