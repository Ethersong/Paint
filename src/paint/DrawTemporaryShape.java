package paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
/**
 * Draws an outline so the user can dynamically the 
 * changes they make.
 */
public class DrawTemporaryShape {
	
	private PaintPanel paintPanel;
	private Graphics2D g2d;
	private TemporaryShape tempShape;
	
	public DrawTemporaryShape(PaintPanel paintPanel, Graphics2D g2d, TemporaryShape tempShape) {
		this.paintPanel = paintPanel;
		this.g2d = g2d;
		this.tempShape = tempShape;	
	}
	
	public void draw(){
		/**
		 * Try to draw the shape that's stored.
		 */
     	g2d.setColor(Color.black);
     	g2d.setStroke(new BasicStroke(2));
     	try {
     		g2d.drawRect(tempShape.getRectangle().getStart().getX(), tempShape.getRectangle().getStart().getY(),
     			tempShape.getRectangle().getWidth(), tempShape.getRectangle().getHeight());
     	} catch (NullPointerException e) { 
     				        	
     	} try {
     		g2d.drawOval(tempShape.getCircle().getStart().getX(), tempShape.getCircle().getStart().getY(),
     			tempShape.getCircle().getRadiusX(), tempShape.getCircle().getRadiusY());
     	} catch (NullPointerException e){
     				      	
     	} try {
     		int [] set1 = new int[] {tempShape.getTriangle().getStart().getX(), 
     			tempShape.getTriangle().getTwo().getX(), tempShape.getTriangle().getThree().getX()};
     		int [] set2 = new int[] {tempShape.getTriangle().getStart().getY(), 
     			tempShape.getTriangle().getTwo().getY(), tempShape.getTriangle().getThree().getY()};
     		g2d.drawPolygon(set1, set2, 3);
     				        	
     	} catch (NullPointerException e) {      		        	
     	}try {		
     		ArrayList<Point> points = tempShape.getSquiggle().getPoints();	
     		g2d.setColor(tempShape.getSquiggle().getColor());
     		g2d.setStroke(new BasicStroke(tempShape.getSquiggle().getThickness()));
     		for(int i = 0; i < points.size() -1; i++){
     			Point p1 = points.get(i);
     			Point p2 = points.get(i+1);			
     			g2d.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());		
     	}			
     	} catch (NullPointerException e) {    					        	
     	}  try {		
     		ArrayList<Point> points = tempShape.getCircleline().getPoints();	
     		g2d.setColor(tempShape.getCircleline().getColor());
     		g2d.setStroke(new BasicStroke(tempShape.getCircleline().getThickness()));
     		for(int i = 0; i < points.size() -1; i++){
     			Point p1 = points.get(i);
    			g2d.drawOval(p1.getX(), p1.getY(), 15, 15);		
     	}	
     	paintPanel.repaint();
     	} catch (NullPointerException e) {    					        	
     	} 
	}
	
	public void dispose() {
		/**
		 * Gets rid of the outline when the user releases
		 * the mouse.
		 */
		tempShape = null;
		paintPanel.repaint();
	}
}
