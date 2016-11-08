import java.awt.Container;
import java.awt.Insets;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent;
import java.io.*;
import sun.audio.*;
import java.awt.Graphics;



/**
 * Creates a black key. Extends Key.
 * @author nachmi 
 */
public class BlackKey extends Key  {

  /**
   * Constructs a white key object that corresponds to a note and sound. 
   * @param note The name of the note that will be played when button is clicked.
   * @param leftBound left bound of the key.
   * @param topBound upper bound of the key.
   * @param width Width of the key.
   * @param height Height of the key.
   */
   public BlackKey(String note, int leftBound, int topBound, int width, int height) {
     super(note,  leftBound, topBound, width, height);
   }   
  
  public void paintComponent(Graphics g) {
	    g.setColor( Color.BLACK );
	    g.fillRect(5, 5, getSize().width-3, getSize().height-8);

  }

}





