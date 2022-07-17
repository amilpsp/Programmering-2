import java.util.*;
public class BlackJack {

    public static void main (String[]args){

        boolean keepPlaying = true;

        //Making cards and shuffling the deck
        new PokerDeck();
        PokerDeck.Deck myDeck = new PokerDeck.Deck();
        //Note to self:                                 REMEMBER TO CHECK WHEN THIS IS NEEDED AGAIN.
        myDeck.generateAndShuffleDeck();
        Queue<PokerDeck.Card> allCardsQueue = arrayListToQueue(myDeck);



        while (keepPlaying){ //whole program play again loop
            //Instantiating players that are going to participate.
            new Player.User();
            new Player.Computer();
            Player.User.score       =0;
            Player.Computer.score   =0;

            boolean keepDealingCards = true;
            boolean userWon          = false;
            boolean computerWon      = false;


            while (keepDealingCards) {


                switch (decideTurn()) {

                    case 1:  //USER'S TURN---------------------
                        boolean drawAnother = true;
                        boolean drewAce     = false;

                        while (drawAnother) {
                            if (allCardsQueue.isEmpty()) {
                                System.out.println("We ran out of cards! Let me shuffle that real quick.");
                                myDeck.generateAndShuffleDeck();
                            }

                            PokerDeck.Card cardDrawn = Player.User.drawCard(allCardsQueue);

                            if (cardDrawn.toString().contains("Ace")) {
                                drewAce = true;
                                System.out.println(
                                    "You drew a " + cardDrawn + ", worth either " + cardDrawn.getCardsValue()+" points, or one point." +
                                            "\n I'll assign it the first value and discount the remainder in case you go over 21."
                                );
                            }
                            else System.out.println("You drew a " + cardDrawn + ", worth " + cardDrawn.getCardsValue()+" points.");

                            Player.User.score += cardDrawn.getCardsValue();
                            System.out.println("Current score of " + Player.User.score +" points.\n");

                            if (Player.User.score >= 21 && drewAce) {
                                System.out.println(
                                        "Your score went over 21, but you drew an Ace, so I'll discount you those extra 13 points."
                                );
                                Player.User.score -= 13;
                                drewAce = false;
                            }
                            if (Player.Computer.score > 21) {                   //THIS DIDN'T WORK, DEBUG LATER.
                                System.out.println("Sorry, you lost!");
                                computerWon = true;
                                break;                              //I want to go to the "play again question directly"
                            }                                       //but I'll check how to do that later.
                            else if (Player.Computer.score == 21) {
                                System.out.println("Blackjack! Congrats, you won!");
                                userWon = true;
                                break;
                            } else {
                                drawAnother = Player.User.yesOrNoQuestion("Do you want to draw another card from the deck?");
                            }
                        }
                        Player.User.yetToPlay = false;
                        break;



                    case 2:  //COMPUTER'S TURN-------------------------------------------
                        drawAnother = true;
                        drewAce = false;

                        while (drawAnother) {
                            System.out.println("The computer drew a card.");
                            if (allCardsQueue.isEmpty()) {
                                myDeck.generateAndShuffleDeck();
                                System.out.println("The deck ran out of cards, shuffling again.");
                            }
                            PokerDeck.Card cardDrawn = Player.Computer.drawCard(allCardsQueue);
                            if (cardDrawn.toString().contains("Ace"))
                                drewAce = true;

                            Player.Computer.score += cardDrawn.getCardsValue();
                            System.out.println("Computer's current " + Player.User.score +" points.\n");

                            if (Player.Computer.score >= 21 && drewAce) {
                                Player.Computer.score -= 13;
                                drewAce = false;
                            }
                            if (Player.Computer.score > 21) {
                                System.out.println("You won!");
                                userWon = true;
                                break;                              //I want to go to the "play again question directly"
                            }                                       //but I'll check how to do that later.
                            else if (Player.Computer.score == 21) {
                                System.out.println("Blackjack!");
                                break;
                            } else {

                                drawAnother = Player.Computer.drawAnotherDecision(Player.Computer.score);
                            }

                        }
                        Player.Computer.yetToPlay = false;
                        break;
                } //Switch



                if (userWon || computerWon ||(!Player.User.yetToPlay && !Player.Computer.yetToPlay))
                    keepDealingCards = false;


            } //while keepDealingCards
            if (!userWon || !computerWon){
                decideAndDisplayWinner(Player.User.score, Player.Computer.score);
                keepPlaying = keepPlayingQuestion();
            }

        }//whole program play again loop
        System.out.println("Okay, thanks for playing! See ya next time (^u^)/ ");
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
    static boolean keepPlayingQuestion(){
        boolean keepPlaying     = Player.User.yesOrNoQuestion("Do you want to play again?");
        boolean sure    = false;
        if (!keepPlaying)
            sure = Player.User.yesOrNoQuestion("Are you sure you want to exit the game?");
        if (!sure) {
            keepPlaying=true;
            keepPlayingQuestion();
        }
        return !keepPlaying;
    }
    static void decideAndDisplayWinner(int userScore, int computerScore){
        System.out.println("The computer's score was: " + computerScore);
        System.out.println("Your score was: " + userScore);

        // the "scores below 21" shouldn't be necessary, will work around that later.
        if (userScore>computerScore && userScore<=21) System.out.println("Congratulations, you won this round!");
        else if (userScore<computerScore && computerScore<=21) System.out.println("Sorry, you lost this round :( ");
        else if (userScore==computerScore && computerScore<=21) System.out.println("This round was a tie!");
        else System.out.println(
                "Sorry, there was a problem comparing the score, please contact the developer to inform them of the bug!");
    }
    static int decideTurn(){
        if (Player.User.yetToPlay)return 1;
        else return 2;
        }


    static Queue<PokerDeck.Card> arrayListToQueue(PokerDeck.Deck myDeck){
        Queue<PokerDeck.Card> allCards = new LinkedList<>(Arrays.asList(myDeck.allCardsArrayList.toArray(new PokerDeck.Card[52])));
        return allCards;
    }

}