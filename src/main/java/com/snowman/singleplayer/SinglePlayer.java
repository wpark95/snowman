package com.snowman.singleplayer;

import com.snowman.SnowmanPrinter;
import com.snowman.WordList;
import java.io.BufferedReader;
import java.io.IOException;

public class SinglePlayer {

  private static int remainingGuess;
  private static int wordLength;
  private static String wordPlaceholder = "";
  private static String secretWord;

  public static void singlePlayerMain(BufferedReader reader) throws IOException {
    getUserGamePreference(reader);
    // TODO: This is for functionality demonstration.
    //  Please modify the following for loop to accommodate the use .csv files.
    for (int i = 0; i < wordLength; i++) {
      wordPlaceholder = wordPlaceholder + ("_");
    }

    secretWord = WordList.wordChoice(wordLength);

    System.out.println(secretWord); // TODO: Delete after testing

    int sadPoint = 3; // TODO: Make sad point more flexible, not a fixed number.
    while (remainingGuess > 0) {
      printGameState();
      SnowmanPrinter.printSnowman(sadPoint, remainingGuess); // TODO: Extract printSnowman as a class later, so that it
      //  can be used in the multiplayer mode.
      System.out.println("Any guess?");
      wordGuess(reader);
    }
  }

  private static void wordGuess(BufferedReader reader) throws IOException {
    // TODO: We should not let user enter a letter or word they already tried. So maybe create a map to keep track of those?
    String userGuess = reader.readLine().trim();

    if (userGuess.length() >= 2) {  // If the user's guess a word

      if (userGuess.equals(secretWord)) {
        // The user guessed the word correctly, so delegate this action to win/lose message generator
      } else {
        System.out.println("Wrong guess. Come on, I'm going to melt!");
        remainingGuess--;
      }

    } else { // If the user's guess is a letter

      if (secretWord.contains(userGuess)) {
        char userLetter = userGuess.toLowerCase().charAt(0);
        for (int i = 0; i < secretWord.length(); i++) {
          char currChar = secretWord.charAt(i);
          if (currChar == userLetter) {
            char[] chars = wordPlaceholder.toCharArray();
            chars[i] = userLetter;
            wordPlaceholder = String.valueOf(chars);
          }
        }

      } else {
        System.out.println("Wrong guess. Come on, I'm melting!");
        remainingGuess--;
      }

    }
  }

  private static void printGameState() {
    System.out.println("Your guess so far: " + wordPlaceholder);
    System.out.println("Remaining guesses: " + remainingGuess);
  }

  private static void getUserGamePreference(BufferedReader reader) throws IOException {
    System.out.println(
        "Hey there! How many guesses would you like? This can be 1 - 30 (inclusive).");
    int userGuessNumInput = Integer.parseInt(reader.readLine().trim());
    if (userGuessNumInput > 30 || userGuessNumInput < 1) {
      throw new IllegalArgumentException(
          "Number of guesses must be a number between 1 and 30 (inclusive).");
    }
    remainingGuess = userGuessNumInput;
    System.out.println("How long do you want the word to be? This can be 4 - 15 (inclusive).");
    int userWordLengthInput = Integer.parseInt(reader.readLine().trim());
    if (userWordLengthInput > 15 || userWordLengthInput < 4) {
      throw new IllegalArgumentException(
          "Word length must be a number between 4 and 15 (inclusive).");
    }
    wordLength = userWordLengthInput;
  }
}


