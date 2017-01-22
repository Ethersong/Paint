package paint;

import java.util.ArrayList;
import java.util.Observable;

import paint.shapes.Shape;
/**
 * Creates a stack to store all the drawn shapes so that they can
 * be repainted in order of placement.
 * The shape to be cut/copied is stored so the user can paste it back.
 * A list of changes using undo/redo is stored so the changes can easily be undone.
 */	
public class PaintModel extends Observable {
	
	private ArrayList<Shape> shapes = new ArrayList<Shape>(); // ArrayList to store all shapes and lines drawn
	
	public Shape storedShape; // Latest shape to be cut or paste
	protected ArrayList<Shape> undoShapes = new ArrayList<Shape>(); // Shape to use for the undo/redo commands
	
	public void append(Shape s) {
		/**
		 * Adds a shape to storage.
		 * @param s: Shape to add
		 */	
		this.shapes.add(s);
		this.setChanged();
		this.notifyObservers();
	}
	
	public ArrayList<Shape> getShapes() {
		/**
		 * Gets ArrayList of all shapes
		 */	
		return this.shapes;
	}
	
	public boolean isEmpty(){
		/**
		 * Checks if the stack of shapes is empty.
		 */	
		return shapes.isEmpty();
	}
	
	public void remove() {
		/**
		 * Remove the top most shape on the stack.
		 */	
		shapes.remove(shapes.size() - 1);
		this.setChanged();
		this.notifyObservers();
	}
	
	public Shape getLast(){
		/**
		 * Peeks at the top most element on the stack.
		 */	
		return shapes.get(shapes.size() - 1);
	}
	
	public int getSize(){
		/**
		 * Gets the size of the stack.
		 */	
		return shapes.size();
	}
}
