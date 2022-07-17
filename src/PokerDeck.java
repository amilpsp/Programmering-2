import java.util.*;
public class PokerDeck {
    static class Deck extends PokerDeck {
        static List<Card> allCardsArrayList = new ArrayList<>();
        private final int amountOfCards = 52;

        public ArrayList<Card> generateCards(){

            //for each suit
            for(int s=0; s < 4; s++){
                //for each card
                for (int n=2; n<=14; n++ ){
                    allCardsArrayList.add(new Card(Color.values()[s],n));
                }
            }
            return (ArrayList<Card>) allCardsArrayList;
        }

        public void generateAndShuffleDeck(){
            generateCards();
            Collections.shuffle(this.allCardsArrayList);
            System.out.println("...[Shuffles the deck in Spanish]...");
        }

    }
    enum Color {
        Diamonds,
        Spades,
        Hearts,
        Clubs,
    }

    class Card extends Deck {
        private int cardsValue;
        private Color cardsColor;

        public Card(Color aColor, int aValue){  //Card constructor
            this.cardsColor = aColor;
            this.cardsValue = aValue;
        } //Constructor
        public int getCardsValue(){
            return cardsValue;
        }
        public Color getCardsColor(){
            return cardsColor;
        }
        public String toString(){
            String valueToString = null;

            switch(this.cardsValue){
                case 2:
                    valueToString="Two";
                    break;
                case 3:
                    valueToString="Three";
                    break;
                case 4:
                    valueToString="Four";
                    break;
                case 5:
                    valueToString="Five";
                    break;
                case 6:
                    valueToString="Six";
                    break;
                case 7:
                    valueToString="Seven";
                    break;
                case 8:
                    valueToString="Eight";
                    break;
                case 9:
                    valueToString="Nine";
                    break;
                case 10:
                    valueToString="Ten";
                    break;
                case 11:
                    valueToString="Jack";
                    break;
                case 12:
                    valueToString="Queen";
                    break;
                case 13:
                    valueToString="King";
                    break;
                case 14:
                    valueToString="Ace";
                    break;
            }
            return valueToString + " of " + cardsColor.toString();
        }

    }

}

