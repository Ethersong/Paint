package paint;

public class Paint {
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Paint();
			}
		});
	}

	PaintModel model; // Model
	View view; // View + Controller

	public Paint() {

		// Model
		this.model = new PaintModel();

		// View + Controller
		this.view = new View(model);
	}
}
