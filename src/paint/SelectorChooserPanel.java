package paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Creates a panel radio buttons to get fill and a slider to
 * get thickness.
 */
public class SelectorChooserPanel extends JPanel implements ActionListener, ChangeListener {
	
	private static final long serialVersionUID = 1L;
	private View view; // So we can talk to our parent or other components of the view
	private JRadioButton fill, outline;  // Only one of the buttons can be checked
	private JSlider slider;  // Slider to change thickness
	private JButton button;  // Background color button
	protected PaintPanel paintPanel;

	public SelectorChooserPanel(View view) {	
		
		this.view=view;	
		this.setLayout(new BorderLayout());		
		this.setBackground(new Color(200, 215, 223));
		
		JPanel gridPanel = new JPanel(new GridLayout(0, 1));	
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		gridPanel.setBackground(new Color(200, 225, 255));
		p1.setBackground(new Color(200, 215, 223));
		p2.setBackground(new Color(200, 215, 223));
		p3.setBackground(new Color(200, 215, 223));
		
		// Radio buttons for Fill Style
		outline = new JRadioButton("No Fill");
		fill = new JRadioButton("Fill");
		fill.setBackground(new Color(200, 215, 223));
		outline.setBackground(new Color(200, 215, 223));
		outline.setSelected(true);
		ButtonGroup bg = new ButtonGroup( );
		bg.add(fill);
		bg.add(outline);
		p1.add(fill);	
		p1.add(outline);		
		p1.setPreferredSize(new Dimension(120, 10));
		
		// Slider to get brush thickness
		slider = new JSlider(JSlider.VERTICAL, 0, 20, 3);
		slider.setMinorTickSpacing(1);
	    slider.setMajorTickSpacing(10);
	    slider.setPaintTicks(true);
	    slider.setPaintLabels(true);
	    slider.setPreferredSize(new Dimension(60, 120));
	    slider.addChangeListener(this);
	    slider.setBackground(new Color(200, 215, 223));
	    p2.add(slider);
	    
	    // Button to set background color
	    button = new JButton("Background");
	    button.addActionListener(this);
	    p3.add(button);

	    gridPanel.add(p1);
	    gridPanel.add(p2);
	    this.add(gridPanel, BorderLayout.NORTH);
		this.add(p3, BorderLayout.SOUTH);	
	}
	
	/**
	 * Controller aspect of this
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {		
		Color color = JColorChooser.showDialog(this, "Choose a background color", Color.blue);
		paintPanel.setBackground(color);
	}
	
	@Override
	public void stateChanged(ChangeEvent arg0) {
		/**
		 * Allows changes to slider to take effect immediately.
		 */
		paintPanel.repaint();	
	}
	
	public boolean getOutline(){
		/**
		 * Returns true if the user wants no fill, or false otherwise.
		 * @return boolean
		 */
		return outline.isSelected();
	}
	
	public int thickness() {
		/**
		 * Returns the int value of how thick strokes should be.
		 * @return int
		 */
		return slider.getValue();
	}	
}
