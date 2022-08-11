package com.snowman.model;

import com.snowman.Main;
import com.snowman.view.MessagePrinter;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Set;

public class Game {

  public static final String MAKE_GUESS_PROMPT = "Make a guess!";
  public static final String UNSEEN_LETTER_PLACEHOLDER = "_";

  private final Set<String> triedWords;
  private final String secretWord;
  private final BufferedReader reader;

  private int remainingGuess;
  private String wordPlaceholder;

  public Game(Set<String> triedWords, int wordLength, int initialGuess, String secretWord,
      BufferedReader reader) {
    this.triedWords = triedWords;
    this.remainingGuess = initialGuess;
    this.secretWord = secretWord;
    this.reader = reader;
    wordPlaceholder = UNSEEN_LETTER_PLACEHOLDER.repeat(wordLength);
  }

  public void play() throws IOException {
    while (remainingGuess >= 0) {
      System.out.println(secretWord); // TODO: This line is for testing. Delete it before Friday!

      MessagePrinter.printSnowman(remainingGuess);
      MessagePrinter.printCurrentState(remainingGuess, wordPlaceholder, triedWords);
      System.out.println(MAKE_GUESS_PROMPT);
      String guess = reader.readLine().toLowerCase().trim();
      evaluateGuess(guess);
    }
  }

  public void evaluateGuess(String guess) throws IOException {
    boolean wordGuessResult = secretWordContainsGuess(guess, triedWords, secretWord,
        wordPlaceholder);
    if (!wordGuessResult) {
      remainingGuess--;
    } else {
      wordPlaceholder = makeNewWordPlaceholder(guess, secretWord, wordPlaceholder);
    }
  }

  private String makeNewWordPlaceholder(String userGuess, String secretWord,
      String wordPlaceholder) {
    String result = wordPlaceholder;
    char userLetter = userGuess.charAt(0);
    for (int i = 0; i < secretWord.length(); i++) {
      char currChar = secretWord.charAt(i);
      if (currChar == userLetter) {
        char[] chars = result.toCharArray();
        chars[i] = userLetter;
        result = String.valueOf(chars);
      }
    }
    return result;
  }

  private boolean secretWordContainsGuess(String userGuess, Set<String> triedWords,
      String secretWord, String wordPlaceholder) throws IOException {
    boolean result = false;

    if (!triedWords.contains(userGuess)) {
      triedWords.add(userGuess);

      if (userGuess.length() > 1) {
        if (userGuess.equals(secretWord)) { // TODO: extract these three lines into a method & reuse
          winGame();
        } else {
          System.out.println("Wrong word. Come on, I'm going to melt!"); // TODO: This should be view.
        }
      } else {
        if (secretWord.contains(userGuess)) {
          if (wordPlaceholder.equals(secretWord)) {
            winGame();
          } else {
            result = true;
          }
        } else {
          System.out.println("Wrong guess. Come on, I'm melting!"); // TODO: This should be view.
        }
      }

    } else {
      result = true;
      System.out.println(String.format("Try again. You've already tried %s before", userGuess));
    }

    return result;
  }

  private void winGame() throws IOException {
    MessagePrinter.printWinMessage();
    Main.main(null); // Winning case
  }

}
