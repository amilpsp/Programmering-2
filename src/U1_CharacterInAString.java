import java.util.Scanner;

public class U1_CharacterInAString {
    public static void main(String[]args){
        boolean toContinue = true;

        while (toContinue) {
            String sentence = requestSentence();
            String letterToSearch = requestLetter();

            int timesIn = timesCounter(sentence, letterToSearch);
            String answer = picAnswer(timesIn);
            System.out.println(answer);
            toContinue=continueQuestion();
        }
        System.out.println("Okay, bye then. Take care!");
    }
    public static String picAnswer(int letterInSentenceTimes){
        String answer;
        if (letterInSentenceTimes == 0) {
            answer = "That letter isn't in your sentence.";
        }
        else
            answer = "That letter is in the sentence " + letterInSentenceTimes + " times.";

        return answer;
    }

    public static String requestSentence(){ //FIX IF IT BREAKS WITH COMAS OR POINTS
        Scanner sentenceScan = new Scanner(System.in);
        String sentence;
        System.out.println("Hello, what sentence or paragraph text do you want to evaluate? Press 'enter' when done typing.");

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
    public static String requestLetter(){
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
    public static int timesCounter(String text, String letterToSearch){
            int counter = 0;

        for (int i = 0; i <= text.length()-1; i++){
            String letter = text.substring(i,i+1);
            if (letter.equalsIgnoreCase(letterToSearch)){
                counter++;
            }
        }
        return counter;
    }
    public static boolean continueQuestion(){
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
