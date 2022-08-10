package com.snowman.controller;

import com.snowman.model.WordProcessor;
import com.snowman.view.SnowmanPrinter;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class SinglePlayer {

  public static final int MAX_GUESS = 30;
  public static final int MIN_GUESS = 1;
  public static final int MAX_WORD_LENGTH = 15;
  public static final int MIN_WORD_LENGTH = 4;
  private static int remainingGuess;
  private static int wordLength;
  private static String wordPlaceholder;
  private static String secretWord;
  private static final Set<String> triedWords = new HashSet<>();

  public void singlePlayerController(BufferedReader reader, WordProcessor words) throws IOException {
    getUserGamePreference(reader);
    wordPlaceholder = "_".repeat(wordLength);
    secretWord = words.wordChoice(wordLength);
    System.out.println(secretWord); // TODO: Delete after testing
    while (remainingGuess >= 0) {
      printGameState();
      SnowmanPrinter.printSnowman(remainingGuess, wordLength);
      System.out.println("Any guess?");
      String userGuess = reader.readLine().toLowerCase().trim();
      boolean wordGuessResult = WordProcessor.wordGuess(userGuess, triedWords, secretWord, wordPlaceholder);
      if (!wordGuessResult) {
        remainingGuess--;
      } else {
        wordPlaceholder = WordProcessor.changeWordPlaceholder(userGuess, secretWord, wordPlaceholder);
      }

    }
  }

  private static void printGameState() {
    System.out.println("Already guessed: " + triedWords);
    System.out.println("Your guess so far: " + wordPlaceholder);
    System.out.println("Remaining guesses: " + remainingGuess);
  }

  private static void getUserGamePreference(BufferedReader reader) throws IOException {
    System.out.println(
        "Hey there! How many guesses would you like? This can be 1 - 30 (inclusive).");
    String userInput = reader.readLine().trim();
    if (userInput.length() == 0) {
      remainingGuess = MIN_GUESS + (int) (Math.random() * (MAX_GUESS - MIN_GUESS) + 1); //TODO verify this equation, just in case ;)
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
