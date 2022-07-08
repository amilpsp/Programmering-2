public class U3_Dice {
    public static void main(String[]args){
        int[] t = Dice.throwTheDice(); //Storing the result of the method onto a class variable.
        for (int i=0; i<t.length-1; i++) // Loop that traverses throughout the whole array.
            System.out.print(t[i]+", "); // Printing every one except the last with comas right after.
        System.out.print(t[t.length-1] + "."); //The last one has a period. Just for aesthetic purposes.
    }
}
class Dice{
    static int[] throwTheDice(){ //I didn't want the method to have the same name as the class
        int[] t = new int[100];
        for (int i=0; i<t.length; i++){ //Traversing through the whole array
            int randomInt = (int) (Math.random()*10); // .random assigns a random value between 0 and 1. I can multiply it by 10 to get an integer
            t[i]=randomInt; //assigning the value to that spot in the array
            if (randomInt>6 || randomInt==0)
                i--; // If it's not a valid number (0 or bigger than 6) I decrease the value of the index by 1, so that, in the next pass the loop ends up at the same index again and gives it another try.
        }
    return t;
    }
}
