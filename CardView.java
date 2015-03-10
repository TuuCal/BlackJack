import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import javax.imageio.*;

class CardView extends JPanel {
  
  private final static ArrayList<BufferedImage> CARDS = new ArrayList<BufferedImage>();
  
  static {
    try {
     int nim = 54;
     for (int ix = 1; ix <= nim; ix++) {
       CARDS.add(ImageIO.read(new File("classic-cards/" + ix + ".png" )));
     }
    } catch (IOException ex) {
      throw new RuntimeException(ex);
    }
  }
  
  public static void main(String[] args) {
    JFrame frame = new JFrame("A Card");
     Container cnt = frame.getContentPane();
     Card aCard = new Card(Suit.Spades,3 );
     CardView pnl = new CardView(aCard);
     cnt.add(pnl);
     frame.pack();
     frame.setVisible(true);
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  private final BufferedImage image;
  
  static int indexOf(Card card) {
    int suitNumber = card.getSuit().ordinal();
    int value = card.getValue();
    
    int index;
    if(value == 1) {
      index = suitNumber;
    } else {
      index = (52 - ((value - 1) * 4)) + suitNumber;
    }
    return index;
  }
  
  CardView(Card card) {
    this(indexOf(card));
  }
  
  CardView(int index) {
    image = CARDS.get(index);
    int width = image.getWidth();
    int height = image.getHeight();
    setPreferredSize(new Dimension(width, height));
    //image = DECK.get();
  }
  
  public void paintComponent(Graphics gr){
   super.paintComponent(gr);
   gr.drawImage(image, 0, 0, (ImageObserver)null);
  }
  
}