import java.util.Scanner;

public class U1_CharacterInAString {
    public static void main(String[]args){
        boolean toContinue = true;

        while (toContinue) { //at the end of the loop it asks the user if they want to go again or not
            String sentence = requestSentence();
            String letterToSearch = requestLetter();

            int timesIn = timesCounter(sentence, letterToSearch);
            String answer = pickAnswer(timesIn);
            System.out.println(answer);
            toContinue=continueQuestion();
        }
        System.out.println("Okay, bye then. Take care!"); //Exit message
    }
    static String pickAnswer(int letterInSentenceTimes){ //The message displayed for the user will depend on whether the letter appears or not in the text.*/
        String answer;
        if (letterInSentenceTimes == 0) {
            answer = "That letter isn't in your sentence.";
        }
        else
            answer = "That letter is in the sentence " + letterInSentenceTimes + " times.";

        return answer;
    }

    static String requestSentence(){ //Asks the user to type in a sentence or paragraph to evaluate.
        Scanner sentenceScan = new Scanner(System.in);
        String sentence;
        System.out.println("Hello, what sentence or paragraph do you want to evaluate? Press 'enter' when done typing.");

        try {
            sentence = sentenceScan.nextLine();
            return sentence;
        }
        catch (Exception e) {
            String sentence1;
            System.out.println("Invalid text, please try again");
            sentence1 = requestSentence();
            return sentence1;
        }
    }
    static String requestLetter(){ //Asks the user to type in a letter to look for in the text.
        Scanner letterScan =new Scanner(System.in);
        String letter;
        System.out.println("Good! Now, what character do you want to check for in this sentence?");

        try {
            letter = letterScan.nextLine();
            return letter;
        }
        catch (Exception e) {
            String letter1;
            System.out.println("Invalid character, please try again.");
            letter1 = requestLetter();
            return letter1;
        }
    }
    static int timesCounter(String text, String letterToSearch){ //looks for the letter to search through each letter of the sentence.
            int counter = 0;

        for (int i = 0; i <= text.length()-1; i++){
            String letter = text.substring(i,i+1);
            if (letter.equalsIgnoreCase(letterToSearch)){
                counter++;
            }
        }
        return counter;
    }
    static boolean continueQuestion(){ //asks the user if they want to continue.
                char answer = 0;
        boolean validInput = false;

        Scanner yesOrNoScan = new Scanner(System.in);
        while (!validInput){
            try {
                System.out.println("Want to evaluate another sentence? (y/n) ");
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
