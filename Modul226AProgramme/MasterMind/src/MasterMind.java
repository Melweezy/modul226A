import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MasterMind {
    public static void main(String[] args) {
        Greetings introduction = new Greetings();
        String input = "";
        boolean finished = false;
        boolean isRight = false;
        char[] sequence = declareSequence();

        System.out.println(introduction.greetingsText());

        do {
            do {
                input = guessingCode(); //Input lesen
                isRight = inputCheck(input); //Input überprüfen
            } while (!isRight);
            //Feedback des Computers
            finished = feedback(input,sequence);

        } while (!finished);
        winning();

    }

    public static  char[] declareSequence() {
        char[] colors = { 'b', 'r', 'g', 'y', 's', 'w' };
        char[] sequence = new char[4];

        Random random= new Random();
        for (int i = 0; i < sequence.length; i++) {
            sequence[i] = colors[random.nextInt(colors.length)];
        }
        return sequence;
    }

    private static String guessingCode()
    {
        Scanner guessingCode = new Scanner(System.in);
        System.out.print("Erraten Sie Ihren Code (r,b,g,y,w,s): ");
        String input = guessingCode.next();
        System.out.println("Ihre Annahme: " + input);
        return input;
    }

    public static Boolean inputCheck(String input)
    {
        char[] inputAsCharArray = input.toCharArray();
        int missspelledLetter = inputAsCharArray.length;

        if (inputAsCharArray.length == 4) {
            for (char c : inputAsCharArray) {
                if (c == 'r' || c == 'b' || c == 'g' || c == 'y' || c == 'w' || c == 's') {
                    missspelledLetter--;
                }
            }
            if(missspelledLetter == 0) {
                return true;
            }
        }
        return  false;
    }

    public static boolean feedback(String input, char[] sequence) {
        char[] inputAsCharArray = input.toCharArray();
        char[] allPerfect = {'p','p','p','p'};
        boolean finished = false;
        int i = 0;
        for (char c : inputAsCharArray) {
            if (c == sequence[i]) {
                inputAsCharArray[i] = 'p';
                i++;
            } else if (c == sequence[0] || c == sequence[1] || c == sequence[2] || c == sequence[3]) {
                inputAsCharArray[i] = 'o';
                i++;
            } else {
                inputAsCharArray[i] = 'f';
                i++;
            }
            if (Arrays.equals(inputAsCharArray, allPerfect)) {
                finished = true;
            }
        }
        System.out.println("HINWEIS: " + inputAsCharArray[0] + "" + inputAsCharArray[1] + "" + inputAsCharArray[2] + "" + inputAsCharArray[3]);
        return finished;
    }

    private static void winning() {
        System.out.println("gg ez!");
    }
}

