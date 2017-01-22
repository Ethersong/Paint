package paint.command;
/**
 * This is the Control that manages how each
 * graphic should be built by calling execute.
 */
public class CommandControl {
	
	public void createGraphic(Command command) {
		/**
		 * Calls executes, which may be different depending
		 * on the class.
		 */
		command.execute();	
	}
}