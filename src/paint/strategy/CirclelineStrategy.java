package paint.strategy;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import paint.PaintPanel;
import paint.Point;
import paint.TemporaryShape;
import paint.shapes.Circleline;
/**
 * Creates an instance of Circleline and adjusts the attributes
 * as the mouse moves and puts the shape into the model stack.
 */
public class CirclelineStrategy implements ShapeManipulatorStrategy, MouseListener, MouseMotionListener{
	
	private Point start;
	private Circleline cl;
	private PaintPanel paintPanel;
	
	public CirclelineStrategy(PaintPanel paintPanel) {
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
		this.cl = null;
		this.cl = new Circleline(new Point(e.getX(), e.getY()));	
		this.cl.addPoint(new Point(e.getX(), e.getY()));
		this.cl.setThickness(paintPanel.getThickness());
		this.cl.setColor(paintPanel.getColor());
		paintPanel.tempShape = null;
		paintPanel.tempShape = new TemporaryShape(this.start);  
		paintPanel.tempShape.setStyle(paintPanel.getColor(), paintPanel.getThickness());
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {	
		/**
		 * Keeps adding points as the mouse is dragged.
		 */
		try{
			this.cl.addPoint(new Point(e.getX(), e.getY()));
			paintPanel.tempShape.addSquiggle(new Point(e.getX(), e.getY()));
			paintPanel.tempShape.drawCircleline();
			paintPanel.repaint();
		} catch (NullPointerException e2) {		
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		/**
		 * Puts the shape into the stack of shapes and
		 * destroys the temporary outline.
		 */
		paintPanel.append(this.cl);
		paintPanel.tempShape = null;
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
