package paint.strategy;

import paint.PaintPanel;
/**
 * Interface for creating shapes and putting them
 * into the model.
 */
public interface ShapeManipulatorStrategy {
	
	void createShape(PaintPanel paintPanel);
	
	void destroy();

}
