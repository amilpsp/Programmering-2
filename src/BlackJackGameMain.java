import java.util.*;

public class BlackJackGameMain {

    public static void main (String[]args){
        new PokerDeck();
        PokerDeck.Deck deck = new PokerDeck.Deck();
        ArrayList<PokerDeck.Card> myDeck;
        myDeck = deck.generateCards();
        deck.shuffleDeck(myDeck);


    }

}
