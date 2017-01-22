package paint.strategy;

import paint.PaintPanel;
/**
 * Sets which strategy should be used, depending
 * on what shape is wanted.
 */
public class ShapeManipulatorContext {
	
	private ShapeManipulatorStrategy strategy; // Each shape has its own strategy
	
	public void setStrategy(ShapeManipulatorStrategy s) {
		/**
		 * Sets the strategy.
		 * @param s: The choosen strategy
		 */
		strategy = null;
		strategy = s;
	}
	
	public void create(PaintPanel paintPanel) {
		/**
		 * Creates the instance of the strategy.
		 */
		strategy.createShape(paintPanel);
	}
	
	public void destroy(){
		/**
		 * Closes the instance of the strategy.
		 */
		strategy.destroy();
	}
}
