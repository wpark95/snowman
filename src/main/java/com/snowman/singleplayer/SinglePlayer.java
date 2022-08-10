package com.snowman.singleplayer;

import com.snowman.Main;
import com.snowman.SnowmanPrinter;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Set;

public class SinglePlayer {

  public static final int MAX_GUESS = 30;
  public static final int MIN_GUESS = 1;
  public static final int MAX_WORD_LENGTH = 15;
  public static final int MIN_WORD_LENGTH = 4;
  private static int remainingGuess;
  private static int wordLength;
  private static String wordPlaceholder = "";
  private static String secretWord;
  private static Set<String> triedWords = new HashSet<>();

  public static void singlePlayerMain(BufferedReader reader) throws IOException {
    getUserGamePreference(reader);
    for (int i = 0; i < wordLength; i++) {
      wordPlaceholder = wordPlaceholder + ("_");
    }
    secretWord = WordList.wordChoice(wordLength);
    System.out.println(secretWord); // TODO: Delete after testing
    int sadPoint = 3; // TODO: Make sad point more flexible, not a fixed number.
    while (remainingGuess > 0) {
      printGameState();
      SnowmanPrinter.printSnowman(sadPoint, remainingGuess);
      System.out.println("Any guess?");
      wordGuess(reader);
    }
  }

  private static void wordGuess(BufferedReader reader) throws IOException {
    // TODO: We should not let user enter a wrong letter or word they already tried. So maybe create a map to keep track of those?
    String userGuess = reader.readLine().toLowerCase().trim();

    if (!triedWords.contains(
        userGuess)) { // If the user input (called userGuess) is a letter or word that we've never seen before,
      triedWords.add(userGuess); // Then we add it to triedWords (the HashSet)
      if (userGuess.length()
          >= 2) { // And then do all the computation to see if it's the secret word or a part of the secret word.
        if (userGuess.equals(secretWord)) {
          // TODO The user guessed the word correctly, so delegate this action to win/lose message generator
        } else {
          System.out.println("Wrong guess. Come on, I'm going to melt!");
          remainingGuess--;
        }
      } else {
        if (secretWord.contains(userGuess)) {
          char userLetter = userGuess.charAt(0);
          for (int i = 0; i < secretWord.length(); i++) {
            char currChar = secretWord.charAt(i);
            if (currChar == userLetter) {
              char[] chars = wordPlaceholder.toCharArray();
              chars[i] = userLetter;
              wordPlaceholder = String.valueOf(chars);
              if(wordPlaceholder.equals(secretWord)) {
                SnowmanPrinter.youWinSnowman();
                Main.main(null);

              }
            }
          }
        } else {
            System.out.println("Wrong guess. Come on, I'm melting!");
            remainingGuess--;
        }
      }

    } else {
      System.out.println(
          String.format("Try again. You've already tried %s before", userGuess));
    }
  }

  private static void printGameState() {
    System.out.println("Already guessed: " + triedWords.toString());
    System.out.println("Your guess so far: " + wordPlaceholder);
    System.out.println("Remaining guesses: " + remainingGuess);
  }

  private static void getUserGamePreference(BufferedReader reader) throws IOException {
    System.out.println(
        "Hey there! How many guesses would you like? This can be 1 - 30 (inclusive).");
    String userInput = reader.readLine().trim();
    if (userInput.length() == 0) {
      remainingGuess = MIN_GUESS + (int) (Math.random() * (MAX_GUESS - MIN_GUESS)
          + 1); //TODO verify this equation, just in case ;)
    } else {
      int userGuessNumInput = Integer.parseInt(userInput);
      if (userGuessNumInput > MAX_GUESS || userGuessNumInput < MIN_GUESS) {
        throw new IllegalArgumentException(
            "Number of guesses must be a number between 1 and 30 (inclusive).");
      }
      remainingGuess = userGuessNumInput;
    }
    System.out.println("How long do you want the word to be? This can be 4 - 15 (inclusive).");
    String userInput2 = reader.readLine().trim();
    if (userInput2.length() == 0) {
      wordLength = MIN_WORD_LENGTH + (int) (Math.random() * (MAX_WORD_LENGTH - MIN_WORD_LENGTH)
          + 1);
    } else {
      int userWordLengthInput = Integer.parseInt(userInput2);
      if (userWordLengthInput > MAX_WORD_LENGTH || userWordLengthInput < MIN_WORD_LENGTH) {
        throw new IllegalArgumentException(
            "Word length must be a number between 4 and 15 (inclusive).");
      }
      wordLength = userWordLengthInput;
    }
  }

}
