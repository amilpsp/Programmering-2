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
        Player.User user = new Player.User();
        Player.Computer computer = new Player.Computer();


        while (continuing){




            System.out.println(Player.drawCard(allCardsQueue));

            continuing = Player.User.yesOrNoQuestion("Do you want to play again?");
        }//while loop
    }//main


    static Queue<PokerDeck.Card> arrayListToQueue(PokerDeck.Deck myDeck){
        Queue<PokerDeck.Card> allCards = new LinkedList<>(Arrays.asList(myDeck.allCardsArrayList.toArray(new PokerDeck.Card[52])));
        return allCards;
    }
    static int decideTurn(){
        int turn;
        if (Player.User.yetToPlay){
            turn=1;
        }
        else-if(Player.Computer.yetToPlay){
            turn=2;
        }
        else{
            turn=3;
        }
    return turn;
    }
}

class Player{
    static int score;
    static boolean yetToPlay = false;

    static Queue<PokerDeck.Card> drawCard(Queue<PokerDeck.Card> allCardsQueue){
        PokerDeck.Card cardDrawn = allCardsQueue.remove(); //drawing a card
        System.out.println(cardDrawn);
        return allCardsQueue;
    }
    static class User extends Player{
        static boolean yesOrNoQuestion(String question){ //asks the user if they want to continue.
            char answer = 0;
            boolean validInput = false;

            Scanner yesOrNoScan = new Scanner(System.in);
            while (!validInput){
                try {
                    System.out.println(question + "(y/n)");
                    answer = yesOrNoScan.next().trim().toUpperCase().charAt(0);
                    if (answer == 'Y' || answer == 'N') {
                        validInput = true;
                        if (answer == 'N'){     // These 3 lines were the only
                            yetToPlay = true;   // new aditions to the old
                        }                       // code from last course
                    }
                    else {
                        System.out.println("Invalid answer! You can only answer 'Y' or 'N'");
                        yesOrNoScan.nextLine();
                    }
                }
                catch (Exception e){
                    System.out.println("Invalid answer! Error message: " + e);
                    yesOrNoScan.nextLine();
                }
            }
            return answer != 'N';
        }
    }

    static class Computer extends Player{
        static boolean drawAnotherDecision(int userScore){
            boolean drawAnother = false;
            if (Computer.score < userScore && Computer.score < 21){
                drawAnother = true;
            }
            else
                yetToPlay = true;
            return drawAnother;
        }

    }
}