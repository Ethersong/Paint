package paint;

import javax.swing.*;

import paint.command.CircleCommand;
import paint.command.CirclelineCommand;
import paint.command.Command;
import paint.command.CommandControl;
import paint.command.RectangleCommand;
import paint.command.SquiggleCommand;
import paint.command.TriangleCommand;
import paint.factory.ShapeFactory;
import paint.shapes.Circle;
import paint.shapes.Circleline;
import paint.shapes.Line;
import paint.shapes.Rectangle;
import paint.shapes.Shape;
import paint.shapes.Triangle;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class PaintPanel extends JPanel implements Observer {
	
	private static final long serialVersionUID = 1L;
	public PaintModel model; // How shapes are stored
	private View view; // Connects with the screen
	private Color color = Color.WHITE; 
	private int thickness;	
	private boolean outline = true; 
	private SelectorChooserPanel scp;
	private ColorChooser colorChooser;		
	public TemporaryShape tempShape; // Creates outline as shape is drawn
	private CommandControl controller = new CommandControl(); // Directs how to put shapes on the canvas 
	private Command builder; 
	private ShapeFactory factory = new ShapeFactory(this, model); // Responsible for creating Strategies
	private DrawTemporaryShape dts; // Tracks the temporary outline that is drawn
	
	public PaintPanel(PaintModel model, View view, SelectorChooserPanel scp, ColorChooser colorChooser){
		/**
		 * Initializes the main GUI
		 * @param model: Storage of any graphics
		 * @param view: Top level view and controller
		 * @param scp: Panel to choose brush size and fill
		 * @param: colorChooser: Panel to choose color
		 */
		this.setBackground(new Color(126, 182, 255));	
		this.colorChooser = colorChooser;		
		this.scp = scp;	
		setMode("Circle"); 
		this.model = model;
		this.model.addObserver(this);	
		this.view = view;		
	}

	/**
	 *  View aspect of this
	 */
	public void paintComponent(Graphics g) {
		
		/**
		 *  Paints the screen with drawn shapes.
		 */
		
        super.paintComponent(g); //paint background
        Graphics2D g2d = (Graphics2D) g; 	       
        this.dts = new DrawTemporaryShape(this, g2d, tempShape);
             
        
        // Gets changes made from GUI
        thickness = scp.thickness();
        outline = scp.getOutline();
        color = colorChooser.getColor();
        
        // Draw Shapes
     	for(Shape s: this.model.getShapes()){
     		/**
    		*  The builder will draw the shape according to
    		*  the command depending on which shape it is.
    		*/     		
     		builder = null;
            String shape = s.getShape();
            switch (shape) {
                case "Circle":  
                		 builder = new CircleCommand((Circle) s, g2d);
                         break;
                case "Rectangle":  
                		 builder = new RectangleCommand((Rectangle) s, g2d);
                         break;
                case "Triangle": 
                		 builder = new TriangleCommand((Triangle) s, g2d);	
                         break;
                case "Circleline": 
                		 builder = new CirclelineCommand((Circleline) s, g2d);	
                         break;
                default: // Squiggle or Polyline
                		 builder = new SquiggleCommand((Line) s, g2d);	
                         break;
            }
     		controller.createGraphic(builder);			
     	}
     	
     	dts.draw();  // Draws temporary outline

		g2d.dispose();
		
	}

	@Override
	public void update(Observable o, Object arg) {
		this.repaint(); // Schedule a call to paintComponent
	}
	
	/**
	 *  Controller aspect of this
	 */
	
	public void setMode(String mode){	
		/**
		 * Controls which shape is drawn.
		 */
		factory.create(mode); // Creates strategy using factory depending on button pressed
	}

	public void append(Shape s){
		/**
		 * Adds a shape to the stack of shapes.
		 */
		model.append(s);
	}
	
	public void setOutline(boolean b) {
		/**
		 * Sets outline mode when box is checked.
		 */
		this.outline = b;
	}
	
	public Color getColor(){
		/**
		 * Gets current color.
		 * @return Color
		 */
		return this.color;
	}
	
	public int getThickness(){
		/**
		 * Gets current thickness.
		 * @return int
		 */
		return this.thickness;	
	}
	
	public boolean getOutline(){
		/**
		 * Gets current thickness.
		 * @return boolean
		 */
		return this.outline;
	}

}
