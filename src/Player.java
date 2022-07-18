import java.util.Queue;
import java.util.Scanner;

public class Player {

    /* Made two different kinds of players because I wanted to make the turn() function take the kind of player,
    because the only difference in the turns is the decision-making on whether the Player is going to
    draw another card or not. In the end I didn't succeed at making the function yet, but that is something that
    I intend to better in the next version. */

    static PokerDeck.Card drawCard(Queue<PokerDeck.Card> allCardsQueue){
        PokerDeck.Card cardDrawn = allCardsQueue.remove(); //drawing a card
        System.out.println(cardDrawn);
        return cardDrawn;
    }

    static class User extends Player {
        static int score;
        static boolean yetToPlay = true;

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
                            yetToPlay = true;   // new additions to the old
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

    static class Computer extends Player {
        static int score;
        static boolean yetToPlay = true;
        static boolean drawAnother = true;
        static boolean drawAnotherDecision(int userScore, boolean userWon){

            if (Computer.score < userScore && userWon == false){

                /* ^ I know that this statement above can be simplified, but I had it like this for
                my own ease of reading */

                drawAnother = true;
                yetToPlay=true;
            }
            return drawAnother;
        }

    }

}
