import java.util.Queue;
import java.util.Scanner;

public class Player {
    static boolean yetToPlay = false;
    public int score;

    static PokerDeck.Card drawCard(Queue<PokerDeck.Card> allCardsQueue){
        PokerDeck.Card cardDrawn = allCardsQueue.remove(); //drawing a card
        System.out.println(cardDrawn);
        return cardDrawn;
    }

    static class User extends Player {
        static int score    ;
        static boolean yetToPlay = false;

        /*   static LinkedList<String> playersHand = new LinkedList<>();*/
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
                            /*why are these here?*/     yetToPlay = true;   // new additions to the old
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
    /*static List<String> getPlayersHand(){
         return playersHand;
     }*/
    }

    static class Computer extends Player {
        static int score;
        static boolean yetToPlay = false;
        static boolean drawAnotherDecision(int userScore){
            boolean drawAnother = false;
            if (Computer.score < userScore && Computer.score < 21){
                drawAnother = true;
            }
            else{
                yetToPlay = true;
            }
            return drawAnother;
        }

    }

}
