import java.util.ArrayList;
import java.util.Arrays;
import java.awt.Container;
import java.awt.Insets;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.io.*;
import sun.audio.*;
import javax.swing.*;

/** 
 * Keyboard class creates the Keyboard JFrame
 * @author nachmi
 */

public class Keyboard {
	
	static String chordTxt;
	
	/**
	 * Adds in all the Keyboard components into the container pane. 
	 * Components to be added in the container include black and white keys
	 * @param pane a JFrame container in which the keyboard will be in
	 */
	private static void Keyboard(Container pane) {

		/* Our container won't have any specific layout, 
		   allowing more freedom of where components can be setup. */
		pane.setLayout(null);
		Insets insets = pane.getInsets();
	
		//Instructions 
		JLabel instructions = new JLabel("Click on a key. Enjoy!");
		
		pane.add(instructions);

	/*	Chord Instructions, still under development
	 * 
		//Adding in the Chord Demo Instructions
		JLabel chordInstructions = new JLabel("Type in the Chord name and press 'Play'. @ = Flat, # = Sharp, m = minor, M = Major. ex: A#M");
		chordInstructions.setBounds(50,30,600,20);
		
		//Adding a JTextField for entering a chord.
		JTextField chord = new JTextField();
		chord.setBounds(650, 30, 100, 20);
		chordTxt = chord.getText();
	
		ChordDemo demo = new ChordDemo(775, 10 + insets.top, size.width, size.height);
	 
		
		pane.add(chordInstructions);
		pane.add(chord);
		pane.add(demo);
	*
	*/
		//Dimension of Black keys
		Dimension size = new Dimension(62, 200);

		//Most left part that the keys will be.
		int leftBorder = 90 + insets.left;
		
		//We call the creaBlackKeys method to create the first octave of black notes.
		String[] bKeyNotes = {"C#1", "D#1", "F#1", "G#1", "A#1"};
		ArrayList<Key> bKeys = 
				createBlackKeys(leftBorder, insets, size, bKeyNotes);
		
		//Now we call the same function to create the second octave of black notes
		String[] bKeyNotes2 = {"C#2", "D#2", "F#2", "G#2", "A#2"};
		bKeys.addAll(createBlackKeys(650, insets, size, bKeyNotes2));
		
		//Add in all the Black Keys
		for (Key k : bKeys) {
			pane.add(k);
		}
		
		//Add White Keys
		leftBorder = 40 + insets.left;
		size = new Dimension(80, 350);	
	
		String[] wKeyNotes = {"C1", "D1", "E1", "F1", "G1", "A1", "B1", "C2", "D2", "E2", "F2", "G2", "A2", "B2"};
		ArrayList<Key> wKeys = 
				createWhiteKeys(leftBorder, insets, size, wKeyNotes);

		//Add in all the White Keys
		for (Key k : wKeys) {
			pane.add(k);
		}
	}    
		
	/**
	 * Returns an ArrayList of Key objects to be used to populate the JFrame container
	 * <p>
	 * This method is primarily called by the Keyboard(Container pane) method.
	 * Calling outside of Keyboard won't work a) It is a private method 
	 * b) params come from a pre-existing Container, which is provided by the Keyboard caller
	 * @param begin The leftBorder of the first white key
	 * @param insets Insets on all sides of the container
	 * @param size The dimensions of the button. 
	 * @param notes A string of corresponding natural notes (C, A, B, D, E....).
	 * @return An ArrayList of keys to be added into the Container.
	 */
	private static ArrayList<Key> createWhiteKeys(int begin, Insets insets, Dimension size, String[] notes) {
		ArrayList<Key> keys = new ArrayList<Key>();
		
		int leftBorder = begin;
		int topBorder = 80 + insets.top;
		int rightBorder = size.width;
		int bottomBorder = size.height;
		
		for(int k = 0; k < notes.length; k++){
			keys.add(new WhiteKey(notes[k], leftBorder, topBorder, size.width, size.height));
			leftBorder+= 80;
		}
		return keys;
	}	

	/**
	 * Returns an ArrayList of Key objects to be used to populate the JFrame container
	 * <p>
	 * This method is primarily called by the Keyboard(Container pane) method.
	 * Calling outside of Keyboard won't work a) It is a private method 
	 * b) params come from a pre-existing Container, which is provided by the Keyboard caller
	 * <p>
	 * Only creates one octave of black keys (i.e only 5 black keys in a row).
	 * @param begin The leftBorder of the first white key
	 * @param insets Insets on all sides of the container
	 * @param size The dimensions of the button. 
	 * @param notes A string of corresponding natural notes (C, A, B, D, E....).
	 * @return An ArrayList of keys to be added into the Container.
	 */
	private static ArrayList<Key> createBlackKeys(int begin, Insets insets, Dimension size, String[] notes) {
		ArrayList<Key> keys = new ArrayList<Key>();
		
		int leftBorder = begin;
		int topBorder = 80 + insets.top;
		int rightBorder = size.width;
		int bottomBorder = size.height;
		for(int j = 0; j < 5; j++){
			if (j == 2) {
				leftBorder += 72;
			}
			keys.add(new BlackKey(notes[j], leftBorder, topBorder , rightBorder, bottomBorder));
			leftBorder += rightBorder + 20;
		}
		return keys;
	}
	
	/**
	 * Creates and shows the JFrame 
	 */
	public static void createAndShowGUI() {
		//Create and Set Up the window.
		JFrame frame = new JFrame("Virtual Keyboard");
		JOptionPane.showMessageDialog(frame, "Welcome to the Virtual Keyboard!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.getContentPane().setBackground( Color.ORANGE);

		//Set up the content pane.
		Keyboard(frame.getContentPane());

		//Size and display the window.
		Insets insets = frame.getInsets();
		frame.setSize(1280 + insets.left +insets.right, 450 + insets.top +insets.bottom);
		frame.setVisible(true);
	}
}
