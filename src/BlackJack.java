public class BlackJack {
    public static void main (String[]args){
        new PokerDeck();
        PokerDeck.Deck myDeck = new PokerDeck.Deck();
        myDeck.generateCards();
        myDeck.shuffleDeck();
    }
}
