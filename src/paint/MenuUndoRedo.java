package paint;
/**
 * Allows the user to undo or redo the latest change.
 * Undo removes the latest drawn shape.
 * Redo reverses an undo, if there is one.
 */
public class MenuUndoRedo {
	
	private PaintModel model;
	private PaintPanel paintPanel;
	
	public MenuUndoRedo(PaintModel model, PaintPanel paintPanel){
		this.model = model;
		this.paintPanel = paintPanel;	
	}
	
	public void undo(){
		/**
		 * Removes the most recent drawn shape on the canvas
		 * and stores it in a stack.
		 */
		if(!model.isEmpty()){
			model.undoShapes.add(model.getLast());
			model.remove();
		}		
		paintPanel.repaint();
	}
	
	public void redo(){
		/**
		 * Reverses the undo by taking the topmost element on 
		 * the stack on drawing it again.
		 */
		if(!model.undoShapes.isEmpty()){			
			model.append(model.undoShapes.remove(model.undoShapes.size() - 1));
		}		
		paintPanel.repaint();
	}
}
