package paint;


import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.*;

/**
 * Top level view and controller.
 */
public class View extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;	
	private PaintModel model;
	
	// The components that make this up
	private PaintPanel paintPanel;
	private ShapeChooserPanel shapeChooserPanel;
	private SelectorChooserPanel selectorChooserPanel;
	private ColorChooser colorPanel;
	private MenuCutCopyPaste ccp;
	private MenuUndoRedo undoRedo;
	
	public View(PaintModel model) {
		super("Paint"); // set the title and do other JFrame init
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setJMenuBar(createMenuBar());
		this.model=model;
		
		Container c = this.getContentPane();
		this.shapeChooserPanel = new ShapeChooserPanel(this);
		this.selectorChooserPanel = new SelectorChooserPanel(this);
		this.colorPanel = new ColorChooser (this);
	
		// Adds additional panels to frame
		JPanel gridPanel = new JPanel(new GridLayout(0,2));
		c.add(gridPanel,BorderLayout.WEST);
		gridPanel.add(this.shapeChooserPanel);
		gridPanel.add(this.selectorChooserPanel);	
		this.paintPanel = new PaintPanel(model, this, selectorChooserPanel, colorPanel);
		selectorChooserPanel.paintPanel = paintPanel;
		c.add(this.paintPanel, BorderLayout.CENTER);	
		c.add(this.colorPanel, BorderLayout.SOUTH);
		colorPanel.setPaintPanel(paintPanel);
		ccp = new MenuCutCopyPaste(model, paintPanel);
		undoRedo = new MenuUndoRedo(model, paintPanel);

		//this.pack();
		this.setLocation(350, 175);
		this.setSize(950, 650);
		this.setVisible(true);
	}

	public PaintPanel getPaintPanel(){
		return paintPanel;
	}
	
	public ShapeChooserPanel getShapeChooserPanel() {
		return shapeChooserPanel;
	}
	
	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu;
		JMenuItem menuItem;

		menu = new JMenu("File");

		// a group of JMenuItems
		menuItem = new JMenuItem("New");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		//menuItem = new JMenuItem("Open");
		//menuItem.addActionListener(this);
		//menu.add(menuItem);

		//menuItem = new JMenuItem("Save");
		//menuItem.addActionListener(this);
		//menu.add(menuItem);

		menu.addSeparator();// -------------

		menuItem = new JMenuItem("Exit");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuBar.add(menu);

		menu = new JMenu("Edit");

		// a group of JMenuItems
		menuItem = new JMenuItem("Cut");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Copy");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Paste");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menu.addSeparator();// -------------

		menuItem = new JMenuItem("Undo");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Redo");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuBar.add(menu);

		return menuBar;
	}

	public void actionPerformed(ActionEvent e) {
		/**
		 * Perform an action when one of the menu button is 
		 * clicked.
		 */
		String action = e.getActionCommand();
        switch (action) {
            case "Exit":  
            		MenuExit exit = new MenuExit();
            		exit.exit();
                    break;
            case "New":  
            		MenuNew newCanvas = new MenuNew(model);
                    break;
            case "Cut":  
            		try {
            			ccp.cut();
            		} catch (CloneNotSupportedException e1) {

            		} catch(ArrayIndexOutOfBoundsException e2){
            			
            		}
                	break;
            case "Copy":  
            		try {
            			ccp.copy();
            		} catch (CloneNotSupportedException e1) {

            		} catch(ArrayIndexOutOfBoundsException e2){
            			
            		}
            		break;
            case "Paste":  
        			shapeChooserPanel.highlightOff();
        			ccp.paste();
        			break;
            case "Undo":  
            		undoRedo.undo();
            		break;
            case "Redo":  
            		undoRedo.redo();
            		break;
        		
        }
	}
}
