package paint.command;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import paint.Point;
import paint.shapes.Line;
/**
 * This class builds Squiggles.
 */
public class SquiggleCommand implements Command{
	
	private Line line;
	private Graphics2D g2d;

	public SquiggleCommand(Line line, Graphics2D g2d){
		/**
		 * Takes a set of points and a 2D graphic to construct a line on screen.
		 */
		this.line = line;
		this.g2d = g2d;
	}

	public void buildGraphic() {
		/**
		 * Draws the graphic on screen.
		 */
		ArrayList<Point> points = line.getPoints();
		for(int i = 0; i < points.size() -1; i++){
			Point p1 = points.get(i);
			Point p2 = points.get(i+1);
			g2d.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());		
		}		
	}

	public void buildColor() {
		/**
		 * Sets the thickness of the graphic.
		 */
		try {
			g2d.setStroke(new BasicStroke(line.getThickness()));
		} catch (IndexOutOfBoundsException e) {			
		}				
	}

	public void buildThickness() {
		/**
		 * Sets the color of the graphic.
		 */
		g2d.setColor(line.getColor());	
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
