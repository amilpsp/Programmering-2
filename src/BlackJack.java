import java.util.*;
public class BlackJack {

    public static void main (String[]args){

        boolean continuing = true;

        //Making cards and shuffling the deck
        new PokerDeck();
        PokerDeck.Deck myDeck = new PokerDeck.Deck();
        //REMEMBER TO ALWAYS CHECK WHEN THIS IS NEEDED AGAIN.
        myDeck.generateAndShuffleDeck();
        Queue<PokerDeck.Card> allCardsQueue = arrayListToQueue(myDeck);

        //Instantiating players that are going to participate.
        new Player.User();
        new Player.Computer();


        while (continuing){ //whole program play again loop

            switch(decideTurn()){

                case 1:
                    boolean drawAnother=true;
                    boolean drewAce=false;

                    while(drawAnother) {
                        if (allCardsQueue.isEmpty()){
                            myDeck.generateAndShuffleDeck();
                        }
                        PokerDeck.Card cardDrawn =Player.User.drawCard(allCardsQueue);
                        if (cardDrawn.toString().contains("Ace"))
                            drewAce=true;
                        Player.User.score += cardDrawn.getCardsValue();
                        if (Player.User.score >= 21 && drewAce){
                            Player.User.score -= 13;
                            drewAce=false;
                        }
                        drawAnother = Player.User.yesOrNoQuestion("Do you want to draw another card from the deck?");
                    }
                    Player.User.yetToPlay=false;
                    break;
                case 2:
                    drawAnother=true;
                    drewAce = false;

                    while(drawAnother) {
                        if (allCardsQueue.isEmpty()){
                            myDeck.generateAndShuffleDeck();
                        }
                        PokerDeck.Card cardDrawn =Player.Computer.drawCard(allCardsQueue);
                        if (cardDrawn.toString().contains("Ace"))
                            drewAce=true;
                        Player.Computer.score += cardDrawn.getCardsValue();
                        if (Player.Computer.score >= 21 && drewAce){
                            Player.Computer.score -= 13;
                            drewAce=false;
                        }
                        drawAnother = Player.Computer.drawAnotherDecision(Player.Computer.score);
                    }
                    Player.Computer.yetToPlay=false;
                    break;
                case 3:
                    break;
            }




            System.out.println();

            continuing = Player.User.yesOrNoQuestion("Do you want to play again?");
        }//whole program play again loop
    }//main

    /*

  -------------I want to find a "quick" way to not have this repeat, it's probably obvious and I'm------------------------
  -----------------------------------overcomplicating my thought process--------------------------------------------------

    static void turn(Player player, Queue<PokerDeck.Card> allCardsQueue,PokerDeck.Deck myDeck) {

        boolean drawAnother = true;
        boolean drewAce = false;

        while (drawAnother) {
            if (allCardsQueue.isEmpty()) {
                myDeck.generateAndShuffleDeck();
            }
            PokerDeck.Card cardDrawn = Player.User.drawCard(allCardsQueue);
            if (cardDrawn.toString().contains("Ace"))
                drewAce = true;
            player.score += cardDrawn.getCardsValue();
            if (player.score >= 21 && drewAce) {
                player.score -= 13;
                drewAce = false;
            }
            drawAnother = Player.User.yesOrNoQuestion("Do you want to draw another card from the deck?");
        }
        Player.User.yetToPlay = false;
    }
*/
    static int decideTurn(){

        if (Player.User.yetToPlay){
            return 1;
        }
        else{
            if (Player.Computer.yetToPlay)return 2;
            else return 3;
        }

    }


    static Queue<PokerDeck.Card> arrayListToQueue(PokerDeck.Deck myDeck){
        Queue<PokerDeck.Card> allCards = new LinkedList<>(Arrays.asList(myDeck.allCardsArrayList.toArray(new PokerDeck.Card[52])));
        return allCards;
    }

}

