import java.util.Scanner;

/**
 * A class that interacts with the user to enable guessing the secret word.
 *
 * @author Max Dupler
 */
public class GameConsole {

    /**
     * . Scanner used to read user inputs
     */
    static Scanner in = new Scanner(System.in);

    /**
     * . boolean to tell the computer whether to keep going or stop the program
     */
    static boolean keepGoing = true;

    /**
     * . String of the alphabet used to keep track of guessed numbers
     */
    private static String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    /**
     * A simple string to generate initial word with a bunch of stars. This
     * string is setup on the assumption on the longest possible word.
     */
    private static final String STARS = "******************************";

    /**
     * The prompt string used to prompt the user for input. The prompt string
     * can be used as: System.out.printf(InputPrompt, currWord);
     */
    private static final String INPUT_PROMPT = "Word so far: %s%n"
            + "Enter a word or a letter [*: quit, +: AI, ?: hint]: ";

    /**
     * A simple message that is printed whenever the user guesses a character
     * correctly. This string is used as: System.out.printf(MatchMessage, c,
     * e.getMessage());
     */
    private static final String MATCH_MESSAGE = "You guessed a character "
            + "correctly!%nThe character '%c' occurs at index position(s) %s%n";
    /**
     * A private static variable that is used to track the characters that have
     * been guessed by the user so far. This word is initialized to a bunch of
     * stars and as the user guesses characters, the corresponding characters
     * are filled-in until the whole word is guessed.
     */
    private static String currWord;

    /**
     * The top-level method that is invoked by WordThrow class to enable the
     * user to use different operations to guess the secret word. This method is
     * expected to prompt the user for input and perform the necessary
     * operations based on user-input. This method essentially uses a set of
     * helper methods to accomplish the necessary functionality.
     * 
     * @param wt The word throw object to be used by this method.
     */
    public static void play(WordThrow wt) {

        // initialize the word length
        initialize(wt);
        System.out.println("Guess the " + currWord.length()
                + " character word.");
        while (keepGoing) {
            System.out.printf(INPUT_PROMPT, currWord);
            String input = in.next();
            // If its a character
            if (input.length() == 1) {
                char c = input.charAt(0);
                if (c == '*') {
                    keepGoing = false;
                } else if (input.equals("?")) {
                    System.out.println("Letters left to guess: " + ALPHABET);
                } else {
                    checkInput(wt, c);
                }
            } else {
                processWord(wt, input);
            }
        }
    }

    /**
     * . a helper method to the play method that initializes the word length
     * 
     * @param wt The word throw object to be used by this method
     */
    private static void initialize(WordThrow wt) {
        // initialize variables to keep track of word length
        currWord = "*";
        boolean correctLength = false;

        // start guessing word length and catch exceptions
        while (!correctLength) {
            try {
                wt.guess(currWord);
                correctLength = true;
            } catch (WordThrow.WordLengthMismatchException e) {
                currWord += "*";
            } catch (WordThrow.CorrectWordException e) {
                return;
            }
        }
    }

    /**
     * . method to check the input the user gave and respond to the user.
     * 
     * @param wt a WortdThrow object
     * @param c  a character value
     */
    private static void checkInput(WordThrow wt, char c) {
        try {
            replaceLetter(c);
            wt.guess(c);
        } catch (WordThrow.MatchAndOccursException e) {
            final String error = e.getMessage();
            Scanner readError = new Scanner(error);
            while (readError.hasNextInt()) {
                int x = readError.nextInt();
                currWord = currWord.substring(0, x) + c
                        + currWord.substring(x + 1);
            }
            System.out.printf(MATCH_MESSAGE, c, error);
            if (!currWord.contains("*")) {
                System.out.println("You guessed the word! Congratulations!");
                keepGoing = false;

            }
            readError.close();
        } catch (WordThrow.MismatchException e) {
            System.out.println("The character '" + c
                    + "' is not in the word.");
        }
    }

    /**
     * . method to replace a guessed character in the list of letters
     * 
     * @param c a character
     */
    private static void replaceLetter(char c) {
        for (int i = 0; i < ALPHABET.length(); i++) {
            if (c == ALPHABET.charAt(i)) {
                ALPHABET = ALPHABET.substring(0, i) + "-"
                        + ALPHABET.substring(i + 1);
            }
        }
    }

    /**
     * . method to process the word guessed by the user
     * 
     * @param wt   a WordThrow object
     * @param test a String type
     */
    private static void processWord(WordThrow wt, String test) {
        try {
            wt.guess(test);
            System.out.println("Good try, but you guessed wrong.");
        } catch (WordThrow.WordLengthMismatchException e) {
            System.out.println("Your guessed word did not have same length.");
        } catch (WordThrow.CorrectWordException e) {
            keepGoing = false;
            System.out.println("You guessed the word! Congratulations!");
        }
    }
}
