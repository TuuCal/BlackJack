import java.awt.*;

public class Card {
    private Suit crdSuit;
    private int crdValue;


    public Card(Suit su, int val) {
      crdSuit = su;
      crdValue = val;
      
    }

    public Suit getSuit() {
      return crdSuit;
    }
    
    public int getValue() {
      return crdValue;
    }
    
    public int getFaceValue() {
      if(crdValue == 1){
        return 11;
      } else if(crdValue > 10){
        return 10;
      } else {
        return crdValue;
      }
    }
    
    public String toString(){
      String numStr = "";
      
      switch(crdValue){
        
        case 1:
          numStr = "Ace";
          break;
          
        case 2:
          numStr = "Two";
          break;
          
        case 3:
          numStr = "Three";
          break;
          
        case 4:
          numStr = "Four";
          break;
          
        case 5:
          numStr = "Five";
          break;
          
        case 6:
          numStr = "Six";
          break;
          
        case 7:
          numStr = "Seven";
          break;
          
        case 8:
          numStr = "Eight";
          break;
          
        case 9:
          numStr = "Nine";
          break;
          
        case 10:
          numStr = "Ten";
          break;
          
        case 11:
          numStr = "Jack";
          break;
          
        case 12:
          numStr = "Queen";
          break;
          
        case 13:
          numStr = "King";
          break;
          
      }
      
      return numStr + " of " + crdSuit.toString();
    }
        
}
