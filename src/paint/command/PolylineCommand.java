package paint.command;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import paint.Point;
import paint.shapes.Polyline;
/**
 * This class builds Polylines.
 */
public class PolylineCommand implements Command{
		
	private Graphics2D g2d;
	private Polyline polyline;
	
	public PolylineCommand(Polyline polyline, Graphics2D g2d) {
		/**
		 * Takes a set of points and a 2D graphic to construct a polyline on screen.
		 */
		this.g2d = g2d;
		this.polyline = polyline;
	}

	public void buildGraphic() {
		/**
		 * Draws the graphic on screen.
		 */
		ArrayList<Point> points = polyline.getPoints();
		for(int i = 0; i < points.size() -1; i++){
			Point p1 = points.get(i);
			Point p2 = points.get(i+1);
			g2d.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());		
		}			
	}

	public void buildColor() {
		/**
		 * Sets the color of the graphic.
		 */
		g2d.setColor(polyline.getColor());		
	}

	public void buildThickness() {
		/**
		 * Sets the thickness of the graphic.
		 */
		g2d.setStroke(new BasicStroke(polyline.getThickness()));		
	}

	public void execute() {
		/**
		 * Executes the building commands.
		 */
		buildColor();			
		buildThickness();
		buildGraphic();		
	}
}
