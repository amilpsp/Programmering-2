import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class U2_WriteUserInputOnAFile {

    public static void main(String[]args) throws IOException {

        boolean validInput = true;
        Scanner scan = new Scanner(System.in);

        System.out.println(
                """
                Hello, what do you want the name of your file to be?
                Please end it with '.txt'
                Note that if you repeat a previous file name, it will get overwritten""");
        String fileName = scan.nextLine();

        File path = new File(fileName);
        FileWriter wr = new FileWriter(path);

        System.out.println("""
                You can type anything you want to store to your text file.
                Press 'enter' when done typing each segment.
                To close the program, just press 'enter' on an empty line.
                """);

        while (validInput) {

            var input = new BufferedReader(
                    new InputStreamReader(System.in)
            );
            String sentence = input.readLine();


            if (Objects.equals(sentence, "")) {
                validInput = false;
                System.out.println("Bye bye!");
            } else {
                wr.write("""
                                                
                        - """ + sentence);
            }
        }
        wr.close();
    }//END OF MAIN
/*
    public static String fetchSentence() { //Asks the user to type in a sentence or paragraph.
        var input= new BufferedReader(
                new InputStreamReader(System.in)
        );
        String sentence;

        try {
            sentence = input.readLine();
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
                var output = new PrintWriter
                        (new BufferedWriter
                        (new FileWriter(fileName)));
                output.println(userInput);
                output.close();

            } catch (FileNotFoundException fex) {
                try {
                    var file = new File(fileName);
                    file.createNewFile();
                    saveToFile(fileName, userInput);
                } catch (Exception e) {
                    System.out.println("Could not create the file, something went wrong. " + e);

                }
            } catch (Exception e) {
                System.out.println("Something went wrong. " + e);

            }
        }
*/
}
