import java.util.*;
public class PokerDeck {

    /* In retrospect, I could've made the public class the Deck and made the Cards a subclass of that. But I was in a
    * hurry because I procrastinated too much hehe. */

    static class Deck extends PokerDeck {
        static List<Card> allCardsArrayList = new ArrayList<>();

        public void generateCards(){

            //for each suit
            for(int s=0; s < 4; s++){
                //for each card
                for (int n=2; n<=14; n++ ){
                    allCardsArrayList.add(new Card(Color.values()[s],n));
                }
            }
        }

        public void generateAndShuffleDeck(){
            generateCards();
            Collections.shuffle(allCardsArrayList);
            System.out.println("...[Shuffles the deck in Spanish]..."); //Just a joke.
        }

    }
    enum Color {
        /* This was part of the inspiration that I had seen on a video before, I thought it'd be more convenient than
        * to try and have a multidimensional array with strings on one side for this and integers for the values as well*/
        Diamonds,
        Spades,
        Hearts,
        Clubs,
    }

    class Card extends Deck {
        final private int cardsValue;
        final private Color cardsColor;

        public Card(Color aColor, int aValue){  //Card constructor
            this.cardsColor = aColor;
            this.cardsValue = aValue;
        } //Constructor
        public int getCardsValue(){ //because the card value is private
            return cardsValue;
        }

        public String toString(){

            String valueToString = null;

            switch(this.cardsValue){
                /*So that I could generate the cards intrinsically with a numerical value without having to depend on
                * individual strings. Although I'd like to make a later version of this that follows the official rules
                * of Blackjack: the Jack, Queen and King are all worth 10 points, and the ace is worth either 1 or 11.*/
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

