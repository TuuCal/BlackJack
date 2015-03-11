import java.util.*;
public class BlackJackTable{
  
    static int wins = 0;
    static int losses = 0;
    static Scanner scan = new Scanner(System.in);
    static String playAgain = "y";
   
    public static void playGame(Deck deck, Hand plyr, Hand dealr){
      deck.refillDeck();
      plyr.clearHand();
      dealr.clearHand();
      
      plyr.pickupCard(deck.drawCard());
      plyr.pickupCard(deck.drawCard());
      dealr.pickupCard(deck.drawCard());
      dealr.pickupCard(deck.drawCard());
      
      plyr.printHand(true);
      dealr.printHand(false);
      
      boolean keepGoing = false;
     do{
      
      System.out.println("Would you like to hit? (y/n)");
      
      String hitting = scan.next();
      if(hitting.equalsIgnoreCase("y")){
        plyr.hit(deck,true);
        keepGoing = true;
      } else{
        keepGoing = false;
      }
      System.out.println(" ");
      }while(keepGoing && plyr.getHandTotal() < 21);
      
      if(plyr.getHandTotal() > 21){
        System.out.println("Bust! You lose this one...");
        System.out.println(" ");
        losses = losses + 1;
        System.out.println("Would you like to play another hand? (y/n)");
        playAgain = scan.next();
        return;
      }
      
      if(plyr.getHandTotal() == 21){
        System.out.println("You hit 21! You win!");
        System.out.println(" ");
        wins = wins + 1;
        System.out.println("Would you like to play another hand? (y/n)");
        playAgain = scan.next();
        return;
      }
      
       while(dealr.getHandTotal() < 17){
        dealr.hit(deck,false);
      }
      
      if(dealr.getHandTotal() == 21){
        plyr.printHand(true);
        dealr.printHand(true);
        System.out.println("The dealer hit 21. You LOSE!");
        losses = losses + 1;
        System.out.println("Would you like to play another hand? (y/n)");
        playAgain = scan.next();
        return;
      }
      
      if(dealr.getHandTotal() > 21){
        plyr.printHand(true);
        dealr.printHand(true);
        System.out.println("Bust! The dealer loses!");
        wins = wins + 1;
        System.out.println("Would you like to play another hand? (y/n)");
        playAgain = scan.next();
        return;
      }
      
      if(plyr.getHandTotal() > dealr.getHandTotal()){
        plyr.printHand(true);
        dealr.printHand(true);
        System.out.println("You Won!");
        System.out.println(" ");
        wins = wins + 1;
      } else {
        plyr.printHand(true);
        dealr.printHand(true);
        System.out.println("You Lost!");
        System.out.println(" ");
        losses = losses + 1;
      }
      
      System.out.println("Would you like to play another hand? (y/n)");
      playAgain = scan.next();
      
    }
  
  public static void main(String[] args) {
    System.out.println("Please input your name and press enter.");
    Hand myHand = new Hand(scan.next());
    System.out.println("Thank you, " + myHand.getName() + " let's begin!");
    System.out.println(" ");
    Hand dealer = new Hand("Dealer");
    Deck myDeck = new Deck();
    
    
    do{
    playGame(myDeck,myHand,dealer);
    }while(!playAgain.equalsIgnoreCase("n"));
    
    System.out.println("You had " + wins + " wins and " + losses + " losses");
   
  }
  
  
}
  
