package paint.strategy;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import paint.PaintPanel;
import paint.Point;
import paint.shapes.Line;
/**
 * Creates an instance of Polyline and adjusts the attributes
 * as the mouse moves and puts the shape into the model stack.
 */
public class PolylineStrategy implements ShapeManipulatorStrategy, MouseListener, MouseMotionListener{
	
	private Point start;
	private Line l;
	private PaintPanel paintPanel;
	
	public PolylineStrategy(PaintPanel paintPanel) {
		/**
		 * Initializes the paint panel for when changes are made.
		 */
		this.paintPanel = paintPanel;		
	}
	
	@Override
	public void createShape(PaintPanel paintPanel) {
		/**
		 * Adds listeners so changes can be made. Sets
		 * fields of the line.
		 */
		this.l = new Line(new Point(0,0));	
		this.l.setThickness(paintPanel.getThickness());
		this.l.setColor(paintPanel.getColor());
		paintPanel.addMouseListener(this);
		paintPanel.addMouseMotionListener(this);	
	}
	
	@Override
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
		 * Adds a point to the list of points.
		 */
		this.l.addPoint(new Point(e.getX(), e.getY()));			
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		/**
		 * Puts the shape into the stack of shapes and
		 * destroys the temporary outline.
		 */
		paintPanel.append(this.l);
		paintPanel.tempShape = null;
	}
	
	/*
	 * Unused mouse methods
	 */
		
	@Override
	public void mouseDragged(MouseEvent e) {}
	
	@Override
	public void mouseMoved(MouseEvent e) {}
	
	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}
	
	@Override
	public void mouseExited(MouseEvent e) {}

}
