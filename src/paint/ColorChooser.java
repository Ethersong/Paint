package paint;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
/**
 * Creates a button that uses JColorChooser where the user can select
 * from a variety of colors to paint with.
 */
public class ColorChooser extends JPanel implements ChangeListener {

	private static final long serialVersionUID = 1L;
	private Color color = Color.WHITE;
	private JColorChooser colorChooser = new JColorChooser();
	private PaintPanel paintPanel;
	
	public ColorChooser(View view){
		/**
		 * Configures the bottom panel of the frame.
		 */
		this.setBackground(new Color(200, 215, 223));
		this.setLayout(new FlowLayout());
		colorChooser.setPreviewPanel(new JPanel());
		this.add(colorChooser);
		colorChooser.getSelectionModel().addChangeListener(this);	
		colorChooser.setBackground(new Color(200, 215, 223));		
	}
   
	@Override
	public void stateChanged(ChangeEvent e) {
		/**
		 * Sets the color to whichever color is selected.
		 */
	    color = colorChooser.getColor();	
	    paintPanel.repaint();
	}
	
	public Color getColor() {
		/**
		 * Returns the users selected color1
		 * @return color
		 */
		return this.color;
	}
	
	public void setPaintPanel(PaintPanel paintPanel){
		/**
		 * Allows to call repaint().
		 */
		this.paintPanel = paintPanel;
	}
}

