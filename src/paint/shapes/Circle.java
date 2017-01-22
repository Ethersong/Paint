package paint.shapes;

import paint.Point;

/**
 * A circle that has all the attributes of shape and 
 * x and y radius.
 */
public class Circle extends Shape{

	private int radiusX, radiusY; // Radius of x and y direction so ovals can be drawn
	
	public Circle(Point start){
		/** Creates a basic Circle with a starting point.
		 * @param start
		 */
		super(start);
		super.shape = "Circle";
	}

	public int getRadiusX() {
		/**
		 *  Gets the radius of X.
		 *  @return : int
		 */
		return radiusX;
	}

	public void setRadiusX(int radiusX) {
		/**
		 * Sets the X radius.
		 * @param radiusX
		 */
		this.radiusX = radiusX;
	}
	
	public int getRadiusY() {
		/**
		 *  Gets the radius of Y.
		 *  @return : int
		 */
		return radiusY;
	}

	public void setRadiusY(int radiusY) {
		/**
		 * Sets the Y radius.
		 * @param radiusY
		 */
		this.radiusY = radiusY;
	}
}
