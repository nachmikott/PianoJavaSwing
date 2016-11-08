/**
 * Contains the Main method
 * @author nachmi
 */

public class Runner {
	
	/**
	 * runs the GUI.
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Keyboard.createAndShowGUI();
			}
		});
	}
}