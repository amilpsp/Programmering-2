import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BlackJack {
    public static void main (String[]args){
        new PokerDeck();
        PokerDeck.Deck myDeck = new PokerDeck.Deck();
        myDeck.generateCards();
        myDeck.shuffleDeck();

        Queue<PokerDeck.Card> playableCards = new LinkedList<>(Arrays.asList(myDeck.AllCards.toArray(new PokerDeck.Card[52])));
        System.out.println(playableCards);


    }
}
