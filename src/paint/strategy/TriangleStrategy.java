package paint.strategy;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import paint.PaintPanel;
import paint.Point;
import paint.TemporaryShape;
import paint.shapes.Triangle;
/**
 * Creates an instance of Triangle and adjusts the attributes
 * as the mouse moves and puts the shape into the model stack.
 */
public class TriangleStrategy implements ShapeManipulatorStrategy, MouseListener, MouseMotionListener{
	
	private Point start;
	private Triangle t;
	private PaintPanel paintPanel;
	
	public TriangleStrategy(PaintPanel paintPanel) {
		/**
		 * Initializes the paint panel for when changes are made.
		 */
		this.paintPanel = paintPanel;		
	}
	
	@Override
	public void createShape(PaintPanel paintPanel) {
		/**
		 * Adds listeners so changes can be made.
		 */
		paintPanel.addMouseListener(this);
		paintPanel.addMouseMotionListener(this);	
	}
	
	public void destroy(){
		/**
		 * Removes the listeners when instance is closed.
		 */
		paintPanel.removeMouseListener(this);
		paintPanel.removeMouseMotionListener(this);		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		/**
		 * Creates a shape on the location that was pressed
		 * and makes an outline.
		 */
		t = null;
		t = new Triangle(new Point(e.getX(), e.getY()));	
		paintPanel.tempShape = null;
		paintPanel.tempShape = new TemporaryShape(new Point(e.getX(), e.getY()));  
	}

	@Override
	public void mouseReleased(MouseEvent e) {	
		/**
		 * Sets the attributes of the shape.
		 * Puts the shape into the stack of shapes and
		 * destroys the temporary outline.
		 */
		try{ 		
			this.t.setThickness(paintPanel.getThickness());
			Point p2 = new Point(e.getX(), e.getY());
			this.t.setTwo(p2);		
			int minX = Math.min(e.getX(), this.t.getStart().getX());
		    int minY = Math.min(e.getY(), this.t.getStart().getY());
		    int maxX = Math.max(e.getX(), this.t.getStart().getX());			    
		    int maxY = Math.max(e.getY(), this.t.getStart().getY());			    			
		    Point p3 = new Point(maxX - minX, maxY - minY);			
			this.t.setThree(p3);		
			this.t.setOutline(paintPanel.getOutline());
			this.t.setColor(paintPanel.getColor());
			paintPanel.append(this.t);
			paintPanel.tempShape = null;			
		} catch (NullPointerException e2) {		
		}	
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		/**
		 * Changes the temporary outline as the current
		 * location changes.
		 */
		try{
			paintPanel.tempShape.setEnd(new Point(e.getX(), e.getY()));
			paintPanel.tempShape.drawTriangle();
			paintPanel.repaint();
		} catch (NullPointerException e2) {			
		}		
	}
		
	/*
	 * Unused mouse methods
	 */

	@Override
	public void mouseMoved(MouseEvent e) {}
	
	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}
	
	@Override
	public void mouseExited(MouseEvent e) {}

}
