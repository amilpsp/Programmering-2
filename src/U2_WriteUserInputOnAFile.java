import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Objects;
import java.util.Scanner;

public class U2_WriteUserInputOnAFile {

    public static void main(String[]args) {
        boolean validInput = true;
        String fileName = "User_Input.txt";
        System.out.println("""
                Hello, here you can type anything you want to store to your text file.
                Press 'enter' when done typing each segment.
                To close the program, just press 'enter' on an empty line.
                """);

        while (validInput){
            String sentence = fetchSentence();
            saveToFile(fileName, sentence);
            if (Objects.equals(sentence, "")) {
                System.out.println("""
                        Are you sure you want to exit?
                        Confirm with another empty line""");
                String confirmationSentence = fetchSentence();
                if (Objects.equals(confirmationSentence, "")) {
                    System.out.println("Bye, have a good one!");
                    validInput = false;
                }
            }
        }

    }//END OF MAIN

    public static String fetchSentence() { //Asks the user to type in a sentence or paragraph.
        Scanner sentenceScan = new Scanner(System.in);
        String sentence;

        try {
            sentence = sentenceScan.nextLine();
            return sentence;
        } catch (Exception e) {
            String sentence1;
            System.out.println("Invalid text, please try again");
            sentence1 = fetchSentence();
            return sentence1;
        }
    }

    static void saveToFile(String fileName,String userInput){
            try {
                var writer = new FileWriter(fileName);
                writer.write(userInput);
                writer.close();

            } catch (FileNotFoundException fex) {
                var file = new File(fileName);
                try {
                    file.createNewFile();
                    saveToFile(fileName, userInput);
                } catch (Exception e) {
                    System.out.println("Could not create the file, something went wrong. " + e);

                }
            } catch (Exception e) {
                System.out.println("Something went wrong. " + e);

            }
        }

}
