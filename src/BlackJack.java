import java.util.*;
public class BlackJack {
    public static void main (String[]args){
        //Program opens
        new PokerDeck();
        PokerDeck.Deck myDeck = new PokerDeck.Deck();

        myDeck.generateCards();
        myDeck.shuffleDeck();
        Queue<PokerDeck.Card> allCardsQueue = arrayListToQueue(myDeck);





    }

    static Queue<PokerDeck.Card> arrayListToQueue(PokerDeck.Deck myDeck){
        Queue<PokerDeck.Card> allCards = new LinkedList<>(Arrays.asList(myDeck.allCardsArrayList.toArray(new PokerDeck.Card[52])));
        return allCards;
    }
}

class Player{
    static int score;
    boolean hasPlayed = false;

    static Queue<PokerDeck.Card> drawCard(Queue<PokerDeck.Card> allCardsQueue){
        PokerDeck.Card cardDrawn = allCardsQueue.remove(); //drawing a card
        System.out.println(cardDrawn);
        return allCardsQueue;
    }
    class User extends Player{

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

    class Computer extends Player{
        static boolean drawAnotherDecision(int userScore){
            if (Computer.score < userScore && Computer.score < 21){
                return true;
            }

        }

    }
}
