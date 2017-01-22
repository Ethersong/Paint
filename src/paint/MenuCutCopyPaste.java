package paint;

import paint.shapes.Shape;
/**
 * Allows the sure to cut, copy, and paste shapes.
 * Copy copies the latest drawn shape.
 * Cut copies the latest drawn shape, and removes it from the canvas.
 * Paste puts the copied or cut shape onto the canvas where the user clicks.
 */
public class MenuCutCopyPaste {
	
	private PaintModel model;
	private PaintPanel paintPanel;
	
	public MenuCutCopyPaste(PaintModel model, PaintPanel paintPanel){
		this.model = model;
		this.paintPanel = paintPanel;	
	}
	
	public void cut() throws CloneNotSupportedException{		
		/**
		 * Cuts a shape by cloning it and storing it as a Shape.
		 * The cut shape is removed from the canvas.
		 */
		if(!model.isEmpty()) {		
			Shape s = model.getLast().clone();			
			model.storedShape = s;
			model.remove();
		}	
		paintPanel.repaint();
	}
	
	public void copy() throws CloneNotSupportedException{
		/**
		 * Copies a shape by cloning it and storing it as a Shape.
		 */
		Shape s = model.getLast().clone();			
		model.storedShape = s;	
		paintPanel.repaint();
	}

	public void paste(){
		/**
		 * Puts the stored shape on the canvas where the user
		 * clicks, with the shapes attributes all attached.
		 */
		paintPanel.setMode("Paste");
	}
}
