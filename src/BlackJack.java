import java.util.*;
public class BlackJack {
    public static void main (String[]args){
        //Program opens
        new PokerDeck();
        PokerDeck.Deck myDeck = new PokerDeck.Deck();

        myDeck.generateCards();
        myDeck.shuffleDeck();


        Queue<PokerDeck.Card> allCardsQueue = arrayListToQueue(myDeck);
        allCardsQueue.remove();




    }

    static Queue<PokerDeck.Card> arrayListToQueue(PokerDeck.Deck myDeck){
        Queue<PokerDeck.Card> allCards = new LinkedList<>(Arrays.asList(myDeck.allCardsArrayList.toArray(new PokerDeck.Card[52])));
        return allCards;
    }
}
