package paint.factory;

import paint.PaintModel;
import paint.PaintPanel;
import paint.strategy.CircleStrategy;
import paint.strategy.CirclelineStrategy;
import paint.strategy.PasteStrategy;
import paint.strategy.PolylineStrategy;
import paint.strategy.RectangleStrategy;
import paint.strategy.ShapeManipulatorContext;
import paint.strategy.ShapeManipulatorStrategy;
import paint.strategy.SquiggleStrategy;
import paint.strategy.TriangleStrategy;

/**
 * ShapeFactory creates either a Circle, Rectangle, Triangle, line
 * or polyline depending on the String passed in. Any additional attributes 
 * the shapes have are set. Finally, the shape is put away in PaintModel 
 * for later use.
 */
public class ShapeFactory {
	
	private ShapeManipulatorStrategy sms;
	private PaintPanel paintPanel;
	private PaintModel model;
	private ShapeManipulatorContext context;
	
	public ShapeFactory(PaintPanel paintPanel, PaintModel model) {	
		/**
		 * Connects ShapeFactory to the panel and model.
		 */
		this.paintPanel = paintPanel;
		this.model = model;
	}
	
	public void create(String shape) {
		/**
		 * Creates an instance of a shape depending on what 
		 * string was passed through.
		 */
		try {
			context.destroy();
		} catch (NullPointerException e){			
		}
		
		context = null;
		context = new ShapeManipulatorContext();
		
		if(shape == "Circle") {

			context.setStrategy(new CircleStrategy(paintPanel));
			context.create(paintPanel);
			
		} else if(shape == "Rectangle") {
			
			context.setStrategy(new RectangleStrategy(paintPanel));
			context.create(paintPanel);
			
		} else if(shape == "Triangle") {
			
			context.setStrategy(new TriangleStrategy(paintPanel));
			context.create(paintPanel);
			
		} else if(shape == "Squiggle") {
			
			context.setStrategy(new SquiggleStrategy(paintPanel));
			context.create(paintPanel);
			
		} else if(shape == "Circleline") {
			
			context.setStrategy(new CirclelineStrategy(paintPanel));
			context.create(paintPanel);
			
		} else if(shape == "Polyline") {
			
			context.setStrategy(new PolylineStrategy(paintPanel));
			context.create(paintPanel);
			
		} else if(shape == "Paste") {
			
			context.setStrategy(new PasteStrategy(paintPanel));
			context.create(paintPanel);
			
		}			
	}
}
