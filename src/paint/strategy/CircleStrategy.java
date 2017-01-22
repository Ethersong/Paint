package paint.strategy;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import paint.PaintPanel;
import paint.Point;
import paint.TemporaryShape;
import paint.shapes.Circle;
/**
 * Creates an instance of Circle and adjusts the attributes
 * as the mouse moves and puts the shape into the model stack.
 */
public class CircleStrategy implements ShapeManipulatorStrategy, MouseListener, MouseMotionListener{
	
	private PaintPanel paintPanel;
	private Point start;
	private Circle c;
	
	public CircleStrategy(PaintPanel paintPanel) {
		/**
		 * Initializes the paint panel for when changes are made.
		 */
		this.paintPanel = paintPanel;	
	}
	
	public void createShape(PaintPanel paintPanel) {	
		/**
		 * Adds listeners so changes can be made.
		 */
		this.paintPanel.addMouseListener(this);
		this.paintPanel.addMouseMotionListener(this);		
	}
	
	public void destroy(){
		/**
		 * Removes the listeners when instance is closed.
		 */
		this.paintPanel.removeMouseListener(this);
		this.paintPanel.removeMouseMotionListener(this);	
	}


	@Override
	public void mousePressed(MouseEvent e) {
		/**
		 * Creates a shape on the location that was pressed
		 * and makes an outline.
		 */
		c = null;
		c = new Circle(new Point(e.getX(), e.getY()));	
		paintPanel.tempShape = null;
		paintPanel.tempShape = new TemporaryShape(new Point(e.getX(), e.getY()));    
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		/**
		 * Changes the temporary outline as the current
		 * location changes.
		 */
		try{
			paintPanel.tempShape.setEnd(new Point(e.getX(), e.getY()));
			paintPanel.tempShape.drawCircle();
			paintPanel.repaint();
		} catch (NullPointerException e2) {			
		}		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		/**
		 * Sets the attributes of the shape.
		 * Puts the shape into the stack of shapes and
		 * destroys the temporary outline.
		 */
		try{			
			int minX = Math.min(e.getX(), this.c.getStart().getX());
		    int minY = Math.min(e.getY(), this.c.getStart().getY());
		    int maxX = Math.max(e.getX(), this.c.getStart().getX());
		    int maxY = Math.max(e.getY(), this.c.getStart().getY());	
		    this.c.setRadiusX(maxX - minX);
			this.c.setRadiusY(maxY - minY);
			this.c.setStart(new Point(minX, minY));	
			this.c.setColor(paintPanel.getColor());
			this.c.setThickness(paintPanel.getThickness());
			this.c.setOutline(paintPanel.getOutline());
			paintPanel.append(this.c);
			c = null;
			paintPanel.tempShape = null;		
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
