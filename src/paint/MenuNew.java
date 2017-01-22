package paint;
/**
 * Allows the sure to clear the canvas by pressing
 * File -> New.
 */
public class MenuNew {
	
	public MenuNew(PaintModel model){	
		/**
		 * Clears the canvas by removing every shape.
		 */
		while(!model.isEmpty()){
			model.remove();
		}	
	}
}
