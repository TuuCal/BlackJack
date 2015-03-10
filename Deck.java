import java.util.*;

public class Deck {
  
  ArrayList<Card> dck;
  
  public Deck(){
    dck = new ArrayList<Card>();
    refillDeck();
  }
  
  public void refillDeck(){
    this.dck.clear();
    
    for(int i = 0; i<=52; i++){
      dck.add( new Card(Suit.values()[i%4],i % 13 + 1));
    }
    
    Collections.shuffle(this.dck);
  }

   public Card drawCard(){
     Card crd = dck.get(0);
     dck.remove(0);
     return crd;
   }
   
}
