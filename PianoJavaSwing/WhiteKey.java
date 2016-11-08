
import java.awt.Color;
import java.awt.Graphics;

/**
 * Creates a white key. Extends Key. 
 * @author nachmi
 */

public class WhiteKey extends Key {
   public void paintComponent(Graphics g)
   {
   		g.setColor(Color.WHITE );
        g.fillRect(5, 5, getSize().width-3, getSize().height-8);
   }

   /**
   * Constructs a white key object that corresponds to a note and sound. 
   * @param note The name of the note that will be played when button is clicked.
   * @param leftBound left bound of the key.
   * @param topBound upper bound of the key.
   * @param width Width of the key.
   * @param height Height of the key.
   */
   public WhiteKey(String note, int leftBound, int topBound, int width, int height) {
     super(note,  leftBound, topBound, width, height);
   }   
}
