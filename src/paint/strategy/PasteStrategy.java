package paint.strategy;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import paint.PaintPanel;
import paint.Point;
import paint.shapes.Line;
import paint.shapes.Shape;
/**
 * Copies the cut or copied object and paste them on the
 * canvas on click.
 */
public class PasteStrategy  implements ShapeManipulatorStrategy, MouseListener, MouseMotionListener{
	
	private Point start;
	private PaintPanel paintPanel;
	
	public PasteStrategy(PaintPanel paintPanel) {
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
		 * Places the queued shape onto the location 
		 * that was pressed.
		 */
		Point p = new Point(e.getX(), e.getY());
		Shape s = new Shape(p);    
		
		if(paintPanel.model.storedShape != null) {    				
			try {
				s = null;
				s = paintPanel.model.storedShape.clone();
			} catch (CloneNotSupportedException e1) {
			}  		
			s.setStart(p);          		
			paintPanel.model.append(s);   					    			
		}  
	}
	
	/*
	 * Unused mouse methods
	 */
	
	@Override
	public void mouseDragged(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}	

	@Override
	public void mouseMoved(MouseEvent e) {}
	
	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}
	
	@Override
	public void mouseExited(MouseEvent e) {}
	
}
