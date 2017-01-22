package paint.shapes;

import paint.Point;

/**
 * A rectangle that has all the attributes of shape and 
 * has width and height.
 */
public class Rectangle extends Shape{

	private int height;
	private int width;
	
	public Rectangle(Point start){
		/** Creates a basic Rectangle with a starting point.
		 * @param start
		 */
		super(start);
		super.shape = "Rectangle";
	}

	public int getHeight() {
		/**
		 *  Gets the height.
		 *  @return : int
		 */
		return height;
	}
	
	public int getWidth() {
		/**
		 *  Gets the width.
		 *  @return : int
		 */
		return width;
	}
	
	public void setDimensions(int height, int width) {
		/**
		 * Sets the height and width of the rectangle.
		 * @param height
		 * @param width
		 */
		this.height = height;
		this.width = width;
	}	
}
