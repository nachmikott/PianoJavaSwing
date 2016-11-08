
import java.awt.Container;
import java.awt.Insets;
import java.awt.Dimension;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent;
import java.io.*;
import sun.audio.*;
import java.awt.Graphics;



/**
 * Essentially a JButton, but looks like a keyboard key
 * @author nachmi
 *
 */
public class Key extends JButton
                           implements ActionListener {
  
  public String thisNote;

  /**
   * Constructs a Key object that corresponds to a note and sound. 
   * @param note The name of the note that will be played when button is clicked.
   * @param leftBound left bound of the key.
   * @param topBound upper bound of the key.
   * @param width Width of the key.
   * @param height Height of the key.
   */
  public Key(String note, int leftBound, int topBound, int width, int height) {
    thisNote = note;
    setText(note);
    setBounds(leftBound, topBound, width, height);

    addActionListener(this);
  }   
   
  public void actionPerformed(ActionEvent e)
  {
    JButton b = (JButton)e.getSource();
    if(b == this) {
	    try {
			playSound();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (UnsupportedAudioFileException e1) {
			e1.printStackTrace();
		}
    
    }
  } 
 
  /**
   * Plays the sound when note is clicked.
   * <p>
   * Plays the file from soundFiles/[NameOfNote.wav].
   * @throws IOException
   * @throws UnsupportedAudioFileException
   */
  public void playSound() throws IOException, UnsupportedAudioFileException { 
		try{ 
		  File sound = new File("soundFiles/" + thisNote + ".wav");
		 
		  Clip clip = AudioSystem.getClip();
		  clip.open(AudioSystem.getAudioInputStream(sound));
		  clip.start();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
  }
   
}






















 

  
  
 