package paint;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
/**
 * Creates a shape panel that detects clicks. If a button is pressed
 * the mode will change corresponding to the button.
 */
class ShapeChooserPanel extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private View view; // So we can talk to our parent or other components of the view	
	private ArrayList<JButton> buttons = new ArrayList<JButton>();  // The Shape buttons
	
	public ShapeChooserPanel(View view) {	
		/**
		 * Initialize the panel.
		 */
		this.view=view;	
		String[] buttonLabels = { "Circle", "Rectangle", "Triangle", "Squiggle", "Circleline", "Polyline"};
		this.setLayout(new GridLayout(buttonLabels.length, 1));
		// Sets up the buttons
		for (String label : buttonLabels) {
			JButton button = new JButton();
			this.add(button);
			button.addActionListener(this);
			button.setText(" ");
			button.setActionCommand(label);
			button.setBorder(BorderFactory.createEmptyBorder());
			button.setPreferredSize(new Dimension(20, 20));
			button.setBackground(Color.WHITE);
			
			try { // Puts images on the buttons
			    Image img = ImageIO.read(getClass().getResource("/images/" + label + ".png"));
			    button.setIcon(new ImageIcon(img));
			} catch (IOException ex) {				
			}
			
			buttons.add(button);
		}
		
		try {
			Image img = ImageIO.read(getClass().getResource("/images/circleH.png"));
			buttons.get(0).setIcon(new ImageIcon(img));
		} catch (IOException ex) {		
		}	
		
	}		
	
	/**
	 * Controller aspect of this
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		/**
		 * Changes the mode depending on which button is clicked.
		 */
		this.view.getPaintPanel().setMode(e.getActionCommand());	
		highlightButton(e);		
	}	
	
	public void highlightButton(ActionEvent e) {
		/**
		 * Highlights the shape when selected by using custom images 
		 * from the drawable folder.
		 */	
        String buttonClicked = e.getActionCommand();
        String[] buttonLabels = { "Circle", "Rectangle", "Triangle", "Squiggle", "Circleline", "Polyline"};
        int i = 0;
        for(JButton button: buttons){
        	
        	try {
			    Image img = ImageIO.read(getClass().getResource("/images/" + buttonLabels[i] + ".png"));
			    button.setIcon(new ImageIcon(img));
			} catch (IOException ex) {				
			}
        	i++;
        }
        switch (buttonClicked) {
            case "Circle": 
            	try {
        			Image img = ImageIO.read(getClass().getResource("/images/CircleH.png"));
        			((AbstractButton) e.getSource()).setIcon(new ImageIcon(img));
        		} catch (IOException ex) {
        		}
            	break;
            case "Rectangle":  
            	try {
            		Image img = ImageIO.read(getClass().getResource("/images/RectangleH.png"));
            		((AbstractButton) e.getSource()).setIcon(new ImageIcon(img));
            	} catch (IOException ex) {
            	}
                break;
            case "Triangle":  
            	try {
        			Image img = ImageIO.read(getClass().getResource("/images/TriangleH.png"));
        			((AbstractButton) e.getSource()).setIcon(new ImageIcon(img));
        		} catch (IOException ex) {
        		}
                break;
            case "Squiggle":  
            	try {
        			Image img = ImageIO.read(getClass().getResource("/images/SquiggleH.png"));
        			((AbstractButton) e.getSource()).setIcon(new ImageIcon(img));
        		} catch (IOException ex) {
        		}
                break;
            case "Polyline":  
            	try {
        			Image img = ImageIO.read(getClass().getResource("/images/PolylineH.png"));
        			((AbstractButton) e.getSource()).setIcon(new ImageIcon(img));
        		} catch (IOException ex) {
        		}
                break;
            case "Circleline":  
            	try {
        			Image img = ImageIO.read(getClass().getResource("/images/CirclelineH.png"));
        			((AbstractButton) e.getSource()).setIcon(new ImageIcon(img));
        		} catch (IOException ex) {
        		}
                break;
        }	
	}	
	
	public void highlightOff(){
		/**
		 * Turns off the highlights when none of the shape
		 * buttons are selected.
		 */
		String[] buttonLabels = { "Circle", "Rectangle", "Triangle", "Squiggle", "Circleline", "Polyline"};
		int i = 0;
		for(JButton button: buttons){
			try { // Puts images on the buttons
			    Image img = ImageIO.read(getClass().getResource("/images/" + buttonLabels[i] + ".png"));
			    button.setIcon(new ImageIcon(img));
			} catch (IOException ex) {				
			}
			i++;			
		}		
	}
}
