import java.util.*;

public class Hand {
  
  private String name;
  ArrayList<Card> handCards = new ArrayList<Card>();
  private int numAces;
  private int handTotal;
  
  public Hand(String yourName){
    
    this.name = yourName;
    numAces = 0;
    handTotal = 0;
  }
  
  public void pickupCard(Card newCard){
    if(newCard.getFaceValue() == 11){
      numAces = numAces + 1;
    }
    
    handCards.add(newCard);
    handTotal = handTotal + newCard.getFaceValue();
  }
  
  public String getName(){
    return name;
  }
  
  public int getAces(){
    return numAces;
  }
  
  public void makeSmallAce(){
    handTotal = handTotal - 10;
    numAces = numAces - 1;
  }
  
  public void reduceAces(){
    numAces = numAces - 1;
  }
  
  public void clearHand(){
    handCards.clear();
    numAces = 0;
    handTotal = 0;
  }
  
  public int getHandTotal(){
    if(handTotal > 21 && numAces > 0){
      this.makeSmallAce();
    }
    return handTotal;
  }
  
  public void hit(Deck deck){
    this.pickupCard(deck.drawCard());
  }
  
  public void stay(){
    System.out.println("Okay, it's the dealer's turn.");
  }
  
  public void printHand(boolean showFirstCard){
    
    System.out.println(this.name + "'s cards:");
    System.out.println(" ");
    for(int i = 0; i < handCards.size(); i++){
      if ( i == 0 && !showFirstCard) {
        System.out.println("  [Hidden]");
      } else {
        System.out.println("  " + handCards.get(i).toString());
      }
    }
      System.out.println(" ");
  }
}
