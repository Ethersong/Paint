package paint;

/**
 * Point that has (x,y) pair representing a position on the grid.
 */
public class Point {
	
	int x, y; // (x,y) coordinates of a point on screen
	
	public Point(int x, int y){
		this.x=x; this.y=y;
	}
	public int getX() {
		/**
		 * Returns X coordinate
		 * @return int
		 */
		return x;
	}

	public void setX(int x) {
		/**
		 * Sets X coordinate to x.
		 * @param x
		 */
		this.x = x;
	}

	public int getY() {
		/**
		 * Returns Y coordinate
		 * @return int
		 */
		return y;
	}

	public void setY(int y) {
		/**
		 * Sets Y coordinate to x.
		 * @param y
		 */
		this.y = y;
	}	
}
