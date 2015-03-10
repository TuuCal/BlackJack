import java.util.*;
public class BlackJack{
  
    static int wins = 0;
    static int losses = 0;
    
    public BlackJack(){
    }
   
    public void dealCards(Hand plyr, Hand dealr, Deck deck){
      deck.refillDeck();
      plyr.clearHand();
      dealr.clearHand();
      
      plyr.hit(deck);
      plyr.hit(deck);
      dealr.hit(deck);
      dealr.hit(deck);
    }
    
    public void whoHit(Hand who, Deck deck){
      who.hit(deck);
    }
    
    public boolean bustCheck(Hand aHand){
      if(aHand.getHandTotal()>21){
        losses += 1;
        return true;
      }else{
        return false;
      }
    }
    
    public boolean blackjCheck(Hand aHand){
      if(aHand.getHandTotal() == 21){
        wins += 1;
        return true;
      }else{
        return false;
      }
    }
    
    public boolean winCheck(Hand plyr, Hand dealr){
      if(plyr.getHandTotal() > dealr.getHandTotal()){
        wins += 1;
        return true;
      } else{
        losses += 1;
        return false;
      }
    }
    
}
  
