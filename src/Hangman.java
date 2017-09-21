// TODO: comment this file

import java.io.File;
import java.util.*;  // for Scanner

public class Hangman extends HangmanProgram {


    public void run() {
        // TODO: write this method
        intro();

    }


    private void intro() {
        String introduction = "CS 106A Hangman!\n" +
                "I will think of a random word.\n" +
                "You'll try to guess its letters.\n" +
                "Every time you guess a letter\n" +
                "that isn't in my word, a new body\n" +
                "part of the hanging man appears.\n" +
                "Guess correctly to avoid the gallows!";
        println(introduction);
        File file = new File("../res/dict.txt");
        System.out.println(file.getPath());
        System.out.println(getClass().getResource("/").getPath());
        println(file.exists());
        playOneGame("PROGRAMMER");

    }

    // TODO: comment this method
    private int playOneGame(String secretWord) {

        int guessesTotalTimes = 8;

        String textOfsecretWord = createHint(secretWord, null);
        String textOfyouGuess = "";
        int textOfguessesLeft = guessesTotalTimes;

        while (textOfguessesLeft > 0) {

            println("Secret word : " + textOfsecretWord);
            println("You guess : " + textOfyouGuess);
            println("guesses left : " + textOfguessesLeft);
            print("you guess?");
            displayHangman(textOfguessesLeft);

            char inputOfyouGuess = readGuess(textOfyouGuess);
            textOfyouGuess += inputOfyouGuess;
            if (textOfsecretWord.equals(secretWord)) {
                println("$you win ! my Word is " + secretWord);
                break;
            } else {
                String newTextOfsecretWord = createHint(secretWord, textOfyouGuess);
                if (textOfsecretWord.equalsIgnoreCase(newTextOfsecretWord)) {
                    textOfguessesLeft--;
                } else {
                    textOfsecretWord = newTextOfsecretWord;
                }
            }

        }
        return guessesTotalTimes;
    }
    private String createHint(String secretWord, String guessedLetters) {

        char[] charsOfsecretWord = secretWord.toUpperCase().toCharArray();
        char[] result = new char[charsOfsecretWord.length];

        Arrays.fill(result, '-');

        if (guessedLetters != null) {
            char[] charsofguessedLetters = guessedLetters.toUpperCase().toCharArray();
            for (char charsofguessedLetter : charsofguessedLetters) {
                for (int y = 0; y < charsOfsecretWord.length; y++) {
                    if (charsofguessedLetter == charsOfsecretWord[y]) {
                        result[y] = charsOfsecretWord[y];
                    }
                }
            }
        }

        return new String(result);
    }

    private char readGuess(String guessedLetters) {


        while (true){
            String inputOfyouGuess = readLine();
            char[] charsOfinput = inputOfyouGuess.toUpperCase().toCharArray();
            if (charsOfinput.length != 1 || charsOfinput[0] < 'A' || charsOfinput[0] > 'Z'){
               println("Type a single letter from A-Z.");
                print("you guess?");
               continue;
            }
            if(guessedLetters == null || guessedLetters.equals("")){
                return charsOfinput[0];
            }else if(guessedLetters.toUpperCase().contains(String.valueOf(charsOfinput[0]))) {
                println("You already guessed that letter.");
                print("you guess?");
                continue;
            }
            return charsOfinput[0];
        }
    }

    // TODO: comment this method
    private void displayHangman(int guessCount) {
        String currentClassFilePath = getClass().getResource("/").getPath();
        String targetFilePathBase = currentClassFilePath.substring(0,currentClassFilePath.indexOf("/bin/"));

    }

    // TODO: comment this method
    private void stats(int gamesCount, int gamesWon, int best) {
        // TODO: write this method
    }

    // TODO: comment this method
    private String getRandomWord(String filename) {
        // TODO: write this method
        return "";
    }
}
